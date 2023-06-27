public class StaffBiasa extends Staff{ //subclass Staff
    public StaffBiasa(String id, String nama, String posisi, int gaji) {
        super(id, nama, posisi, gaji);
    }

    @Override
    public void menu() {
        throw new UnsupportedOperationException("Unimplemented method 'menu'");
    }
}
