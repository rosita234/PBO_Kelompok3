//function saja, tidak perlu ada Override


public class AksesMenu {
    private HakAkses hakAkses;
    private String idMenu;

    public AksesMenu(){

    }

    public AksesMenu(HakAkses hakAkses){
        this.hakAkses = hakAkses;
    }

    public HakAkses getHakAkses() {
        return hakAkses;
    }

    public void setHakAkses(HakAkses hakAkses) {
        this.hakAkses = hakAkses;
    }

    public String getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(String idMenu) {
        this.idMenu = idMenu;
    }

    public void menuAkses(HakAkses hakAkses){
        if(hakAkses.getRole().equals("Staff")){
            System.out.println("=================================================");
            idMenu = "Menu Staff";
            System.out.println(idMenu);
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

        if(hakAkses.getRole().equals("Admin")){
            System.out.println("=================================================");
            idMenu = "Menu Admin";
            System.out.println(idMenu);
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
        if(hakAkses.getRole().equals("Supervisor")){
            System.out.println("=================================================");
            idMenu = "Menu Supervisor";
            System.out.println(idMenu);
            System.out.println("=================================================");
            System.out.println("1.  Tambah Barang");
            System.out.println("2.  Hapus Barang");
            System.out.println("3.  Edit Barang");
            System.out.println("4.  List Barang");
            System.out.println("5.  List Staff");
            System.out.println("6.  Tambah Staff");
            System.out.println("7.  Update Staff");
            System.out.println("8.  List Pembeli");
            System.out.println("9.  History Transaksi");
            System.out.println("10. History Barang");
            System.out.println("11. LOGOUT");
            System.out.println("=================================================");
        }
    }
}
