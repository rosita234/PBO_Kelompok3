public class Kasir extends Staff { //subclass Staff
    public Kasir(String id, String nama, String posisi, int gaji) {
        super(id, nama, posisi, gaji);
    }

    @Override
    public void menu() {
        System.out.println();
        System.out.println("Menu");
        System.out.println("=================================================");
        System.out.println("1.  Transaksi");
        System.out.println("2.  List Barang");
        System.out.println("3.  Daftar Membership");
        System.out.println("4.  Poin Pembeli");
        System.out.println("5.  List Pembeli");
        System.out.println("6.  History Transaksi");
        System.out.println("7.  LOGOUT");
        System.out.println("=================================================");
    }
    
}
