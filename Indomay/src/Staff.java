public class Staff{
    
    private String name;
    private String password;

    public Staff(String name, String password){
        super();
        this.name = name;
        this.password = password;
    }
    public String getName(){
        return name;
    }
    public String getPassword() {
        return password;
    }
    public void setName(String a){
        this.name = a;
    }
    public void setPassword(String b){
        this.password = b;
    }

    public String toString(){
        return "Staff [Name = " + name + ", Password = " + password + "]";
    }
}