public class StaffNode {
    private Staff item;
    private StaffNode next;

    public StaffNode(Staff item){
        this.item = item;
        this.next = null;
    }

    public Staff getItem() {
        return item;
    }

    public StaffNode getNext() {
        return next;
    }

    public void setItem(Staff item) {
        this.item = item;
    }

    public void setNext(StaffNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return this.item.toString();
    }
}
