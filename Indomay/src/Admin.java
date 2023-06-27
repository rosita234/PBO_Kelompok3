public class Admin extends Staff { //subclass staff
    public Admin(String id, String nama, String posisi, int gaji) {
        super(id, nama, posisi, gaji);
    }

    @Override
    public void menu() {
        System.out.println();
        System.out.println("Menu");
        System.out.println("=================================================");
        System.out.println("1.  Tambah Barang");
        System.out.println("2.  Hapus Barang");
        System.out.println("3.  Edit Barang");
        System.out.println("4.  List Barang");
        System.out.println("5.  List Staff");
        System.out.println("6.  List Pembeli");
        System.out.println("7.  History Transaksi");
        System.out.println("8.  History Barang");
        System.out.println("9.  LOGOUT");
        System.out.println("=================================================");
    }
}
