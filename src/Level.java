import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Thiloshon on 14-Apr-16.
 */
public class Level implements java.io.Serializable{


    private String[][] resit = new String[18][20];

    private String[][] retake = new String[18][20];



    private  ArrayList<ArrayList<Integer>> pass = new ArrayList<ArrayList<Integer>>(18);




    public void saveResitDataToFile() throws IOException {
        String file = ("C:\\Users\\Thiloshon\\IdeaProjects\\Award Calculation System of UoG CLI\\Resits");
        String file2 = ("C:\\Users\\Thiloshon\\IdeaProjects\\Award Calculation System of UoG CLI\\Retakes");
        FileWriter writer = new FileWriter(file);
        FileWriter writer2 = new FileWriter(file2);
        //BufferedWriter bufferedWriter = new BufferedWriter(writer);
        PrintWriter pw = new PrintWriter(writer);
        PrintWriter pw2 = new PrintWriter(writer2);

        for (String[] array : resit){
            for (String value : array){
                pw.write(value + " ");
            }
            pw.write("\n");
        }

        for (String[] array : retake){
            for (String value : array){
                pw2.write(value + " ");
            }
            pw2.write("\n");
        }

        writer.flush();
        writer.close();
        pw.close();
        writer2.flush();
        writer2.close();
        pw2.close();
        //bufferedWriter.close();
    }




    public void LoadResitDataFromFile() throws IOException {
        int i = 0;
        int j = 0;

        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Thiloshon\\IdeaProjects\\Award Calculation System of UoG CLI\\Resits"));
        for (String line; (line = br.readLine()) != null; ) {
            String[] data = line.split(" ");
            for (String value : data) {
                resit[i][j]=value;
                j++;
            }
            i++;
            j=0;
        }
        br.close();



        i=0;
        j=0;

        BufferedReader br2 = new BufferedReader(new FileReader("C:\\Users\\Thiloshon\\IdeaProjects\\Award Calculation System of UoG CLI\\Retakes"));
        for (String line; (line = br2.readLine()) != null; ) {
            String[] data = line.split(" ");
            for (String value : data) {
                retake[i][j]=value;
                j++;
            }
            i++;
            j=0;
        }
        br2.close();

    }

    @Override
    public String toString() {
        return "Level{" +
                "pass=" + pass +
                ", resit=" + Arrays.deepToString(resit) +
                ", retake=" + Arrays.deepToString(retake) +
                '}';
    }

    public ArrayList<ArrayList<Integer>> getPass() {
        return pass;
    }

    public void setPass(ArrayList<ArrayList<Integer>> pass) {
        this.pass = pass;
    }

    public String[][] getRetake() {
        return retake;
    }

    public void setRetake(String[][] retake) {
        this.retake = retake;
    }

    public String[][] getResit() {
        return resit;
    }

    public void setResit(String[][] resit) {
        this.resit = resit;
    }
}
