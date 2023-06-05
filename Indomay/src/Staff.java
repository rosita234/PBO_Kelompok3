public class Staff{
    
    private String name;
    private String password;

    public Staff(String name, String password){
        super();
        this.name = name;
        this.password = password;
    }
    //Constructor all Fields
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
    //Constructor toString
    public String toString(){
        return "Staff: [Name = " + name + ", Password = " + password + "]";
    }
    //Constuctor Empty
    public void Staff() {
    }
}