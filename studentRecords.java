import java.util.ArrayList;
import java.util.Scanner;

public class studentRecords {

    public static void searchStudents(ArrayList<student> records, Scanner sc) {

        System.out.println("\nDo you want to Search? Yes/No");

        if (!sc.nextLine().equalsIgnoreCase("Yes")) {return;}

        System.out.println("Search by Id, Name, or Gpa?");

        String searchChoice = sc.nextLine();

        if (searchChoice.equalsIgnoreCase("Id")) {

            System.out.println("Enter ID:");

            int idTarget = sc.nextInt();
            sc.nextLine();

            studentAlgorithm.bubbleSort(records, "Id");

            student result = studentAlgorithm.binarySearchById(records, idTarget);

            if (result != null) {
                System.out.println(result.getName() + " target found!");
            }
            else {
                System.out.println("Student not found.");
            }
        }

        else if (searchChoice.equalsIgnoreCase("Name")) {

            System.out.println("Enter Name:");

            String nameTarget = sc.nextLine();
            boolean found = false;

            for (student s : records) {

                if (s.getName().equalsIgnoreCase(nameTarget)) {

                    System.out.println(s.getName() + " target found!");
                    found = true;
                }
            }

            if (!found) {
                System.out.println("Student not found.");
            }
        }

        else if (searchChoice.equalsIgnoreCase("Gpa")) {

            System.out.println("Enter GPA:");

            double gpaTarget = sc.nextDouble();
            sc.nextLine();

            boolean found = false;

            for (student s : records) {

                if (s.getGpa() == gpaTarget) {

                    System.out.println(s.getName() + " target found!");
                    found = true;
                }
            }

            if (!found) {
                System.out.println("Student not found.");
            }
        }

        else {
            System.out.println("Invalid search option.");
        }
    }


    public static void addStudents(ArrayList<student> records, Scanner sc) {

        boolean continueMore = true;

        while (continueMore) {

            System.out.println("\nEnter Student ID:");

            int userId = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter Student Name:");

            String userName = sc.nextLine();

            System.out.println("Enter Student GPA:");

            double userGpa = sc.nextDouble();
            sc.nextLine();

            student userStudent = new student(userId, userName, userGpa);

            records.add(userStudent);

            System.out.println("Another? Yes/No");

            String answer = sc.nextLine();

            if (answer.equalsIgnoreCase("No")) {
                continueMore = false;
            }
        }
    }

