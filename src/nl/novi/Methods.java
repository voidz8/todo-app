package nl.novi;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Writer;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Methods {

    private final String absolutePath = Paths.get(".").toAbsolutePath().normalize().toFile() + "\\resources\\";
    private Object TodoList;

    public void menu() {
        System.out.println(Methods.class.getResourceAsStream("/me"));
        Scanner input = new Scanner(System.in);
        System.out.println(ConsoleColors.CYAN);
        System.out.println("Welkom bij de todo app");
        System.out.println("Voer het nummer in van de pagina waar je naartoe wilt:");
        System.out.println("1. Maak een nieuwe todo lijst");
        System.out.println("2. Open een bestaande todo lijst");
        System.out.println("3. Wijzig een bestaande todo lijst");
        System.out.println("4. Bekijk todo's van vandaag");
        System.out.println("5. Bekijk openstaande todo's");
        System.out.println("6. Exit");
        int x = input.nextInt();

        switch (x) {
            case 1:
                createNewTodoList();
                break;
            case 2:
                System.out.println("je hebt 1 gekozen");
                break;
            case 3:
                System.out.println("je hebt 1 gekozen");
                break;
            case 4:
                System.out.println("je hebt 1 gekozen");
                break;
            case 5:
                System.out.println("je hebt 1 gekozen");
                break;
            case 6:
                System.out.println("je hebt 1 gekozen");
                break;
            default:
                System.out.println("De door u gekozen optie bestaat niet het programma word nu afgesloten.");
                System.exit(0);
        }
        input.close();
    }

    private void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private boolean intRange(int startRange, int endRange, int givenInt) {
        return givenInt >= startRange && givenInt <= endRange;
    }

    private void createNewTodoList() {
        Scanner input = new Scanner(System.in);
        clearConsole();
        System.out.println(ConsoleColors.HEADING + "1. Nieuwe todo lijst maken." + ConsoleColors.CYAN);

        System.out.println("Vul de naam van de todo lijst in:");
        TodoList todoList = new TodoList(input.next());

        System.out.println("Vul de week in van de todo lijst:");
        int weekNumber = input.nextInt();
        while (!intRange(1, 52, weekNumber)) {
            System.out.println(ConsoleColors.RED + "Weeknummer bestaat niet. Vul een weeknummer in tussen 1-52." + ConsoleColors.CYAN + "\nVul de week in van de todo lijst:");
            weekNumber = input.nextInt();
        }
        todoList.setWeek(weekNumber);


        System.out.println("1. Voeg todo items toe");
        System.out.println("2. Sla todo lijst op en voeg items later toe");
        int option = input.nextInt();
        while (!intRange(1, 2, option)) {
            System.out.println(ConsoleColors.RED + "Optie " + option + " bestaat niet.\n" + ConsoleColors.CYAN + "Probeer opnieuw:");
            option = input.nextInt();
        }

        if (option == 1) {
            this.saveFile(todoList.getWeek());
            this.addNewTodoItem(todoList);
        }
        if (option == 2) {
            this.saveFile(todoList.getWeek());
        }
    }

    private void addNewTodoItem(Object todoList) {
        System.out.print(todoList);
        Scanner input = new Scanner(System.in);
        System.out.println(ConsoleColors.HEADING + "1. Nieuwe todo taak maken." + ConsoleColors.CYAN);
        System.out.println("Taak naam: ");
        String taskName = input.next();
        System.out.println("Vul het nummer in van dag waarop je de taak wilt uitvoeren:");
        System.out.println("1. Maandag");
        System.out.println("2. Dinsdag");
        System.out.println("3. Woensdag");
        System.out.println("4. Donderdag");
        System.out.println("5. Vrijdag");
        System.out.println("6. Zaterdag");
        System.out.println("7. Zonddag");
        int day = input.nextInt();
        while (!intRange(1, 7, day)) {
            System.out.println(ConsoleColors.RED + "Kies een dag 1-7, " + day + " is geen geldige dag" + ConsoleColors.CYAN + "Probeer opnieuw:");
        }
        System.out.println("Geschatte tijd(minuten): ");
        int estimatedTime = input.nextInt();
        Todo todoItem = new Todo(taskName, estimatedTime, day);
        List<Todo> todoItems = new ArrayList<>();
//        if (todoList.getTodoList() != null) {
//            todoItems = todoList.getTodoList();
//        }
        todoItems.add(todoItem);
//        try {
//            FileOutputStream fos = new FileOutputStream("week-" + todoList.getWeek());
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            oos.writeObject(todoList);
//            oos.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

    private void saveFile(int week) {
        try {
            File file = new File(absolutePath + "week-" + week + ".txt");
            Writer output = new BufferedWriter(new FileWriter(file));
            output.close();
            System.out.println(ConsoleColors.GREEN + "Succesfully saved todo-list" + ConsoleColors.CYAN);
        } catch (Exception e) {
            System.out.println(ConsoleColors.RED + "Error while saving file: " + e + ConsoleColors.CYAN);
        }
    }
}
