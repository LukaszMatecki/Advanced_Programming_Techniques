<div align="center">

# PRIME1 - Prime Generator

[![Tags](https://img.shields.io/badge/Tagi-%23number--theory-lightgrey?style=flat-square)](#)

</div>

---

## 📝 Treść zadania

Piotr (Peter) chce wygenerować liczby pierwsze na potrzeby swojego systemu kryptograficznego. Twoim zadaniem jest mu w tym pomóc i napisać program, który wygeneruje wszystkie liczby pierwsze znajdujące się w zadanym przedziale od $m$ do $n$ włącznie.

Przypomnijmy: liczba pierwsza to liczba naturalna większa od $1$, która ma dokładnie dwa dzielniki naturalne – jedynkę i samą siebie.

---

## ⚙️ Specyfikacja danych

**Wejście (Input):**
* W pierwszej linii znajduje się liczba przypadków testowych $t$ ($t \le 10$).
* W kolejnych $t$ liniach podane są pary liczb $m$ i $n$ oddzielone spacją, definiujące przedziały.
* Zastosowano ograniczenia: $1 \le m \le n \le 1000000000$ oraz $n-m \le 100000$.

**Wyjście (Output):**
* Dla każdego przypadku testowego należy wypisać w nowych liniach wszystkie liczby pierwsze $p$ spełniające warunek $m \le p \le n$.
* Wyniki poszczególnych przypadków testowych muszą być oddzielone od siebie jedną pustą linią.

> **Ostrzeżenie:** Zadanie przetwarza duże zbiory danych wejściowych i wyjściowych (Large I/O data), dlatego należy zwrócić szczególną uwagę na wydajność zaimplementowanego algorytmu.

---

## 💻 Przykładowe dane

| Wejście (Input) | Wyjście (Output) |
| :--- | :--- |
| `2`<br>`1 10`<br>`3 5` | `2`<br>`3`<br>`5`<br>`7`<br><br>`3`<br>`5` |

---

## 💡 Realizacja

Problem ten jest klasycznym zagadnieniem z teorii liczb. Zaimplementowane w języku **Java** rozwiązanie wykorzystuje prostą, ale wystarczająco wydajną metodę zoptymalizowanego dzielenia próbnego.

Kluczowe optymalizacje zastosowane w kodzie:
1. **Ograniczenie zakresu sprawdzania:** Sprawdzanie, czy liczba $i$ jest pierwsza, nie wymaga dzielenia jej przez wszystkie liczby mniejsze od $i$. Pętla wewnętrzna sprawdza potencjalne dzielniki $j$ jedynie do wartości pierwiastka kwadratowego z badanej liczby (`Math.sqrt(i)`). Dzięki temu złożoność spada z $O(N)$ do $O(\sqrt{N})$, co przy przedziałach sięgających miliarda jest absolutely kluczowe do uniknięcia przekroczenia limitu czasu (Time Limit Exceeded).
2. **Przerwanie działania (break):** Gdy tylko algorytm znajdzie jakikolwiek dzielnik, natychmiast przerywa wewnętrzną pętlę i przechodzi do sprawdzania kolejnej liczby.
3. **Obsługa krawędziowa:** Program prawidłowo wyłapuje i wyklucza wartość $1$ (przypisując flagę `1`), chroniąc przed uznaniem jej za liczbę pierwszą.