    public static void updateStudent(ArrayList<student> records, Scanner sc) {

        System.out.println("\nDo you want to update? Yes/No");

        if (!sc.nextLine().equalsIgnoreCase("Yes")) {return;}

        System.out.println("Search by Id, Name, or Gpa?");
        String searchChoice = sc.nextLine();

        student foundStudent = null;

        if (searchChoice.equalsIgnoreCase("Id")) {

            System.out.println("Enter ID:");
            int idTarget = sc.nextInt();
            sc.nextLine();

            for (student s : records) {
                if (s.getId() == idTarget) {
                    foundStudent = s;
                    break;
                }
            }

        } else if (searchChoice.equalsIgnoreCase("Name")) {

            System.out.println("Enter Name:");
            String nameTarget = sc.nextLine();

            for (student s : records) {
                if (s.getName().equalsIgnoreCase(nameTarget)) {
                    foundStudent = s;
                    break;
                }
            }

        } else if (searchChoice.equalsIgnoreCase("Gpa")) {

            System.out.println("Enter GPA:");
            double gpaTarget = sc.nextDouble();
            sc.nextLine();

            for (student s : records) {
                if (s.getGpa() == gpaTarget) {
                    foundStudent = s;
                    break;
                }
            }

        } else {

            System.out.println("Invalid search option.");
            return;
        }
        if (foundStudent == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.println("\nStudent found!");
        System.out.println("ID: " + foundStudent.getId());
        System.out.println("Name: " + foundStudent.getName());
        System.out.println("GPA: " + foundStudent.getGpa());

        System.out.println("\nWhat do you want to updated Id, Name, or Gpa?");

        String updateChoice = sc.nextLine();

        if (updateChoice.equalsIgnoreCase("Id")) {

            System.out.println("Enter new ID:");
            int replaceId = sc.nextInt();
            sc.nextLine();

            foundStudent.setId(replaceId);

            System.out.println("ID updated to: " + foundStudent.getId());

        } else if (updateChoice.equalsIgnoreCase("Name")) {

            System.out.println("Enter new Name:");
            String replaceName = sc.nextLine();

            foundStudent.setName(replaceName);

            System.out.println("Name updated to: " + foundStudent.getName());

        } else if (updateChoice.equalsIgnoreCase("Gpa")) {

            System.out.println("Enter new GPA:");
            double replaceGpa = sc.nextDouble();
            sc.nextLine();

            foundStudent.setGpa(replaceGpa);

            System.out.println("GPA updated to: " + foundStudent.getGpa());

        } else {
            System.out.println("Invalid update option.");
        }
    }

    public static void deleteStudent(ArrayList<student> records, Scanner sc) {

        System.out.println("\nDo you want to Delete? Yes/No");

        if (!sc.nextLine().equalsIgnoreCase("Yes")) {return;}

        System.out.println("Search by Id, Name, or Gpa?");

        String deleteChoice = sc.nextLine();

        if (deleteChoice.equalsIgnoreCase("Id")) {

            System.out.println("Enter ID:");

            int idTarget = sc.nextInt();
            sc.nextLine();

            boolean found = false;

            for (int i = 0; i < records.size(); i++) {

                if (records.get(i).getId() == idTarget) {

                    System.out.println(records.get(i).getName() + " target found!");

                    records.remove(i);

                    System.out.println("Student deleted!");

                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Student not found.");
            }
        }

        else if (deleteChoice.equalsIgnoreCase("Name")) {

            System.out.println("Enter Name:");

            String nameTarget = sc.nextLine();

            boolean found = false;

            for (int i = 0; i < records.size(); i++) {

                if (records.get(i).getName().equalsIgnoreCase(nameTarget)) {

                    System.out.println(records.get(i).getName() + " target found!");

                    records.remove(i);

                    System.out.println("Student deleted!");

                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Student not found.");
            }
        }

        else if (deleteChoice.equalsIgnoreCase("Gpa")) {

            System.out.println("Enter GPA:");

            double gpaTarget = sc.nextDouble();

            sc.nextLine();

            boolean found = false;

            for (int i = 0; i < records.size(); i++) {

                if (records.get(i).getGpa() == gpaTarget) {

                    System.out.println(records.get(i).getName() + " target found!");

                    records.remove(i);

                    System.out.println("Student deleted!");

                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Student not found.");
            }
        }

        else {
            System.out.println("Invalid delete option.");
        }
    }
    public static void sortStudents(ArrayList<student> records, Scanner sc) {

        System.out.println("\nDo you want to sort? Yes/No");

        if (!sc.nextLine().equalsIgnoreCase("Yes")) {return;}
        System.out.println("\nSort by Id, Name, or Gpa?");

        String sortChoice = sc.nextLine();

        if (!sortChoice.equalsIgnoreCase("Id") && !sortChoice.equalsIgnoreCase("Name") && !sortChoice.equalsIgnoreCase("Gpa")) {
            System.out.println("Invalid sort option.");
            return;
        }

        System.out.println("\nChoose Sorting Algorithm:");

        System.out.println("1. Bucket Sort");
        System.out.println("2. Radix Sort");
        System.out.println("3. Bubble Sort");
        System.out.println("4. Quick Sort");
        System.out.println("5. Merge Sort");

        int algorithmChoice = sc.nextInt();
        sc.nextLine();

        if (algorithmChoice == 1) {

            if (sortChoice.equalsIgnoreCase("Id")|| sortChoice.equalsIgnoreCase("Gpa")) {
                studentAlgorithm.bucketSort(records, sortChoice);
            }

            else {
                System.out.println("Bucket Sort requires numeric data.");
                return;
            }
        }

        else if (algorithmChoice == 2) {

            if (sortChoice.equalsIgnoreCase("Id")|| sortChoice.equalsIgnoreCase("Gpa")) {
                studentAlgorithm.radixSort(records, sortChoice);
            }

            else {
                System.out.println("Radix Sort requires numeric data.");
                return;
            }
        }

        else if (algorithmChoice == 3) {

            studentAlgorithm.bubbleSort(records, sortChoice);
        }

        else if (algorithmChoice == 4) {

            studentAlgorithm.quickSort(records,0,records.size() - 1, sortChoice);
        }

        else if (algorithmChoice == 5) {

            studentAlgorithm.mergeSort(records,0,records.size() - 1,sortChoice);
        }

        else {
            System.out.println("Invalid algorithm option.");
            return;
        }

        System.out.println("\nSorted!");

        displayStudents(records);
    }


    public static void displayStudents(ArrayList<student> records) {

        System.out.println("\nStudent Records:");

        for (student s : records) {

            System.out.println("ID: " + s.getId() + " Name: " + s.getName()  + " GPA: " + s.getGpa());
        }
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<student> records = new ArrayList<>();

        addStudents(records, sc);
        searchStudents(records, sc);

        updateStudent(records, sc);
        deleteStudent(records, sc);
        sortStudents(records, sc);

        sc.close();
    }
}