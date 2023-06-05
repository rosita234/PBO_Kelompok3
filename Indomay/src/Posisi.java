/*
 * 22SI2 
 * Louin Liman 
 * 03081220043
 * sirlinjj@gmail.com
 * 
 * Class ini berfungsi untuk membedakan status staff antara admin atau kasir
 */

public class Posisi {

    private String status;
    private String employment;
    private String contract;


    public Posisi() {
    }

    public Posisi(String status, String employment, String contract) {
        this.status = status;
        this.employment = employment;
        this.contract = contract;
    }

    public String getEmployment() {
        return this.employment;
    }

    public void setEmployment(String employment) {
        this.employment = employment;
    }

    public String getContract() {
        return this.contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "{" +
            " status='" + getStatus() + "'" +
            ", employment='" + getEmployment() + "'" +
            ", contract='" + getContract() + "'" +
            "}";
    }
    
}
