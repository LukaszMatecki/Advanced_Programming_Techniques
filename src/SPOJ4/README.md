<div align="center">

# ADDREV - Adding Reversed Numbers

[![Tags](https://img.shields.io/badge/Tagi-%23simple--math_%7C_%23ad--hoc--1-lightgrey?style=flat-square)](#)

</div>

---

## 📝 Treść zadania

Zadanie polega na operowaniu na tzw. "odwróconych" liczbach. Odwrócona liczba to taka, w której cyfry zapisane są w odwrotnej kolejności (np. `1245` staje się `5421`). Wszelkie wiodące zera, które powstaną w wyniku odwrócenia, są pomijane (np. liczba `1200` po odwróceniu to `21`).

Twoim zadaniem jest:
1. Wczytać dwie odwrócone liczby.
2. Odwrócić je z powrotem do normalnej postaci (zakładając, że żadne zera nie zostały wcześniej utracone, tj. `21` traktujemy po prostu jako `12`).
3. Dodać te dwie liczby do siebie.
4. Odwrócić otrzymaną sumę i wypisać wynik (pamiętając o pominięciu zer wiodących).

---

## ⚙️ Specyfikacja danych

**Wejście (Input):**
* Pierwsza linia wejścia zawiera jedną dodatnią liczbę całkowitą $N$ (około 10000), określającą liczbę przypadków testowych.
* Następnie podanych jest $N$ linii. Każda z nich zawiera dwie dodatnie liczby całkowite oddzielone spacją – są to dwie odwrócone liczby, które należy do siebie dodać.

**Wyjście (Output):**
* Dla każdego przypadku testowego należy wypisać sumę w postaci odwróconej, z pominięciem zer wiodących. *(W ramach testów, program wypisuje wyniki wyliczone różnymi metodami wraz z odpowiednim komentarzem).*

---

## 💻 Przykładowe dane

| Wejście (Input) | Wyjście (Output) |
| :--- | :--- |
| `3`<br>`24 1`<br>`4358 754`<br>`305 794` | <br>`34`<br>`1998`<br>`1` |

---

## 💡 Realizacja

Rozwiązanie problemu zostało zaimplementowane w języku **Java**. W celach edukacyjnych i demonstracyjnych główny plik `Spoj4.java` implementuje aż **trzy różne metody** odwracania liczb, co pozwala porównać podejścia programistyczne do tego samego zagadnienia:

1. **Wbudowane mechanizmy (`odwrocLiczbe`):**
   Wykorzystuje klasę `StringBuilder` i jej metodę `reverse()`. Liczba zamieniana jest na ciąg znaków, odwracana jednym poleceniem, a następnie rzutowana z powrotem na `int` za pomocą `Integer.parseInt()`. Rzutowanie to bezpiecznie i automatycznie usuwa zera wiodące. Jest to najszybsze w implementacji i najbardziej czytelne podejście.

2. **Pętla po znakach (`odwrocLiczbePetla`):**
   Rozwiązanie operujące na zmiennych typu `String`. Liczba rzutowana jest na tekst, po czym pętla `for` przechodzi po nim od tyłu, budując nowy, odwrócony ciąg znaków poprzez zwykłą konkatenację. Wynik ponownie zamieniany jest na liczbę całkowitą.

3. **Operacje matematyczne i rekurencja (`odwrocLiczbeRekurencyjnie`):**
   Rozwiązanie działające czysto na wartościach liczbowych, bez konieczności rzutowania na tekst. Wykorzystuje rekurencyjną metodę pomocniczą, która w każdym kroku "odcina" ostatnią cyfrę za pomocą operatora modulo (`liczba % 10`) i dodaje ją do przesuwanego o rząd wielkości wyniku (mnożenie przez 10). Dzielenie całkowitoliczbowe (`liczba / 10`) pozwala przechodzić przez kolejne cyfry aż do wyzerowania pierwotnej wartości.
