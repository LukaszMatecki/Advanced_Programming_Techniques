<div align="center">

# FCTRL - Factorial

[![Tags](https://img.shields.io/badge/Tagi-%23math-lightgrey?style=flat-square)](#)

</div>

---

## 📝 Treść zadania

Zadanie polega na wyznaczeniu liczby zer na końcu rozwinięcia dziesiętnego silni dla podanej liczby $N$ (oznaczanej w zadaniu jako funkcja $Z(N)$). 

Z uwagi na to, że wartość $N!$ (gdzie $N$ może wynosić do $10^9$) rośnie astronomicznie szybko, bezpośrednie obliczenie silni, a następnie zliczanie w niej zer jest niemożliwe – przekracza to wszelkie limity pamięciowe i czasowe. Problem należy rozwiązać analitycznie. 

Zera na końcu liczby powstają z mnożenia przez $10$, a w rozkładzie na czynniki pierwsze $10 = 2 \times 5$. W rozwinięciu silni czynników równych $2$ jest zawsze znacznie więcej niż czynników równych $5$. Oznacza to, że całkowita liczba zer na końcu $N!$ jest determinowana wyłącznie przez liczbę wystąpień czynnika $5$ w rozkładzie na czynniki pierwsze wszystkich liczb od $1$ do $N$.

---

## ⚙️ Specyfikacja danych

**Wejście (Input):**
* Pierwsza linia zawiera jedną dodatnią liczbę całkowitą $T$ (około 100000), oznaczającą liczbę przypadków testowych.
* Następnie podanych jest $T$ linii, z których każda zawiera dokładnie jedną liczbę całkowitą $N$ ($1 \le N \le 1000000000$).

**Wyjście (Output):**
* Dla każdego przypadku testowego należy wypisać w nowej linii jedną nieujemną liczbę całkowitą, będącą wartością funkcji $Z(N)$. *(W celach demonstracyjnych kod wypisuje wyniki opatrzone komentarzem).*

---

## 💻 Przykładowe dane

| Wejście (Input) | Wyjście (Output) |
| :--- | :--- |
| `6`<br>`3`<br>`60`<br>`100`<br>`1024`<br>`23456`<br>`8735373` | <br>`0`<br>`14`<br>`24`<br>`253`<br>`5861`<br>`2183837` |

---

## 💡 Realizacja

Rozwiązanie problemu w języku **Java** opiera się na sumowaniu wyników całkowitoliczbowego dzielenia liczby $N$ przez kolejne potęgi piątki ($5, 25, 125, \dots$). Złożoność takiego algorytmu to zaledwie $O(\log_5 N)$, co pozwala na błyskawiczne rozwiązanie problemu nawet dla maksymalnych wartości wejściowych.

W pliku `Spoj5.java` zaimplementowano **dwa podejścia** do tego samego algorytmu:

1. **Podejście iteracyjne:**
   Wykorzystuje pętlę `while`. W każdym kroku liczba jest dzielona przez $5$, a wynik tego dzielenia (oznaczający ilość wielokrotności piątki) jest dodawany do globalnego licznika. Pętla kończy działanie, gdy wartość staje się mniejsza od $5$. Jest to optymalne pamięciowo i bardzo wydajne rozwiązanie.

2. **Podejście rekurencyjne (`zeraRekurencyjnie`):**
   Wykorzystuje metodę wywołującą samą siebie. Zwraca ona wynik dzielenia $N / 5$ powiększony o wywołanie rekurencyjne dla zmniejszonego $N$. Daje to bardzo elegancki i zwięzły kod matematyczny. Z uwagi na szybko rosnące potęgi piątki, głębokość rekurencji (maksymalnie ok. $13$ wywołań dla $10^9$) jest minimalna i nie grozi przepełnieniem stosu.
