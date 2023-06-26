public class TransaksiNode {
    private Transaksi item;
    private TransaksiNode next;

    public TransaksiNode(Transaksi item){
        this.item = item;
        next = null;
    }

    public Transaksi getItem() {
        return item;
    }

    public TransaksiNode getNext() {
        return next;
    }

    public void setItem(Transaksi item) {
        this.item = item;
    }

    public void setNext(TransaksiNode next) {
        this.next = next;
    }
    

    @Override
    public String toString() {
        return this.item.toString();
    }
}
