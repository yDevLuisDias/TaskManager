package Util;

import java.util.ArrayList;
import java.util.Scanner;

public class Options {
    ArrayList<Tasks> TaskList = new ArrayList<>();

    private String promptInput(Scanner sc, String s) {
        System.out.println(s);
        return sc.nextLine();
    }

    public void CreateTask(Scanner sc) {
        String name = promptInput(sc, "What name of task?");
        String des = promptInput(sc, "What is description of task?");
        String valid = promptInput(sc, "What validate of task?");

        Tasks newTasks = new Tasks(name, des, valid);
        TaskList.add(newTasks);

        System.out.println("Task created successfully!");
    }

    public void MenuView(Scanner sc) {

        if (TaskList.isEmpty()) {
            System.out.println("No task saved");
            return;
        }

        System.out.println("Want form preference search ? \n Chose an option");
        System.out.println("1.Search of ID \n2.Search all task saved \n3.Back");

        try {
            byte choice = sc.nextByte();
            sc.nextLine();

            switch (choice) {
                case 1 -> ViewSearch(sc);
                case 2 -> ViewAll();
                case 3 -> {
                }
                default -> System.out.println("Option invalid, try again \n");
            }
        } catch (Exception e) {
            System.out.println("input invalid");
        }
    }

    private void ViewSearch(Scanner sc) {
        int ID = 0;
        try {
            System.out.println("What is ID of task? (1 to " + TaskList.size() + ").");
            ID = sc.nextInt();
            sc.nextLine();

            if (ID > TaskList.size() + 1 || ID < 1) {
                System.out.println("Input invalid");
            }

        } catch (Exception e) {
            System.out.println("Input invalid, try again");
            sc.nextLine();
        }

        System.out.println("This is your task ?:");
        System.out.println(TaskList.get(ID - 1));
        System.out.println("y/n");
        String choice = sc.nextLine();

        if (choice.equals("n") || choice.equals("N")) {
            ViewSearch(sc);
        } else if (!choice.equals("y") && !choice.equals("Y")) {
            System.out.println("Input invalid, try again");
            ViewSearch(sc);
        }
    }

    private void ViewAll() {
        byte i;

        System.out.println("<-- All task saved -->");
        for (i = 0; i < TaskList.size(); i++) {
            System.out.println("Task #" + (i + 1));
            System.out.println("\n" + TaskList.get(i));
            System.out.println("<--------------------> \n");
        }
        System.out.println("All task displayed \n");
    }

    public void MenuDelete(Scanner sc) {

        if (TaskList.isEmpty()) {
            System.out.println("No task for delete");
            return;
        }
        try {
            System.out.println("What option you want, for delete task? \n1.Delete for the Id \n2.Delete All \n3.Back");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> deleteIdTask(sc);
                case 2 -> deleteAllTask();
                case 3 -> {
                }
                default -> System.out.println("Input invalid");
            }
        } catch (Exception e) {
            System.out.println("Option invalid, try again");
        }
    }

    private void deleteIdTask(Scanner sc) {
        try {
            System.out.println("Which task do you  want removed? (1 to " + TaskList.size() + " ).");
            int i = sc.nextInt();
            sc.nextLine();
            System.out.println(TaskList.get(i - 1));

            System.out.println("\nDo you want to delete this task \n(y/n)?");
            String choice = sc.nextLine();

            if (choice.equals("y") || choice.equals("Y")) {
                TaskList.remove(i - 1);
                System.out.println("Task removed successfully!");

            } else if (!choice.equals("n") && !choice.equals("N")) {
                System.out.println("Input invalid, try again");
                MenuDelete(sc);
            }

        } catch (Exception e) {
            System.out.println("Input invalid, try again");
        }
    }

    private void deleteAllTask() {
        int i;
        for (i = 0; i < TaskList.size(); i++) {
            TaskList.remove(i);
        }
        System.out.println("All task delete successfully! \n");
    }
}