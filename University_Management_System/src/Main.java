import services.UniversityService;
import utils.InputValidator;

public class Main {
    public static void main(String[] args) {
        UniversityService service = new UniversityService();
        boolean running = true;

        System.out.println("UNIVERSITY MANAGEMENT SYSTEM v1.0");

        while (running) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Teachers List");
            System.out.println("2. Students List (Detailed)");
            System.out.println("3. Class list and details");
            System.out.println("4. Register new Student");
            System.out.println("5. Create new Class");
            System.out.println("6. Find class per student (ID)");
            System.out.println("7. Quit");

            int option = InputValidator.readInt("Please select an option: ", 1, 7);

            switch (option) {
                case 1 : service.displayAllTeachers(); break;
                case 2 : service.displayAllStudents();
                case 3 : service.displayClassesAndDetails(); break;
                case 4: service.registerNewStudent(); break;
                case 5 : service.createNewUniversityClass(); break;
                case 6 : service.listClassesByStudentId(); break;
                case 7 : {
                    System.out.println("Thanks for using our services!");
                    running = false;
                    break;
                }
                default:
                    System.out.println("Please input a valid option..."); break;
            }
        }
    }
}