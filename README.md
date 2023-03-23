# Serwis-Aukcyjny

W ramach projektu chce utworzyć system umożliwiający wystawianie aukcji oraz licytowanie przedmiotów. Dodatkowo system ma umożliwiać zakładanie kont dla użytkowników oraz umożliwiać ocenę transakcji.

Główne funkcje systemu:
  Strona główna
  Kategorie
  Konto użytkownika
  Aukcje
  Wyszukiwanie aukcji
  Licytacje i zakupy Kup teraz
  Oceny transakcji
  Obserwacja aukcji

Technologie:
  Spring + Hibernate
  Frontend Bootrap

Dodatkowe Funkcjonalności:
  Zewnetrzne Rest Api do pobierania aukcji np z allegro czy ceneo 
  Mozliwość załadowania aukcji z csv/xml
  
Podstawowe byty:

Kategoria:
  nazwa
  opisowa nazwa
  logotyp/miniaturka (opcjonalnie)
  
Konto użytkownika:
  login (email wykorzystywany do komunikacji i powiadomień)
  hasło
  nazwa konta (prezentowana na profilu konta)
  województwo
  miasto
  adres (ulica, nr domu, kod pocztowy)
  data założenia konta
  status konta (AKTYWNE/NIEAKTYWNE/ZABLOKOWANE)
  logotyp/miniaturka/awatar
  typ (NORMALNE/PREMIUM)
  
Aukcja/Produkt:
  tytuł
  opis
  zdjęcia (opcjonalnie)
  kategoria
  kwota minimalna
  kwota Kup Teraz
  promowana (można przyjąć, że konto premium, może promować np. 10 aukcji w miesiącu)
  lokalizacja (odpowiada lokalizacji konta użytkownika)
  data wystawienia
  data zakończenia (lub jesli produkt to bezterminowo)
  ilość odwiedzin (wyświetleń strony aukcji)
  
Licytacja:
  aukcja
  użytkownik
  kwota
  
Linia zamówienia:
  Produkt (encja)
  Liczba produktów
  Cena produktu
  Koszt Dostawy

Zamówienie:
  Nazwa użytkownika
  Koszt całościowy
  Adres dostawy
  Adres użytkownika
  Data złożenia
  Linie zamówienia (encje)
  Klient (encja)
  Status (enum)

Zakup (byt odpowiadający najwyższej licytacji lub Kup teraz):
  aukcja
  użytkownik
  kwota

Autor:
  Imię
  Nazwisko
  
Rola:
  Nazwa roli

Koszyk (nie encja):
  Linie zamówienia
  
Funkcjonalności admina:
  Dodawanie kategorii
  nazwa kategorii
  id rodzica
  
Przegląd drzewa kategorii:
  wyszukiwanie kategorii
  możliwość przeciągania kategorii (zmiany położenia)

Dodawanie produktu:
  wybór aukcja/kup teraz
  nazwa
  opis
  url obrazka
  stan magazynowy
  cena
  typ produktu (dropdown)
  kategoria (dropdown)
  autor (dropdown)
  
Lista produktów:
  lista wszystkich dodanych produktów z wypisaniem ich danych
  przycisk do przejścia na edycję danego produktu
  wyszukiwanie produktów
  
Funkcjonalności użytkownika(Kupującego):
  Rejestracja użytkownika
  wpisywanie danych do pól formularza + walidacja tych pól
  Logowanie
  możliwość zalogowania się użytkownika (po uprzedniej rejestracji)
  możliwość wylogowania użytkownika
  
Funkcjonalności użytkownika(Sprzedawców):
  Rejestracja użytkownika
  wpisywanie danych do pól formularza + walidacja tych pól
  Logowanie
  możliwość zalogowania się użytkownika (po uprzedniej rejestracji)
  możliwość wylogowania użytkownika
  możliwość wystawiania produktów na sprzedaż aukcja/kup teraz


Obserwacja aukcji:
  aukcja
  użytkownik
  
