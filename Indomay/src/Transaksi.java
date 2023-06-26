//fitur ini digunakan untuk mengecek history dari setiap transakasi
//By: Rosita Darianty(03081220014)
//email: 03081220014@student.uph.edu

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

public class Transaksi {
    private String tanggalDanWaktu;
    private String idTransaksi;
    private String namaStaff;
    private String namaPembeli;
    private ListKetTransaksi listKetTransaksi;
    public ListPembeli listPembeli;
    public Pembeli pembeli;
    private double totalBelanja;
    private double diskon;

    public Transaksi(String namaStaff){
        this.tanggalDanWaktu = waktu();
        this.idTransaksi = idBon();
        listKetTransaksi = new ListKetTransaksi();
        this.namaStaff = namaStaff;
        namaPembeli();
    }

    public void namaPembeli(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Ada Membership (Ya/Tidak) : ");
        String jb = sc.nextLine();
        if (jb.equalsIgnoreCase("ya")){
            System.out.println("=================================================");
            System.out.print("No. Telp : ");
            String noTelp = sc.nextLine();
            System.out.println();
            if(listPembeli.cekPembeli(noTelp)){
                PembeliNode p = listPembeli.getHead();
                while (p != null){
                    if(noTelp.equalsIgnoreCase(p.getItem().getNoTelp())){
                        pembeli = p.getItem();
                        namaPembeli = pembeli.getNama();
                    }
                    p = p.getNext();
                }
            }
        }
        else{
            pembeli = null;
            namaPembeli = "";
        }
        sc.close();
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
    
    public void setIdTransaksi(String idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public String getTanggalDanWaktu() {
        return tanggalDanWaktu;
    }

    public void setTanggalDanWaktu(String tanggalDanWaktu) {
        this.tanggalDanWaktu = tanggalDanWaktu;
    }

    public ListKetTransaksi getListKetTransaksi() {
        return listKetTransaksi;
    }

    public void setListKetTransaksi(ListKetTransaksi listKetTransaksi) {
        this.listKetTransaksi = listKetTransaksi;
    }

    public ListPembeli getListPembeli() {
        return listPembeli;
    }

    public String getNamaPembeli() {
        return namaPembeli;
    }

    public String getNamaStaff() {
        return namaStaff;
    }

    public void setListPembeli(ListPembeli listPembeli) {
        this.listPembeli = listPembeli;
    }

    public void setNamaPembeli(String namaPembeli) {
        this.namaPembeli = namaPembeli;
    }

    public void setNamaStaff(String namaStaff) {
        this.namaStaff = namaStaff;
    }

    public void setPembeli(Pembeli pembeli) {
        this.pembeli = pembeli;
    }

    public Pembeli getPembeli() {
        return pembeli;
    }

    public boolean adaTukarPoin() {
        if(pembeli != null){
            Scanner sc = new Scanner(System.in);
            System.out.println("<<System>> Tukar poin ? (YA/TIDAK)");
            String jb = sc.nextLine();
            sc.close(); 
            return jb.equalsIgnoreCase("ya");
        }
        return false;
    }

    public void tukarPoinDapatDiskon(){
        diskon = 0;
        if(pembeli != null){
            Scanner sc = new Scanner(System.in);
            System.out.println("100 Poin -> diskon 5%");
            System.out.println("200 Poin -> diskon 10%");
            System.out.println("200 Poin -> diskon 15%");
            System.out.println("=================================================");
            System.out.println("Poin yang Ingin Ditukar : ");
            int jb = sc.nextInt();
            if (jb == 100 && pembeli.getMembership().getPoin() >= 100){
                diskon = 0.05;
                pembeli.getMembership().setPoin(pembeli.getMembership().getPoin()-jb);
            }
            else if (jb == 200 && pembeli.getMembership().getPoin() >= 200){
                diskon = 0.1;
                pembeli.getMembership().setPoin(pembeli.getMembership().getPoin()-jb);
            }
            else if (jb == 300 && pembeli.getMembership().getPoin() >= 300){
                diskon = 0.15;
                pembeli.getMembership().setPoin(pembeli.getMembership().getPoin()-jb);
            } 
            sc.close();
        }
    }

    public void total(){
        if(adaTukarPoin()){
            double banyakDiskon = listKetTransaksi.totalHarga() * diskon;
            System.out.println(String.format("Total Item    :           Rp. %d",listKetTransaksi.totalHarga()));
            System.out.println(String.format("Total Disc    :          -Rp. %.3f",banyakDiskon));
            totalBelanja = listKetTransaksi.totalHarga() - banyakDiskon;
            System.out.println(String.format("Total Belanja :           Rp. %.3f",totalBelanja));
            pembeli.getMembership().setPoin(pembeli.getMembership().getPoin() + totalBelanja/10000);
        }
        else{
            totalBelanja = listKetTransaksi.totalHarga();
            System.out.println(String.format("Total Item    :           Rp. %d",totalBelanja));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Tanggal : %s\nID Bon  : %s Kasir : %s\n%s", 
        tanggalDanWaktu, idTransaksi, namaStaff,listKetTransaksi));
        total();
        sb.append(String.format("Pembeli : %s",this.pembeli.getNama()));
        return sb.toString();
    }

}
