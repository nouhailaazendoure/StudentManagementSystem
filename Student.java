import java.util.ArrayList;

public class Student {
    String name;
    String id;
    ArrayList<Double> grades = new ArrayList<>();

    Student(String name, String id, ArrayList<Double> grades) {
        this.name = name;
        this.id = id;
        this.grades = grades;
    }

    double average() {
        if (grades.isEmpty()) return 0;
        double sum = 0;
        for (double g : grades) sum += g;
        return sum / grades.size();
    }

    void display() {
        System.out.print("Name: " + name + " | ID: " + id + " | Grades: ");
        for (int i = 0; i < grades.size(); i++) {
            System.out.print(grades.get(i));
            if (i < grades.size() - 1) System.out.print(", ");
        }
        System.out.println(" | Average: " + average());
    }
}