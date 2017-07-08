# spring-boot-app

# jak uruchomić aplikację

* Budowanie - z poziomu konsoli wywołać komendę ``mvn clean package`` w folderze z plikiem **pom.xml**

* Wygenerowany plik **.war** umieścić na serwerze Tomcat

# co w kolejnych wersjachh

* v. 0.1 - aplikacja na serwletach, widok z formularzem z jednym polem, na następnej stronie podwojony komunikat
* v. 0.2 - rozszerzenie do aplikacji "Notes", zmiana formularza na pierwszej stronie na formularz z polami do wpisywania tematu notatki, treści notatki oraz do wpisywania autora. Na drugiej stronie wyświetlenie wprowadzonej notatki (temat, autor, data wprowadzenia, treść).
* v. 0.3 - przekazywanie danych pomiędzy widokiem a drugą stroną w postaci obiektu 'Note' z wyżej wymienionymi polami
* v. 0.4 - oprócz wyświetlania wprowadzonego obiektu notatki na drugiej stronie dodatkowe zapisywanie treści w pliku note_*yyyyMMddhhmm* (gdzie yyyy - rok, MM - miesiąc, dd - dzień, hh - godzina, mm - minuta z daty wprowadzenia notatki)

* v. 0.5 - połączenie aplikacji do bazy danych MySQL, utworzenie bazy *node_app*, a w niej tabeli *note* i zapisywanie notatki do tabeli przed wyświetleniem jej na ekranie
