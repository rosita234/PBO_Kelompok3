import java.util.Scanner;

public class App {

    static Barang barang[] = new Barang[3];
    static Staff staff[] = new Staff[3];
    static History history[] = new History[3];
    static Pembeli pembeli[] = new Pembeli[3];
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception{
        init();
        boolean choice = true;
        
        do{
            showMenu();
            System.out.print("Masukkan pilihan : ");
            String pilihan = sc.nextLine();
            System.out.println();
            
            switch(pilihan){
                case "1":
                    inputBarang();
                    break;
                case "2":
                    showBarang();
                    break;
                case "3":
                    inputStaffDanPosisi();
                    break;
                case "4":
                    showStaffDanPosisi();
                    break;
                case "5":
                    inputPembeli();
                    break;
                case "6":
                    showPembeliDanPoin();
                    break;
                case "7":
                    inputHistory();
                    break;
                case "8":
                    showHistory();
                    break;
                case "9":
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
        System.out.println("1. Input Barang");
        System.out.println("2. Show Barang");
        System.out.println("3. Input Staff & Posisinya");
        System.out.println("4. Show Staff & Posisinya");
        System.out.println("5. Input Pembeli");
        System.out.println("6. Show Pembeli & Poin yang Dimiliki");
        System.out.println("7. Input history transaksi");
        System.out.println("8. Show history transaksi");
        System.out.println("9. Exit");
        System.out.println("==========================================");
    }

    public static void inputBarang(){
        System.out.println("==========================================");
        System.out.print("Kode Barang   : ");
        String kodeStok = sc.nextLine();
        System.out.print("Nama Barang   : ");
        String namaStok = sc.nextLine();
        System.out.print("Jumlah Barang : ");
        int jumlahStok = sc.nextInt();
        System.out.print("Harga Barang  : ");
        int hargaStok = sc.nextInt();
        System.out.println("==========================================");
        System.out.println();

        Barang newBarang = new Barang(kodeStok, namaStok, jumlahStok, hargaStok);

        for (int i = 0; i < barang.length; i++) {
            if (barang[i] == null) {
                barang[i] = newBarang;
                break;
            }
            else{
                int sizeBaru = barang.length * 2;
                Barang[] tempatBaru = new Barang[sizeBaru];
                for (int j = 0; j < barang.length; j++) {
                    tempatBaru[j] = barang[j];
                }
                barang = tempatBaru;
            }
        }
        sc.nextLine();
    }

    public static void showBarang(){
        System.out.println("Kode Nama Barang          Qty  Harga");
        System.out.println("==========================================");
        for(int i = 0; i < barang.length; i++){
            if(barang[i] != null){
                System.out.println(barang[i]);
            }
        }
    }

    public static void inputStaffDanPosisi(){
        System.out.println("==========================================");
        System.out.print("Nama Staff           : ");
        String namaStaff = sc.nextLine();
        System.out.print("Password             : ");
        String password = sc.nextLine();

        System.out.print("Status (Kasir/Admin) : ");
        String status = sc.nextLine();
        System.out.print("Employment           : ");
        String employment = sc.nextLine();
        System.out.print("Masa Kontrak         : ");
        String kontrak = sc.nextLine();
        System.out.println("==========================================");
        System.out.println();

        Posisi posisiBaru = new Posisi(status,employment,kontrak);
        Staff staffBaru = new Staff(namaStaff, password,posisiBaru);

        for (int i = 0; i < staff.length; i++) {
            if (staff[i] == null) {
                staff[i] = staffBaru;
                break;
            }
            else{
                int sizeBaru = staff.length * 2;

                Staff[] tempatBaru = new Staff[sizeBaru];

                for (int j = 0; j < staff.length; j++) {
                    tempatBaru[j] = staff[j];
                }
                staff = tempatBaru;
            }
        }
    }

    public static void showStaffDanPosisi(){
        System.out.println("Nama                 Password   Status     Employment           Kontrak");
        System.out.println("================================================================================");
        for(int i = 0; i < staff.length; i++){
            if(staff[i] != null){
                System.out.println(staff[i]);
            }
        }
    }

    public static void inputPembeli(){
        System.out.println("==========================================");
        System.out.print("Nama Pembeli : ");
        String nama = sc.nextLine();
        System.out.print("No Telp      : ");
        String telp = sc.nextLine();
        System.out.println("==========================================");
        System.out.println();

        Pembeli pembeliBaru = new Pembeli(nama, telp);

        for (int i = 0; i < pembeli.length; i++) {
            if (pembeli[i] == null) {
                pembeli[i] = pembeliBaru;
                break;
            }
            else{
                int sizeBaru = pembeli.length * 2;
                Pembeli[] tempatBaru = new Pembeli[sizeBaru];
                for (int j = 0; j < pembeli.length; j++) {
                    tempatBaru[j] = pembeli[j];
                }
                pembeli = tempatBaru;
            }
        }
    }

    public static void showPembeliDanPoin(){
        System.out.println("Nama                 No. Telp     Poin");
        System.out.println("=========================================");

        for(int i = 0; i < pembeli.length; i++){
            if(pembeli[i] != null){
                System.out.println(pembeli[i]);
            }
        }
    }

    public static void inputHistory(){
        System.out.println("==========================================");
        System.out.print("Tanggal         : ");
        String tanggal = sc.nextLine();
        System.out.print("Keterangan      : ");
        String ketrerangan = sc.nextLine();
        System.out.print("Jenis Transaksi : ");
        String jenis = sc.nextLine();
        System.out.println("==========================================");
        System.out.println();

        History newHistory = new History(tanggal, ketrerangan, jenis);

        for (int i = 0; i < history.length; i++) {
            if (history[i] == null) {
                history[i] = newHistory;
                break;
            }
            else{
                int sizeBaru = barang.length * 2;
                History[] tempatBaru = new History[sizeBaru];
                for (int j = 0; j < history.length; j++) {
                    tempatBaru[j] = history[j];
                }
                history = tempatBaru;
            }
        }

    }

    public static void showHistory(){
        System.out.println("Tanggal         Operasi    Keterangan");
        System.out.println("==========================================");
        for(int i = 0; i < history.length; i++){
            if(history[i] != null){
                System.out.println(history[i]);
            }
        }
    }

    public static void init() {
        barang[0] = new Barang("S01", "Sabun Mandi", 10, 20000);
        barang[1] = new Barang("S02", "Pasta Gigi", 12, 15000);
        barang[2] = new Barang("S03","Shampoo",10,50000);

        Posisi posisi1 = new Posisi("Kasir", "Magang", "1 tahun");
        Posisi posisi2 = new Posisi("Admin", "Karyawan Tetap", null);
        Posisi posisi3  = new Posisi("Staff Toko", "Magang", "1.5 tahun");

        Membership membership1 = new Membership(100);        
        Membership membership2 = new Membership(200);
        Membership membership3 = new Membership(300); 

        pembeli[0] = new Pembeli("albert", "08167859078");
        pembeli[0].setMembership(membership1);
        pembeli[1] = new Pembeli("mark", "081287645797");
        pembeli[1].setMembership(membership2);
        pembeli[2] = new Pembeli("john", "08135896470");
        pembeli[2].setMembership(membership3);

        staff[0] = new Staff("Alfredo","pertemuan4",posisi1);
        staff[1] = new Staff("Louin","akulouin",posisi2);
        staff[2] = new Staff("Edbert", "akuEdbert",posisi3);
    }
}