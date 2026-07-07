<div align="center">

# ONP - Transform the Expression

[![Tags](https://img.shields.io/badge/Tagi-%23stack-lightgrey?style=flat-square)](#)

</div>

---

## 📝 Treść zadania

Zadanie polega na przekształceniu w pełni nawiasowanego wyrażenia algebraicznego do postaci Odwrotnej Notacji Polskiej (ONP, ang. *Reverse Polish Notation* - RPN). 

Dostępne dwuargumentowe operatory matematyczne to: `+`, `-`, `*`, `/`, `^` (od najniższego do najwyższego priorytetu). Operandami są wyłącznie małe litery alfabetu angielskiego: od `a` do `z`. Wyrażenia są podawane w taki sposób, że każda operacja jest jawnie zamknięta w nawiasach (nie ma wieloznaczności typu `a*b*c`), co eliminuje konieczność ręcznego kontrolowania priorytetów operatorów.

*Oryginalne tagi: `#stack`*

---

## ⚙️ Specyfikacja danych

**Wejście (Input):**
* Pierwsza linia zawiera jedną liczbę całkowitą $t$ ($t \le 100$), określającą liczbę wyrażeń do przetworzenia.
* Następnie podanych jest $t$ linii, z których każda zawiera jedno wyrażenie algebraiczne o długości nieprzekraczającej 400 znaków.

**Wyjście (Output):**
* Dla każdego wyrażenia należy w nowej linii wypisać jego odpowiednik w Odwrotnej Notacji Polskiej.

---

## 💻 Przykładowe dane

| Wejście (Input) | Wyjście (Output) |
| :--- | :--- |
| `3`<br>`(a+(b*c))`<br>`((a+b)*(z+x))`<br>`((a+t)*((b+(a+c))^(c+d)))` | <br>`abc*+`<br>`ab+zx+*`<br>`at+bac++cd+^*` |

---

## 💡 Realizacja

Problem ten jest klasycznym przykładem zastosowania struktury danych LIFO (Last-In-First-Out). Ze względu na to, że w zadaniu podane wyrażenia są w pełni nawiasowane, można zastosować uproszczony algorytm konwersji, pomijając sprawdzanie priorytetów. Zaimplementowano **dwa podejścia** w języku **Java**:

1. **Podejście strukturalne ze stosem (`Spoj8.java`):**
   Rozwiązanie wykorzystujące jawną strukturę `Stack<Character>`. Algorytm iteruje po znakach wejściowych: 
   * Litery są od razu dopisywane do ciągu wynikowego (używając szybkiego `StringBuilder`).
   * Operatory (`+`, `-`, itp.) odkładane są na stos.
   * Prawy nawias `)` oznacza koniec podwyrażenia – program zdejmuje jeden operator ze stosu i dopisuje go do wyniku.
   * Lewy nawias `(` jest w tym uproszczonym modelu po prostu ignorowany.

2. **Podejście rekurencyjne ze stosem wywołań (`Spoj8_2.java`):**
   Rozwiązanie bez użycia zewnętrznej struktury stosu. Jej rolę przejmuje systemowy stos wywołań funkcji (ang. *call stack*). Natrafienie na lewy nawias `(` wywołuje rekurencyjnie funkcję przetwarzającą nowe, wewnętrzne podwyrażenie. Pojawienie się prawego nawiasu `)` kończy aktualne wywołanie, dokleja zapamiętany operator i przesyła wynik (oraz aktualny indeks, aby nie przetwarzać tych samych znaków podwójnie, wykorzystując do tego dedykowaną klasę pomocniczą `Wynik`) poziom wyżej.
