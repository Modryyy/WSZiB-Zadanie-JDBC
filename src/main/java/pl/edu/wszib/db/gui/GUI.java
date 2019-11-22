package pl.edu.wszib.db.gui;

import pl.edu.wszib.db.DBConnector;
import pl.edu.wszib.model.Pytanie;

import java.util.Scanner;

public class GUI {
        public static void Menu(){
    Scanner scanner = new Scanner(System.in);
    int wyborIdPytania;
            System.out.println("1. Dodaj Pytanie, 2.Usun Pytanie, 3.Odczytaj Pytanie, 4. Edytuj Pytanie, 5. Exit");
    int wybor = scanner.nextInt();


    switch (wybor) {
        case 1:
            AddQuestion();
            Menu();
            break;
        case 2:
            RemoveQuestion();
            Menu();
            break;
        case 3:
            System.out.println("Podaj id pytania ktore chcesz odczytac: ");
            wyborIdPytania = scanner.nextInt();
            Pytanie pytanie = DBConnector.getPytanie(wyborIdPytania);
            System.out.println(pytanie);
            Menu();
            break;
        case 4:

            UpdateQuestion();
            Menu();
            break;
        case 5:
            System.exit(0);
            break;
        default:
            Menu();
            break;
    }

    }

    public static void AddQuestion(){
            Pytanie pytanie = new Pytanie();
            int i =0;
        boolean prawidlowyWybor = false;
       while(DBConnector.getPytanie(i) != null){
            i++;
        }

        pytanie.setIdPytania(i);

        System.out.println("Wybierz nagrode za pytanie!");
        System.out.println("500, 1000, 2000, 5000, 10000, 20000, 40000, 75000, 125000, 250000, 500000, 1000000");
        Scanner scanner = new Scanner(System.in);
        while(prawidlowyWybor == false) {
           String kwota = scanner.nextLine();
            try {
                if (kwota.equals("500") || kwota.equals("1000") || kwota.equals("2000") || kwota.equals("5000") || kwota.equals("10000") ||
                        kwota.equals("20000") || kwota.equals("40000") || kwota.equals("75000") || kwota.equals("125000") || kwota.equals("250000") ||
                        kwota.equals("500000") | kwota.equals("1000000")) {

                    pytanie.setNagroda(Integer.parseInt(kwota));

                    prawidlowyWybor = true;
                }
                else {System.out.println("podaj prawidlowa wartosc");}
            }
            catch (NumberFormatException e) {

            }
        }

        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Podaj tresc Pytania");
        String pyt = scanner1.nextLine();
        pytanie.setPytanie(pyt);

        Scanner scanner2 = new Scanner(System.in);
        Scanner scanner3 = new Scanner(System.in);
        Scanner scanner4 = new Scanner(System.in);
        Scanner scanner5 = new Scanner(System.in);
        System.out.println("Podaj proponowe odpowiedzi Pytania");
        System.out.println("Odpowiedz A: ");
        String odpA = scanner2.nextLine();
        System.out.println("Odpowiedz B: ");
        String odpB = scanner3.nextLine();
        System.out.println("Odpowiedz C: ");
        String odpC = scanner4.nextLine();
        System.out.println("Odpowiedz D: ");
        String odpD = scanner5.nextLine();

        String Odpowiedz = ("a)"+ odpA +"\t" +"b)"+ odpB +"\t" +"c)"+ odpC +"\t" +"d)"+ odpD);
        pytanie.setOdpowiedzi(Odpowiedz);

        System.out.println("Ktora odp jest prawidlowa? ");
        System.out.println("a,b,c czy d");


        boolean prawidlowaodp = false;
        while(prawidlowaodp == false) {
            String PrawidlowaOdp = scanner.nextLine();
            if (PrawidlowaOdp.equals("a")|| PrawidlowaOdp.equals("b")||PrawidlowaOdp.equals("c")||PrawidlowaOdp.equals("d")) {
                pytanie.setPrawidlowaOdpowiedz(PrawidlowaOdp);
                prawidlowaodp = true;
            }
                System.out.println("wpisz poprawnie odpowiedz (tylko 1 litera: a,b,c lub d)");

        }
        System.out.println("idPytania: "+ i);
        DBConnector.addQuestion(pytanie);
        }

