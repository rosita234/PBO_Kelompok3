public abstract class Staff implements MenuAkses{ //superclass //interface
    
    private String idStaff;
    private String namaStaff;
    private String posisi;
    private int gaji;
    private UserLogin userLogin;

    public Staff() {
        userLogin = new UserLogin();
    }

    public Staff(String idStaff, String name, String posisi, int gaji){
        this.idStaff = idStaff;
        this.namaStaff = name;
        this.posisi = posisi;
        this.gaji = gaji;
        this.userLogin = new UserLogin();
    }
    //Constructor all Fields
    public String getNamaStaff() {
        return namaStaff;
    }

    public int getGaji() {
        return gaji;
    }

    public String getIdStaff() {
        return idStaff;
    }
    
    public String getPosisi() {
        return posisi;
    }

    public UserLogin getUserLogin() {
        return userLogin;
    }

    public void setNamaStaff(String namaStaff) {
        this.namaStaff = namaStaff;
    }

    public void setGaji(int gaji) {
        this.gaji = gaji;
    }

    public void setIdStaff(String idStaff) {
        this.idStaff = idStaff;
    }

    public void setPosisi(String posisi) {
        this.posisi = posisi;
    }

    public void setUserLogin(UserLogin userLogin) {
        this.userLogin = userLogin;
    }

    //Constructor toString
    public String toString(){
        return String.format("%-4s %-20s %-10s Rp. %-20d %s", 
        idStaff,
        namaStaff,
        posisi,
        gaji,
        userLogin
        );
    }
    
}