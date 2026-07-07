<div align="center">

# TAUT - Tautology

[![Tags](https://img.shields.io/badge/Tagi-%23logic-lightgrey?style=flat-square)](#)

</div>

---

## 📝 Treść zadania

Zadanie polega na napisaniu programu, który weryfikuje, czy podane wyrażenie logiczne jest **tautologią**. Wyrażenie jest tautologią, jeśli zawsze przyjmuje wartość prawdy, niezależnie od wartości logicznych przypisanych do jego zmiennych.

Wyrażenie zapisane jest w **notacji polskiej (prefiksowej)**, co oznacza, że operator zawsze poprzedza swoje argumenty. W zadaniu wykorzystywane są następujące operatory logiczne:
* `C` – Koniunkcja (AND)
* `D` – Alternatywa (OR)
* `I` – Implikacja (IF... THEN)
* `E` – Równoważność (IF AND ONLY IF)
* `N` – Negacja (NOT)

Zmienne są reprezentowane przez małe litery alfabetu (`a-z`). Gwarantowane jest, że w pojedynczym wyrażeniu może wystąpić maksymalnie 16 różnych zmiennych, a jego całkowita długość nie przekroczy 111 znaków.

---

## ⚙️ Specyfikacja danych

**Wejście (Input):**
* Pierwsza linia zawiera liczbę wyrażeń do sprawdzenia (maksymalnie 35).
* Kolejne linie to pojedyncze wyrażenia logiczne zapisane w notacji prefiksowej bez użycia spacji.

**Wyjście (Output):**
* Dla każdego wyrażenia należy w nowej linii wypisać słowo `YES`, jeśli jest ono tautologią, lub `NO` w przeciwnym wypadku.

---

## 💻 Przykładowe dane

| Wejście (Input) | Wyjście (Output) |
| :--- | :--- |
| `7`<br>`IIpqDpNp`<br>`NCNpp`<br>`Iaz`<br>`NNNNNNNp`<br>`IIqrIIpqIpr`<br>`Ipp`<br>`Ezz` | <br>`YES`<br>`YES`<br>`NO`<br>`NO`<br>`YES`<br>`YES`<br>`YES` |

---

## 💡 Realizacja

Problem weryfikacji tautologii jest wariantem klasycznego problemu spełnialności (SAT). Ze względu na sztywne ograniczenie do zaledwie 16 unikalnych zmiennych, optymalnym i najpewniejszym podejściem jest rozwiązanie typu *brute-force*, sprawdzające wszystkie możliwe wartościowania. 

Zaimplementowany w **Javie** kod bazuje na dwóch kluczowych mechanizmach:

1. **Generowanie tablicy prawdy (Maska bitowa):**
   Program analizuje wyrażenie, wyszukując wszystkie unikalne zmienne (małe litery) za pomocą zbioru `HashSet`. Mając $N$ unikalnych zmiennych, wiemy, że istnieje dokładnie $2^N$ możliwych kombinacji wartości Prawda/Fałsz. Pętla wykorzystująca przesunięcia bitowe (`1 << n`) traktuje kolejne liczby całkowite jako maski binarne, błyskawicznie generując i podstawiając każdy z możliwych stanów logicznych dla zestawu zmiennych.

2. **Ewaluacja notacji prefiksowej (Rekurencja):**
   Notacja prefiksowa eliminuje problem priorytetów operatorów oraz nawiasów, co pozwala na proste przeliczenie wyrażenia algorytmem rekurencyjnego zejścia. Ewaluator (`eval`) czyta ciąg od lewej do prawej używając globalnego wskaźnika tablicowego `pos[0]`. 
   * Napotkanie zmiennej kończy gałąź i zwraca jej wartość z obecnej maski bitowej.
   * Napotkanie operatora jednoargumentowego (`N`) rekurencyjnie oblicza i odwraca kolejny element.
   * Napotkanie operatora dwuargumentowego (`C`, `D`, `I`, `E`) wykonuje dwa kolejne zagnieżdżone wywołania, zdobywając wartości lewego oraz prawego operandu, po czym wykonuje na nich właściwą operację logiczną.
