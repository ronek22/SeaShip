# SeaShip ![Travis](https://travis-ci.org/ronek22/SeaShip.svg?branch=master)
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

