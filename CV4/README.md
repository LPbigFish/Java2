# Java 2 - 4. cvičení v1
Vycházejte z projektu <https://gitlab.vsb.cz/jez04-vyuka/java2/labs/java2lab04v1.git>

## Lombok

Použijte knihovnu Lombok a zjednodušte třídy `lab.Setting` a `lab.data.Score`.

- Vytvořte tag `project/properties/lombok.version` s textem 1.18.42
- Přidejte do `pom.xml` závislost na knihovně Lombok (vzhledejte maven lombok). použijte scope `provided` 
  a jako verzi použijte proměnnou  ${lombok.version}
- Přidejte do `pom.xml` do `project/build/plugins` plugin `maven-compiler-plugin` ve verzi `3.15.0` (<https://mvnrepository.com/artifact/org.apache.maven.plugins/maven-compiler-plugin>)
- Přidejte do `pom.xml` do pluginu `maven-compiler-plugin` do rtagu `configuration` annotation processor:
```xml
					<annotationProcessorPaths>
						<path>
							<groupId>org.projectlombok</groupId>
							<artifactId>lombok</artifactId>
							<version>${lombok.version}</version>
						</path>
					</annotationProcessorPaths>
```
- Do `module-info.java` přidejte `requires static lombok;`
- Ve třídách `lab.Setting` a `lab.data.Score` použijte anotace z knihovny Lombok tak,
  aby se třídy zjednodušili.
- V ostatních místech kódu najděte ta kde lze použít lombok především getter a setter metody.
- Použijte anotaci `@Log4j2` pro vytvoření statické proměnné s logrem <https://projectlombok.org/features/log>
  všude tam kde je třeba logovat informace.

## Record

Vytvořte `record`, který bude sloužit k uložení informaci o času a pozici zničení každého ufa.
Záznam ničení jednotlivých `Ufo` ukládejte do kolekce ve tříde `World` a vypište vše na konci programu při zavření okna.

## Bonusový úkol

Najděte si na mapě kde leží ostrov Lombok :-)
