import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception{
        
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
}