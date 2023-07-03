public class HakAkses {
    private String role;

    public HakAkses(){

    }

    public HakAkses(String role){
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return role;
    }
}
