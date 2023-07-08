import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class App {
    static ArrayList<Barang> barang = new ArrayList<Barang>();
    static ArrayList<Staff> staff = new ArrayList<Staff>();
    static ArrayList<Pembeli> pembeli = new ArrayList<Pembeli>();
    static ArrayList<Transaksi> historyTransaksi = new ArrayList<Transaksi>();
    static ArrayList<HistoryBarang> historyBarang = new ArrayList<HistoryBarang>();

    static Staff staffYangLogin;
    static Pembeli pembeliYangBeli;
    static int banyakPoinYangInginDitukar = 0;

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException, IOException{
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        init();
        boolean choice = true;
        
        do{
            menuLogin();
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

                    if(login(username,password)){
                        String namaStaff = staffYangLogin.getNamaStaff();
                        String role = staffYangLogin.getUserLogin().getHakAkses().getRole();
                        System.out.println("<<System>> Hello, "+ namaStaff);
                        boolean menu = true;

                        do{
                            staffYangLogin.menu();
                            System.out.print("Masukkan pilihan : ");
                            String opsi = sc.nextLine();
                            if (role.equalsIgnoreCase("Kasir")){
                                switch(opsi){
                                    case "1":
                                        transaksi();
                                        break;
                                    case "2":
                                        showBarang();
                                        break;
                                    case "3":
                                        daftarMembership(); //tambah Pembeli
                                        break;
                                    case "4":
                                        cekPoinPembeli();
                                        break;
                                    case "5":
                                        showPembeli();
                                        break;
                                    case "6":
                                        showHistoryTransaksi();
                                        break;
                                    case "7":
                                        System.out.println("<<System>> Bye");
                                        staffYangLogin = null;
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
                                    showBarang();
                                    break;
                                case "5":
                                    showStaff();
                                    break;
                                case "6":
                                    showPembeli();
                                    break;
                                case "7":
                                    showHistoryTransaksi();
                                    break;
                                case "8":
                                    showHistoryBarang();
                                    break;
                                case "9":
                                    System.out.println("<<System>> Bye");
                                    staffYangLogin = null;
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
                                    showBarang();
                                    break;
                                case "5":
                                    showStaff();
                                    break;
                                case "6":
                                    showPembeli();
                                    break;
                                case "7":
                                    tambahStaff();
                                    break;
                                case "8":
                                    updateStaff();
                                    break;
                                case "9":
                                    showHistoryTransaksi();
                                    break;
                                case "10":
                                    showHistoryBarang();
                                    break;
                                case "11":
                                    System.out.println("<<System>> Bye");
                                    staffYangLogin = null;
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

    public static void menuLogin(){
        System.out.println();
        System.out.println("                   Menu                   ");
        System.out.println("==========================================");
        System.out.println("1.  Login");
        System.out.println("2.  Exit");
        System.out.println("==========================================");
    }

    public static boolean login(String username, String password){
        for (int i = 0; i < staff.size();i++){
            if(staff.get(i).getUserLogin().getUsername().equals(username) && staff.get(i).getUserLogin().getPassword().equals(password)){
                staffYangLogin = staff.get(i);
                return true;
            }
        }
        return false;
    }

    public static void tambahBarang() {
        //Exception Handling
        try {
            System.out.print("Kode   : ");
            String kode = sc.nextLine();
            System.out.print("Nama   : ");
            String nama = sc.nextLine();
            //Untuk Handling Jumlah dan Harga
            System.out.print("Jumlah : ");
            int jumlah = Integer.parseInt(sc.nextLine());
            System.out.print("Harga  : ");
            int harga = Integer.parseInt(sc.nextLine());
            
            Barang barangBaru = new Barang(kode, nama, jumlah, harga);
            barang.add(barangBaru);
            
            HistoryBarang historyBaru = new HistoryBarang("Add", staffYangLogin.getIdStaff(), staffYangLogin.getNamaStaff(), barangBaru.getKodeBarang());
            historyBarang.add(historyBaru);
            
            System.out.println("<<System>> Barang Berhasil Ditambah");
            System.out.println();
        } catch (NumberFormatException e) {
            System.out.println("<<System>> Input Harus Dalam Bentuk Angka");
            System.out.println("<<System>> Barang Gagal Ditambah");
            System.out.println();
        }
    }

    public static void hapusBarang(){
        boolean kodeAda = false;
        System.out.print("Kode   : ");
        String kode = sc.nextLine();
        for (int i = 0; i < barang.size(); i++){
            if (barang.get(i).getKodeBarang().equals(kode)){
                barang.remove(i);
                kodeAda = true;
                String ket = String.format("%s", kode);
                HistoryBarang historyBaru = new HistoryBarang("Delete", staffYangLogin.getIdStaff(), staffYangLogin.getNamaStaff(), ket);
                historyBarang.add(historyBaru);
                System.out.println("<<System>> Barang Berhasil Dihapus");
            }
        }
        if(!kodeAda){
            System.out.println("<<System>> Kode Barang Invalid");
        }
    }
    public static void editBarang(){
        boolean kodeAda = false;
        System.out.println();
        System.out.println("Menu Edit Barang");
        System.out.println("============================");
        System.out.println("1. Edit Kode Barang");
        System.out.println("2. Edit Nama Barang");
        System.out.println("3. Edit Jumlah Barang");
        System.out.println("4. Edit Harga Barang");
        System.out.println("============================");
        System.out.print("Opsi : ");
        String opsi = sc.nextLine();
        System.out.println();
    
        if(opsi.equals("1") || opsi.equals("2") || opsi.equals("3") ||opsi.equals("4") ){
            System.out.print("Masukkan Kode Barang   : ");
            String kode = sc.nextLine();
            for (int i = 0; i < barang.size(); i++){
                if (barang.get(i).getKodeBarang().equals(kode)){
                    kodeAda = true;
                    String ket = "";
                    //Exception Handling
                    try{
                        if (opsi.equals("1")){
                        System.out.print("Kode Baru : ");
                        String kodeBaru = sc.nextLine();
                        barang.get(i).setKodeBarang(kodeBaru);
                        ket = String.format("%s -> %s", kode,kodeBaru);
                        }
                        else if (opsi.equals("2")){
                            System.out.print("Nama Baru : ");
                            String namaBaru = sc.nextLine();
                            String namaLama = barang.get(i).getNamaBarang();
                            barang.get(i).setNamaBarang(namaBaru);
                            ket = String.format("%s -> %s", namaLama,namaBaru);
                        }   
                        else if (opsi.equals("3")){
                            System.out.print("Jumlah Baru : ");
                            //Handling jumlahBaru
                            int jumlahBaru = Integer.parseInt(sc.nextLine());
                            int jumlahLama = barang.get(i).getJumlahBarang();
                            barang.get(i).setJumlahBarang(jumlahBaru);
                            ket = String.format("%d -> %d", jumlahLama,jumlahBaru);
                        }
                        else if (opsi.equals("4")){
                            System.out.print("Harga Baru : ");
                            //Handling hargaBaru
                            int hargaBaru = Integer.parseInt(sc.nextLine());
                            int hargaLama = barang.get(i).getHargaBarang();
                            barang.get(i).setJumlahBarang(hargaBaru);
                            ket = String.format("%d -> %d", hargaLama,hargaBaru);
                        }
                        HistoryBarang historyBaru = new HistoryBarang("Edit", staffYangLogin.getIdStaff(), staffYangLogin.getNamaStaff(), ket);
                        historyBarang.add(historyBaru);
                        System.out.println("<<System>> Barang Berhasil Diedit");
                    }catch (NumberFormatException e) {
                        System.out.println("<<System>> Input Harus Dalam Bentuk Angka");
                        System.out.println("<<System>> Barang Tidak Berhasil Diedit");
                        System.out.println();
                    }
                }
            }
        }
        
        if(!kodeAda){
            System.out.println("<<System>> Kode Barang Invalid");
        }

    }

    public static void tambahStaff(){
        //Exception Handling
        try{
            System.out.print("ID       : ");
            String id = sc.nextLine();
            System.out.print("Nama     : ");
            String nama = sc.nextLine();
            System.out.print("Posisi   : ");
            String posisi = sc.nextLine();
            System.out.print("Gaji     : ");
            //Handling gaji
            int gaji = Integer.parseInt(sc.nextLine());
            System.out.println("Role -> Kasir/Admin/Supervisor/Tidak Ada");
            System.out.print("Role     : ");
            String role = sc.nextLine();

            if (role.equalsIgnoreCase("Kasir") || role.equalsIgnoreCase("Admin")||role.equalsIgnoreCase("Supervisor")){
                System.out.print("Username : ");
                String username = sc.nextLine();
                System.out.print("Password : ");
                String password = sc.nextLine();
                if (role.equalsIgnoreCase("Kasir")){
                    Staff staffBaru = new Kasir(id, nama, posisi, gaji);
                    staffBaru.getUserLogin().setUsername(username);
                    staffBaru.getUserLogin().setPassword(password);
                    staffBaru.getUserLogin().getHakAkses().setRole(role);
                    staff.add(staffBaru);
                }
                else if (role.equalsIgnoreCase("Admin")){
                    Staff staffBaru = new Admin(id, nama, posisi, gaji);
                    staffBaru.getUserLogin().setUsername(username);
                    staffBaru.getUserLogin().setPassword(password);
                    staffBaru.getUserLogin().getHakAkses().setRole(role);
                    staff.add(staffBaru);
                }
                else if (role.equalsIgnoreCase("Supervisor")){
                    Staff staffBaru = new Supervisor(id, nama, posisi, gaji);
                    staffBaru.getUserLogin().setUsername(username);
                    staffBaru.getUserLogin().setPassword(password);
                    staffBaru.getUserLogin().getHakAkses().setRole(role);
                    staff.add(staffBaru);
                }
            }
            else{
                Staff staffBaru = new StaffBiasa(id, nama, posisi, gaji);
                staff.add(staffBaru);
            }
            System.out.println("<<System>> Staff Berhasil Ditambah");
            System.out.println();
        }catch (NumberFormatException e) {
            System.out.println("<<System>> Input Harus Dalam Bentuk Angka");
            System.out.println("<<System>> Staff Tidak Berhasil Ditambah");
            System.out.println();
        }
    }

    public static void updateStaff(){
        boolean idAda = false;
        System.out.println("1. Update Gaji Staff");
        System.out.println("2. Update Posisi Staff");
        System.out.println("3. Update Role Staff");
        System.out.println("4. Pecat Staff");
        System.out.println("============================");
        System.out.println("Opsi :");
        String opsi = sc.nextLine();
    
        if(opsi.equals("1") || opsi.equals("2") || opsi.equals("3") ||opsi.equals("4") ){
            showStaff();
            System.out.print("Masukkan ID Staff   : ");
            String idStaff = sc.nextLine();
            for (int i = 0; i < staff.size(); i++){
                if (staff.get(i).getIdStaff().equals(idStaff)){
                    idAda = true;
                    try{
                        //Handling gajiBaru
                        if (opsi.equals("1")){
                            System.out.println("Gaji Baru : ");
                            int gajiBaru = Integer.parseInt(sc.nextLine());
                            staff.get(i).setGaji(gajiBaru);
                        }
                        else if (opsi.equals("2")){
                            System.out.println("Posisi Baru : ");
                            String posisiBaru = sc.nextLine();
                            staff.get(i).setPosisi(posisiBaru);
                        }   
                        else if (opsi.equals("3")){
                            System.out.println("Role Baru : ");
                            String roleBaru = sc.nextLine();
                            staff.get(i).getUserLogin().getHakAkses().setRole(roleBaru);
                        }
                        else if (opsi.equals("4")){
                            String ket = String.format("%s %-20s Dipecat", idStaff,staff.get(i).getNamaStaff());
                            staff.remove(i);
                            System.out.println(ket);
                        }
                        System.out.println("<<System>> Staff Berhasil Diupdate");
                    }catch (NumberFormatException e) {
                        System.out.println("<<System>> Input Harus Dalam Bentuk Angka");
                        System.out.println("<<System>> Staff Tidak Berhasil Diupdate");
                        System.out.println();
                    }
                }
            }
        }
        
        if(!idAda){
            System.out.println("<<System>> ID Staff Invalid");
        }
    }

    public static void daftarMembership(){ //tambah pembeli
        System.out.print("Nama     : ");
        String nama = sc.nextLine();
        System.out.print("No. Telp : ");
        String noTelp = sc.nextLine();
        Pembeli pembeliBaru = new Pembeli(nama, noTelp);
        pembeli.add(pembeliBaru);
        System.out.println("<<System>> Nomor Telp Berhasil Didaftar");
        System.out.println();
    }

    public static void cekPoinPembeli(){
        System.out.print("No. Telp : ");
        String noTelp = sc.nextLine();
        boolean noTelpAda = false;
        for (int i = 0; i < pembeli.size(); i++){
            if (pembeli.get(i).getNoTelpPembeli().equals(noTelp)){
                System.out.println();
                System.out.println("Nama : " + pembeli.get(i).getNamaPembeli());
                System.out.println("Poin : " + pembeli.get(i).getMembership().getPoin());
                noTelpAda = true;
            }
        }

        if(!noTelpAda){
            System.out.println("<<System>> No Telp Invalid");
        }
    }

    public static void showBarang(){
        System.out.println();
        System.out.println("No. Kode Nama                 Jumlah Harga");
        System.out.println("==================================================");
        int idx = 1;
        for (Barang x : barang) {
            System.out.println(String.format("%2d. %s", idx++, x));
        }
        System.out.println();
    }

    public static void showStaff(){
        System.out.println();
        System.out.println("No.  ID  Nama                 Posisi     Gaji                     Username   Password   Role");
        System.out.println("==================================================================================================");
        int idx = 1;
        for (Staff x : staff) {
            System.out.println(String.format("%2d. %s", idx++, x));
        }
        System.out.println();
    }

    public static void showPembeli(){
        System.out.println();
        System.out.println("No. Nama                 No.Telp      Poin");
        System.out.println("===================================================");
        int idx = 1;
        for (Pembeli x : pembeli) {
            System.out.println(String.format("%2d. %s", idx++, x));
        }
        System.out.println();
    }

    public static void showHistoryTransaksi(){
        int idx = 1;
        boolean historyAda = false;
        for (Transaksi x : historyTransaksi) {
            System.out.println();
            System.out.println("Transaksi " + idx++);
            System.out.println("==========================================================");
            System.out.println(x);
            historyAda = true;
        }
        if (!historyAda) {
            System.out.println("<<System>> History Masih Kosong");
        }
    }

    public static void showHistoryBarang(){
        int idx = 1;
        boolean historyAda = false;
        System.out.println();
        System.out.println("No. Tanggal              Operasi ID   Nama                 Keterangan");
        System.out.println("==============================================================================");
        for (HistoryBarang x : historyBarang) {
            System.out.println(String.format("%2d. %s", idx++, x));
            historyAda = true;
        }
        if (!historyAda) {
            System.out.println("<<System>> History Masih Kosong");
        }
    }

    public static void transaksi(){
        boolean noTelpAda = false;
        System.out.print("Ada Membership (Ya/Tidak) : ");
        String adaMember = sc.nextLine();
        if (adaMember.equalsIgnoreCase("ya")){
            System.out.println("=================================================");
            System.out.print("No. Telp : ");
            String noTelp = sc.nextLine();
            System.out.println();
            for (int i = 0; i < pembeli.size(); i++){
                if(pembeli.get(i).getNoTelpPembeli().equals(noTelp)){
                    pembeliYangBeli = pembeli.get(i);
                    noTelpAda = true;
                    System.out.println("<<System>> Hai, " + pembeliYangBeli.getNamaPembeli());
                    menuTransaksi();
                }
            }
        }
        else{
            pembeliYangBeli = null;
            System.out.println();
            noTelpAda = true; //Biar tidak muncul nomor telepon tidak terdafar
            menuTransaksi();
        }
        if (!noTelpAda){
            System.out.println("<<System>> Nomor Telepon tidak Terdaftar");
        }
    }
    
    public static boolean barangAda(String kodeBarang){
        for(int i = 0; i < barang.size(); i++){
            if(barang.get(i).getKodeBarang().equals(kodeBarang)) return true;
        }
        return false;
    }

    public static String namaBarang(String kodeBarang){
        for(int i = 0; i < barang.size(); i++){
            if(barang.get(i).getKodeBarang().equals(kodeBarang)) return barang.get(i).getNamaBarang();
        }
        return "";
    }

    public static int hargaBarang(String kodeBarang){
        for(int i = 0; i < barang.size(); i++){
            if(barang.get(i).getKodeBarang().equals(kodeBarang)) return barang.get(i).getHargaBarang();
        }
        return 0;
    }

    public static void kurangJumlahBarang(String kodeBarang, int jumlah){
        for(int i = 0; i < barang.size(); i++){
            if(barang.get(i).getKodeBarang().equals(kodeBarang)){
                barang.get(i).setJumlahBarang(barang.get(i).getJumlahBarang()-jumlah);
            }
        }
    }

    public static void tambahJumlahBarang(String kodeBarang, int jumlah){
        for(int i = 0; i < barang.size(); i++){
            if(barang.get(i).getKodeBarang().equalsIgnoreCase(kodeBarang)){
                barang.get(i).setJumlahBarang(barang.get(i).getJumlahBarang()+jumlah);
            }
        }
    }

    public static boolean jumlahBarangLebihBanyakDari(String kodeBarang, int jumlah){
        for(int i = 0; i < barang.size(); i++){
            if(barang.get(i).getKodeBarang().equals(kodeBarang)){
                if(barang.get(i).getJumlahBarang() >= jumlah) return true;
            }
        }
        return false;
    }

    public static boolean barangSudahPernahDiScan(String kodeBarang, Transaksi transaksi){
        for(int i = 0; i<transaksi.getKetTransaksi().size(); i++){
            if(transaksi.getKetTransaksi().get(i).getKodeBarang().equals(kodeBarang)){
                return true;
            }
        }
        return false;
    }

    public static int indexBarangSudahPernahDiScan(String kodeBarang, Transaksi transaksi){
        int index = -1;
        for(int i = 0; i<transaksi.getKetTransaksi().size(); i++){
            if(transaksi.getKetTransaksi().get(i).getKodeBarang().equals(kodeBarang)){
                index = i;
            }
        }
        return index;
    }

    public static boolean barangAdaDiKet(String namaBarang, Transaksi transaksi){
        for(int i = 0; i<transaksi.getKetTransaksi().size(); i++){
            if(transaksi.getKetTransaksi().get(i).getNamaBarang().equalsIgnoreCase(namaBarang)){
                return true;
            }
        }
        return false;
    }

    public static void menuTransaksi(){
        boolean masihProsesTransaksi = true;
        String noTelp = "";
        if (pembeliYangBeli != null){
            noTelp = pembeliYangBeli.getNoTelpPembeli();
        }
        Transaksi transaksiBaru = new Transaksi(staffYangLogin.getNamaStaff(),noTelp);
        double diskon = 0;
        do{
            System.out.println();
            System.out.println("Menu Transaksi");
            System.out.println("==========================================");
            System.out.println("1. Scan Barang");
            System.out.println("2. List Barang yang Ada di Transaksi");
            System.out.println("3. Hapus Barang di Transaski");
            System.out.println("4. Tukar Poin");
            System.out.println("5. Transaksi Selesai");
            System.out.println("6. Transaksi Batal");
            System.out.println("==========================================");
            System.out.print("Pilihan : ");
            String pilihan = sc.nextLine();
            System.out.println();
            String jb = "X";
            switch(pilihan){
                case "1":
                        //Exception Handling
                        do{
                            showBarang();
                            try{
                                System.out.print("Kode Barang   : ");
                                String kode = sc.nextLine();
                                //Handling jumlah
                                System.out.print("Jumlah Barang : ");
                                int jumlah = Integer.parseInt(sc.nextLine());
                                System.out.println();
                                if (barangAda(kode)){
                                    if(jumlahBarangLebihBanyakDari(kode, jumlah)){
                                        //cek jika barang sudah pernah discan
                                        if(barangSudahPernahDiScan(kode,transaksiBaru)){
                                            int i = indexBarangSudahPernahDiScan(kode, transaksiBaru);
                                            int jumlahBaru = transaksiBaru.getKetTransaksi().get(i).getJumlahBarang() + jumlah;
                                            transaksiBaru.getKetTransaksi().get(i).setJumlahBarang(jumlahBaru);
                                            transaksiBaru.getKetTransaksi().get(i).setTotalHarga(jumlahBaru * transaksiBaru.getKetTransaksi().get(i).getHargaBarang());
                                        }
                                        else{
                                            KetTransaksi ketTransaksi = new KetTransaksi(kode,namaBarang(kode), jumlah, hargaBarang(kode),jumlah * hargaBarang(kode));
                                            transaksiBaru.getKetTransaksi().add(ketTransaksi);
                                        }
                                        kurangJumlahBarang(kode, jumlah);
                                    }
                                    else{
                                        System.out.println("<<System>> Jumlah yang Dimasukkan Lebih Banyak dari yang Ada");
                                    }
                                    
                                }
                                else{
                                    System.out.println("<<System>> Kode Barang Invalid");
                                }
                            }catch (NumberFormatException e) {
                            System.out.println("<<System>> Input Harus Dalam Bentuk Angka");
                            System.out.println("<<System>> Gagal Memasukkan Barang yang DiScan");
                            System.out.println();
                            }
                            System.out.println("==========================================");
                            System.out.println("<< Tekan Enter untuk Lanjut Scan>>");
                            System.out.println("<< Ketik X untuk Berhenti Scan>>");
                            jb = sc.nextLine();
                        }while(!jb.equalsIgnoreCase("X"));
                        
                    break;
                case "2":
                    if(transaksiBaru.getKetTransaksi().size() != 0){
                        System.out.println();

                        for (KetTransaksi x : transaksiBaru.getKetTransaksi()) {
                            System.out.println(x);
                        }
                        System.out.println();
                    }
                    else{
                        System.out.println("<<System>> Transaksi Masih Kosong");
                    }
                    break;
                case "3":
                    System.out.println("==========================================");
                    if(transaksiBaru.getKetTransaksi() != null){
                        for (KetTransaksi x : transaksiBaru.getKetTransaksi()) {
                            System.out.println(x);
                        }
                        System.out.println("==========================================");
                        System.out.print("Nama Barang yang Ingin Dihapus : ");
                        String namaBarang = sc.nextLine();
                        if(barangAdaDiKet(namaBarang, transaksiBaru)){
                            for (int i = 0; i < transaksiBaru.getKetTransaksi().size(); i++){
                                if (transaksiBaru.getKetTransaksi().get(i).getNamaBarang().equalsIgnoreCase(namaBarang)){
                                    int jumlahBarangYangDihapus = transaksiBaru.getKetTransaksi().get(i).getJumlahBarang();
                                    transaksiBaru.getKetTransaksi().remove(i);
                                    tambahJumlahBarang(namaBarang, jumlahBarangYangDihapus);
                                    System.out.println("<<System>> Barang Berhasil Dihapus");
                                }
                            }
                        }
                        else
                            System.out.println("<<System>> Barang tidak Terdapat pada Transaksi");
                    }
                    else{
                        System.out.println("<<System>> Transaksi Masih Kosong");
                    }
                    break;
                case "4":
                    if(pembeliYangBeli != null){
                        //Exception Handling
                        try{
                            System.out.println("100 Poin -> diskon 5%");
                            System.out.println("200 Poin -> diskon 10%");
                            System.out.println("300 Poin -> diskon 15%");
                            System.out.println("Poin yang ditukar hanya bisa kelipatan 100");
                            System.out.println("=================================================");
                            System.out.print("Poin yang Ingin Ditukar : ");
                            //Untuk handling banyakPoinYangInginDitukar
                            banyakPoinYangInginDitukar = Integer.parseInt(sc.nextLine());
                            double banyakPoinPembeli =  pembeliYangBeli.getMembership().getPoin();
                            System.out.println();
                            if (banyakPoinYangInginDitukar == 100 && banyakPoinPembeli >= 100){
                                diskon = 0.05;
                                pembeliYangBeli.getMembership().setPoin(banyakPoinPembeli-banyakPoinYangInginDitukar);
                                System.out.println("<<System>> 100 Poin Berhasil Ditukar");
                                System.out.println("<<System>> Diskon 5% Untuk Transaksi Ini");
                            }
                            else if (banyakPoinYangInginDitukar == 200 && banyakPoinPembeli >= 200){
                                diskon = 0.1;
                                pembeliYangBeli.getMembership().setPoin(banyakPoinPembeli-banyakPoinYangInginDitukar);
                                System.out.println("<<System>> 200 Poin Berhasil Ditukar");
                                System.out.println("<<System>> Diskon 10% Untuk Transaksi Ini");
                            }
                            else if (banyakPoinYangInginDitukar == 300 && banyakPoinPembeli >= 300){
                                diskon = 0.15;
                                pembeliYangBeli.getMembership().setPoin(banyakPoinPembeli-banyakPoinYangInginDitukar);
                                System.out.println("<<System>> 300 Poin Berhasil Ditukar");
                                System.out.println("<<System>> Diskon 15% Untuk Transaksi Ini");
                            } 

                            if(banyakPoinPembeli < banyakPoinYangInginDitukar){
                                System.out.println("<<System>> Poin tidak cukup");
                            }
                            if (banyakPoinYangInginDitukar > 300){
                                System.out.println("<<System>> Poin yang Ditukar Maksimal 300 Poin");
                            }
                            if(banyakPoinYangInginDitukar % 100 != 0){
                                System.out.println("<<System>> Poin yang ditukar hanya bisa kelipatan 100");
                            }
                        }catch (NumberFormatException e) {
                            System.out.println("<<System>> Input Harus Dalam Bentuk Angka");
                            System.out.println();
                        }
                    }
                    else{
                        System.out.println("<<System>> Pembeli tidak mempunyai membership");
                    }
                    break;
                case "5":
                    double totalHarga = 0;
                    for (int i = 0; i < transaksiBaru.getKetTransaksi().size(); i++){
                        totalHarga += transaksiBaru.getKetTransaksi().get(i).getHargaBarang();
                    }
                    transaksiBaru.setTotalHargaTransaksi(totalHarga);
                    if(transaksiBaru.getTotalHargaTransaksi() != 0){
                        transaksiBaru.setBanyakDiskon(transaksiBaru.getTotalHargaTransaksi() * diskon);
                        transaksiBaru.setTotalBelanja(transaksiBaru.getTotalHargaTransaksi()-transaksiBaru.getBanyakDiskon());

                        if(diskon != 0){
                            pembeliYangBeli.getMembership().setPoin(pembeliYangBeli.getMembership().getPoin() + transaksiBaru.getTotalBelanja()/10000);
                        }
                        System.out.println(transaksiBaru);
                        historyTransaksi.add(transaksiBaru);
                    }
                    else{
                        System.out.println("<<System>> Transaksi Batal");
                    }
                    diskon = 0;
                    masihProsesTransaksi = false;
                    break;
                case "6":
                    if(pembeliYangBeli != null){
                        pembeliYangBeli.getMembership().setPoin(pembeliYangBeli.getMembership().getPoin()+banyakPoinYangInginDitukar);
                        diskon = 0;
                        transaksiBaru.setBanyakDiskon(0);
                        transaksiBaru.setTotalHargaTransaksi(0);
                        transaksiBaru.setTotalBelanja(0);
                    }
                    else{
                        transaksiBaru.setTotalHargaTransaksi(0);
                    }
                    transaksiBaru = null;
                    System.out.println("<<System>> Transaksi Batal");
                    masihProsesTransaksi = false;
                    break;
                default:
                    System.out.println("<<System>> Harap Memilih Opsi yang Tersedia");
                    break;
            } 
        }while(masihProsesTransaksi);
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
                    //Tambah Staff, set UserLogin, set HakAkses
                    if (!baris.equals("ID;NAMA;POSISI;GAJI;USERNAME;PASSWORD;ROLE")) {
                        if (nilai[6].equalsIgnoreCase("Kasir")){
                            Staff staffBaru = new Kasir(nilai[0], nilai[1],nilai[2], Integer.parseInt(nilai[3]));
                            staffBaru.getUserLogin().setUsername(nilai[4]);
                            staffBaru.getUserLogin().setPassword(nilai[5]);
                            staffBaru.getUserLogin().getHakAkses().setRole(nilai[6]);
                            staff.add(staffBaru);
                        }
                        else if (nilai[6].equalsIgnoreCase("Admin")){
                            Staff staffBaru = new Admin(nilai[0], nilai[1],nilai[2], Integer.parseInt(nilai[3]));
                            staffBaru.getUserLogin().setUsername(nilai[4]);
                            staffBaru.getUserLogin().setPassword(nilai[5]);
                            staffBaru.getUserLogin().getHakAkses().setRole(nilai[6]);
                            staff.add(staffBaru);
                        }
                        else if (nilai[6].equalsIgnoreCase("Supervisor")){
                            Staff staffBaru = new Supervisor(nilai[0], nilai[1],nilai[2], Integer.parseInt(nilai[3]));
                            staffBaru.getUserLogin().setUsername(nilai[4]);
                            staffBaru.getUserLogin().setPassword(nilai[5]);
                            staffBaru.getUserLogin().getHakAkses().setRole(nilai[6]);
                            staff.add(staffBaru);
                        }
                        else{
                            Staff staffBaru = new StaffBiasa(nilai[0], nilai[1],nilai[2], Integer.parseInt(nilai[3]));
                            staff.add(staffBaru);
                        }
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
                        //Tambah Barang
                        Barang barangBaru = new Barang(nilai[0], nilai[1], Integer.parseInt(nilai[2]), Integer.parseInt(nilai[3]));
                        barang.add(barangBaru);
                        //Tammbah HistoryBarang
                        HistoryBarang historyBaru = new HistoryBarang("Add", "S001", "Stephanie", nilai[0]);
                        historyBarang.add(historyBaru);
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
                        //Tambah Pembeli, Set Membership
                        Pembeli pembeliBaru = new Pembeli(nilai[1], nilai[0]);
                        pembeliBaru.getMembership().setPoin(Double.parseDouble(nilai[2]));
                        pembeli.add(pembeliBaru);
                    }
                }
                scanFile.close();
            }
        }catch (Exception e){ //Exception Handling
            System.out.println("Error : " + e.getMessage());
        }

        //Tambah Transaksi, set ketTransaksi
        Transaksi transaksiSatu = new Transaksi("Stephanie", "");
        KetTransaksi ketTransaksiSatu = new KetTransaksi("A001",namaBarang("A001"), 1, hargaBarang("A001"),1 * hargaBarang("A001"));
        transaksiSatu.getKetTransaksi().add(ketTransaksiSatu);
        transaksiSatu.setTotalHargaTransaksi(1 * hargaBarang("A001"));
        historyTransaksi.add(transaksiSatu);

        Transaksi transaksiDua = new Transaksi("Stephanie", "");
        KetTransaksi ketTransaksiDua = new KetTransaksi("A003",namaBarang("A003"), 1, hargaBarang("A003"),1 * hargaBarang("A003"));
        transaksiDua.getKetTransaksi().add(ketTransaksiDua);
        transaksiDua.setTotalHargaTransaksi(1 * hargaBarang("A003"));
        historyTransaksi.add(transaksiDua);

        Transaksi transaksiTiga = new Transaksi("Stephanie", "");
        KetTransaksi ketTransaksiTiga = new KetTransaksi("A002",namaBarang("A002"), 1, hargaBarang("A002"),1 * hargaBarang("A002"));
        transaksiTiga.getKetTransaksi().add(ketTransaksiTiga);
        transaksiTiga.setTotalHargaTransaksi(1 * hargaBarang("A002"));
        historyTransaksi.add(transaksiTiga);
}}
