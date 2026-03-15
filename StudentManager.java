import java.util.ArrayList;

public class StudentManager {
    ArrayList<Student> list = new ArrayList<>();

    void addStudent(Student s) {
        for (Student st : list) {
            if (st.id.equals(s.id)) {
                System.out.println("ID already exists!");
                return;
            }
        }
        list.add(s);
        System.out.println("Student added successfully!");
    }

    void modifyStudent(String id, Student newStudent) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).id.equals(id)) {
                list.set(i, newStudent);
                System.out.println("Student modified successfully!");
                return;
            }
        }
        System.out.println("Student not found!");
    }

    void removeStudent(String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).id.equals(id)) {
                list.remove(i);
                System.out.println("Student removed successfully!");
                return;
            }
        }
        System.out.println("Student not found!");
    }

    void sortByName() {
        list.sort((s1, s2) -> s1.name.compareTo(s2.name));
        System.out.println("Sorted by name successfully!");
    }

    void sortByAverage() {
        list.sort((s1, s2) -> Double.compare(s2.average(), s1.average()));
        System.out.println("Sorted by average successfully!");
    }

    Student searchById(String id) {
        for (Student s : list) {
            if (s.id.equals(id)) return s;
        }
        return null;
    }

    void displayAll() {
        if (list.isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        System.out.println("\nStudent List:");
        for (Student s : list) s.display();
    }

    void displayTopStudent() {
        if (list.isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        Student top = list.get(0);
        for (Student s : list) if (s.average() > top.average()) top = s;
        System.out.println("Top Student:");
        top.display();
    }

    void displayBottomStudent() {
        if (list.isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        Student bottom = list.get(0);
        for (Student s : list) if (s.average() < bottom.average()) bottom = s;
        System.out.println("Bottom Student:");
        bottom.display();
    }

    void displayPassedCount() {
        if (list.isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        int count = 0;
        for (Student s : list) if (s.average() >= 10) count++;
        System.out.println("Number of students passed: " + count + " out of " + list.size());
    }
}