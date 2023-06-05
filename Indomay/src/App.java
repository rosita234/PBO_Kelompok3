import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception{
        init();

        Stok sabun = new Stok("S01", "Sabun Mandi", 10, 20000);
        System.out.println(sabun);
        boolean choice = true;
        Scanner sc = new Scanner(System.in);

        do{
            showMenu();
            System.out.println("Masukkan pilihan :");
            String pilihan = sc.nextLine();
            
            switch(pilihan){
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                    choice = false;
                default:
                    break;
            }

            sc.close();
        }while(choice);
    }

    public static void showMenu(){
        System.out.println("1. Scan barang");
        System.out.println("2. Cek Stok");
        System.out.println("3. Cek Data Pembeli");
        System.out.println("4. History Transaksi");
        System.out.println("5. Exit");
    }

    public static void init() {
        Stok sabun = new Stok("S01", "Sabun Mandi", 10, 20000);
        Stok odol = new Stok("S02", "Pasta Gigi", 12, 15000);
        Stok shampoo = new Stok("S03","Shampoo",10,50000);

        Membership poin1 = new Membership(100, 0.1);        
        Membership poin2 = new Membership(200, 0.2);
        Membership poin3 = new Membership(300, 0.3); 

        Posisi mickey = new Posisi("Kasir", "Magang", "1 tahun");
        Posisi jackie = new Posisi("Admin", "Karyawan Tetap", null);
        Posisi willie = new Posisi("Staff Toko", "Magang", "1.5 tahun");

        Pembeli satu = new Pembeli("albert", "08167859078", "ya");
        Pembeli dua = new Pembeli("mark", "081287645797", "ya");
        Pembeli tiga = new Pembeli("john", "08135896470", "tidak");
        
        History transaksi1 = new History("6 Juni 2023", null , "Scan Barang");
        History transaksi2 = new History("5 Juni 2023", null, "Cek Stok");
        History transaksi3 = new History("4 Juni 2023", "Pembuatan membership baru", "Cek data pembeli");

        Staff user1 = new Staff("Alfredo","pertemuan4");
    }



}

