def main():
    liczba_testow = int(input().strip())

    for i in range(liczba_testow):
        ciag_znakow = input().strip()
        stos = []
        wynik = []

        for znak in ciag_znakow:
            if znak.isalpha(): # sprawdzamy czy znak jest literą
                wynik.append(znak)
            elif znak not in '()': # jeśli znak nie jest nawiasem
                stos.append(znak)
            elif znak == ')':
                wynik.append(stos.pop())
        print(''.join(wynik))

if __name__ == "__main__":
    main()
