public class Staff{
    
    private String name;
    private String password;
    private Posisi posisi;

    public Staff() {
        posisi = new Posisi();
    }

    public Staff(String name, String password){
        this.name = name;
        this.password = password;
        posisi = new Posisi();;
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
    
}