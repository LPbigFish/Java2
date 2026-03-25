# Java 2 - 6. cvičení v1 JPA - vazby

Vycházejte z projektu <https://gitlab.vsb.cz/jez04-vyuka/java2/labs/java2lab06v1>

## JPA Hibernate Model Gen

Pomocí mavenu přidejt knihovnu `hibernate-jpamodelgen` [mvn repo](https://mvnrepository.com/artifact/org.hibernate.orm/hibernate-jpamodelgen)
, která umožní automatické vygenerování popisných třít pro JPA entity.

Závislost do `pom.xml`
```xml
<!-- Source: https://mvnrepository.com/artifact/org.hibernate.orm/hibernate-jpamodelgen -->
<dependency>
    <groupId>org.hibernate.orm</groupId>
    <artifactId>hibernate-jpamodelgen</artifactId>
    <version>${hibernate.version}</version>
    <scope>provided</scope>
</dependency>
```
Nutno přidat k pluginu `maven-compiler-plugin` jako annotation processor hned za `lombok`.
```xml
<path>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-jpamodelgen</artifactId>
    <version>6.6.11.Final</version>
</path>
```

Vygenerované zdorojové kódy ve složce `target/generated-sources/annotations` musíme přidat k projektovým souborům pomocí pluginu `build-helper-maven-plugin`:
```xml
<plugin>
    <groupId>org.codehaus.mojo</groupId>
    <artifactId>build-helper-maven-plugin</artifactId>
    <version>3.6.1</version>
    <executions>
        <execution>
            <id>add-source</id>
            <phase>process-resources</phase>
            <goals>
                <goal>add-source</goal>
            </goals>
            <configuration>
                <sources>
                    <source>target/generated-sources/annotations</source>
                </sources>
            </configuration>
        </execution>
    </executions>
</plugin>
```

Do `module.info.java` nutno přidat závislost na modulu pro anotace ve vygenerovaných třídách:
```java
requires static jakarta.annotation;
```

## Entity a vazby

Ze tříd `Score`, `Player`, `Game`, `PlatformGame`, `FirstPersonShooter` udělejte platné entity.

- Nezapomeňte na anotace pro konstruktor bez parametrů
- Anotace pro vazby `OneToMany` a `ManyToOne` a na parametr `mappedBy`
- Zajistěte aby se kolekce nevypisovaly jako soužást metody `toString` - jinak dojde k probl0m;m
- Zajestěte aby se pro hashcode a equals používalo pouze `id`.

## JpaConnector

Naimplementujte funkcionalitu metod ze třídy `JpaConnector`

- Pro metodu `findBy(String partialPlayerNames, String partialGameNames, Score.Difficult difficult)` použijte `CriteriaQuery`.
  Popis chování metody najdete v kometáři kódu.
  - Parametry jmen rozdělte pomocí split na jednotlivé části.
  - Vytvořte kolekce predikátů s operátorem LIKE
  - Pokud nejsou kolekce prázdné použijte OR nebo AND operátor (kolekce převeďte na pole)
  - pro `difficult` použijte operátor `==` jen v případě že není `null`.
