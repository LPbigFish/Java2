# Java 2 - Exercise 3 v1
Based on the project <https://gitlab.vsb.cz/jez04-vyuka/java2/labs/java2lab03v1.git>

## Builder

- Create a "builder" for the `lab.Setting` class
- Ensure that instances of `lab.Setting` can only be created using the "builder".
- To create the "builder", create a static factory method in the `lab.Setting` class.
  Ensure that only this method is used externally.
- Create a static method for creating a special instance of the `lab.Setting` class, e.g.
  for high game difficulty.

## Log4j2

Use logging with the Log4j2 library in the project.

- Add logging messages to some classes. For example, to moving objects.
- For moving objects at the `TRACE` level, log every position change.

Configure log4j2 so that:

- it creates a new file each time it runs
- a new file is created when the file reaches a certain size/age
- files are deleted when they reach a certain number/total size/age
- Try to set different log levels for different packages.

Get inspiration from the documentation <https://logging.apache.org/log4j/2.x/manual/appenders.html>
and search for `RollingFile` or `DefaultRolloverStrategy`

## Equals and Hashcode

For the `lab.score.Score` class, override the `equals` and `hashcode` methods so that they make logical sense.
