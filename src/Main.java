import java.util.ArrayList;
import java.util.Scanner;

public class Main {



    public static void main(String[] args)
    {

        ArrayList<String> listOfBooks = new ArrayList<>();
        listOfBooks.add("Ressources/Smith-Richesse_des_Nations_1.txt");
        listOfBooks.add("Ressources/Smith-Richesse_des_Nations_2.txt");
        listOfBooks.add("Ressources/Smith-Richesse_des_Nations_3.txt");
        listOfBooks.add("Ressources/Smith-Richesse_des_Nations_4.txt");
        listOfBooks.add("Ressources/Smith-Richesse_des_Nations_5.txt");

        Scanner sc = new Scanner(System.in);
        Menu.menu(listOfBooks, sc);
    }
}
