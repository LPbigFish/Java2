package lab.storage;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lab.data.Game;
import lab.data.MyEntity;
import lab.data.Player;
import lab.data.Player_;
import lab.data.Score;
import lab.data.Score_;

public class JpaConnector {

    private final EntityManagerFactory emf;
    private final EntityManager em;

    public JpaConnector() {
        emf = Persistence.createEntityManagerFactory("java2");
        em = emf.createEntityManager();
    }

    public <T extends MyEntity> List<T> getAll(Class<T> clazz) {
        return em.createQuery(String.format("SELECT e FROM %s e", clazz.getSimpleName()), clazz).getResultList();
    }

    public <T extends MyEntity> void save(T entity) {
        em.getTransaction().begin();
        if (entity.getId() == null || entity.getId() == 0) {
            em.persist(entity);
            em.getTransaction().commit();
        } else {
            em.merge(entity);
            em.getTransaction().commit();
        }
    }

    public void deletePlayer(Player player) {
        em.getTransaction().begin();
        player.getScores().forEach(em::remove);
        em.remove(player);
        em.getTransaction().commit();
    }

    public void deleteGame(Game game) {
        em.getTransaction().begin();
        game.getScores().forEach(em::remove);
        em.remove(game);
        em.getTransaction().commit();
    }

    public void delete(MyEntity entity) {
        em.getTransaction().begin();
        em.remove(em.contains(entity) ? entity : em.merge(entity));
        em.getTransaction().commit();
    }

    public void stop() {
        em.close();
        emf.close();
    }

    public EntityManager getEntityManager() {
        //return entity manager. Type Object is there because of compilation of empty task assignment
        return em;
    }

    public <T> T find(long id, Class<T> clazz) {
        return em.find(clazz, id);
    }

    public void modifyNoPersistOrMerge(long id, Consumer<Score> modificator) {
        em.getTransaction().begin();
        Score score = em.find(Score.class, id);
        modificator.accept(score);
        em.getTransaction().commit();
    }

    /**
     * Najde skóre dle zadaných kritérií. Využijte criteria builder.
     *
     * @param partialPlayerNames - mezerou oddělené částečná jména, příjmení nebo přezdívky hledaných hráčů
     * @param partialGameNames   - mezerou oddělená částečná jména hledaných her
     * @param difficult          - heledaná obtížnost nebo NULL
     * @return seznam skóre, kde jméno hry obsahuje aspoň jedeno z částečných jmen hry, a zároveň hráč
     * obsahuje alespoň jedno částečné jméno nebo příjmení nebo pžřezdívku a zároveň je úroveň hry rovna
     * difficult pokud je zadána jiná hodnota než NULL
     */
    public List<Score> findBy(String partialPlayerNames, String partialGameNames, Score.Difficult difficult) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Score> q = cb.createQuery(Score.class);
        Root<Score> r = q.from(Score.class);

        String[] player_names = partialPlayerNames.split(" ");

        List<Predicate> a = Arrays
            .stream(player_names)
            .flatMap(name ->
                Stream.of(
                    cb.like(r.get(Player_.FIRST_NAME), "%" + name + "%"),
                    cb.like(r.get(Player_.LAST_NAME), "%" + name + "%"),
                    cb.like(r.get(Player_.NICK), "%" + name + "%")
                )
            ).toList();

        List<Predicate> all = new ArrayList<>();
        if (!a.isEmpty()) {
            Predicate names = cb.or(a.toArray(new Predicate[0]));
            all = List.of(names);
        }
        if (!all.isEmpty()) {
            q.where(all.toArray(new Predicate[0]));
        }
        return em.createQuery(q).getResultList();
    }

}
