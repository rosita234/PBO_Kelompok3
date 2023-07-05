import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.ArrayList;

public class Transaksi {
    private String tanggalDanWaktu;
    private String idTransaksi;
    private String namaStaff;
    private ArrayList<KetTransaksi> ketTransaksi;
    private String noTelpPembeli;
    private double totalHargaTransaksi; //total sebelum diskon
    private double banyakDiskon;
    private double totalBelanja; //total sebelum diskon

    public Transaksi(String namaStaff, String noTelp){
        this.tanggalDanWaktu = waktu();
        this.idTransaksi = idBon();
        ketTransaksi =  new ArrayList<KetTransaksi>();
        this.namaStaff = namaStaff;
        this.noTelpPembeli = noTelp;
    }

    public String idBon(){
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        for (int i = 0; i < 9; i++) {
            int randomIndex = random.nextInt(characters.length());
            sb.append(characters.charAt(randomIndex));
        }
        return sb.toString();
    }

    public String waktu(){
        LocalDateTime waktu = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return waktu.format(format);

    }

    public String getIdTransaksi() {
        return idTransaksi;
    }

    public ArrayList<KetTransaksi> getKetTransaksi() {
        return ketTransaksi;
    }

    public String getNamaStaff() {
        return namaStaff;
    }

    public String getTanggalDanWaktu() {
        return tanggalDanWaktu;
    }

    public void setIdTransaksi(String idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public void setKetTransaksi(ArrayList<KetTransaksi> ketTransaksi) {
        this.ketTransaksi = ketTransaksi;
    }

    public void setNamaStaff(String namaStaff) {
        this.namaStaff = namaStaff;
    }

    public void setTanggalDanWaktu(String tanggalDanWaktu) {
        this.tanggalDanWaktu = tanggalDanWaktu;
    }

    public double getBanyakDiskon() {
        return banyakDiskon;
    }

    public double getTotalBelanja() {
        return totalBelanja;
    }

    public double getTotalHargaTransaksi() {
        return totalHargaTransaksi;
    }

    public void setBanyakDiskon(double banyakDiskon) {
        this.banyakDiskon = banyakDiskon;
    }

    public void setTotalBelanja(double totalBelanja) {
        this.totalBelanja = totalBelanja;
    }

    public void setTotalHargaTransaksi(double totalHargaTransaksi) {
        this.totalHargaTransaksi = totalHargaTransaksi;
    }

    public String getNoTelpPembeli() {
        return noTelpPembeli;
    }

    public void setNoTelpPembeli(String noTelpPembeli) {
        this.noTelpPembeli = noTelpPembeli;
    }

    public String listKetTransaksi() {
        StringBuilder stringBuilder = new StringBuilder();
        
        for (int i = 0; i < ketTransaksi.size(); i++) {
            stringBuilder.append(ketTransaksi.get(i).toString());
        }
        
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Tanggal : %s\nID Bon  : %s Kasir : %s\n==========================================================\n%s\n", 
        tanggalDanWaktu, idTransaksi, namaStaff,listKetTransaksi()));
        sb.append("==========================================================\n");
        sb.append(String.format("Total Harga   :                          Rp. %.3f\n",totalHargaTransaksi));
        if(banyakDiskon != 0){
            sb.append(String.format("Total Disc    :                         -Rp. %.3f\n",banyakDiskon));
            sb.append(String.format("Total Belanja :                          Rp. %.3f\n",totalBelanja));
        }
        return sb.toString();
    }

}
