/**
 * Created by Thiloshon on 15-Apr-16.
 */
import java.io.IOException;
import java.util.Scanner;
public class Starter {
    Scanner sc = new Scanner(System.in);
    StudentCollection studentCollection = new StudentCollection();
    Assessment assessment = new Assessment();
    Level lvl = new Level();

    public void welcomePage(){
        System.out.println("");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("---------------- UOG AWARD CALCULATION SYSTEM ---------------------- UOG AWARD CALCULATION SYSTEM ---------------------- UOG AWARD CALCULATION SYSTEM -------------------------");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("");
        System.out.println("                  WELCOME TO THE AWARD CALCULATION SYSTEM of UNIVERSITY OF GUGSI");
        System.out.println("");

    }

    public void start() throws IOException, ClassNotFoundException {

        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Choose your option:");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        System.out.println("1 Add New Student");
        System.out.println("2 Add Marks");
        System.out.println("3 View Students List");
        System.out.println("4 Generate Award");
        System.out.println("5 View Modules");
        System.out.println("6 Generate Records");
        System.out.println("");

        int option;

            do {
                while (!sc.hasNextInt()) {
                    System.out.println("Please choose your option Between 1 to 6:");
                    sc.next();
                }
                option = sc.nextInt();

                if (!(option >= 1 && option <= 6)) {
                    System.out.println("Please choose your option Between 1 to 6:");
                }
            } while (option < 1 || option > 6);



        switch (option) {
            case 1: addNewStudent();
                break;

            case 2: AddMarks();

                break;
            case 4: generateAwards();
                break;
            case 3: ViewStudents();
                break;
            case 6 : GenerateRecords();
                break;




        }


    }


