import java.util.Scanner;

public class firmAccessPage {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("==========================================");
        System.out.println("          ACCESS CONTROL SYSTEM           ");
        System.out.println("==========================================");
        System.out.print("Enter Access level Clearance ID (1-10): ");

        int inputId = 0;

        try {
            inputId = Integer.parseInt(input.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("[ERROR]Invalid input.");
            System.out.println("Please enter a valid integer.");
            input.close();
            return;
        }

        String name = "";
        String pw = "";
        int accessLevel = 0;
        String title = "";
        boolean valid = false;

        switch (inputId) {
            case 1:
                name = "Jessica Pearson";
                pw = "1111";
                accessLevel = 10;
                title = "Managing Partner";
                valid = true;
                break;
            case 2:
                name = "Harvey Specter";
                pw = "2222";
                accessLevel = 9;    
                title = "Senior Partner";
                valid = true;
                break;
            case 3:
                name = "Louis Litt";
                pw = "3333";
                accessLevel = 8;
                title = "Senior Partner";
                valid = true;
                break;
            case 4:
                name = "Mike Ross";
                pw = "4444";
                accessLevel = 5;
                title = "Associate";
                valid = true;
                break;
            case 5:
                name = "Donna Paulsen";
                pw = "5555";
                accessLevel = 7;
                title = "Executive Assistant";
                valid = true;
                break;
            case 6:
                name = "Rachel Zane";
                pw = "6666";
                accessLevel = 6;    
                title = "Paralegal";
                valid = true;
                break;
            default:
                System.out.println("[ERROR] Invalid Access Level ID.");
                break;
        }

         if (valid) {
            System.out.println("\n[IDENTIFIED]: " + name);
            System.out.print("Enter Passcode: ");

            String inputPw = input.nextLine().trim();

            if (inputPw.equals(pw)) {
                System.out.println("\n------------------------------------------");
                System.out.println(">>> ACCESS GRANTED <<<");
                System.out.println("Welcome, " + name);
                System.out.println("Title: " + title);
                System.out.println("Security Clearance: LEVEL " + accessLevel);
                System.out.println("------------------------------------------");

                if (accessLevel == 10) {
                    System.out.println("[CLASSIFIED] Full system override authorized. Access to high security systems granted.");
                    System.out.println("All classified files and case records are now accessible.");
                    System.out.println("You have the authority to modify, delete, or create in our secure database.");

                } else if (accessLevel >= 7) {
                    System.out.println("[CLASSIFIED] Access to sensitive case files granted.");
                } else if (accessLevel >= 5) {
                    System.out.println("[CLASSIFIED] Access to general case files granted.");
                } else {
            System.out.println("[Security Alert] Access denied.");
            System.out.println("You do not have the required clearance level to access this system.");

        }

        input.close();
    }
}
    }
}