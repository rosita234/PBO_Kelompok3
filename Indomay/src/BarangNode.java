public class BarangNode {
    private Barang item;
    private BarangNode next;

    public BarangNode(Barang item){
        this.item = item;
        next = null;
    }

    public Barang getItem() {
        return item;
    }

    public BarangNode getNext() {
        return next;
    }

    public void setItem(Barang item) {
        this.item = item;
    }

    public void setNext(BarangNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return this.item.toString();
    }
}
