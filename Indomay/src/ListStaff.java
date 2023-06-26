public class ListStaff {
    private StaffNode head;
    private StaffNode tail;
    private int count;
    private Staff staff;

    public ListStaff(){
        this.head = this.tail = null;
        count = 0;
    }

    public int getCount() {
        return count;
    }

    public StaffNode getHead() {
        return head;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setHead(StaffNode head) {
        this.head = head;
    }

    public void setTail(StaffNode tail) {
        this.tail = tail;
    }
    
    public StaffNode getTail() {
        return tail;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public boolean isEmpty(){return count == 0;}

    public boolean login(String username,String pass){
        if(!isEmpty()){
            StaffNode p = head;
            while(p != null){
                if(p.getItem().getUserLogin().getUsername().equals(username) && p.getItem().getUserLogin().getPassword().equals(pass)){
                    staff = p.getItem();
                    return true;
            
                }
                p = p.getNext();
            }
        }
        return false;
    }

    public String getNama(String id){
        String nama = "";
        if(!isEmpty()){
            StaffNode p = head;
            while(p != null){
                if(p.getItem().getId().equals(id) ){
                    nama = p.getItem().getName();
            
                }
                p = p.getNext();
            }
        }
        return nama;
    }

    public void add(String id, String nama, String posisi, int gaji){
        Staff staffBaru = new Staff(id, nama, posisi, gaji);
        StaffNode newNode = new StaffNode(staffBaru);
        if(isEmpty()){
            head = tail = newNode;
        }
        else{
            tail.setNext(newNode);
            tail = newNode;
        }
        count++;
    }

    public void add(Staff staffBaru){
        StaffNode newNode = new StaffNode(staffBaru);
        if(isEmpty()){
            head = tail = newNode;
        }
        else{
            tail.setNext(newNode);
            tail = newNode;
        }
        count++;
    }

    public boolean cekStaff(String id){
        if(!isEmpty()){
            StaffNode p = head;
            while(p != null){
                if (id.equals(p.getItem().getId())) return true;
                p = p.getNext();
            }
        }
        return false;
    }

    public int getIndex(String id){
        if (!isEmpty()){
            StaffNode p = head;
            int idx = 0;
            while (p!=null){
                if(id.equals(p.getItem().getId())) return idx;
                p = p.getNext();
                idx++;
            }
        }
        return -1;
    }

    public void delete(String id){
        if(cekStaff(id)){
            int index = getIndex(id);
            StaffNode p = head;
            if (index == 0){
                head = p.getNext();
                p.setNext(null);
                p = null;
            }
            else if (index == count-1){
                for (int i = 0; i < index-1; i++) {
                    p = p.getNext();
                }
                StaffNode akhir = p.getNext();
                akhir.setNext(null);
                p.setNext(null);
                tail = p;
                akhir = null;
                
            }
            else{
                for (int i = 0; i < index-1; i++) {
                    p = p.getNext(); 
                    
                }
                StaffNode staffDihapus = p.getNext();
                p.setNext(staffDihapus.getNext());
                staffDihapus.setNext(null);
                staffDihapus = null;
            }
            count--;
        }
        else{
            System.out.println("<<System>> Staff tidak Terdaftar");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(!isEmpty()){
            StaffNode p = head;
            int idx = 1;
            System.out.println("No.  ID  Nama                 Posisi     Gaji                     Username   Password   Role");
            while(p!= null){
                sb.append(String.format("%2d. %s\n",idx++, p.getItem()));
                p = p.getNext();
            }
            System.out.println("==================================================================================================");
        }
        return sb.toString();
    }
}
