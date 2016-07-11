/*
import java.io.File;
import java.util.Scanner;

*/
/*
        *Created by Thiloshon on 14-Apr-16.*//*



public class dump {
    Module modules = new Module();
    StudentCollection stdColl = new StudentCollection();
    Scanner sc = new Scanner(System.in);

    public void marks(int level, int adjustment) {

        int end = 0;
        int a = 0;
        int moduleCount = 0;
        while (end != 1 && moduleCount <= 5) {
            modules.ViewModules(level);
            System.out.print("Enter Module number:");
            int moduleNo = sc.nextInt();
            AssesmentType();

            //System.out.println("Enter 9 for finishing module, 10 for finishing feeding");

            int i = 0;
            a = 0;
            int marks = -1;
            while (a != 9 && i <= 7) {
                System.out.print("Assessment type: ");
                a = sc.nextInt();
                if (a != 9) {
                    StudentCollection.student.marks[moduleNo + adjustment][i] = "" + a;
                    System.out.print("mark: ");
                    marks = sc.nextInt();


                    if (marks <= 100 && marks >= 0) { //checks if the input is valid
                        if (marks < 30) { //Prepare for resit
                            System.out.println(" That's a resit, resit marks: ");
                            marks = sc.nextInt();
                            if (marks < 30) {
                                System.out.println(" That's a retake, retake marks: ");
                                marks = sc.nextInt();
                                if (marks < 30) {
                                    System.out.println(" That's a resit in retake, resit marks: ");
                                    marks = sc.nextInt();
                                    if (marks < 30) {
                                        System.out.println("failed module. is that a prerequisite module?");
                                        int option = sc.nextInt();
                                        if (option == 1) {
                                            System.out.println("out of the degree");
                                        } else {
                                            System.out.println("module failed, but can continue to next module");

                                        }
                                    }
                                }
                            }
                        }


                    } else {
                        System.out.println(" Input marks out of range , input valid marks");
                        marks = -1;

                    }
                    if (marks != -1) {
                        StudentCollection.student.marks[moduleNo + adjustment][++i] = "" + marks;
                        i++;
                    }


                }


            }


            System.out.println("Wish to end level? (1/0)");
            end = sc.nextInt();


        }
    }


    public void AddMarks() {
        System.out.println("Level: ");
        int level = sc.nextInt();

        switch (level) {
            case 4: {
                marks(4, -1);
                System.out.print("Do you wanna feed for next level?");
                int choice = sc.nextInt();
                if (choice == 0) {
                    break;
                }
            }
            case 5: {
                marks(5, 5);
                System.out.print("Do you wanna feed for next level?");
                int choice = sc.nextInt();
                if (choice == 0) {
                    break;
                }
            }
            case 6: {
                marks(6, 11);
                break;
            }
        }

    }

    public void AssesmentType() {
        System.out.println("1 ICT\n2 CW\n3 Other\n 8 End module");
    }
}


//private String[][] marks = new String[18][8];

//stdColl.stud.marks[0][0]="0";
//stdColl.stud.marks [moduleNo + adjustment][i] = "" + a;
//stdColl.stud.getMarks()[moduleNo + adjustment][i] = "" + a;
//StudentCollection.marks[moduleNo + adjustment][i] = "" + a;

//stdColl.stud.marks [moduleNo + adjustment][++i] = "" + b;
//stdColl.stud.getMarks()[moduleNo + adjustment][++i] = "" + b;

System.out.print("Do you wanna feed for next level?");
        int choice=sc.nextInt();
        return choice;


        int end=0;
        int a=0;
        int moduleCount=0;
        while(end!=10&&moduleCount<=5){
        modules.ViewModules(3);
        System.out.print("Enter Module number:");
        int moduleNo=sc.nextInt();
        AssesmentType();
        System.out.println("Enter 9 for finishing module, 10 for finishing feeding");

        int i=0;
        while(a!=9&&i<=7){
        System.out.print("Assesement type: ");
        a=sc.nextInt();
        StudentCollection.marks[moduleNo-1][i]=""+a;
        System.out.print("mark: ");
        int b=sc.nextInt();
        StudentCollection.marks[moduleNo-1][++i]=""+b;
        //end = sc.nextInt();
        i++;
        //System.out.print(end);


        }
        end=sc.nextInt();

        }


// System.out.print("Do you wanna feed for next level?");
// int choice = sc.nextInt();












*/
