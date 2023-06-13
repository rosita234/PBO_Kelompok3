//fitur ini berfungsi untuk menyimpan identitas pembelian dan status membership
//By : Edbert Muis (03081220022)
//email : 03081220022@student.uph.edu

public class Pembeli {

    public String nama;
    public String noTelp;
    private int poin;

    public Pembeli() {
    }

    public Pembeli(String nama, String noTelp, int poin) {
        this.nama = nama;
        this.noTelp = noTelp;
        this.poin = poin;
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

    public int getPoin() {
        return poin;
    }

    public void setPoin(int poin) {
        this.poin = poin;
    }

    
    @Override
    public String toString() {
        return String.format("%-20s %-12s %d", 
        nama,
        noTelp,
        poin) ;
    }

}

