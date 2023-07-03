public class Barang {
    private String kodeBarang;
    private String namaBarang;
    private int jumlahBarang;
    private int hargaBarang;

    public Barang(){}

    public Barang(String kodeBarang, String namaBarang, int jumlahBarang, int hargaBarang){
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.jumlahBarang = jumlahBarang;
        this.hargaBarang = hargaBarang;
    }

    public String getKodeBarang() {
        return kodeBarang;
    }
    
    public String getNamaBarang() {
        return namaBarang;
    }

    public int getJumlahBarang() {
        return jumlahBarang;
    }

    public int getHargaBarang() {
        return hargaBarang;
    }

    public void setKodeBarang(String kodeBarang) {
        this.kodeBarang = kodeBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public void setJumlahBarang(int jumlahBarang) {
        this.jumlahBarang = jumlahBarang;
    }

    public void setHargaBarang(int hargaBarang) {
        this.hargaBarang = hargaBarang;
    }

    @Override
    public String toString() {
        return String.format("%-4s %-20s %-4d   Rp. %d", 
        kodeBarang,
        namaBarang, 
        jumlahBarang, 
        hargaBarang);
    }
}
