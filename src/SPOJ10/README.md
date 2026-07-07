<div align="center">

# HASHIT - Hash it!

[![Tags](https://img.shields.io/badge/Tagi-%23hash--table_%7C_%23hashing-lightgrey?style=flat-square)](#)

</div>

---

## 📝 Treść zadania

Zadanie polega na samodzielnym zaimplementowaniu tablicy z haszowaniem (ang. *hash table*) o stałym rozmiarze 101 elementów, przechowującej klucze w postaci ciągów znaków (maksymalnie 15 liter).

Konieczna jest implementacja następujących operacji:
1. **Znajdź (Find):** Zwraca indeks elementu w tablicy (lub ignoruje, jeśli nie istnieje).
2. **Dodaj (Insert):** Wstawia nowy klucz (ignoruje, jeśli klucz już znajduje się w tablicy).
3. **Usuń (Delete):** Usuwa klucz z tablicy bez przesuwania pozostałych elementów, ustawiając dane miejsce jako puste (ignoruje, jeśli klucz nie istnieje).

Wyznaczanie pozycji elementu opiera się na specyficznej funkcji haszującej:  
$Hash(key) = h(key) \pmod{101}$  
gdzie:  
$h(key) = 19 \times (ASCII(a_1) \times 1 + \dots + ASCII(a_n) \times n)$

Kolizje (sytuacje, gdy różne klucze wskażą ten sam indeks) należy rozwiązywać metodą **adresowania otwartego**. Zgodnie z poleceniem, należy szukać pierwszego wolnego miejsca według wzoru:  
$(Hash(key) + j^2 + 23 \times j) \pmod{101}$  
dla $j = 1, \dots, 19$. Jeśli po sprawdzeniu 20 pozycji (łącznie z pozycją bazową dla $j=0$) algorytm nie znajdzie miejsca, operacja wstawiania zostaje zignorowana.

*Oryginalne tagi: `#hash-table` `#hashing`*

---

## ⚙️ Specyfikacja danych

**Wejście (Input):**
* Pierwsza linia zawiera liczbę przypadków testowych $t$ ($t \le 100$).
* Dla każdego przypadku najpierw podana jest liczba operacji $n_1$ ($n_1 \le 1000$).
* Kolejne linie to komendy w formacie `ADD:string` (dodaj) lub `DEL:string` (usuń). Nie ma pustych linii pomiędzy testami.

**Wyjście (Output):**
* Dla każdego przypadku testowego program musi wypisać:
  * W pierwszej linii: całkowitą liczbę kluczy w tablicy.
  * W kolejnych liniach: `indeks:klucz` dla wszystkich zapisanych kluczy, posortowane rosnąco po indeksach.

---

## 💻 Przykładowe dane

| Wejście (Input) | Wyjście (Output) |
| :--- | :--- |
| `1`<br>`11`<br>`ADD:marsz`<br>`ADD:marsz`<br>`ADD:Dabrowski`<br>`ADD:z`<br>`ADD:ziemii`<br>`ADD:wloskiej`<br>`ADD:do`<br>`ADD:Polski`<br>`DEL:od`<br>`DEL:do`<br>`DEL:wloskiej` | `5`<br>`34:Dabrowski`<br>`46:Polski`<br>`63:marsz`<br>`76:ziemii`<br>`96:z` |

---

## 💡 Realizacja

Rozwiązanie problemu w języku **Java** zostało zrealizowane poprzez manualną obsługę tablicy typu `String[]` o stałym rozmiarze 101 (zgodnie z wymaganiami). Zrezygnowano z gotowych kolekcji typu `HashSet` czy `HashMap`, ponieważ zadanie narzuca bardzo rygorystyczny i niestandardowy sposób obsługi kolizji.

Kluczowe elementy algorytmu:
1. **Funkcja haszująca (`hash`):** Pętla przechodzi po znakach słowa, mnoży ich kod ASCII przez pozycję w słowie (liczoną od 1), mnoży całość przez 19 i zwraca resztę z dzielenia przez 101.
2. **Obsługa kolizji (`find`, `insert`):** Zaimplementowano pętlę sprawdzającą do 20 pozycji ($j$ od $0$ do $19$). Dla $j=0$ sprawdzany jest oryginalny hasz, a dla kolejnych iteracji używane jest przesunięcie kwadratowe ze wzoru $(start + j^2 + 23 \times j) \pmod{101}$.
3. **Zapobieganie duplikatom:** Metoda wstawiająca (`insert`) wywołuje najpierw metodę wyszukującą (`find`). Jeśli dane słowo znajduje się już w tablicy, operacja zostaje wczesniej przerwana, co chroni przed dublowaniem wpisów przy kolizjach adresów.
4. **Usuwanie (`delete`):** Jeśli dany klucz istnieje, algorytm nadpisuje jego pozycję w tablicy wartością `null`. Metoda nie wymaga przesuwania innych elementów.
