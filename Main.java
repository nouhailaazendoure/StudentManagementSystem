import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        int choice;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Add student");
            System.out.println("2. Modify student");
            System.out.println("3. Remove student");
            System.out.println("4. Display all students");
            System.out.println("5. Sort by name");
            System.out.println("6. Sort by average");
            System.out.println("7. Search by ID");
            System.out.println("8. Display top student");
            System.out.println("9. Display bottom student");
            System.out.println("10. Display number of passed students");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    ArrayList<Double> grades = new ArrayList<>();
                    System.out.print("How many grades? ");
                    int n = sc.nextInt();
                    sc.nextLine();
                    for (int i = 0; i < n; i++) {
                        System.out.print("Grade " + (i + 1) + ": ");
                        grades.add(sc.nextDouble());
                    }
                    sc.nextLine();
                    manager.addStudent(new Student(name, id, grades));
                    break;

                case 2:
                    System.out.print("ID to modify: ");
                    String modId = sc.nextLine();
                    System.out.print("New Name: ");
                    String newName = sc.nextLine();
                    System.out.print("New ID: ");
                    String newId = sc.nextLine();
                    ArrayList<Double> newGrades = new ArrayList<>();
                    System.out.print("How many grades? ");
                    int m = sc.nextInt();
                    sc.nextLine();
                    for (int i = 0; i < m; i++) {
                        System.out.print("Grade " + (i + 1) + ": ");
                        newGrades.add(sc.nextDouble());
                    }
                    sc.nextLine();
                    manager.modifyStudent(modId, new Student(newName, newId, newGrades));
                    break;

                case 3:
                    System.out.print("ID to remove: ");
                    String remId = sc.nextLine();
                    manager.removeStudent(remId);
                    break;

                case 4: manager.displayAll(); break;
                case 5: manager.sortByName(); manager.displayAll(); break;
                case 6: manager.sortByAverage(); manager.displayAll(); break;

                case 7:
                    System.out.print("ID to search: ");
                    String searchId = sc.nextLine();
                    Student s = manager.searchById(searchId);
                    if (s != null) { System.out.println("Student found:"); s.display(); }
                    else System.out.println("Student not found!");
                    break;

                case 8: manager.displayTopStudent(); break;
                case 9: manager.displayBottomStudent(); break;
                case 10: manager.displayPassedCount(); break;
                case 0: System.out.println("Exiting program..."); break;
                default: System.out.println("Invalid choice!");
            }

        } while (choice != 0);

        sc.close();
    }
}
