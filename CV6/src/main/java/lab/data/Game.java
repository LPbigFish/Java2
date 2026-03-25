package lab.data;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lab.Tools;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder(toBuilder = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Game implements MyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String name;
    @ToString.Exclude
    @OneToMany(mappedBy = Score_.GAME)
    private List<Score> scores;

    public static Game generate() {
        return new Game(null, Tools.randomGameName(), null);
    }

    public static Game generateAny() {
        return switch (Tools.RANDOM.nextInt(3)) {
            case 1 -> PlatformGame.generate();
            case 2 -> FirstPersonShooter.generate();
            default -> generate();
        };
    }
}
