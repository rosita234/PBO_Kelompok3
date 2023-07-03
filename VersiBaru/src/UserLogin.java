public class UserLogin {
    private String username;
    private String password;
    private HakAkses hakAkses;

    public UserLogin(){
        hakAkses = new HakAkses();
    }

    public UserLogin(String username, String password){
        this.username = username;
        this.password = password;
        hakAkses = new HakAkses();
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public HakAkses getHakAkses() {
        return hakAkses;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setHakAkses(HakAkses hakAkses) {
        this.hakAkses = hakAkses;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-10s %s", 
        username,
        password,
        hakAkses.toString());
    }
    
}
