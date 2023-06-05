//fitur ini digunakan untuk mengecek history dari setiap transakasi
//By: Rosita Darianty(03081220014)
//email: 03081220014@student.uph.edu


import java.util.ArrayList;
import java.time.LocalDateTime;

public class History {
    private String tanggal;
    private ArrayList historyArray;
    private String keterangan;
    private String jenis_transaksi;

    public History(){}

    public History(String tanggal, String keterangan, String jenis_transaksi){
        this.jenis_transaksi = jenis_transaksi;
        this.keterangan = keterangan;
        this.tanggal = tanggal;
    }

    public String getTanggal() {
        return this.tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public ArrayList getHistoryArray() {
        return this.historyArray;
    }

    public void setHistoryArray(ArrayList historyArray) {
        this.historyArray = historyArray;
    }

    public String getKeterangan() {
        return this.keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public void setJenis_transaksi(String jenis_transaksi) {
        this.jenis_transaksi = jenis_transaksi;
    }

    public String getJenis_transaksi() {
        return jenis_transaksi;
    }

    @Override
    public String toString(){
        return String.format("Tanggal: %s Jenis Transaksi %s Keterangan %s", tanggal, jenis_transaksi, keterangan);
    }
}
