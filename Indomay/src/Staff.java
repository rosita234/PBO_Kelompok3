public class Staff{
    
    private String name;
    private String password;
    private Posisi posisi;

    public Staff(String name, String password, Posisi posisi){
        this.name = name;
        this.password = password;
        this.posisi = posisi;
    }
    //Constructor all Fields
    public String getName(){
        return name;
    }
    public String getPassword() {
        return password;
    }
    
    public Posisi getPosisi() {
        return posisi;
    }

    public void setName(String a){
        this.name = a;
    }
    public void setPassword(String b){
        this.password = b;
    }

    public void setPosisi(Posisi posisi) {
        this.posisi = posisi;
    }

    //Constructor toString
    public String toString(){
        return String.format("%-20s %-10s %s", 
        name,
        password, 
        posisi.toString());
    }
    /*
    //Constuctor Empty
    public void Staff() {
    }
    */
}