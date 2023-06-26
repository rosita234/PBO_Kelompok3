public class HistoryBarangNode {
    private HistoryBarang item;
    private HistoryBarangNode next;

    public HistoryBarangNode(HistoryBarang item){
        this.item = item;
        next = null;
    }

    public HistoryBarang getItem() {
        return item;
    }

    public HistoryBarangNode getNext() {
        return next;
    }

    public void setItem(HistoryBarang item) {
        this.item = item;
    }

    public void setNext(HistoryBarangNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return this.item.toString();
    }
}
