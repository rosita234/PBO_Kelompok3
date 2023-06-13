/* Nama : Aurelya Hendra Qiu
 * Email : 03081220041@student.uph.edu
 */

public class Membership {
    /*Class Membership berisi :
     * - Cek poin membership
     * - Cek promo (benefit membership)
     */

    private int poin;
    private double promo;

    public Membership(){}

    public Membership(int poin, double promo){
        this.poin = poin;
        this.promo = promo;
    }

    public int getPoin() {
        return poin;
    }

    public double getPromo() {
        return promo;
    }

    public void setPoin(int poin) {
        this.poin = poin;
    }

    public void setPromo(double promo) {
        this.promo = promo;
    }

    @Override
    public String toString(){
        return String.format("%d  %.2f", poin, promo); 
    }
}