//fitur ini berfungsi untuk menyimpan identitas pembelian dan status membership
//By : Edbert Muis (03081220022)
//email : 03081220022@student.uph.edu

public class Pembeli {

    public String nama;
    public String noTelp;
    private Membership membership;

    public Pembeli() {
    }

    public Pembeli(String nama, String noTelp, Membership membership) {
        this.nama = nama;
        this.noTelp = noTelp;
        this.membership = membership;
    }

    public String getNama() {
        return this.nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNoTelp() {
        return this.noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
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
        nama,
        noTelp,
        membership.toString()) ;
    }

}

