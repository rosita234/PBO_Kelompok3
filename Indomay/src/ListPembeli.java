public class ListPembeli {
    
    private PembeliNode head;
    private PembeliNode tail;
    private int count;

    public ListPembeli(){
        this.head = this.tail = null;
        count = 0;
    }

    public int getCount() {
        return count;
    }

    public PembeliNode getHead() {
        return head;
    }

    public PembeliNode getTail() {
        return tail;
    }
    
    public void setCount(int count) {
        this.count = count;
    }

    public void setHead(PembeliNode head) {
        this.head = head;
    }
    
    public void setTail(PembeliNode tail) {
        this.tail = tail;
    }

    public boolean isEmpty(){return count == 0;}

    public void add(Pembeli pembeli){
        PembeliNode newNode = new PembeliNode(pembeli);
        if(isEmpty()){
            head = tail = newNode;
        }
        else{
            tail.setNext(newNode);
            tail = newNode;
        }
        count++;
    }

    public void add(String noTelp, String nama){
        Pembeli pembeli = new Pembeli(nama, noTelp);
        PembeliNode newNode = new PembeliNode(pembeli);
        if(isEmpty()){
            head = tail = newNode;
        }
        else{
            tail.setNext(newNode);
            tail = newNode;
        }
        count++;
    }

    public boolean cekPembeli(String noTelp){
        if(!isEmpty()){
            PembeliNode p = head;
            while (p != null){
                if(noTelp.equalsIgnoreCase(p.getItem().getNoTelp()))return true;
                    p = p.getNext();
            }
        }
        return false;
    }

    public String getNamaPembeli(String noTelp){
        String namaPembeli = "";
        if(!isEmpty()){
            PembeliNode p = head;
            while (p != null){
                if(noTelp.equalsIgnoreCase(p.getItem().getNoTelp()))return p.getItem().getNama();
                    p = p.getNext();
            }
        }
        return namaPembeli;
    }

    public double cekPoin(String noTelp){
        double poin = 0;
        if(!isEmpty()){
            PembeliNode p = head;
            while (p != null){
                if(noTelp.equalsIgnoreCase(p.getItem().getNoTelp()))return p.getItem().getMembership().getPoin();
                    p = p.getNext();
            }
        }
        return poin;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!isEmpty()) {
            System.out.println("No. Nama                 No.Telp      Poin");
            System.out.println("===================================================");
            int idx = 1;
            PembeliNode p = head;
            while (p != null) {
                sb.append(String.format("%2d. %s\n", idx++, p.getItem()));
                p = p.getNext();
            }
        }
        return sb.toString();
    }
}
