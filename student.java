public class student {
    private int id;
    private String name;
    private double gpa;

    public student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public int getId() {return id;}

    public String getName() {return name;}

    public double getGpa() {return gpa;}

    public void setId(int n) {id = n;}

    public void setName(String n) {name = n;}

    public void setGpa(double n) {gpa = n;}
}