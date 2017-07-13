# spring-boot-app
# jak uruchomić aplikację

* Wymagane jest istnienie bazy danych 'node_app' (CREATE DATABASE node_app), a następnie przejście do niej (USE node_app) i utworzenie tabeli 'note' poleceniem: 
	CREATE TABLE note (note_id int NOT NULL AUTO_INCREMENT, title VARCHAR(128) NOT NULL,
	content VARCHAR(500) NOT NULL, author VARCHAR(64) NOT NULL, date VARCHAR(64) NOT NULL,
	PRIMARY KEY (note_id) ) ENGINE=InnoDB;

* Budowanie - z poziomu konsoli wywołać komendę ``mvn clean package`` w folderze z plikiem **pom.xml**

* Wygenerowany plik **.war** umieścić na serwerze Tomcat

# co w kolejnych wersjach

* v. 0.1 - aplikacja na serwletach, widok z formularzem z jednym polem, na następnej stronie podwojony komunikat
* v. 0.2 - rozszerzenie do aplikacji "Notes", zmiana formularza na pierwszej stronie na formularz z polami do wpisywania tematu notatki, treści notatki oraz do wpisywania autora. Na drugiej stronie wyświetlenie wprowadzonej notatki (temat, autor, data wprowadzenia, treść).
* v. 0.3 - przekazywanie danych pomiędzy widokiem a drugą stroną w postaci obiektu 'Note' z wyżej wymienionymi polami
* v. 0.4 - oprócz wyświetlania wprowadzonego obiektu notatki na drugiej stronie dodatkowe zapisywanie treści w pliku note_*yyyyMMddhhmm* (gdzie yyyy - rok, MM - miesiąc, dd - dzień, hh - godzina, mm - minuta z daty wprowadzenia notatki)
* v. 0.45 - dodanie walidacji do aplikacji: nie przyjmowanie notatek bez określonego tytułu, treści lub autora, wypisywanie komunikatu "Nie wypełnione wszystkie pola"
* v. 0.5 - połączenie aplikacji do bazy danych MySQL, utworzenie bazy *node_app*, a w niej tabeli *note* i zapisywanie notatki do tabeli przed wyświetleniem jej na ekranie
* v. 0.6 - pokazywanie na pierwszym ekranie aplikacji wszystkich wpisów z notatkami w postaci tabelki (piewsza kolumna: liczba porządkowa, druga kolumna: tytuł notatki, trzecia kolumna: link "Zobacz"). Pod tabelką wyświetlany przycisk "Dodaj notatkę". Po kliknięciu linki "zobacz" wyświetlana strona z tytułem, treścią, autorem i datą wprowadzenia notatki. Po naciśnięciu przycisku "Dodaj notatkę" wyświetlana strona z formularzem dodawania notatki (pierwsza strona z poprzedniej wersji). Po potwierdzeniu powrót do strony głównej z tabelką.
* v. 0.7 - dodanie do tabelki na stronie głównej czwartej kolumny z linkiem "Edytuj". Po kliknięciu w link przejście do strony z formularzem edycji notatki. Po zapisaniu zmienionej notatki w bazie danych przejście do strony z podglądem treści notatki.
* v. 0.8 - dodanie do tabelki na stronie głównej piątej kolumny z linkiem "Usuń". Po kliknięciu w link usunięcie danej notatki z bazy danych i przejście na stronę główną.
* v. 1.0 - zastosowanie w aplikacji frameworka Spring
* v. 1.1 - zastosowanie w aplikacji frameworka SpringBoot
