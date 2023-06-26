public class KetTransaksiNode {
    private KetTransaksi item;
    private KetTransaksiNode next;

    public KetTransaksiNode(KetTransaksi item){
        this.item = item;
        next = null;
    }

    public KetTransaksi getItem() {
        return item;
    }

    public KetTransaksiNode getNext() {
        return next;
    }

    public void setItem(KetTransaksi item) {
        this.item = item;
    }

    public void setNext(KetTransaksiNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return this.item.toString();
    }
}