    public static void RemoveQuestion() {

        System.out.println("Podaj idPytania ktorego chcesz usunac.");
        Scanner scanner = new Scanner(System.in);
        int idUsuwanegoPytania = scanner.nextInt();

        while (DBConnector.getPytanie(idUsuwanegoPytania) == null) {
            System.out.println("Nie ma takiego pytania! Podaj jeszcze raz idPytania:");
            idUsuwanegoPytania = scanner.nextInt();
            System.out.println("Powrot do menu = -10");
            if (idUsuwanegoPytania == -10) {
                Menu();

            }
        }
            DBConnector.removeQuestion(idUsuwanegoPytania);
        }

        public static void UpdateQuestion(){
            Pytanie pytanie = new Pytanie();

            boolean prawidlowyWybor = false;
            String kwota;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Podaj idPytania ktorego chcesz aktualizowac: ");

            int idAktualizacja = scanner.nextInt();
            while(DBConnector.getPytanie(idAktualizacja) == null){
                System.out.println("Nie ma takiego pytania! Podaj jeszcze raz idPytania:");
                idAktualizacja = scanner.nextInt();

                System.out.println("Powrot do menu = -10");
                if(idAktualizacja == -10){
                    Menu();
                }

            }

            pytanie.setIdPytania(idAktualizacja);

            System.out.println("Wybierz nagrode za pytanie!");
            System.out.println("500, 1000, 2000, 5000, 10000, 20000, 40000, 75000, 125000, 250000, 500000, 1000000");

            while(prawidlowyWybor == false) {
                kwota = scanner.nextLine();
                try {
                    if (kwota.equals("500") || kwota.equals("1000") || kwota.equals("2000") || kwota.equals("5000") || kwota.equals("10000") ||
                            kwota.equals("20000") || kwota.equals("40000") || kwota.equals("75000") || kwota.equals("125000") || kwota.equals("250000") ||
                            kwota.equals("500000") | kwota.equals("1000000")) {

                        pytanie.setNagroda(Integer.parseInt(kwota));

                        prawidlowyWybor = true;
                    }
                    else {System.out.println("podaj prawidlowa wartosc");}
                }
                catch (NumberFormatException e) {

                }
            }

            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Podaj tresc Pytania");
            String pyt = scanner1.nextLine();
            pytanie.setPytanie(pyt);

            Scanner scanner2 = new Scanner(System.in);
            Scanner scanner3 = new Scanner(System.in);
            Scanner scanner4 = new Scanner(System.in);
            Scanner scanner5 = new Scanner(System.in);
            System.out.println("Podaj proponowe odpowiedzi Pytania");
            System.out.println("Odpowiedz A: ");
            String odpA = scanner2.nextLine();
            System.out.println("Odpowiedz B: ");
            String odpB = scanner3.nextLine();
            System.out.println("Odpowiedz C: ");
            String odpC = scanner4.nextLine();
            System.out.println("Odpowiedz D: ");
            String odpD = scanner5.nextLine();

            String Odpowiedz = ("a)"+ odpA +"\t" +"b)"+ odpB +"\t" +"c)"+ odpC +"\t" +"d)"+ odpD);
            pytanie.setOdpowiedzi(Odpowiedz);

            System.out.println("Ktora odp jest prawidlowa? ");
            System.out.println("a,b,c czy d");


            boolean prawidlowaodp1 = false;
            while(prawidlowaodp1 == false) {
                String PrawidlowaOdp = scanner.nextLine();
                if (PrawidlowaOdp.equals("a")|| PrawidlowaOdp.equals("b")||PrawidlowaOdp.equals("c")||PrawidlowaOdp.equals("d")) {
                    pytanie.setPrawidlowaOdpowiedz(PrawidlowaOdp);
                    break;
                }
                System.out.println("wpisz poprawnie odpowiedz (tylko 1 litera: a,b,c lub d)");

            }
            DBConnector.updateQuestion(idAktualizacja, pytanie);
        }
        }

