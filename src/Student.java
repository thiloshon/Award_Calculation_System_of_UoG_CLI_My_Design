import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Thiloshon on 17-Apr-16.
 */
public class Student implements java.io.Serializable{
    private String name;
    private int iDNo;
    private String course;

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String[][] marks = new String[18][8];
    private ArrayList<Integer> resits = new ArrayList<Integer>();
    private ArrayList<Integer> retakes = new ArrayList<Integer>();
    private String award;


    public ArrayList<Integer> getRetakes() {
        return retakes;
    }

    public void setRetakes(ArrayList<Integer> retakes) {
        this.retakes = retakes;
    }

    public ArrayList<Integer> getResits() {
        return resits;
    }

    public void setResits(ArrayList<Integer> resits) {
        this.resits = resits;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getiDNo() {
        return iDNo;
    }

    public void setiDNo(int iDNo) {
        this.iDNo = iDNo;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public String[][] getMarks() {
        return marks;
    }

    public void setMarks(String[][] marks) {
        this.marks = marks;
    }

    public Student(int iDNo){

        //this.name=name;
        this.iDNo=iDNo;
    }



    //private ArrayList<Integer> marksList = new ArrayList<Integer>();



    /*public void getStandardData(){

        for (String[] array : marks){
            for (String value : array){
                System.out.print(value + " ");
            }
            System.out.print("\n");

        }




    }*/


    @Override
    public String toString() {
        return "Student{" +
                "award='" + award + '\'' +
                ", name='" + name + '\'' +
                ", iDNo=" + iDNo +
                ", course='" + course + '\'' +
                ", marks=" + Arrays.deepToString(marks) +
                ", resits=" + resits +
                ", retakes=" + retakes +
                '}';
    }
}
