public class ListHistoryBarang {
    private HistoryBarangNode head;
    private HistoryBarangNode tail;
    private int count;

    public ListHistoryBarang(){
        this.head = this.tail = null;
        count = 0;
    }

    public int getCount() {
        return count;
    }

    public HistoryBarangNode getHead() {
        return head;
    }

    public HistoryBarangNode getTail() {
        return tail;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setHead(HistoryBarangNode head) {
        this.head = head;
    }

    public void setTail(HistoryBarangNode tail) {
        this.tail = tail;
    }

    public boolean isEmpty(){return count == 0;}

    public void add(String operasi, String ID, String namaStaff, String keterangan){
        HistoryBarang history = new HistoryBarang(operasi, ID, namaStaff, keterangan);
        HistoryBarangNode newNode = new HistoryBarangNode(history);

        if(isEmpty()){
            head = tail = newNode;
        }
        else{
            tail.setNext(newNode);
            tail = newNode;
        }
        count++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!isEmpty()) {
            System.out.println("No. Tanggal              Operasi ID   Nama                 Keterangan");
            int idx = 1;
            HistoryBarangNode p = head;
            while (p != null) {
                sb.append(String.format("%-3d. %s\n", idx++, p.getItem()));
                p = p.getNext();
            }
        }
        return sb.toString();
    }
    
}
