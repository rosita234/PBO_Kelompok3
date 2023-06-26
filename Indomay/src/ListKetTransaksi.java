public class ListKetTransaksi extends ListBarang{
    private KetTransaksiNode head;
    private KetTransaksiNode tail;
    private int count;

    public ListKetTransaksi(){
        this.head = this.tail = null;
        count = 0;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setHead(KetTransaksiNode head) {
        this.head = head;
    }

    public void setTail(KetTransaksiNode tail) {
        this.tail = tail;
    }

    public boolean isEmpty(){return count == 0;}

    public void add(String idStaff, ListStaff listStaff, String kodeBarang, int jumlahBarang){
        if (kodeBarangAda(kodeBarang)){
            KetTransaksi ketTransaksi = new KetTransaksi(getNamaBarang(kodeBarang), jumlahBarang, getHargaBarang(kodeBarang));
            KetTransaksiNode newNode = new KetTransaksiNode(ketTransaksi);

            if(isEmpty()){
                head = tail = newNode;
            }
            else{
                tail.setNext(newNode);
                tail = newNode;
            }
            editJumlah(idStaff, listStaff, kodeBarang,getJumlahBarang(kodeBarang)-jumlahBarang);
            count++;
        }
    }
    
    public boolean barangAdaDiKet(String namaBarang){
        if(!isEmpty()){
            KetTransaksiNode p = head;
            while(p != null){
                if (namaBarang.equalsIgnoreCase(p.getItem().getNamaBarang())) return true;
                p = p.getNext();
            }
        }
        return false;
    }

    public int getIndex(String namaBarang){
        if (!isEmpty()){
            KetTransaksiNode p = head;
            int idx = 0;
            while (p!=null){
                if(namaBarang.equalsIgnoreCase(p.getItem().getNamaBarang())) return idx;
                p = p.getNext();
                idx++;
            }
        }
        return -1;
    }

    public int getJumlahBarangDiKet(String namaBarang){
        int jumlah = 0;
        if (!isEmpty()){
            KetTransaksiNode p = head;
            while (p!=null){
                if(namaBarang.equalsIgnoreCase(p.getItem().getNamaBarang())) return p.getItem().getJumlahBarang();
                p = p.getNext();
            }
        }
        return jumlah;
    }

    public void delete(String idStaff, ListStaff listStaff, String namaBarang){
        if(barangAdaDiKet(namaBarang)){
            int index = getIndex(namaBarang);
            KetTransaksiNode p = head;
            if (index == 0){
                //Hapus head
                head = p.getNext();
                p.setNext(null);
                p = null;
            }
            else if (index == count-1){
                //Hapus tail/Barang di list Akhir
                for (int i = 0; i < index-1; i++) {
                    p = p.getNext();
                    //Pointer berada sebelum tail
                }
                KetTransaksiNode akhir = p.getNext();
                akhir.setNext(null);
                p.setNext(null);
                tail = p;
                akhir = null;
                
            }
            else{
                for (int i = 0; i < index-1; i++) {
                    p = p.getNext(); //pointer berada sebelum barang
                    
                }
                KetTransaksiNode barang = p.getNext();
                p.setNext(barang.getNext());
                barang.setNext(null);
                barang = null;
            }
            String kodeBarang = getKodeBarang(namaBarang);
            editJumlah(idStaff, listStaff, kodeBarang,getJumlahBarang(kodeBarang)+getJumlahBarangDiKet(namaBarang));
            count--;
        }
        else{
            System.out.println("<<System>> Barang tidak Ada di Keterangan Transaksi");
        }
    }

    public int totalHarga(){
        int jumlah = 0;
        if(!isEmpty()){
            KetTransaksiNode p = head;
            while (p != null){
                jumlah += p.getItem().getJumlahBarang();
            }
        }
        return jumlah;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(!isEmpty()){
            KetTransaksiNode p = head;
            while(p!= null){
                sb.append(String.format("%s\n", p.getItem()));
                p = p.getNext();
            }
            System.out.println("=================================================");
        }
        return sb.toString();
    }
}