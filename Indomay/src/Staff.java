public class Staff{
    
    private String id;
    private String name;
    private String posisi;
    private int gaji;
    private UserLogin userLogin;

    public Staff() {
        userLogin = new UserLogin();
    }

    public Staff(String id, String name, String posisi, int gaji){
        this.id = id;
        this.name = name;
        this.posisi = posisi;
        this.gaji = gaji;
        this.userLogin = new UserLogin();
    }
    //Constructor all Fields
    public String getName(){
        return name;
    }

    public int getGaji() {
        return gaji;
    }

    public String getId() {
        return id;
    }
    
    public String getPosisi() {
        return posisi;
    }

    public UserLogin getUserLogin() {
        return userLogin;
    }

    public void setName(String a){
        this.name = a;
    }

    public void setGaji(int gaji) {
        this.gaji = gaji;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPosisi(String posisi) {
        this.posisi = posisi;
    }

    public void setUserLogin(UserLogin userLogin) {
        this.userLogin = userLogin;
    }

    //Constructor toString
    public String toString(){
        return String.format("%-4s %-20s %-10s %-20d %s", 
        id,
        name,
        posisi,
        gaji,
        userLogin.toString()
        );
    }
    
}