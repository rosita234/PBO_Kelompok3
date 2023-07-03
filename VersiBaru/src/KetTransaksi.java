public class KetTransaksi {
    private String kodeBarang;
    private String namaBarang;
    private int jumlahBarang;
    private int hargaBarang;
    private int totalHarga;

    public KetTransaksi(){

    }

    public KetTransaksi(String kodeBarang,String namaBarang, int jumlahBarang, int hargaBarang, int totalHarga){
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.jumlahBarang = jumlahBarang;
        this.hargaBarang = hargaBarang;
        this.totalHarga = totalHarga;
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

    public int getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(int totalHarga) {
        this.totalHarga = totalHarga;
    }

    public String getKodeBarang() {
        return kodeBarang;
    }

    public void setKodeBarang(String kodeBarang) {
        this.kodeBarang = kodeBarang;
    }

    @Override
    public String toString(){
        return String.format("%-20s %-4d Rp. %-10d Rp. %d\n", 
        namaBarang, jumlahBarang, hargaBarang,totalHarga);
    }
}