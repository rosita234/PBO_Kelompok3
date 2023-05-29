/*Class stok dapat digunakan untuk
- Input Stok
- Edit Stok (Menambah, mengubah, menghapus stok)
- Cek Status Stok, termasuk jumlah barang 
 */

public class Stok {
    private String kodeStok;
    private String namaStok;
    private int jumlahStok;
    private int hargaStok;

    public Stok(String kodeStok, String namaStok, int jumlahStok, int hargaStok){
        this.kodeStok = kodeStok;
        this.namaStok = namaStok;
        this.jumlahStok = jumlahStok;
        this.hargaStok = hargaStok;
    }

    public int getHargaStok() {
        return hargaStok;
    }

    public int getJumlahStok() {
        return jumlahStok;
    }

    public String getKodeStok() {
        return kodeStok;
    }
    
    public String getNamaStok() {
        return namaStok;
    }

    public void setHargaStok(int hargaStok) {
        this.hargaStok = hargaStok;
    }

    public void setJumlahStok(int jumlahStok) {
        this.jumlahStok = jumlahStok;
    }

    public void setKodeStok(String kodeStok) {
        this.kodeStok = kodeStok;
    }

    public void setNamaStok(String namaStok) {
        this.namaStok = namaStok;
    }
}
