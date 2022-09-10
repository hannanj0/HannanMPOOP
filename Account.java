
public class Account {
    private int share;

    public Account() {
        this.share = 0;
    }

    public Account(int share) {
        this.share = share;
    }

    public int getShares() {
        return this.share;
    }

    public void buy(int amount) {
        this.share += amount;
    }

    public void sell(int amount) {
        this.share -= amount;
    }

    public String toString() {
        return "Shares: " + this.share;
    }

}
