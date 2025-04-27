package App;

import Util.Options;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Options options = new Options();
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("<-- Welcome to your Task Manager! --> \n");
            System.out.println("Select an option\n 1.Create Task\n 2.Delete Task\n 3.View Tasks\n 4.Exit ");

            try {
                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1 -> options.CreateTask(sc);
                    case 2 -> options.MenuDelete(sc);
                    case 3 -> options.MenuView(sc);
                    case 4 -> {
                        System.out.println("Existing");
                        sc.close();
                    }
                    default -> System.out.println("option invalid, try again \n");
                }
            } catch (Exception e) {
                System.out.println("Input invalid, try again \n");
                sc.nextLine();
            }
        } while (choice != 4);
    }
}