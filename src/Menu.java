import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class Menu {

    public static void menu(ArrayList newListOfBooks, Scanner sc) {

        System.out.println("\n ");
        System.out.println("#########     Menu    ##########\n ");
        System.out.println("1. Lister les fichiers ");
        System.out.println("2. Ajouter un fichier ");
        System.out.println("3. Supprimer un fichier ");
        System.out.println("4. Afficher des informations sur un livre ");
        System.out.println("5. Quitter le programme ");


        try {/*sc.nextInt();*/

            int choice = sc.nextInt();
            sc.nextLine();


            switch (choice) {


                case 1:
                    System.out.println("Voici la liste des livres : \n");
                    for (int i = 0; i != newListOfBooks.size(); i++) {
                        System.out.println(newListOfBooks.get(i));
                    }
                    menu(newListOfBooks, sc);
                    break;
                case 2:

                    System.out.println("Merci de renseigner le nom du fichier à ajouter");
                    String lastAdd = sc.nextLine();
                    newListOfBooks.add(lastAdd);
                    System.out.println("Vous avez bien ajouté le fichier : " + newListOfBooks.get(newListOfBooks.indexOf(lastAdd)) + "\n");
                    menu(newListOfBooks, sc);
                    break;


                case 3:

                    System.out.println("Merci de renseigner le n° du fichier à supprimer");


                    for (int i = 0; i != newListOfBooks.size(); i++) {
                        System.out.println(i + 1 + " " + newListOfBooks.get(i));

                    }

                    try {

                        int index = sc.nextInt();
                        newListOfBooks.remove(index - 1);
                        System.out.println("voici votre nouvelle liste :" );
                        for (int i = 0; i != newListOfBooks.size(); i++) {
                            System.out.println(i + 1 + " " + newListOfBooks.get(i));}
                        menu(newListOfBooks, sc);
                        break;

                    } catch (Exception e1) {
                        System.out.println("Vous avez fait une erreur de saisi \nMerci de procéder à un nouveau choix");
                        menu(newListOfBooks, sc);

                    }

                case 4:
                    fourChoice(newListOfBooks);
                    break;

                case 5:
                    System.out.println("Vous venez de quitter le programme !");
                    break;

                default:
                    System.out.println("Prends un café et choisis parmi la plage proposée (stp)");
                    menu(newListOfBooks, sc);
            }
        } catch (Exception e3) {
            System.out.println("Merci de saisir un numérique parmi la plage proposée");
            Scanner sc2 = new Scanner(System.in);
            menu(newListOfBooks, sc2);
        }


    }

    public static void fourChoice(ArrayList list) throws FileNotFoundException {

        System.out.println("###############################\n ");
        System.out.println("---------Voici la liste des fichiers--------");
        for (int i = 0; i != list.size(); i++) {
            System.out.println(i + 1 + " " + list.get(i));
        }


        System.out.println("Sélectionner l'un de ces fichiers : ");
        Scanner sc3 = new Scanner(System.in);
        System.out.println("Quel est votre choix ?");

        int choice = sc3.nextInt();
        sc3.nextLine();

        System.out.println("Vous avez choisi : " + list.get(choice - 1));
        System.out.println("Quel type d'information souhaitez vous obtenir sur le fichier ? ");
        System.out.println("1 : Afficher le nombre de ligne du fichier\n2 : Afficher le nombre de mot du fichier");

        /*underSubMenu(list);*/
        Scanner sc2 = new Scanner(System.in);
        int cho = sc2.nextInt();
        switch (cho) {
            case (1):
                System.out.println("le nombre de ligne dans le fichier est : ");
                System.out.println(displayLinesNumber((String) list.get(choice - 1)));
                System.out.println("\n---->     RETOUR MENU PRINCIPAL");
                menu(list, sc2);
                break;
            case (2):
                System.out.println("le nombre de mot dans le fichier est : ");
                System.out.println(displayWordsNumber((String) list.get(choice - 1)));
                System.out.println("\n---->     RETOUR MENU PRINCIPAL");
                menu(list, sc2);
                break;
        }
    }


    public static int displayLinesNumber(String file) throws FileNotFoundException {

        ArrayList<String> listLines = new ArrayList<>();
        Scanner sc = new Scanner(new File(file));
        for (int i = 0; sc.hasNextLine(); i++) {
            listLines.add(sc.nextLine());

        }
        sc.close();
        return listLines.size();
    }

    public static int displayWordsNumber(String file) throws FileNotFoundException {
        HashMap<String, Integer> listLines = new HashMap<>();

        Scanner sc = new Scanner(new File(file));
        for (int i = 0; sc.hasNextLine(); i++) {


            String line = sc.nextLine();
            if (listLines.containsKey(line)) {
                int compt = listLines.get(line);
                compt++;
                listLines.put(line, compt);
            } else {
                listLines.put(line, 1);
            }

        }
        sc.close();
        return listLines.size();

    }

}















