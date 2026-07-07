<div align="center">

# SBANK - Sorting Bank Accounts

[![Tags](https://img.shields.io/badge/Tagi-%23sorting_%7C_%23ad--hoc--1-lightgrey?style=flat-square)](#)

</div>

---

## 📝 Treść zadania

W jednym z banków internetowych każdego dnia wykonywane są tysiące operacji. Ponieważ niektórzy klienci są bardziej aktywni od innych, część numerów kont bankowych pojawia się na liście operacji wielokrotnie. 

Twoim zadaniem jest posortowanie numerów kont bankowych w porządku rosnącym (leksykograficznie). Jeśli dane konto występuje na liście więcej niż jeden raz, tuż za numerem konta należy podać liczbę jego powtórzeń. Format konta to: 2 cyfry kontrolne, 8-cyfrowy kod banku oraz 16 cyfr identyfikujących właściciela (zapisanych w grupach po cztery cyfry).

> **Ostrzeżenie:** Banki to instytucje działające w czasie rzeczywistym, dlatego wymagają **SZYBKICH** rozwiązań. Zadanie posiada bardzo rygorystyczny limit czasowy. Dobrze zaprojektowany algorytm sortujący i optymalne zarządzanie wejściem/wyjściem to klucz do sukcesu.

---

## ⚙️ Specyfikacja danych

**Wejście (Input):**
* Pierwsza linia zawiera liczbę przypadków testowych $t$ ($t \le 5$).
* Dla każdego przypadku najpierw podana jest liczba kont $n$ ($n \le 100 000$).
* Następnie znajduje się lista $n$ kont bankowych (każde konto posiada dokładnie jedną spację na samym końcu linii).
* Pomiędzy testami występuje pusta linia.

**Wyjście (Output):**
* Posortowana lista kont wraz z liczbą ich wystąpień (oddzielona spacją).
* Wyniki dla poszczególnych przypadków testowych muszą być oddzielone pustą linią.

---

## 💻 Przykładowe dane

| Wejście (Input) | Wyjście (Output) |
| :--- | :--- |
| `2`<br>`6`<br>`03 10103538 2222 1233 6160 0142 `<br>`03 10103538 2222 1233 6160 0141 `<br>`30 10103538 2222 1233 6160 0141 `<br>`30 10103538 2222 1233 6160 0142 `<br>`30 10103538 2222 1233 6160 0141 `<br>`30 10103538 2222 1233 6160 0142 `<br><br>`5`<br>`30 10103538 2222 1233 6160 0144 `<br>`30 10103538 2222 1233 6160 0142 `<br>`30 10103538 2222 1233 6160 0145 `<br>`30 10103538 2222 1233 6160 0146 `<br>`30 10103538 2222 1233 6160 0143 ` | `03 10103538 2222 1233 6160 0141 1`<br>`03 10103538 2222 1233 6160 0142 1`<br>`30 10103538 2222 1233 6160 0141 2`<br>`30 10103538 2222 1233 6160 0142 2`<br><br>`30 10103538 2222 1233 6160 0142 1`<br>`30 10103538 2222 1233 6160 0143 1`<br>`30 10103538 2222 1233 6160 0144 1`<br>`30 10103538 2222 1233 6160 0145 1`<br>`30 10103538 2222 1233 6160 0146 1` |

---

## 💡 Realizacja

Maksymalna liczba kont w jednym teście to aż 100 000. Oznacza to, że tradycyjne metody wczytywania i wypisywania danych (jak klasa `Scanner` czy wielokrotne wywołanie `System.out.println()`) doprowadziłyby do przekroczenia limitu czasu (Time Limit Exceeded).

Rozwiązanie zaimplementowane w języku **Java** zostało wysoce zoptymalizowane pod kątem wydajności I/O oraz struktury danych:

1. **Szybkie wejście/wyjście:**
   Do odczytu zastosowano strumień `BufferedReader`, który buforuje dane wejściowe, drastycznie skracając czas odczytu setek tysięcy linii. Na wyjściu użyto klasy `StringBuilder`, która zbiera cały wynik do jednego obiektu i wypisuje go na konsolę pojedynczym wywołaniem `System.out.print()`. Zadbano również o rzetelną obsługę pustych znaków nowej linii (`do-while`).

2. **Agregacja (Hashowanie):**
   Zamiast zapisywać wszystkie konta do wielkiej tablicy, a potem ją sortować i liczyć duplikaty (co wymagałoby ogromnej pamięci), użyto struktury `HashMap<String, Integer>`. Służy ona jako słownik – od razu grupuje identyczne ciągi znaków (konta) i inkrementuje ich licznik.

3. **Sortowanie końcowe:**
   Dopiero po zagregowaniu unikalnych kont, zbiór kluczy (`keySet`) przenoszony jest do klasycznej listy `ArrayList`, gdzie wbudowana, wysoce zoptymalizowana metoda `Collections.sort()` układa je alfabetycznie przed wypisaniem na ekran.
