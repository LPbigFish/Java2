# Java 2 - Exercise 4 v1
Start with the project <https://gitlab.vsb.cz/jez04-vyuka/java2/labs/java2lab04v1.git>

## Lombok

Use the Lombok library to simplify the `lab.Setting` and `lab.data.Score` classes.

- Create a tag `project/properties/lombok.version` with the text 1.18.42
- Add a dependency on the Lombok library to `pom.xml` (search for maven lombok). Use the scope `provided`
  and use the variable  ${lombok.version} as the version
- Add the `maven-compiler-plugin` plugin in version `3.15.0` (<https://mvnrepository.com/artifact/org.apache.maven.plugins/maven-compiler-plugin>) to `pom.xml` in `project/build/plugins`
- Add the annotation processor to the `configuration` tag in the `maven-compiler-plugin` plugin in `pom.xml`:
```xml
                <annotationProcessorPaths>
                   <path>
                      <groupId>org.projectlombok</groupId>
                      <artifactId>lombok</artifactId>
                      <version>${lombok.version}</version>
                   </path>
                </annotationProcessorPaths>
```
- Add `requires static lombok;` to `module-info.java`
- Use annotations from the Lombok library in the `lab.Config` and `lab.data.Score` classes to
  simplify the classes.
- Find other places in the code where Lombok can be used, especially getter and setter methods.
- Use the `@Log4j2` annotation to create a static variable with the logger <https://projectlombok.org/features/log>
  wherever information needs to be logged.

## Record

Create a `record` that will be used to store information about the time and position of each UFO's destruction.
Store the destruction records of individual `UFO`s in a collection in the `World` class and
print everything at the end of the program when the window is closed.

## Bonus task

Find the island of Lombok on the map :-)

