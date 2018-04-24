# SeaShip
Program, pozwala na przemieszczanie się statkiem po morzu. Morze ma wyspy na które statek nie może wpłynąć.
Program spełnia następujące wymagania:
- Określone są punkt początkowy(x,y) statku oraz jego kierunek (N -> północ, S -> południe, E -> wschód, W -> zachód).
- Obsługa poleceń przesuwających statek naprzód (n) i wstecz (w).
- Obsługa poleceń powodujących obrót statku w lewo (l) i prawo (p).
- Statek przyjmuje łańcuch znaków z poleceniami (literami: n,w,l,p oznaczającymi odpowiednio naprzód,
wstecz, lewo, prawo).
- Obsługa wykrywania lądu. Wykrywanie odbywa się przed każdym ruchem na
nową pozycję. Jeśli polecenie wymaga wpłynięcia na ląd, statek anuluje ruch i pozostaje
na obecnej pozycji.
- Możliwość zapisu mapy do pliku oraz odtworzenia mapy z pliku.
## Użyte rodzaje asercji:
* ***assertEquals*** https://github.com/ronek22/SeaShip/blob/70ff2a9612e0f156d083e01c836a1e31fbfe73f2/src/test/java/ship/ShipTest.java#L42-L47
* ***assertArrayEquals*** https://github.com/ronek22/SeaShip/blob/70ff2a9612e0f156d083e01c836a1e31fbfe73f2/src/test/java/ship/BoardTest.java#L21-L25
* ***assertTrue*** https://github.com/ronek22/SeaShip/blob/70ff2a9612e0f156d083e01c836a1e31fbfe73f2/src/test/java/ship/BoardTest.java#L88-L92
* ***assertFalse*** https://github.com/ronek22/SeaShip/blob/70ff2a9612e0f156d083e01c836a1e31fbfe73f2/src/test/java/ship/BoardTest.java#L94-L98
* ***assertThrows*** *(uwzględnienie wyjątków)* https://github.com/ronek22/SeaShip/blob/70ff2a9612e0f156d083e01c836a1e31fbfe73f2/src/test/java/ship/BoardTest.java#L36-L42
* ***assertAll*** https://github.com/ronek22/SeaShip/blob/70ff2a9612e0f156d083e01c836a1e31fbfe73f2/src/test/java/ship/GameTest.java#L52-L61

## Zastosowanie biblioteki Hamcrest
https://github.com/ronek22/SeaShip/blob/70ff2a9612e0f156d083e01c836a1e31fbfe73f2/src/test/java/ship/BoardTest.java#L68-L80
https://github.com/ronek22/SeaShip/blob/70ff2a9612e0f156d083e01c836a1e31fbfe73f2/src/test/java/ship/BoardTest.java#L82-L86

## Zastosowanie testów parametrycznych przy użyciu plików testowych
*Plik .csv zawieral dane o poczatkowej pozycji statku, komendom jakim został poddany oraz pozycji docelowej*
https://github.com/ronek22/SeaShip/blob/70ff2a9612e0f156d083e01c836a1e31fbfe73f2/src/test/java/ship/GameTest.java#L43-L49

Projekt oparty na **JAVA 8** oraz skonfigurowany do automatycznego budowania projektu przez **TravisCI**