    public void GenerateRecords(){
        System.out.println("1 List of Students with Resits");
        System.out.println("2 List of Students with Retakes");
        System.out.println("3 Resits in a Specific Module");
        System.out.println("4 Retakes in a Specific Module");
        System.out.println("5 List of Passed Students");
        System.out.println("6 List of Exclusions");
        System.out.println("7 Records of Student");
        System.out.println("8 Marks of Student");

        int choice = sc.nextInt();
        switch (choice){
            case 1: AllResits();
                break;
            case 2:AllRetakes();
                break;
            case 3: ModuleResit();
                break;
            case 4:ModuleRetake();
                break;
            case 7:StudentRecord();
                break;
            case 8:StudentMark();
                break;

        }
        try {
            start();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void StudentRecord(){
        System.out.println("Type the Student Number");
        int iD = sc.nextInt();
        try {
            studentCollection.LoadDataFromFile(iD);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Name of the student: " + studentCollection.student.getName());
        System.out.println("Number of the student: " + studentCollection.student.getiDNo());
        System.out.println("Course of the student: " + studentCollection.student.getCourse());
        System.out.print("Current Award of the student: ");
        assessment.Calculation();
        System.out.print("Resits: ");
        for(Integer value: studentCollection.student.getResits()){

        }

        for(Integer value=0; value<studentCollection.student.getResits().size(); value++){
            System.out.println("Type of Assesment ");
            System.out.println(studentCollection.student.getResits().get(value));
            value++;
            System.out.println("Module Number ");
            System.out.println(studentCollection.student.getResits().get(value));
            value++;
            value++;
            System.out.println("intial marks ");
            System.out.println(studentCollection.student.getResits().get(value));
            value++;
            System.out.println("");


        }

        System.out.print("Retakes: ");

        for(Integer value=0; value<studentCollection.student.getRetakes().size(); value++){
            System.out.println("Type of Assesment ");
            System.out.println(studentCollection.student.getRetakes().get(value));
            value++;
            System.out.println("Module Number ");
            System.out.println(studentCollection.student.getRetakes().get(value));
            value++;
            value++;
            System.out.println("intial marks ");
            System.out.println(studentCollection.student.getRetakes().get(value));
            value++;
            System.out.println("");

        }




    }
    public void StudentMark(){
        System.out.println("Type the Student Number");
        int iD = sc.nextInt();
        try {
            studentCollection.LoadDataFromFile(iD);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Name of the student: " + studentCollection.student.getName());
        System.out.println("Number of the student: " + studentCollection.student.getiDNo());
        System.out.println("Course of the student: " + studentCollection.student.getCourse());
        System.out.print("Current Award of the student: ");
        assessment.Calculation();

        int y=0;

        for (String[] array : studentCollection.student.getMarks()){
            System.out.println("Module " + y);
            int x=0;
            for (String value : array){
                if (value!=null){
                    if (!value.equalsIgnoreCase("null")) {
                        if (x%2==0){
                            System.out.print("Type: " + value + " ");
                        }else {
                            System.out.print("marks: " + value + " ");
                        }
                        System.out.print("\n");
                    }
                }


                x++;
            }
            System.out.print("\n");
            y++;

        }
    }




    public void ModuleResit(){
        try {
            lvl.LoadResitDataFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Type the Module Number");
        System.out.println("1 SDP \n2 CSF \n3 IADM \n4 English \n5 Web \n6 PHP");
        System.out.println("7 SDP2 \n8 CSF2 \n9 IADM2 \n10 English2 \n11 Web2 \n12 PHP2");
        System.out.println("13 SDP3 \n14 CSF3 \n15 IADM3 \n16 Englis3 \n17 Web3");

        int choice = sc.nextInt();

        int x=0;
        for(x=0; x<20; x++){
            //System.out.println(lvl.getResit()[choice-1][x]);
            //System.out.println(" choice " + (choice-1) + "x " + x);
            if (lvl.getResit()[choice-1][x]!=null) {
                //if (lvl.getResit()[choice - 1][x].matches("null")) {
                    if (!lvl.getResit()[choice - 1][x].equalsIgnoreCase("null")) {

                        System.out.println(lvl.getResit()[choice - 1][x]);
                    }



                //}
            }
        }

        /*for(String str : lvl.getRetake()[choice-1]) {
            if (lvl.getResit()[choice-1][x]!=null) {
                if (lvl.getResit()[choice - 1][x].matches("null")) {
                    if (!lvl.getResit()[choice - 1][x].equalsIgnoreCase("null")) {

                        System.out.println(lvl.getResit()[choice - 1][x]);
                    }



                }
            }

        }*/

       /* for (String[] array : lvl.getResit()){
            for (String value : array){
                //if (value!=null) {
                    //if (!value.matches("null")) {
                        System.out.println(value);
                    //}
                //}

            }

        }*/



    }

    public void ModuleRetake(){
        try {
            lvl.LoadResitDataFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Type the Module Number");
        System.out.println("1 SDP \n2 CSF \n3 IADM \n4 English \n5 Web \n6 PHP");
        System.out.println("7 SDP2 \n8 CSF2 \n9 IADM2 \n10 English2 \n11 Web2 \n12 PHP2");
        System.out.println("13 SDP3 \n14 CSF3 \n15 IADM3 \n16 Englis3 \n17 Web3");

        int choice = sc.nextInt();

        int x=0;
        for(x=0; x<20; x++){
            //System.out.println(lvl.getResit()[choice-1][x]);
            //System.out.println(" choice " + (choice-1) + "x " + x);
            if (lvl.getRetake()[choice-1][x]!=null) {
                //if (lvl.getResit()[choice - 1][x].matches("null")) {
                if (!lvl.getRetake()[choice - 1][x].equalsIgnoreCase("null")) {

                    System.out.println(lvl.getRetake()[choice - 1][x]);
                }



                //}
            }
        }





    }







    public void AllResits(){
        try {
            lvl.LoadResitDataFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String[] array : lvl.getResit()){
            for (String value : array){
                if (value!=null) {
                    if (!value.matches("null")) {
                        System.out.println(value);
                    }
                }

            }

        }

    }

    public void AllRetakes(){
        try {
            lvl.LoadResitDataFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String[] array : lvl.getRetake()){
            for (String value : array){
                if (value!=null) {
                    if (!value.matches("null")) {
                        System.out.println(value);
                    }
                }

            }

        }

    }


    public void ViewStudents(){
        studentCollection.ViewStudents();
        try {
            start();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void generateAwards(){
        System.out.println("Student ID Please: ");
        int studentID = sc.nextInt();

        try {
            studentCollection.LoadDataFromFile(studentID);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assessment.Calculation();
        try {
            start();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void addNewStudent() throws IOException, ClassNotFoundException {
        System.out.println("Student ID Please: ");
        int studentID =0;



            while (!sc.hasNextInt()) {
                System.out.println("Integer Please");
                sc.next();
            }
        studentID =sc.nextInt();

        try {
            studentCollection.addStudent(studentID);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Student " + studentID + " is created successfully");
        start();
    }


    public void AddMarks() throws ClassNotFoundException, IOException {
        System.out.println("Student ID Please: ");
        int studentID = sc.nextInt();

        studentCollection.LoadDataFromFile(studentID);
        //studentCollection.LoadDataFromFile2(studentID);
        //studentCollection.saveDataToFile(studentID);
        assessment.AddMarks(studentID);
        try {
            studentCollection.saveDataToFile(studentID);
        } catch (IOException e) {
            e.printStackTrace();
        }

        start();
        //sci.getStandardData();

       // studentCollection.LoadDataFromFile(studentID);


/*
        for (String[] array : studentCollection.marks){
            for (String value : array){
                System.out.print(value + " ");
            }
            System.out.print("\n");

        }*/



    }

    public void viewStudentList(){

    }

}
