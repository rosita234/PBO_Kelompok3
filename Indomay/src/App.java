import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class App {
    static ListBarang listBarang = new ListBarang();
    static ListPembeli listPembeli = new ListPembeli();
    static ListStaff listStaff = new ListStaff();
    static AksesMenu aksesMenu = new AksesMenu();
    static Staff staff;
    static Pembeli pembeli;
    static ListTransaksi listTransaksi  = new ListTransaksi();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException, IOException{
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        init();

        boolean choice = true;
        
        do{
            showMenu();
            System.out.print("Masukkan pilihan : ");
            String pilihan = sc.nextLine();
            System.out.println();
            
            switch(pilihan){
                case "1":
                    System.out.print("Username : ");
                    String username = sc.nextLine();
                    System.out.print("Password : ");
                    String password = sc.nextLine();
                    System.out.println();

                    if(listStaff.login(username, password)){
                        staff = listStaff.getStaff();
                        String namaStaff = staff.getName();
                        HakAkses hakAkses = staff.getUserLogin().getHakAkses();
                        System.out.println("<<System>> Hello, "+ namaStaff);
                        boolean menu = true;

                        do{
                            aksesMenu.menuAkses(hakAkses);
                            System.out.print("Masukkan pilihan : ");
                            String opsi = sc.nextLine();
                            if (aksesMenu.getIdMenu().equals("Menu Staff")){
                                switch(opsi){
                                    case "1":
                                        listBarang();
                                        System.out.println();
                                        transaksi();
                                        break;
                                    case "2":
                                        listBarang();
                                        break;
                                    case "3":
                                        daftarMembership();
                                        break;
                                    case "4":
                                        cekPoinPembeli();
                                        break;
                                    case "5":
                                        listPembeli();
                                        break;
                                    case "6":
                                        cekHistoryTransaksi();
                                        break;
                                    case "7":
                                        System.out.println("<<System>> Bye");
                                        staff = null;
                                        menu = false;
                                        break;
                                    default:
                                        System.out.println("<<System>> Harap Memilih Opsi yang Tersedia");
                                        break;
                                }   
                            }
                            if (aksesMenu.getIdMenu().equals("Menu Admin")){
                                switch(opsi){
                                case "1":
                                    tambahBarang();
                                    break;
                                case "2":
                                    hapusBarang();
                                    break;
                                case "3":
                                    editBarang();
                                    break;
                                case "4":
                                    listBarang();
                                    break;
                                case "5":
                                    listStaff();
                                    break;
                                case "6":
                                    listPembeli();
                                    break;
                                case "7":
                                    cekHistoryTransaksi();
                                    break;
                                case "8":
                                    cekHistoryBarang();
                                    break;
                                case "9":
                                    System.out.println("<<System>> Bye");
                                    staff = null;
                                    menu = false;
                                    break;
                                default:
                                    System.out.println("<<System>> Harap Memilih Opsi yang Tersedia");
                                    break;
                                }   
                            }
                            if (aksesMenu.getIdMenu().equals("Menu Supervisor")){
                                switch(opsi){
                                case "1":
                                    tambahBarang();
                                    break;
                                case "2":
                                    hapusBarang();
                                    break;
                                case "3":
                                    editBarang();
                                    break;
                                case "4":
                                    listBarang();
                                    break;
                                case "5":
                                    listStaff();
                                    break;
                                case "6":
                                    tambahStaff();
                                    break;
                                case "7":
                                    updateStaff();
                                    break;
                                case "8":
                                    listPembeli();
                                    break;
                                case "9":
                                    cekHistoryTransaksi();
                                    break;
                                case "10":
                                    cekHistoryBarang();
                                    break;
                                case "11":
                                    System.out.println("<<System>> Bye");
                                    staff = null;
                                    menu = false;
                                    break;
                                default:
                                    System.out.println("<<System>> Harap Memilih Opsi yang Tersedia");
                                    break;
                                }   
                            }
                        }while (menu);
                    }
                    else{
                        System.out.println("<<System>> Username atau Password Invalid");
                    }
                    break;
                case "2":
                    System.out.println("<<System>> Bye");
                    choice = false;
                    break;
                default:
                    System.out.println("<<System>> Harap Memilih Opsi yang Tersedia");
                    break;
            }
        }while(choice);
        sc.close();
    }

    public static void showMenu(){
        System.out.println();
        System.out.println("                   Menu                   ");
        System.out.println("==========================================");
        System.out.println("1.  Login");
        System.out.println("2.  Exit");
        System.out.println("==========================================");
    }

    public static void transaksi(){
        Transaksi newTransaksi = new Transaksi(staff.getName());
        System.out.print("Ada Membership (Ya/Tidak) : ");
        String adaMember = sc.nextLine();
        if (adaMember.equalsIgnoreCase("ya")){
            System.out.println("=================================================");
            System.out.print("No. Telp : ");
            String noTelp = sc.nextLine();
            System.out.println();
            if(listPembeli.cekPembeli(noTelp)){
                PembeliNode p = listPembeli.getHead();
                while (p != null){
                    if(noTelp.equalsIgnoreCase(p.getItem().getNoTelp())){
                        pembeli = p.getItem(); //simpan data pembeli
                    }
                    p = p.getNext();
                }
            }
        }
        else{
            pembeli = null;
        }
        
        listBarang(); //tampilkan list barang
        String jb = "X";
        //Scan Barang
        System.out.println("Menu");
        System.out.println("==========================================");
        System.out.println("1. Scan Barang");
        System.out.println("2. Hapus Barang di Transaski");
        System.out.println("3. Tukar Poin");
        System.out.println("4. Transaksi selesai");
        System.out.println("==========================================");
        System.out.print("Opsi : ");
        String menuTransaksi = sc.nextLine();
        switch(menuTransaksi){
            case "1":
                do{
                    System.out.print("Kode Barang   : ");
                    String kode = sc.nextLine();
                    System.out.print("Jumlah Barang : ");
                    String jumlah = sc.nextLine();
                    System.out.println();
                    newTransaksi.getListKetTransaksi().add(staff.getId(), listStaff, kode, Integer.parseInt(jumlah));
                    System.out.println("==========================================");
                    System.out.println("<< Tekan Enter untuk Lanjut Scan>>");
                    System.out.println("<< Ketik X untuk Berhenti Scan>>");
                    jb = sc.nextLine();
                }while(!jb.equalsIgnoreCase("X"));
            case "2":
                System.out.println("Nama Barang : ");
                String namaBarang = sc.nextLine();
                newTransaksi.getListKetTransaksi().delete(staff.getId(), listStaff, namaBarang);
            case "3":
            case "4":
            default:
                System.out.println("<<System>> Harap Memilih Opsi yang Tersedia");
                break;

        }

        listTransaksi.add(newTransaksi);
    }

    public static void listBarang(){
        System.out.println(listBarang);
    }

    public static void daftarMembership(){

    }

    public static void listPembeli(){
        System.out.println(listPembeli);
    }

    public static void cekPoinPembeli(){

    }

    public static void historyTransaksi(){
        System.out.println(listTransaksi);
    }

    public static void cekHistoryTransaksi(){
        
    }

    public static void cekHistoryBarang(){
        System.out.println(listBarang.getHistoryBarang());
    }

    public static void tambahBarang(){

    }

    public static void hapusBarang(){
        
    }

    public static void editBarang(){
        
    }

    public static void listStaff(){
        System.out.println(listStaff);
    }

    public static void tambahStaff(){

    }

    public static void updateStaff(){

    }

    public static void init(){
        try{
            File fileBarang = new File("ListBarang.csv");
            File filePembeli = new File("ListPembeli.csv");
            File fileStaff = new File("ListStaff.csv");
            if(fileStaff.exists()){
                Scanner scanFile = new Scanner(fileStaff);
                while(scanFile.hasNextLine()){
                    String baris = scanFile.nextLine();
                    String[] nilai = baris.split(";");
                    if (!baris.equals("ID;NAMA;POSISI;GAJI;USERNAME;PASSWORD;ROLE")) {
                        Staff staff = new Staff(nilai[0], nilai[1],nilai[2], Integer.parseInt(nilai[3]));
                        staff.getUserLogin().setUsername(nilai[4]);
                        staff.getUserLogin().setPassword(nilai[5]);
                        staff.getUserLogin().getHakAkses().setRole(nilai[6]);
                        listStaff.add(staff);
                    }
                }
                scanFile.close();
            } 
            if(fileBarang.exists()){
                Scanner scanFile = new Scanner(fileBarang);
                while(scanFile.hasNextLine()){
                    String baris = scanFile.nextLine();
                    String[] nilai = baris.split(";");
                    if (!baris.equals("KODE;NAMA;JUMLAH;HARGA")) {
                        Barang barang = new Barang(nilai[0], nilai[1], Integer.parseInt(nilai[2]), Integer.parseInt(nilai[3]));
                        listBarang.add("S001",listStaff,barang);
                    }
                }
                scanFile.close();
            }
            if(filePembeli.exists()){
                Scanner scanFile = new Scanner(filePembeli);
                while(scanFile.hasNextLine()){
                    String baris = scanFile.nextLine();
                    String[] nilai = baris.split(";");
                    if (!baris.equals("NOMOR;NAMA;POIN")) {
                        Pembeli pembeli = new Pembeli(nilai[0], nilai[1]);
                        pembeli.getMembership().setPoin(Double.parseDouble(nilai[2]));
                        listPembeli.add(pembeli);
                    }
                }
                scanFile.close();
            }
        }catch (Exception e){
            System.out.println("Error : " + e.getMessage());
        }
    }
}