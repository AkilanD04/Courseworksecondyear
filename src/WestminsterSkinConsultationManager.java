import java.util.ArrayList;
import java.util.Scanner;

interface SkinConsultationManager {
    public void doctoropt();
    public void patientopt();
}

public class WestminsterSkinConsultationManager {
    static ArrayList<String> doctorList = new ArrayList<>();
    static ArrayList<String> doctorSurName = new ArrayList<>();
    static ArrayList<String> doctorSpecialized = new ArrayList<>();
    static ArrayList<String> doctorDOB = new ArrayList<>();
    static ArrayList<Long> doctorNic = new ArrayList<>();
    static ArrayList<Integer> doctorMobileNumber = new ArrayList<>();
    static ArrayList<Integer> doctorMedicalID = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        boolean condition = true;
        Scanner obj = new Scanner(System.in);
        while (condition) {
            System.out.print("1-For Doctor\n2-For Patient\n0-To exit\nEnter: ");
            int option = obj.nextInt();
            switch (option) {
                case 1:
                    System.out.print("1-ADD Doctor\n2-DELETE Doctor\n3-SHOW Doctors\n4-SAVE File\n5-EXIT\nEnter: ");
                    int opt = obj.nextInt();
                    switch (opt) {
                        case 1:
                            Doctor.check();
                            Doctor.show();
                            break;
                        case 2:
                            Doctor.delete();
                            break;
                        case 3:
                            Doctor.sortedshow();
                            break;
                        case 4:
                            //code to save the doctors to file
                            break;
                        case 5:
                            System.out.println("Exiting...");
                            break;
                        default:
                            System.out.println("Invalid input!!");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("OK wait...");
                    break;
                case 0:
                    System.out.println("You are exiting...");
                    condition = false;
                    break;
                default:
                    System.out.println("Invalid option!!");
                    break;
            }
        }
    }
}
