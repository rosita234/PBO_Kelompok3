import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HistoryBarang {
    private String tanggal;
    private String operasi;
    private String idStaff;
    private String namaStaff;
    private String keterangan;

    public HistoryBarang(String operasi, String idStaff,String namaStaff, String keterangan){
        this.tanggal = waktu();
        this.operasi = operasi;
        this.idStaff = idStaff;
        this.namaStaff = namaStaff;
        this.keterangan = keterangan;
    }

    public String waktu(){
        LocalDateTime waktu = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return waktu.format(format);

    }

    public String getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(String idStaff) {
        this.idStaff = idStaff;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public String getNamaStaff() {
        return namaStaff;
    }

    public String getOperasi() {
        return operasi;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public void setNamaStaff(String namaStaff) {
        this.namaStaff = namaStaff;
    }

    public void setOperasi(String operasi) {
        this.operasi = operasi;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    @Override
    public String toString() {
        return String.format("%s  %-6s  %-4s %-20s %s", tanggal, operasi, idStaff,namaStaff, keterangan);
    }
}
