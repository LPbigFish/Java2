# Java 2 - 3. cvičení v1
Vycházejte z projektu <https://gitlab.vsb.cz/jez04-vyuka/java2/labs/java2lab03v1.git>

## Builder

- Pro třídu `lab.Setting` vytvořte "builder"
- Zajistěte, že instance `lab.Setting` je možné vytvářet pouze pomocí "builderu".
- Pro vytváření "builder-u" vytvořte statickou tovární metodu ve třídě `lab.Setting`.
  Zajistěte, že se vně používá pouze tato metoda.
- Vytvořte statickou metodu pro vytvoření speciální instance třídy `lab.Setting`, třeba
  pro vysokou obtížnost hry.

## Log4j2

V projektu použijte logování pomocí knihovny Log4j2.

- Přidejte logovací zprávy do některých tříd. Například do pohybujících se objektů.
- Pro pohybující se objekty v úrovni `TRACE` vypisujte každou změnu polohy.

Nakonfigurujte log4j2 tak aby:

- vytvářel nový soubor při každém spuštění
- Aby se po dosažení dané velikosti/stáří souboru vytvořil nový
- Aby se po dosažení počtu/celkové velikosti/stáří soubory mazaly
- Zkuste nastavit aby se v různých balíčcích použil různý log level.

Inspirujte se v dokumentaci <https://logging.apache.org/log4j/2.x/manual/appenders.html>
a hledejte `RollingFile` nebo `DefaultRolloverStrategy`

## Equals a Hashcode

Pro třídu `lab.score.Score` překryjte metodu `equals` a `hashcode` tak aby dávala logicky smysl.
