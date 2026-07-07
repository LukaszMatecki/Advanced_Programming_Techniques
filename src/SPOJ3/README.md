<div align="center">

# FCTRL2 - Small factorials

[![Tags](https://img.shields.io/badge/Tagi-%23math_%7C_%23big--numbers-lightgrey?style=flat-square)](#)

</div>

---

## 📝 Treść zadania

Zadanie polega na obliczeniu silni ($n!$) dla podanych dodatnich liczb całkowitych. Mimo że liczby wejściowe są stosunkowo małe (maksymalnie do $100$), wynik ich silni rośnie bardzo szybko i znacząco przekracza zakres standardowych typów wbudowanych (takich jak `int` czy `long`). Wymaga to zastosowania specjalnych mechanizmów do obsługi tzw. wielkich liczb (ang. *big numbers*).

*Oryginalne tagi: `#math` `#big-numbers`*

---

## ⚙️ Specyfikacja danych

**Wejście (Input):**
* Pierwsza linia zawiera jedną liczbę całkowitą $t$ ($1 \le t \le 100$), określającą liczbę przypadków testowych.
* Następnie następuje $t$ linii, z których każda zawiera jedną liczbę całkowitą $n$ ($1 \le n \le 100$).

**Wyjście (Output):**
* Dla każdej podanej liczby $n$ należy w nowej linii wypisać wartość jej silni, czyli $n!$.

---

## 💻 Przykładowe dane

<table>
  <tr>
    <th width="50%">Wejście (Input)</th>
    <th width="50%">Wyjście (Output)</th>
  </tr>
  <tr>
    <td valign="top">
<pre>
4
1
2
5
3
</pre>
    </td>
    <td valign="top">
<pre>
1
2
120
6
</pre>
    </td>
  </tr>
</table>

---

## 💡 Realizacja

Ze względu na to, że wartość $100!$ składa się z ponad 150 cyfr, standardowe typy liczbowe w Javie nie są w stanie jej przechować. Z tego powodu w obu przygotowanych rozwiązaniach wykorzystano klasę `java.math.BigInteger`. 

Przygotowano **dwa podejścia** do obliczania silni:

1. **Podejście iteracyjne (`Spoj3.java`):**
   Rozwiązanie wykorzystujące klasyczną pętlę `for`. Zmienna akumulująca wynik jest mnożona przez kolejne liczby aż do osiągnięcia wartości $n$. Jest to podejście optymalne pamięciowo i całkowicie bezpieczne (brak ryzyka przepełnienia stosu).

2. **Podejście rekurencyjne (`Spoj3_2.java`):**
   Rozwiązanie oparte na definicji rekurencyjnej silni, w której metoda wywołuje samą siebie ($n! = n \times (n-1)!$). Kod jest bardziej elegancki i deklaratywny, jednak przy większych wartościach $n$ każde wywołanie obciąża stos programu (ang. *call stack*). Dla $n \le 100$ narzut ten jest całkowicie akceptowalny i nie powoduje błędów `StackOverflowError`.
