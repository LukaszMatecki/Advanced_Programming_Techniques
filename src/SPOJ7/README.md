<div align="center">

# MUTDNA - DNA

[![Tags](https://img.shields.io/badge/Tagi-Brak-lightgrey?style=flat-square)](#)

</div>

---

## 📝 Treść zadania

Biolodzy odkryli dziwną cząsteczkę DNA, składającą się z sekwencji $N$ znaków ze zbioru $\{A, B\}$. W wyniku serii mutacji wszystkie cząsteczki docelowo zmieniają się w nić składającą się wyłącznie ze znaków `A`.

Odkryto dwa rodzaje mutacji:
1. Zmiana pojedynczego, konkretnego znaku w sekwencji (`A` na `B` lub `B` na `A`).
2. Zmiana całego prefiksu sekwencji, czyli zamiana wszystkich znaków na pozycjach od $1$ do $K$ (gdzie $K \le N$) na znaki przeciwne.

Twoim zadaniem jest obliczenie najmniejszej możliwej liczby mutacji, które przekształcą cząsteczkę z jej stanu początkowego do stanu końcowego (same litery `A`). Mutacje mogą zachodzić w dowolnej kolejności.

---

## ⚙️ Specyfikacja danych

**Wejście (Input):**
* Pierwsza linia zawiera jedną dodatnią liczbę całkowitą $N$ ($1 \le N \le 1000000$), oznaczającą długość cząsteczki.
* Druga linia to ciąg znaków o długości $N$, składający się wyłącznie z liter `A` i `B`, reprezentujący stan początkowy.

**Wyjście (Output):**
* Należy wypisać dokładnie jedną liczbę – wymaganą minimalną liczbę mutacji.

---

## 💻 Przykładowe dane

Aby zachować przejrzystość, poniżej zestawiono trzy odrębne przypadki testowe z treści zadania w jednym bloku:

| Wejście (Input) | Wyjście (Output) |
| :--- | :--- |
| `4`<br>`ABBA`<br><br>`5`<br>`BBABB`<br><br>`12`<br>`AAABBBAAABBB` | <br>`2`<br><br><br>`2`<br><br><br>`4` |

---

## 💡 Realizacja

Ze względu na to, że zmiana prefiksu modyfikuje wiele znaków naraz, naiwne sprawdzanie wszystkich kombinacji byłoby zbyt wolne dla $N = 1000000$. Problem wymaga zoptymalizowanego algorytmu działającego w czasie liniowym $O(N)$. 

W języku **Java** przygotowano **dwa podejścia** oparte na analizie zachłannej (greedy):

1. **Iteracja od lewej z flagą stanu (`Spoj7.java`):**
   Algorytm przetwarza ciąg znaków od lewej do prawej. Zamiast fizycznie modyfikować tablicę (co byłoby kosztowne czasowo), program używa logicznej flagi `czy_odwrocony_prefix`. Odczytuje ona "rzeczywisty" stan danego znaku po uwzględnieniu dotychczasowych mutacji. Gdy natrafi na znak `B`, rejestruje mutację i zmienia stan flagi. 

2. **Iteracja od tyłu / od prawej do lewej (`Spoj7_2.java`):**
   Jest to klasyczne i bardzo wydajne rozwiązanie tego problemu. Ponieważ odwrócenie prefiksu ($1$ do $K$) wpływa tylko na znaki znajdujące się *przed* pozycją $K$, znaki znajdujące się na końcu ciągu determinują nasze wybory. Program analizuje ciąg od końca (od indeksu $N-1$ do $0$). Na bieżąco śledzi, jakiego znaku oczekuje (zaczynając od `A`). Gdy napotka znak niezgodny z oczekiwaniem, zwiększa licznik mutacji i w odpowiednich przypadkach aktualizuje oczekiwany wzorzec dla pozostałej, lewej części ciągu.
