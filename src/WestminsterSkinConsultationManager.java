import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class WestminsterSkinConsultationManager implements SkinConsultationManager {

    public static ArrayList<Doctor> doctors = new ArrayList<>(10);

    public static ArrayList<Patient> patients = new ArrayList<>();

    public static ArrayList<Consultation> consultations = new ArrayList<>();

    public static void DoctorListAdd(Doctor object) {
        doctors.add(object);
    }

    public static void PatientListAdd(Patient object) {
        patients.add(object);
    }

    public static void ConsultationListAdd(Consultation object) {
        consultations.add(object);
    }

    public void displayTheMenu() {
        readTheFile();
        boolean stop = false;
        while (!stop) {
            System.out.println("\n\n---------------------Menu For SkinConsultation---------------------\n" +
                    "\n Press 'A' to Add a Doctor \n" +
                    " Press 'D' to Delete a Doctor \n" +
                    " Press 'P' to list Doctors in alphabetical order \n" +
                    " Press 'S' to Store list of Doctors \n" +
                    " Press 'G' to Use the GUI \n" +
                    " Press 'E' to Exit the Program ");


            Scanner input = new Scanner(System.in);
            System.out.println("\n-------------Please Type an option from the Menu above-------------");
            String select = input.next().toUpperCase();

            switch (select) {
                case "A":
                    addTheDoctor();
                    break;
                case "D":
                    deleteTheDoctor();
                    break;
                case "P":
                    System.out.println("\n *************List of Doctors in Alphabetical order********************\n");
                    printDoctorABC();
                    break;
                case "S":
                    saveTheFile();
                    System.out.println("\n *************List of Doctors SAVED********************\n");
                    break;
                case "G":
                    System.out.println("\n *************GUI Application is Opened********************\n");
                    OpenTheGui();
                    break;
                case "E":
                    System.out.println("You are about to exit the program...");
                    System.out.println("\n ************************************");
                    stop = true;
                    break;
                default:
                    System.out.println("Wrong Option Selected");
                    System.out.println("\n ************************************");


            }
        }

    }

    public void addTheDoctor() {
        int MLNum;
        String FName;
        String SName;
        String DOB;
        int MNum;
        String SPL;

        if (doctors.size() > 9) {
            System.out.println("This System can hold a maximum of 10 doctors");
        } else {
            boolean check = true;

            Scanner input = new Scanner(System.in);
            System.out.println("Please enter the Doctor Medical License Number");
            while (true) {
                try {
                    MLNum = Integer.parseInt(input.nextLine());
                    System.out.println("\nChecking for existing doctor.....");
                    while (check) {
                        if (compareMedicalLicenseNumber(MLNum)) {
                            System.out.println("Already there... try to add another doctor!!!!!\n");
                            MLNum = Integer.parseInt(input.nextLine());
                        } else {
                            check = false;
                            System.out.println("continue to add the details.....\n");
                            System.out.println("Please enter the firstname of the doctor...");
                            FName = input.nextLine().toUpperCase();
                            if (!FName.matches("[a-zA-Z]+")) {
                                do {
                                    System.out.println("Numbers or Special characters invalid for firstname!!!!!");
                                    System.out.println("Please enter the firstname of the doctor...");
                                    FName = input.nextLine().toUpperCase();
                                } while (!(FName.matches("[a-zA-Z]+")));
                            }
                            System.out.println("Please enter the surname of the doctor...");
                            SName = input.nextLine().toUpperCase();
                            if (!SName.matches("[a-zA-Z]+")) {
                                do {
                                    System.out.println("Numbers or Special characters invalid for surname!!!!!");
                                    System.out.println("Please enter the surname of the doctor...");
                                    SName = input.nextLine().toUpperCase();
                                } while (!(SName.matches("[a-zA-Z]+")));
                            }
                            DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
                            Date date;
                            while (true) {
                                try {
                                    System.out.println("Please enter the Date of Birth of the doctor(yyyy/mm/dd)...");
                                    DOB = input.nextLine();
                                    date = df.parse(DOB);
                                    break;
                                } catch (ParseException e) {
                                    System.out.println("Wrong input type.");
                                }
                            }
                            System.out.println("Please enter the Mobile No of the doctor...");
                            while (true) {
                                try {
                                    MNum = Integer.parseInt(input.nextLine());
                                    break;
                                } catch (NumberFormatException n) {
                                    System.out.println("Please enter series of numbers (EX..07XXXXXXXX).");
                                } catch (Exception e) {
                                    System.out.println("Unspecified error (not a NumberFormatException).");
                                }
                            }
                            System.out.println("Please enter the Specialisation of the doctor...");
                            SPL = input.nextLine().toUpperCase();
                            Doctor doctor1 = new Doctor(FName, SName, DOB, MNum, MLNum, SPL);
                            DoctorListAdd(doctor1);
                            System.out.println("\n **********************Doctor's details have been recorded********************\n");
                        }
                    }
                    break;
                } catch (NumberFormatException n) {
                    System.out.println("Please enter series of numbers (from 0-9)!!!!!");
                }
            }
        }
    }

    public boolean compareMedicalLicenseNumber(int MLNumber) {

        for (Doctor doctor : doctors) {
            if (MLNumber == doctor.getMedicalLicenceNumber()) {
                return true;
            }
        }
        return false;
    }

    public void deleteTheDoctor() {
        if (doctors.size() == 0) {
            System.out.println("!!!!!!!!!sorry no doctors available to delete!!!!!!!!!");
        } else {
            Scanner input = new Scanner(System.in);

            System.out.println("......Displaying the existing Doctor medical license number and their firstname......\n");

            for (Doctor doctor : doctors) {
                System.out.println("Doctor medical license number - " + doctor.getMedicalLicenceNumber() + " firstname - " + doctor.getFirstname());
            }

            System.out.println("\nEnter medical license number to be deleted ");
            int MLNumToBeDeleted = Integer.parseInt(input.nextLine());

            Doctor doctorToDelete = null;
            for (Doctor doctor : doctors) {
                if (doctor.getMedicalLicenceNumber() == MLNumToBeDeleted) {
                    doctorToDelete = doctor;
                    break;
                }
            }

            if (doctorToDelete != null) {
                doctors.remove(doctorToDelete);
                System.out.println("Doctor " + doctorToDelete.getFirstname() + " has been successfully deleted.");
                System.out.println(".........Doctors Remaining in the list........");
                System.out.println(doctors.size());
            } else {
                System.out.println("No doctor was found with medical license number " + MLNumToBeDeleted + ".");
                System.out.println(".........Doctors Remaining in the list........");
                System.out.println(doctors.size());
            }
        }
    }

    public void printDoctorABC() {
        doctors.sort(new SortingDoctorsSname());

        for (Doctor doctor : doctors) {
            System.out.println("Surname : " + doctor.getSurname());
            System.out.println("Firstname : " + doctor.getFirstname());
            System.out.println("Date Of Birth : " + doctor.getDateOfBirth());
            System.out.println("Mobile Number : " + doctor.getMobileNumber());
            System.out.println("Medical Licence No : " + doctor.getMedicalLicenceNumber());
            System.out.println("Specialisation : " + doctor.getSpecialisation() + "\n");
        }
    }

    public void OpenTheGui() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors available");
        } else {
            BookSortGUI.doctorTransfer(doctors);
            ConfirmationFinalGUI.doctorObjectTransfer(doctors);
            new StartGUI();
        }
    }

    public void saveTheFile() {
        try {
            FileOutputStream writeData = new FileOutputStream("doctor");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            writeStream.writeObject(doctors);
            writeStream.flush();
            writeStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readTheFile() {
        try {
            File file = new File("doctor");
            if (!file.exists()) {
                System.out.println("-----------------------------------------------------------------------------------");
                System.out.println("\nNo Data saved\n");
                return;
            }
            System.out.println("-----------------------------------------------------------------------------------");
            System.out.println("\nprevious data loaded\n");
            try {
                try {
                    FileInputStream readData = new FileInputStream("doctor");
                    ObjectInputStream readStream = new ObjectInputStream(readData);

                    ArrayList<Doctor> doctorlist = (ArrayList<Doctor>) readStream.readObject();
                    readStream.close();
                    System.out.println(doctorlist.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

