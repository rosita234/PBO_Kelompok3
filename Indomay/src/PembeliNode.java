public class PembeliNode {
    private Pembeli item;
    private PembeliNode next;

    public PembeliNode(Pembeli item){
        this.item = item;
        next = null;
    }

    public Pembeli getItem() {
        return item;
    }

    public PembeliNode getNext() {
        return next;
    }

    public void setItem(Pembeli item) {
        this.item = item;
    }

    public void setNext(PembeliNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return this.item.toString();
    }
}
