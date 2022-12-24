import javax.print.Doc;
import java.util.*;

public class Doctor extends Person {
    static Person person = new Person();
    static Doctor doctor = new Doctor();
    private int medicalLicenseNumber;
    private String specialized;

    static void check() throws InterruptedException {
        if (WestminsterSkinConsultationManager.doctorList.size() < 10) {
            insert();
        } else {
            System.out.println("Doctor count reached 10!!");
            Thread.sleep(3000);
        }
    }

    static void insert() {
        boolean cond = true;
        while (cond) {
            Scanner obj = new Scanner(System.in);
            try {
                System.out.print("Enter name: ");
                person.setName(obj.next());
                WestminsterSkinConsultationManager.doctorList.add(person.getName());
                System.out.print("Enter surname: ");
                person.setSurname(obj.next());
                WestminsterSkinConsultationManager.doctorSurName.add(person.getSurname());
                System.out.print("Enter date of birth in DD-MM-YYYY format: ");
                person.setDob(obj.next());
                WestminsterSkinConsultationManager.doctorDOB.add(person.getDob());
                System.out.print("Enter mobile number: ");
                person.setMobileNumber(obj.nextInt());
                WestminsterSkinConsultationManager.doctorMobileNumber.add(person.getMobileNumber());
                System.out.print("Enter NIC number: ");
                person.setNic(obj.nextLong());
                WestminsterSkinConsultationManager.doctorNic.add(person.getNic());
                System.out.print("Enter medical license number: ");
                doctor.setMedicalLicenseNumber(obj.nextInt());
                WestminsterSkinConsultationManager.doctorMedicalID.add(doctor.getMedicalLicenseNumber());
                System.out.print("Enter your specialization: ");
                doctor.setSpecialized(obj.next());
                WestminsterSkinConsultationManager.doctorSpecialized.add(doctor.getSpecialized());
                cond = false;
            } catch (Exception e) {
                System.out.println("You entered something wrong please enter again!!!");
            }
            System.out.print("Do you want to change above data\n1: YES\n2: NO\nENTER: ");
            int opt = obj.nextInt();
            switch (opt){
                case 1:
                    cond=true;
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Invalid input!!");
                    break;
            }
        }
    }

    static void show() throws InterruptedException {
        System.out.println("---------------------------------------");
        System.out.println("Doctor name: " + person.getName());
        System.out.println("Surname: " + person.getSurname());
        System.out.println("ID: " + doctor.getMedicalLicenseNumber());
        System.out.println("specialized in: " + doctor.getSpecialized());
        System.out.println("DOB: " + person.getDob());
        System.out.println("NIC: " + person.getNic());
        System.out.println("Mobile number: " + person.getMobileNumber());
        Thread.sleep(3000);
        System.out.println("---------------------------------------");
    }

    static void delete() throws InterruptedException {
        System.out.println("Medical license number of doctors");
        for (int s:WestminsterSkinConsultationManager.doctorMedicalID){
            System.out.println(s);
        }
        int pos = 0;
        boolean cond = true;
        while (cond) {
            Scanner obj = new Scanner(System.in);
            System.out.print("Enter the medical license number of doctor: ");
            int num = obj.nextInt();
            for (int i = 0; i < WestminsterSkinConsultationManager.doctorMedicalID.size(); i++) {
                if (WestminsterSkinConsultationManager.doctorMedicalID.get(i) == num) {
                    pos = i;
                    cond = false;
                    break;
                }
                System.out.println("ID not found please enter again");
            }
        }
        person.setName(WestminsterSkinConsultationManager.doctorList.get(pos));
        person.setSurname(WestminsterSkinConsultationManager.doctorSurName.get(pos));
        person.setDob(WestminsterSkinConsultationManager.doctorDOB.get(pos));
        person.setNic(WestminsterSkinConsultationManager.doctorNic.get(pos));
        person.setMobileNumber(WestminsterSkinConsultationManager.doctorMobileNumber.get(pos));
        doctor.setSpecialized(WestminsterSkinConsultationManager.doctorSpecialized.get(pos));
        doctor.setMedicalLicenseNumber(WestminsterSkinConsultationManager.doctorMedicalID.get(pos));
        WestminsterSkinConsultationManager.doctorList.remove(pos);
        WestminsterSkinConsultationManager.doctorSurName.remove(pos);
        WestminsterSkinConsultationManager.doctorDOB.remove(pos);
        WestminsterSkinConsultationManager.doctorNic.remove(pos);
        WestminsterSkinConsultationManager.doctorMobileNumber.remove(pos);
        WestminsterSkinConsultationManager.doctorSpecialized.remove(pos);
        WestminsterSkinConsultationManager.doctorMedicalID.remove(pos);
        show();
        System.out.println("Deleted successfully");
        System.out.println("Remaining doctors: " + WestminsterSkinConsultationManager.doctorList.size());
    }
    static void sortedshow() throws InterruptedException {
        ArrayList<String> temp_list = new ArrayList<>(List.copyOf(WestminsterSkinConsultationManager.doctorSurName));
        ArrayList<Integer> position = new ArrayList<>();
        Collections.sort(WestminsterSkinConsultationManager.doctorSurName);
        System.out.println(temp_list);
        for (int i = 0;i<temp_list.size();i++){
            String name = WestminsterSkinConsultationManager.doctorSurName.get(i);
            for (int j = 0;j<WestminsterSkinConsultationManager.doctorSurName.size();j++){
                if (name.equals(temp_list.get(j))) {
                    position.add(j);
                    break;
                }
            }
        }
        for (int i = 0;i<position.size();i++){
            person.setMobileNumber(WestminsterSkinConsultationManager.doctorMobileNumber.get(position.get(i)));
            person.setNic(WestminsterSkinConsultationManager.doctorNic.get(position.get(i)));
            person.setSurname(WestminsterSkinConsultationManager.doctorSurName.get(i));
            person.setDob(WestminsterSkinConsultationManager.doctorDOB.get(position.get(i)));
            doctor.setMedicalLicenseNumber(WestminsterSkinConsultationManager.doctorMedicalID.get(position.get(i)));
            doctor.setSpecialized(WestminsterSkinConsultationManager.doctorSpecialized.get(position.get(i)));
            person.setName(WestminsterSkinConsultationManager.doctorList.get(position.get(i)));
            show();
        }
        WestminsterSkinConsultationManager.doctorSurName=temp_list;
    }

    public String getSpecialized() {
        return specialized;
    }

    public void setSpecialized(String specialized) {
        this.specialized = specialized;
    }

    public int getMedicalLicenseNumber() {
        return (int) medicalLicenseNumber;
    }

    public void setMedicalLicenseNumber(int medicalLicenseNumber) {
        this.medicalLicenseNumber = medicalLicenseNumber;
    }
}
