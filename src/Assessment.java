import java.util.Scanner;

/**
 * Created by Thiloshon on 14-Apr-16.
 *
 * Now checking if GIT is working fine....LOL
 *
 */
public class Assessment {
    Module modules = new Module();
    Scanner sc = new Scanner(System.in);

    public void marks(int level, int adjustment, int iD) {
        int end = 0;
        int a = 0;
        int moduleCount = 0;
        while (end != 1 && moduleCount <= 5) {
            modules.ViewModules(level);
            System.out.println("Enter Module number:");
            int moduleNo = sc.nextInt();
            AssesmentType();

            int i = 0;
            int y = 0;
            int w = 0;
            a = 0;
            int marks = -1, mark2 = 0;
            while (a != 9 && i <= 7) {
                System.out.println("Assessment type:");
                //a = sc.nextInt();



                do {
                    while (!sc.hasNextInt()) {
                        System.out.println("Please Enter 1, 2, 3 or 9");
                        sc.next();
                    }
                    a = sc.nextInt();

                    if (!((a >= 1 && a <= 3) || a==9)) {
                        System.out.println("Please Enter 1, 2, 3 or 9");
                    }
                } while (a!=1&&a!=2&&a!=3&&a!=9);





                if (a != 9) {
                    StudentCollection.student.marks[moduleNo + adjustment][i] = "" + a;
                    System.out.print("mark: ");
                    //marks = sc.nextInt();

                    do {
                        while (!sc.hasNextInt()) {
                            System.out.println("Please enter a numeral");
                            sc.next();
                        }
                        marks = sc.nextInt();

                        if (!(marks >= 1 && marks <= 100)) {
                            System.out.println("Invalid Mark!");
                        }
                    } while (marks < 1 || marks > 100);




                    if (marks <= 100 && marks >= 0) { //checks if the input is valid
                        if (marks < 30) { //Prepare for resit
                            System.out.println(" That's a resit, resit marks: ");
                            mark2 = marks;
                            marks = sc.nextInt();
                            if (marks < 30) { //Prepare for retake
                                System.out.println(" That's a retake, retake marks: ");
                                mark2 = marks;
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
                                } else {
                                    StudentCollection.student.getRetakes().add(a);//Type
                                    StudentCollection.student.getRetakes().add(moduleNo + adjustment);//[index][]
                                    StudentCollection.student.getRetakes().add(i + 1);//[][index]
                                    StudentCollection.student.getRetakes().add(mark2);//failed marks
                                    //w++;
                                    int x = 0;
                                    do {
                                        if (StudentCollection.lvl.getRetake()[moduleNo + adjustment][x].equalsIgnoreCase("null")) {
                                            StudentCollection.lvl.getRetake()[moduleNo + adjustment][x] = iD + "";
                                            break;
                                        }
                                        x++;
                                        y = x;
                                    } while (y < StudentCollection.lvl.getRetake()[moduleNo + adjustment].length);
                                }
                            } else {
                                StudentCollection.student.getResits().add(a);//Type
                                StudentCollection.student.getResits().add(moduleNo + adjustment);//[index][]
                                StudentCollection.student.getResits().add(i + 1);//[][index]
                                StudentCollection.student.getResits().add(mark2);//failed marks
                                int x = 0;
                                do {
                                    if (StudentCollection.lvl.getResit()[moduleNo + adjustment][x].equalsIgnoreCase("null")) {
                                        StudentCollection.lvl.getResit()[moduleNo + adjustment][x] = iD + "";
                                        break;
                                    }
                                    x++;
                                    w = x;
                                    System.out.println(StudentCollection.lvl.getResit()[moduleNo + adjustment][x]);
                                } while (w < StudentCollection.lvl.getResit()[moduleNo + adjustment].length);
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

    public void Calculation(){

        int w=0;
        int z=0;
        int total2=0;
        int noOfMarks2=0;
        int creditL4=0;

        for(w=0; w<6; w++){
            for(z=0; z<8; z++){
                z++;
                //System.out.print(StudentCollection.student.marks);
                if (StudentCollection.student.marks[w][z]!=null){
                    if (!StudentCollection.student.marks[w][z].matches("null")) {
                        //if (!StudentCollection.student.marks[w][z].equalsIgnoreCase("null")) {
                        //System.out.print("im in here at " + w + z);
                        total2 = Integer.parseInt(StudentCollection.student.marks[w][z])+total2;
                        noOfMarks2++;
                    }
                }


            }
            //StudentCollection.student.marks[x]
            //int avg = total2/noOfMarks2;
            int avg =0;
            try{
                avg = total2/noOfMarks2;
            }catch (ArithmeticException e){

            }


            if (avg>40){
                creditL4+=20;
            }


            noOfMarks2=0;

        }


        boolean resitTimes = false;


        if (!StudentCollection.student.getResits().isEmpty()){
            resitTimes = true;
        }

        int x=6;
        int y=0;
        int total=0;
        int noOfMarks=0;


        int creditL5=0;
        int creditL6=0;


        double avgL5=0;
        double avgL6=0;
        double avgSmall =0;
        for(x=6; x<12; x++){
            for(y=0; y<8; y++){
                y++;
                if (StudentCollection.student.marks[x][y]!=null){
                    if (!StudentCollection.student.marks[x][y].equalsIgnoreCase("null")) {
                        total = Integer.parseInt(StudentCollection.student.marks[x][y])+total;
                        noOfMarks++;
                    }
                }


            }
            //StudentCollection.student.marks[x]
            //System.out.println("marks " + noOfMarks);
            int avg=0;
            try{
                avg = total/noOfMarks;
            }catch (ArithmeticException e){

            }

            if (avg>40){
                creditL5+=20;
            }

            avgSmall=avg + avgSmall;
            noOfMarks=0;

        }

        avgL5 = (avgSmall/6)*(1.0/3);

        total=0;
        avgSmall=0;
        noOfMarks=0;

        for(x=12; x<18; x++){
            for(y=0; y<8; y++){
                y++;
                if (StudentCollection.student.marks[x][y]!=null){
                    if (!StudentCollection.student.marks[x][y].equalsIgnoreCase("null")) {
                        total = Integer.parseInt(StudentCollection.student.marks[x][y])+total;
                        noOfMarks++;
                    }
                }


            }
            //StudentCollection.student.marks[x]
            int avg = 0;
            try{
                avg = total/noOfMarks;
            }catch (ArithmeticException e){

            }

            if (avg>40){
                creditL6+=20;
            }
            avgSmall=avg + avgSmall;
            noOfMarks=0;
        }
        avgL6 = (avgSmall/6)*(2.0/3);

        double average = (avgL5+avgL6)/2;

        if (creditL6>=120&&creditL5>=120&&creditL4>=120){
            if ((average)>=70){
                System.out.println("1st Class Hons");
            }
            else if ((average)>=60){
                System.out.println("2nd Class upper Hons");
            }
            else if ((average)>=50){
                System.out.println("2nd Class lower Hons");
            }
            else if ((average)>=40){
                System.out.println("2rd class Hons");
            }
        }
        else if (creditL6>=60&&creditL5>=120&&creditL4>=120){
            if (!resitTimes)System.out.println("Non Hons Distinction / Merit Degree");
            else System.out.println("Non Hons Degree");
        }else if (creditL5>=120&&creditL4>=120){
            if (!resitTimes)System.out.println("DipHE Distinction / Merit Degree");
            else System.out.println("DipHE");
        }else if(creditL4>=120){
            if (!resitTimes)System.out.println("CertHE Distinction / Merit Degree");
            else System.out.println("CertHE");
        }else System.out.print("Not eligible for any awards  ");


    }

    public void AddMarks(int iD) {
        System.out.println("Level: ");
        int level = sc.nextInt();

        switch (level) {
            case 4: {
                marks(4, -1, iD);
                System.out.print("Do you wanna feed for next level?");
                int choice = sc.nextInt();
                if (choice == 0) {
                    break;
                }
            }
            case 5: {
                marks(5, 5, iD);
                System.out.print("Do you wanna feed for next level?");
                int choice = sc.nextInt();
                if (choice == 0) {
                    break;
                }
            }
            case 6: {
                marks(6, 11, iD);
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

/*System.out.print("Do you wanna feed for next level?");
        int choice = sc.nextInt();
        return choice;*/



                /*int end = 0;
                int a = 0;
                int moduleCount=0;
                while (end != 10&&moduleCount<=5) {
                    modules.ViewModules(3);
                    System.out.print("Enter Module number:");
                    int moduleNo = sc.nextInt();
                    AssesmentType();
                    System.out.println("Enter 9 for finishing module, 10 for finishing feeding");

                    int i = 0;
                    while (a != 9&& i<=7) {
                        System.out.print("Assesement type: ");
                        a = sc.nextInt();
                        StudentCollection.marks[moduleNo - 1][i] = "" + a;
                        System.out.print("mark: ");
                        int b = sc.nextInt();
                        StudentCollection.marks[moduleNo - 1][++i] = "" + b;
                        //end = sc.nextInt();
                        i++;
                        //System.out.print(end);


                    }
                    end = sc.nextInt();

                }
*/
// System.out.print("Do you wanna feed for next level?");
// int choice = sc.nextInt();


//Module.m.getRetake().get(moduleNo + adjustment).add(iD);

//stdColl.m.m.getRetake().get(moduleNo + adjustment).add(iD);

//stdColl.modulo.getRetake().add(moduleNo + adjustment, iD );
//stdColl.modulo.getRetake().get(moduleNo + adjustment).add(iD);
//StudentCollection.lvl.getRetake()[moduleNo + adjustment][3]=iD + "";


//stdColl.modulo.getResit().get(moduleNo + adjustment).add(iD);
//stdColl.m.m.getResit().get(moduleNo + adjustment).add(iD);
//System.out.println(moduleNo + adjustment);
//System.out.println(Module.m.resit[moduleNo + adjustment][0]);
//System.out.print(Module.m.resit.get(moduleNo + adjustment));
//Module.m.resit.get(moduleNo + adjustment).add(iD);

//Module.m.resit[moduleNo + adjustment][0]= "" + iD;
//System.out.println(Module.m.resit);

//StudentCollection.lvl.getResit()[moduleNo + adjustment][y]=iD + "";

//StudentCollection.lvl.getResit()[moduleNo + adjustment][3]=iD + "";
//y++;