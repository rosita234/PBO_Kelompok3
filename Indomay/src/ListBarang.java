public class ListBarang {
    private BarangNode head;
    private BarangNode tail;
    private int count;
    public ListHistoryBarang historyBarang;
    private ListStaff listStaff;

    public ListBarang(){
        this.head = this.tail = null;
        count = 0;
        historyBarang = new ListHistoryBarang();
    }

    public int getCount() {
        return count;
    }

    public ListStaff getListStaff() {
        return listStaff;
    }

    public void setListStaff(ListStaff listStaff) {
        this.listStaff = listStaff;
    }

    public BarangNode getHead() {
        return head;
    }

    public BarangNode getTail() {
        return tail;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setHead(BarangNode head) {
        this.head = head;
    }

    public void setTail(BarangNode tail) {
        this.tail = tail;
    }

    public ListHistoryBarang getHistoryBarang() {
        return historyBarang;
    }

    public void setHistoryBarang(ListHistoryBarang historyBarang) {
        this.historyBarang = historyBarang;
    }

    public boolean isEmpty(){return count == 0;}

    public void add(String idStaff,ListStaff listStaff, Barang barang){
        BarangNode newNode = new BarangNode(barang);

        if(isEmpty()){
            head = tail = newNode;
        }
        else{
            tail.setNext(newNode);
            tail = newNode;
        }
        String ket = barang.toString();
        historyBarang.add("Add", idStaff,listStaff.getNama(idStaff), ket);
        count++;
    }

    public void add(String idStaff, ListStaff listStaff, String kodeBarang, String namaBarang, int jumlahBarang, int hargaBarang){
        Barang barang = new Barang(kodeBarang, namaBarang, jumlahBarang, hargaBarang);
        BarangNode newNode = new BarangNode(barang);

        if(isEmpty()){
            head = tail = newNode;
        }
        else{
            tail.setNext(newNode);
            tail = newNode;
        }
        String ket = barang.toString();
        historyBarang.add("Add", idStaff,listStaff.getNama(idStaff), ket);
        count++;
    }

    public int getIndex(String kodeBarang){
        if (!isEmpty()){
            BarangNode p = head;
            int idx = 0;
            while (p!=null){
                if(kodeBarang.equalsIgnoreCase(p.getItem().getKodeBarang())) return idx;
                p = p.getNext();
                idx++;
            }
        }
        return -1;
    }

    public boolean kodeBarangAda(String kodeBarang){
        if(!isEmpty()){
            BarangNode p = head;
            while (p != null){
                if(kodeBarang.equalsIgnoreCase(p.getItem().getKodeBarang()))return true;
                    p = p.getNext();
            }
        }
        return false;
    }

    public String getKodeBarang(String namaBarang){
        if(!isEmpty()){
            BarangNode p = head;
            while (p != null){
                if(namaBarang.equalsIgnoreCase(p.getItem().getNamaBarang()))return p.getItem().getKodeBarang();
                    p = p.getNext();
            }
        }
        return "";
    }

    public String getNamaBarang(String kodeBarang){
        if(!isEmpty()){
            BarangNode p = head;
            while (p != null){
                if(kodeBarang.equalsIgnoreCase(p.getItem().getKodeBarang()))return p.getItem().getNamaBarang();
                    p = p.getNext();
            }
        }
        return "";
    }

    public int getJumlahBarang(String kodeBarang){
        if(!isEmpty()){
            BarangNode p = head;
            while (p != null){
                if(kodeBarang.equalsIgnoreCase(p.getItem().getKodeBarang()))return p.getItem().getJumlahBarang();
                    p = p.getNext();
            }
        }
        return -1;
    }

    public int getHargaBarang(String kodeBarang){
        if(!isEmpty()){
            BarangNode p = head;
            while (p != null){
                if(kodeBarang.equalsIgnoreCase(p.getItem().getKodeBarang()))return p.getItem().getHargaBarang();
                    p = p.getNext();
            }
        }
        return -1;
    }

    public boolean barangAdaDiList(String kodeBarang){
        if(!isEmpty()){
            BarangNode p = head;
            while(p != null){
                if (kodeBarang.equalsIgnoreCase(p.getItem().getKodeBarang())) return true;
                p = p.getNext();
            }
        }
        return false;
    }

    public void delete(String idStaff,ListStaff listStaff, String kodeBarang){
        if(barangAdaDiList(kodeBarang)){
            int index = getIndex(kodeBarang);
            BarangNode p = head;
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
                BarangNode akhir = p.getNext();
                akhir.setNext(null);
                p.setNext(null);
                tail = p;
                akhir = null;
                
            }
            else{
                for (int i = 0; i < index-1; i++) {
                    p = p.getNext(); //pointer berada sebelum barang
                    
                }
                BarangNode barang = p.getNext();
                p.setNext(barang.getNext());
                barang.setNext(null);
                barang = null;
            }
            String ket = String.format("%s %s", kodeBarang, getNamaBarang(kodeBarang));
            historyBarang.add("Delete", idStaff, listStaff.getNama(idStaff), ket);
            count--;
        }
        else{
            System.out.println("<<System>> Barang tidak Ada di List");
        }
    }

    public void editKode(String idStaff, ListStaff listStaff, String kodeBarang, String kodeBarangBaru){
        if(kodeBarangAda(kodeBarang)){
            BarangNode p = head;
            while (p != null){
                if(kodeBarang.equalsIgnoreCase(p.getItem().getKodeBarang())){
                    p.getItem().setKodeBarang(kodeBarangBaru);
                    String ket = String.format("%s -> %s", kodeBarang, kodeBarangBaru);
                    historyBarang.add("Edit",idStaff, listStaff.getNama(idStaff), ket);
                }
                p = p.getNext();
            }
        }
    }

    public void editNama(String idStaff, ListStaff listStaff, String kodeBarang, String namaBarangBaru){
        if(kodeBarangAda(kodeBarang)){
            BarangNode p = head;
            while (p != null){
                if(kodeBarang.equalsIgnoreCase(p.getItem().getKodeBarang())){
                    p.getItem().setNamaBarang(namaBarangBaru);
                    String ket = String.format("%s -> %s", getNamaBarang(kodeBarang), namaBarangBaru);
                    historyBarang.add("Edit", idStaff, listStaff.getNama(idStaff), ket);
                }
                p = p.getNext();
            }
        }
    }

    public void editJumlah(String idStaff, ListStaff listStaff, String kodeBarang, int jumlahBaru){
        if(kodeBarangAda(kodeBarang)){
            BarangNode p = head;
            while (p != null){
                if(kodeBarang.equalsIgnoreCase(p.getItem().getKodeBarang())){
                    p.getItem().setJumlahBarang(jumlahBaru);
                    String ket = String.format("%d -> %d", getHargaBarang(kodeBarang), jumlahBaru);
                    historyBarang.add("Edit", idStaff, listStaff.getNama(idStaff), ket);
                }
                p = p.getNext();
            }
        }
    }

    public void editHarga(String idStaff, ListStaff listStaff, String kodeBarang, int hargaBaru){
        if(kodeBarangAda(kodeBarang)){
            BarangNode p = head;
            while (p != null){
                if(kodeBarang.equalsIgnoreCase(p.getItem().getKodeBarang())){
                    p.getItem().setHargaBarang(hargaBaru);
                    String ket = String.format("%s -> %s", getHargaBarang(kodeBarang), hargaBaru);
                    historyBarang.add("Edit", idStaff, listStaff.getNama(idStaff), ket);
                }
                p = p.getNext();
            }
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!isEmpty()) {
            System.out.println("No. Kode Nama                 Jumlah Harga");
            System.out.println("==================================================");
            int idx = 1;
            BarangNode p = head;
            while (p != null) {
                sb.append(String.format("%2d. %s\n", idx++, p.getItem()));
                p = p.getNext();
            }
        }
        return sb.toString();
    }
}
