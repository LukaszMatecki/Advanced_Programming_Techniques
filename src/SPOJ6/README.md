<div align="center">

# PALIN - The Next Palindrome

[![Tags](https://img.shields.io/badge/Tagi-%23ad--hoc--1-lightgrey?style=flat-square)](#)

</div>

---

## 📝 Treść zadania

Zadanie polega na znalezieniu najmniejszego palindromu, który jest ostro większy od podanej dodatniej liczby całkowitej `K`. Palindrom to liczba, której reprezentacja w systemie dziesiętnym jest identyczna podczas czytania od lewej do prawej, jak i od prawej do lewej.

Z uwagi na to, że podana liczba `K` może składać się z aż do `1 000 000` cyfr, konieczne jest zrezygnowanie ze standardowych operacji matematycznych. Wynikowe liczby zawsze muszą być wyświetlane bez wiodących zer.

---

## ⚙️ Specyfikacja danych

**Wejście (Input):**
* Pierwsza linia zawiera jedną liczbę całkowitą `t`, oznaczającą liczbę przypadków testowych.
* W kolejnych `t` liniach podane są całkowitoliczbowe wartości `K`.

**Wyjście (Output):**
* Dla każdej liczby `K` należy wypisać najmniejszy palindrom, który jest od niej większy. *(Zaimplementowany kod wypisuje wynik wraz z dodatkowym komunikatem tekstowym w celach demonstracyjnych).*

> **Ostrzeżenie:** Zadanie charakteryzuje się bardzo dużą ilością danych wejściowych i wyjściowych, co wymusza optymalizację algorytmu.

---

## 💻 Przykładowe dane

| Wejście (Input) | Wyjście (Output) |
| :--- | :--- |
| `2`<br>`808`<br>`2133` | <br>`818`<br>`2222` |

---

## 💡 Realizacja

Z uwagi na ogromny rozmiar danych (liczby do miliona znaków), użycie standardowych typów jak `BigInteger` byłoby nieoptymalne czasowo. Rozwiązanie w języku **Java** zostało oparte na bezpośredniej manipulacji tablicami cyfr. Algorytm działa w czasie proporcjonalnym do długości liczby i opiera się na kilku kluczowych krokach:

1. **Obsługa przypadku brzegowego:** Jeśli liczba składa się wyłącznie z dziewiątek (np. `99`, `999`), program od razu generuje i zwraca nową liczbę dłuższą o jeden znak w postaci `10...01` (np. `1001`).
2. **Odbicie lustrzane:** Program wykonuje kopię lewej połowy znaków na prawą stronę.
3. **Weryfikacja wielkości:** Następuje sprawdzenie (`nowyWiekszy`), czy wygenerowany w ten sposób palindrom jest ostro większy od pierwotnej liczby `K`. Jeśli tak, jest to gotowy wynik.
4. **Propagacja przeniesienia:** Jeśli lustrzane odbicie utworzyło liczbę mniejszą lub równą, algorytm inkrementuje środkową cyfrę (lub dwie środkowe dla długości parzystej). Następnie ewentualne "przeniesienie" (jeśli z `9` zrobiło się `10`) jest propagowane w lewo, a zaktualizowana lewa strona ponownie zostaje odbita lustrzanie na prawą stronę, co daje poprawny i optymalny rezultat.
