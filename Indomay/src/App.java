import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class App {
    static ListBarang listBarang = new ListBarang();
    static ListPembeli listPembeli = new ListPembeli();
    static ListStaff listStaff = new ListStaff();
    static ListTransaksi historyTransaksi = new ListTransaksi();
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
                        String role = staff.getUserLogin().getHakAkses().getRole();
                        System.out.println("<<System>> Hello, "+ namaStaff);
                        boolean menu = true;

                        do{
                            staff.menu();
                            System.out.print("Masukkan pilihan : ");
                            String opsi = sc.nextLine();
                            if (role.equalsIgnoreCase("Kasir")){
                                switch(opsi){
                                    case "1":
                                        transaksi();
                                        break;
                                    case "2":
                                        listBarang();
                                        break;
                                    case "3":
                                        daftarMembership(); //tambah Pembeli
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
                            if (role.equalsIgnoreCase("Admin")){
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
                            if (role.equalsIgnoreCase("Supervisor")){
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
        System.out.print("Ada Membership (Ya/Tidak) : ");
        String adaMember = sc.nextLine();
        String namaPembeli = "-";
        if (adaMember.equalsIgnoreCase("ya")){
            System.out.println("=================================================");
            System.out.print("No. Telp : ");
            String noTelp = sc.nextLine();
            System.out.println();
            pembeli = listPembeli.cekPembeli(noTelp, listPembeli);
            namaPembeli = pembeli.getNama();
        }
        else{
            pembeli = null;
        }

        Transaksi newTransaksi = new Transaksi(staff.getName(),namaPembeli);
        
        listBarang(); //tampilkan list barang
        String jb = "X";
        boolean menuTransaksi = true;
        do{
            System.out.println("Menu");
            System.out.println("==========================================");
            System.out.println("1. Scan Barang");
            System.out.println("2. Hapus Barang di Transaski");
            System.out.println("3. Tukar Poin");
            System.out.println("4. Transaksi selesai");
            System.out.println("==========================================");
            System.out.print("Opsi : ");
            String opsiMenuTransaksi = sc.nextLine();
            switch(opsiMenuTransaksi){
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
                    break;
                case "2":
                    System.out.println(newTransaksi.getListKetTransaksi());
                    System.out.println("Nama Barang : ");
                    String namaBarang = sc.nextLine();
                    newTransaksi.getListKetTransaksi().delete(staff.getId(), listStaff, namaBarang);
                    break;
                case "3":
                    if(pembeli != null){
                        newTransaksi.tukarPoinDapatDiskon(pembeli);
                    }
                    else{
                        System.out.println("Pembeli tidak mempunyai membership");
                    }
                    break;
                case "4":
                    if(newTransaksi.getTotalBelanja() != 0){
                        System.out.println(newTransaksi);
                        listTransaksi.add(newTransaksi);
                        pembeli = null;
                        menuTransaksi = false;
                    }
                    else{
                        System.out.println("Transaski kosong");
                    }
                    pembeli = null;
                    menuTransaksi = false;
                    break;
                default:
                    System.out.println("<<System>> Harap Memilih Opsi yang Tersedia");
                    break;

            }
        }while(menuTransaksi);
    }

    public static void listBarang(){
        System.out.println(listBarang);
    }

    public static void daftarMembership(){ //Tambah Pembeli
        System.out.print("Nama     : ");
        String nama = sc.nextLine();
        System.out.print("No. Telp : ");
        String noTelp = sc.nextLine();
        Pembeli pembeliBaru = new Pembeli(nama, noTelp);
        listPembeli.add(pembeliBaru);
        System.out.println();
    }

    public static void listPembeli(){
        System.out.println(listPembeli);
    }

    public static void cekPoinPembeli(){

    }

    public static void historyTransaksi(){
        System.out.println(historyTransaksi);
    }

    public static void cekHistoryTransaksi(){
        
    }

    public static void cekHistoryBarang(){
        System.out.println(listBarang.getHistoryBarang());
    }

    public static void tambahBarang(){
        System.out.print("Kode   : ");
        String kode = sc.nextLine();
        System.out.print("Nama   : ");
        String nama = sc.nextLine();
        System.out.print("Jumlah : ");
        int jumlah = sc.nextInt();
        System.out.print("Harga  : ");
        int harga = sc.nextInt();
        Barang barang = new Barang(kode, nama, jumlah, harga);
        listBarang.add(staff.getId(),listStaff,barang);
        System.out.println();
    }

    public static void hapusBarang(){
        
    }

    public static void editBarang(){
        
    }

    public static void listStaff(){
        System.out.println(listStaff);
    }

    public static void tambahStaff(){
        System.out.print("ID       : ");
        String id = sc.nextLine();
        System.out.print("Nama     : ");
        String nama = sc.nextLine();
        System.out.print("Posisi   : ");
        String posisi = sc.nextLine();
        System.out.print("Gaji     : ");
        int gaji = sc.nextInt();
        sc.nextLine();
        System.out.println("Role -> Kasir/Admin/Supervisor/Tidak Ada");
        System.out.print("Role     : ");
        String role = sc.nextLine();

        //harus terpisah satu-satu entah kenapa
        if (role.equalsIgnoreCase("Kasir") || role.equalsIgnoreCase("Admin")||role.equalsIgnoreCase("Supervisor")){
            //harus terpisah satu-satu entah kenapa
            System.out.print("Username : ");
            String username = sc.nextLine();
            System.out.print("Password : ");
            String password = sc.nextLine();
            if (role.equalsIgnoreCase("Kasir")){
                Staff staffBaru = new Kasir(id, nama, posisi, gaji);
                staffBaru.getUserLogin().setUsername(username);
                staffBaru.getUserLogin().setPassword(password);
                staffBaru.getUserLogin().getHakAkses().setRole(role);
                listStaff.add(staffBaru);
            }
            else if (role.equalsIgnoreCase("Admin")){
                Staff staffBaru = new Admin(id, nama, posisi, gaji);
                staffBaru.getUserLogin().setUsername(username);
                staffBaru.getUserLogin().setPassword(password);
                staffBaru.getUserLogin().getHakAkses().setRole(role);
                listStaff.add(staffBaru);
            }
            else if (role.equalsIgnoreCase("Supervisor")){
                Staff staffBaru = new Supervisor(id, nama, posisi, gaji);
                staffBaru.getUserLogin().setUsername(username);
                staffBaru.getUserLogin().setPassword(password);
                staffBaru.getUserLogin().getHakAkses().setRole(null);
                listStaff.add(staffBaru);
            }
        }
        else{
            Staff staffBaru = new StaffBiasa(id, nama, posisi, gaji);
            listStaff.add(staffBaru);
        }
        System.out.println();
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
                        if (nilai[6].equalsIgnoreCase("Kasir")){
                            Staff staffBaru = new Kasir(nilai[0], nilai[1],nilai[2], Integer.parseInt(nilai[3]));
                            staffBaru.getUserLogin().setUsername(nilai[4]);
                            staffBaru.getUserLogin().setPassword(nilai[5]);
                            staffBaru.getUserLogin().getHakAkses().setRole(nilai[6]);
                            listStaff.add(staffBaru);
                        }
                        else if (nilai[6].equalsIgnoreCase("Admin")){
                            Staff staffBaru = new Admin(nilai[0], nilai[1],nilai[2], Integer.parseInt(nilai[3]));
                            staffBaru.getUserLogin().setUsername(nilai[4]);
                            staffBaru.getUserLogin().setPassword(nilai[5]);
                            staffBaru.getUserLogin().getHakAkses().setRole(nilai[6]);
                            listStaff.add(staffBaru);
                        }
                        else if (nilai[6].equalsIgnoreCase("Supervisor")){
                            Staff staffBaru = new Supervisor(nilai[0], nilai[1],nilai[2], Integer.parseInt(nilai[3]));
                            staffBaru.getUserLogin().setUsername(nilai[4]);
                            staffBaru.getUserLogin().setPassword(nilai[5]);
                            staffBaru.getUserLogin().getHakAkses().setRole(nilai[6]);
                            listStaff.add(staffBaru);
                        }
                        else{
                            Staff staffBaru = new StaffBiasa(nilai[0], nilai[1],nilai[2], Integer.parseInt(nilai[3]));
                            listStaff.add(staffBaru);
                        }
                    }
                }System.out.println(listStaff);
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
                        Pembeli pembeliBaru = new Pembeli(nilai[0], nilai[1]);
                        pembeliBaru.getMembership().setPoin(Double.parseDouble(nilai[2]));
                        listPembeli.add(pembeliBaru);
                    }
                }
                scanFile.close();
            }
        }catch (Exception e){
            System.out.println("Error : " + e.getMessage());
        }
    }
}