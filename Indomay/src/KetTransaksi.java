public class KetTransaksi {
    private String namaBarang;
    private int jumlahBarang;
    private int hargaBarang;

    public KetTransaksi(){

    }

    public KetTransaksi(String namaBarang, int jumlahBarang, int hargaBarang){
        this.namaBarang = namaBarang;
        this.jumlahBarang = jumlahBarang;
        this.hargaBarang = hargaBarang;
    }

    public int getHargaBarang() {
        return hargaBarang;
    }

    public int getJumlahBarang() {
        return jumlahBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setHargaBarang(int hargaBarang) {
        this.hargaBarang = hargaBarang;
    }

    public void setJumlahBarang(int jumlahBarang) {
        this.jumlahBarang = jumlahBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    @Override
    public String toString(){
        return String.format("%-20s %-4d Rp. %d", 
        namaBarang, jumlahBarang, hargaBarang);
    }
}