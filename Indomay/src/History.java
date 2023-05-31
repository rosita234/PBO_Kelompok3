//fitur ini digunakan untuk mengecek history dari setiap transakasi
//By: Rosita Darianty(03081220014)
//email: 03081220014@student.uph.edu


import java.util.ArrayList;
import java.time.LocalDateTime;

public class History {
    private LocalDateTime tanggal;
    private ArrayList historyArray;
    private String keterangan;


    public LocalDateTime getTanggal() {
        return this.tanggal;
    }

    public void setTanggal(LocalDateTime tanggal) {
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

}
