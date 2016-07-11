import java.io.*;

/**
 * Created by Thiloshon on 14-Apr-16.
 */
public class Module {

    public void ViewModules(int level){
        if (level==4){
            System.out.println("1 SDP \n2 CSF \n3 IADM \n4 English \n5 Web \n6 PHP");
        }else if (level==5){
            System.out.println("1 SDP2 \n2 CSF2 \n3 IADM2 \n4 English2 \n5 Web2 \n6 PHP2");
        }else System.out.println("1 SDP3 \n2 CSF3 \n3 IADM3 \n4 Englis3 \n5 Web3 \n6 PHP3");
    }

}


    /*//public static ModuleCollection m;



    public static void moduleSave() throws IOException, ClassNotFoundException {

        System.out.println(m);

        File file = new File("C:\\Users\\Thiloshon\\IdeaProjects\\Award Calculation System of UoG CLI\\Resits");
        //m = new ModuleCollection();
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos =new ObjectOutputStream(fos);

        oos.writeObject(m);
        oos.flush();
        oos.close();
        fos.close();


    }

    public static void moduleLoad() throws IOException {
        File file = new File("C:\\Users\\Thiloshon\\IdeaProjects\\Award Calculation System of UoG CLI\\Resits");
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        try {
            try {
                m = (ModuleCollection)ois.readObject();
            } catch (java.io.InvalidClassException m){
                System.out.print("bugger");
            }

        } catch (ClassNotFoundException e) {
            System.out.print("dfdf");
        }
        System.out.println(m);
    }





















*/







