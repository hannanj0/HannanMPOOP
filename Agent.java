import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Agent {

	// Creates an array list storing Stock objects
	//
	private ArrayList<Stock> Stocks;

	public Agent() {
		Stocks = new ArrayList<Stock>();
	}

	// Gets the number of stocks
	//
	public int getNumberOfStocks() {
		return Stocks.size();
	}

	// Prints the information as a portfolio
	//
	public String getStockInfo(int StockNumber) {
		Stock c = Stocks.get(StockNumber);
		String text = "";
		int min = -25;
		int max = 25;
		double randomNumb = (new Random().nextDouble() * (max - min)) + min;
		randomNumb += 25;
		text += c.getName() + " Portfolio: " + "\n";
		text += "Name: " + c.getName() + "\n";
		text += "Shares: " + c.getFunds() + "\n";
		text += "Price: £" + randomNumb;
		return text;

	}

	// Gets the stock names
	//
	public String getListOfStockNames() {
		String text = "";
		Iterator<Stock> it = Stocks.iterator();
		while (it.hasNext()) {
			Stock c = it.next();
			text += c.getName() + "\n";
		}
		return text;
	}

	// Method to add stock
	//
	public void addStock(Stock c) {
		Stocks.add(c);
	}

	// Uses while and if statement to buy stocks
	//
	public boolean buy(String StockName, int amount) {
		Iterator<Stock> it = Stocks.iterator();
		boolean found = false;
		while (it.hasNext()) {
			Stock c = it.next();
			if (c.getName().equalsIgnoreCase(StockName)) {
				found = true;
				c.buy(amount);
			}
		}
		return found;
	}

	// Uses while and if statement to sell stock given there is enough stock to sell
	//
	public boolean sell(String StockName, int amount) {
		Iterator<Stock> it = Stocks.iterator();
		boolean found = false;
		while (it.hasNext()) {
			Stock c = it.next();
			if (c.getName().equalsIgnoreCase(StockName)) {
				if (amount <= c.getFunds()) {
					found = true;
					c.sell(amount);
				}

			}
		}
		return found;
	}

	// Method to remove stock
	//
	public void removeStock2(String StockName) {
		Stocks.removeIf((c) -> c.getName().equals(StockName));
	}
}
