public class Stock extends User {

    private Account account;

    public Stock(String name) {
        super(name);
        this.account = new Account();
    }

    public void buy(int amount) {
        this.account.buy(amount);
    }

    public void sell(int amount) {
        this.account.sell(amount);
    }

    public int getFunds() {
        return this.account.getShares();
    }

}
