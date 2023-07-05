public class Pembeli {

    public String namaPembeli;
    public String noTelpPembeli;
    private Membership membership;

    public Pembeli() {
        membership = new Membership(0);
    }

    public Pembeli(String nama, String noTelp) {
        this.namaPembeli = nama;
        this.noTelpPembeli = noTelp;
        membership = new Membership(0);
    }

    public String getNamaPembeli() {
        return namaPembeli;
    }

    public String getNoTelpPembeli() {
        return noTelpPembeli;
    }

    public void setNamaPembeli(String namaPembeli) {
        this.namaPembeli = namaPembeli;
    }

    public void setNoTelpPembeli(String noTelpPembeli) {
        this.noTelpPembeli = noTelpPembeli;
    }

    public Membership getMembership() {
        return membership;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
    }
    
    @Override
    public String toString() {
        return String.format("%-20s %-12s %s", 
        namaPembeli,
        noTelpPembeli,
        membership) ;
    }

}

