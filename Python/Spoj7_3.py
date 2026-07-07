dlugosc = int(input().strip())
dna = input().strip()

oczekiwany = 'A'
liczba_mutacji = 0

i = dlugosc - 1
while i > 0:
    if dna[i] != oczekiwany: # Jeśli znak na pozycji i nie zgadza się z oczekiwanym, to potrzebna jest mutacja
        if dna[i - 1] != oczekiwany: # Jeśli poprzedni znak również nie pasuje, to wykonujemy mutację typu "odwrócenie prefiksu"
            oczekiwany = dna[i]
            i -= 1
        liczba_mutacji += 1
    i -= 1

if dna[0] != oczekiwany: liczba_mutacji += 1

print(liczba_mutacji)