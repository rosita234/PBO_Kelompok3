public class Membership {
    /*Class Membership berisi :
     * - Cek poin membership
     * - Cek promo (benefit membership)
     */

    private double poin;

    public Membership(){
    }

    public Membership(int poin){
        this.poin = poin;
    }

    public double getPoin() {
        return poin;
    }

    public void setPoin(double poin) {
        this.poin = poin;
    }

    @Override
    public String toString(){
        return String.format("%.2f", poin); 
    }
}