Ocena transakcji (zakupu):
  zakup
  ocena sprzedającego
  komentarz sprzedającego
  ocena kupującego
  komentarz kupującego
  
Funkcjonalności:

Prezentowanie strony głównej:
  prezentacja kategorii (głównych – jeśli ich struktura będzie drzewiasta): np. lista linków w lewej lub prawej kolumnie, prowadzących do aukcji z wybranej kategorii
  prezentacja listy ostatnio dodanych aukcji (np. 10)
  prezentacja listy kończących się aukcji (np. 10)
  prezentacja listy aukcji zalogowanego usera (wystawionych)
  prezentacja listy aukcji, które licytuje zalogowany user
  prezentacja listy aukcji obserwowanych
  prezentacja listy aukcji „właśnie zakończonych” (np. 10)
  (opcjonalnie) dodatkowe listy aukcji, np. najpopularniejsze (najwięcej licytacji albo odwiedzin)
  
Wybór kategorii aukcji:
  lista kategorii, w których umieszczane są aukcje
  (opcjonalnie) lista może być strukturą drzewiastą z zagłębieniami; prezentacja i wyszukiwanie aukcji musi to uwzględniać)
  (opcjonalnie) administracja kategoriami (podstawowa wersja ma z góry narzucone kategorie)
  
Zarządzanie kontem użytkownika:
  formularz umożliwiający założenie konta
  strona (dostępna po zalogowaniu) umożliwiająca edycję danych konta(admin)
  podobnie jak na stronie głównej, powinny się tu pojawić listy aukcji: obserwowanych, wystawionych, licytowanych (także przegranych) i zakończonych (wygranych, jak i    tych, które nie uzyskały kwoty minimalnej)
  (opcjonalnie) prezentacja ocen i komentarzy z aukcji
  (opcjonalnie) dodanie roli administratora, który może także blokować konto
  
Wystawianie aukcji:
  formularz umożliwiający wystawienie aukcji i określenie jej parametrów
  aukcję można skasować (jeśli nie było licytacji)
  aukcje/produkty można zablokować (usunąć dla klientów ale zostawic w bazie na liscie produktów sprzedawcy)
  
Wyszukiwanie aukcji:
  strona prezentująca wyniki wyszukiwania aukcji
  prowadzą do niej np. linki kategorii ze strony głównej
  wszędzie, gdzie prezentowana jest nazwa kategorii, powinna być ona klikalna i prowadzić do strony z prezentacją wyników
  dodatkowo na stronie z wynikami można ograniczać/filtrować aukcje (np. po województwie i mieście) oraz sortować, np. po dacie dodania, po dacie końca aukcji
  mechanizm musi uwzględniać aukcje premium i prezentować je „najpierw”
  (opcjonalnie) pole na wpisanie nru aukcji lub nazwy konta: szukanie po numerze (prezentuje konkretną aukcję), szukanie aukcji usera (prezentuje listę jego aukcji)
  
Licytacje i zakupy:
  zalogowany użytkownik może zalicytować na aukcji
  może podać dowolną kwotę
  może od razu wybrać Kup teraz
  można licytować tylko na trwające aukcje
  najwyższa oferta albo Kup teraz staje się Zakupem
  jeśli nie została osiągnięta kwota minimalna, to nie ma zwycięzcy
  Uwaga! Dla uproszczenia trzeba napisać mechanizm, który będzie uruchamiany przy każdym wejściu na stronę i będzie „zamykał” aukcje, które się skończyły (od             ostatniego wejścia na stronę) i wyłaniał zwycięzców
  (opcjonalnie) z pomocą Trenera można się pokusić o użycie Schedulera/Quartza/Crona
  
Oceny transakcji:
  zarówno sprzedający, jak i kupujący może wystawić ocenę oraz komentarz
  
Obserwacja aukcji
  zalogowany użytkownik może dodać aukcję do obserwowanych
  po wejściu na obserwowaną aukcję, fakt ten powinien być zaznaczony, np. napisem albo obrazkiem gwiazdki

