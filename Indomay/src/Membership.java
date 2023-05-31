/* Nama : Aurelya Hendra Qiu
 * Email : 03081220041@student.uph.edu
 */

public class Membership {
    /*Class Membership berisi :
     * - Cek poin membership
     * - Cek promo (benefit membership)
     */

    private int poin;
    private int promo;

    public Membership(int poin, int promo){
        this.poin = poin;
        this.promo = promo;
    }

    public int getPoin() {
        return poin;
    }

    public int getPromo() {
        return promo;
    }

    public void setPoin(int poin) {
        this.poin = poin;
    }

    public void setPromo(int promo) {
        this.promo = promo;
    }
}