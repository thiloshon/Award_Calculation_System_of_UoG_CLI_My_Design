import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Thiloshon on 15-Apr-16.
 */
public class StudentCollection {
    public static Student student;

    public static Level lvl = new Level();

    //Module m = new Module();
    //public static ModuleCollection modulo;
    //ModuleCollection modulo = new ModuleCollection(12);
    //private ArrayList<Student> students = new ArrayList<Student>();

    public void addStudent(int iD) throws IOException, ClassNotFoundException {

        File file = new File("C:\\Users\\Thiloshon\\IdeaProjects\\Award Calculation System of UoG CLI\\Students\\" + iD);

        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        Student st = new Student(iD);


        //LoadDataFromFile(iD);
        System.out.println("Name of the Student: ");
        Scanner sc =new Scanner(System.in);

        String name = sc.nextLine();

        //student.setName(sc.next());
        System.out.println("Course of the Student: ");
        //student.setCourse(sc.next());

        String course = sc.nextLine();

        st.setCourse(course);
        st.setName(name);

        oos.writeObject(st);
        oos.flush();
        oos.close();
        fos.close();

        //LoadDataFromFile(iD);

        //m.moduleLoad();


        /*File file2 = new File("C:\\Users\\Thiloshon\\IdeaProjects\\Award Calculation System of UoG CLI\\Resits");

        FileOutputStream fos2 = new FileOutputStream(file2);
        ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
        ModuleCollection m =new ModuleCollection(9);
        //oos.writeObject(m);
        oos.flush();
        oos.close();
        fos.close();*/
    }

    public void saveDataToFile(int iD) throws IOException, ClassNotFoundException {
        File file = new File("C:\\Users\\Thiloshon\\IdeaProjects\\Award Calculation System of UoG CLI\\Students\\" + iD);

        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(student);
        oos.flush();
        oos.close();
        fos.close();

        //m.moduleSave();
        //Module.moduleSave();
        //System.out.println(lvl);
        lvl.saveResitDataToFile();


        //saveResitRetakeDataToFile();


    }
    /*public void LoadDataFromFile2(int iD)  {
        File file2 = new File("C:\\Users\\Thiloshon\\IdeaProjects\\Award Calculation System of UoG CLI\\Resits");
        FileInputStream fis2 = null;
        try {
            fis2 = new FileInputStream(file2);
        } catch (FileNotFoundException e) {
            System.out.print("file not found");
        }
        ObjectInputStream ois2 = null;
        try {
            ois2 = new ObjectInputStream(fis2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            try{
                modulo = (ModuleCollection) ois2.readObject();
            } catch (EOFException e){

            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.print("Class not found");
        }
        System.out.println(modulo);
    }*/

    public void LoadDataFromFile(int iD) throws IOException {
        File file = new File("C:\\Users\\Thiloshon\\IdeaProjects\\Award Calculation System of UoG CLI\\Students\\" + iD);


        FileInputStream fis = null;

        try {
            fis = new FileInputStream(file);

        } catch (FileNotFoundException e) {
            System.out.print("file not found");
        }
        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(fis);

        } catch (IOException e) {
        }
        try {
            student=null;
            student = (Student) ois.readObject();

           // System.out.println(student);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.print("Object ot found");
        }
        //System.out.println(stud);

        //m.moduleLoad();
        //Module.moduleLoad();

        lvl.LoadResitDataFromFile();
        //System.out.println(lvl);

    }


    public void ViewStudents() {

        File folder = new File("C:\\Users\\Thiloshon\\IdeaProjects\\Award Calculation System of UoG CLI\\Students");
        File[] listOfFiles = folder.listFiles();
        ArrayList<Integer> arr = new ArrayList<Integer>();



        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                //System.out.println(listOfFiles[i].getName());
                arr.add(Integer.parseInt(listOfFiles[i].getName()));
            } else if (listOfFiles[i].isDirectory()) {
                System.out.println("Directory " + listOfFiles[i].getName());
            }
        }
        Collections.sort(arr);
        for (int value: arr){
            System.out.println(value);
        }

    }

    /*public void saveResitRetakeDataToFile() throws IOException {
        File file = new File("C:\\Users\\Thiloshon\\IdeaProjects\\Award Calculation System of UoG CLI\\Resits");

        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(modulo);
        oos.flush();
        oos.close();
        fos.close();

    }*/


}

//String file = ("Students\\" + iD);

//Student student = new Student(iD);

//public static String[][] marks = new String[18][8];

//Student student = new Student();

/* FileWriter writer = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);

        //writer.write("" + iD);
        //writer.flush();
        writer.close();
        bufferedWriter.close();*/








    /*public void saveDataToFile(int iD) throws IOException {
        String file = ("Students\\" + iD );
        FileWriter writer = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);

        for (String[] array : marks){
            for (String value : array){
                writer.write(value + " ");
            }
            writer.write("\n");


        }
        writer.flush();
        writer.close();
        bufferedWriter.close();
    }*/




    /*public void LoadDataFromFile(int iD) throws IOException {
        int i = 0;
        int j = 0;

        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Thiloshon\\IdeaProjects\\Award Calculation System of UoG CLI\\Students\\" + iD));
        for (String line; (line = br.readLine()) != null; ) {
            String[] data = line.split(" ");
            for (String value : data) {
                marks[i][j]=value;
                //System.out.print(value + " ");
                j++;
            }
            //System.out.print("\n");
            i++;
            j=0;

            //addCD(new CD(data[0], data[1], data[2], data[3], data[4], data[5], data[6], Integer.parseInt(data[7])));
        }
        br.close();
        for (String[] array : marks){
            for (String value : array){
               // System.out.print(value + " , ");
            }
           // System.out.print("\n");

        }
    }*/
