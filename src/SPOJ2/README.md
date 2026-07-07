<div align="center">

# SMPSEQ3 - Fun with Sequences

[![Tags](https://img.shields.io/badge/Tagi-%23basics-lightgrey?style=flat-square)](#)

</div>

---

## 📝 Treść zadania

Zadanie polega na znalezieniu i wypisaniu w porządku rosnącym wszystkich elementów pierwszego ciągu liczb, które nie występują w drugim ciągu. Na wejściu podawane są dwa posortowane rosnąco ciągi liczb całkowitych: $S = s_1, s_2 \dots s_n$ oraz $Q = q_1, q_2 \dots q_m$.

---

## ⚙️ Specyfikacja danych

**Wejście (Input):**
* Pierwsza linia zawiera jedną liczbę całkowitą $n$ ($2 \le n \le 100$).
* Druga linia zawiera $n$ liczb całkowitych ciągu $S$: $-100 \le s_i \le 100$, przy czym $s_i \le s_{i+1}$.
* Trzecia linia zawiera jedną liczbę całkowitą $m$ ($2 \le m \le 100$).
* Czwarta linia zawiera $m$ liczb całkowitych ciągu $Q$: $-100 \le q_i \le 100$, przy czym $q_i \le q_{i+1}$.

**Wyjście (Output):**
* Ciąg szukanych liczb całkowitych oddzielonych spacjami.

---

## 💻 Przykładowe dane

| Wejście (Input) | Wyjście (Output) |
| :--- | :--- |
| `5`<br>`-2 -1 0 1 4`<br>`6`<br>`-3 -2 -1 1 2 3` | `0 4` |

---

## 💡 Realizacja

W ramach tego zadania przygotowano **dwa podejścia** do rozwiązania problemu w języku **Java**, które różnią się sposobem przeszukiwania danych:

1. **Wyszukiwanie liniowe (`Spoj2.java`):**
   Rozwiązanie oparte na podwójnej pętli. Dla każdego elementu z pierwszego ciągu ($S$), program iteruje po drugim ciągu ($Q$), sprawdzając warunek równości. Jest to rozwiązanie typu *brute-force*, prostsze w implementacji, ale charakteryzujące się wyższą złożonością obliczeniową $O(n \times m)$.

2. **Wyszukiwanie binarne (`Spoj2_2.java`):**
   Zoptymalizowane podejście wykorzystujące fakt, że ciągi podane na wejściu są już posortowane (zgodnie ze specyfikacją zadania). Zamiast weryfikować każdy element po kolei, program używa wbudowanej metody `Arrays.binarySearch()`. Znacząco redukuje to złożoność czasową do $O(n \log m)$, co czyni to rozwiązanie wydajniejszym.
