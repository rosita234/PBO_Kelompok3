public class ListTransaksi {
    private TransaksiNode head;
    private TransaksiNode tail;
    private int count;

    public ListTransaksi(){
        this.head = this.tail = null;
        count = 0;
    }

    public int getCount() {
        return count;
    }

    public TransaksiNode getHead() {
        return head;
    }

    public TransaksiNode getTail() {
        return tail;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setHead(TransaksiNode head) {
        this.head = head;
    }

    public void setTail(TransaksiNode tail) {
        this.tail = tail;
    }

    public boolean isEmpty(){return count == 0;}

    public void add(Transaksi transaksi){
        TransaksiNode newNode = new TransaksiNode(transaksi);
        
        if(isEmpty()){
            head = tail = newNode;
        }
        else{
            tail.setNext(newNode);
            tail = newNode;
        }
        count++;
    }

    public void add(String namaStaff, String namaPembeli){
        Transaksi transaksi = new Transaksi(namaStaff, namaPembeli);
        TransaksiNode newNode = new TransaksiNode(transaksi);
        
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
            System.out.println("History");
            System.out.println("=================================================");
            TransaksiNode p = head;
            int idx = 0;
            while (p != null) {
                System.out.println("Transaksi " + idx++);
                sb.append(String.format("%s", p.getItem()));
                p = p.getNext();
            }
            System.out.println("=================================================");
        }
        return sb.toString();
    }
}
