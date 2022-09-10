
import java.awt.*;
import java.awt.event.*;

public class TradingApp extends Frame {

	/*
	 * We will use this to print messages to the user.
	 */
	private static TextArea infoArea = new TextArea("Investment Trading App");

	public static void print(String text) {
		infoArea.setText(text);
	}
	// ---

	private Agent agent;
	private Panel StockButtonsPanel;

	public void buy(String name, int amount) {
		boolean found = agent.buy(name, amount);
		if (found == false) {
			System.out.println("ERROR: Try Again");
		} else {
			System.out.println("SUCCESS!");
		}
	}

	public void sell(String name, int amount) {
		boolean found = agent.sell(name, amount);
		if (found == false) {
			System.out.println("ERROR: Try Again");
		} else {
			System.out.println("SUCCESS!");
		}
	}

	public void removeStock(String StockName) {
		agent.removeStock2(StockName);
		int numStocks = agent.getNumberOfStocks();
		System.out.println(numStocks);
		StockButtonsPanel.remove(numStocks);
	}

	/**
	 * This method prints the names of all Stocks.
	 */
	public void printStocks() {
		String text = agent.getListOfStockNames();
		print(text);
	}

	/**
	 * This method prints the information of the Stock with the given index.
	 */
	public void printStockInfo(int index) {
		String text = agent.getStockInfo(index);
		print(text);
	}

	/**
	 * This method takes all the necessary steps when a Stock is added.
	 */

	public void addStock(String name) {
		agent.addStock(new Stock(name));

		int numStocks = agent.getNumberOfStocks();
		Button btn = new Button("Stock " + numStocks);

		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				printStockInfo(numStocks - 1);
			}
		});
		StockButtonsPanel.add(btn);
		this.setVisible(true); // Just to refresh the frame, so that the button shows
		// up
	}

	public TradingApp() {

		this.agent = new Agent();
		this.setLayout(new FlowLayout());

		// Button to print the stocks list
		//
		Button reportButton = new Button("Print stocks list");
		reportButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				printStocks();
			}
		});

		this.add(reportButton);

		Button removeStockButton = new Button("Remove Stock");
		removeStockButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Prompt acp = new Prompt();

				TextField Text = new TextField("Enter name of the Stock");
				acp.add(Text);

				acp.addSubmitListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						removeStock(Text.getText());
					}
				});
				acp.activate();
			}
		});

		this.add(removeStockButton);

		// Button to add stocks
		//
		Button addStockButton = new Button("Add Stock");
		addStockButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Prompt acp = new Prompt();

				TextField Text = new TextField("Enter name of the Stock");
				acp.add(Text);

				acp.addSubmitListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						addStock(Text.getText());
					}
				});
				acp.activate();
			}
		});

		this.add(addStockButton);

		// Button to place orders on stocks available
		//
		Button buyButton = new Button("Order");

		buyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Prompt acp = new Prompt();

				TextField Text = new TextField("Enter Name of the Stock");
				acp.add(Text);
				TextField Text2 = new TextField("Enter The Amount You Want to Order");
				acp.add(Text2);

				acp.addSubmitListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						String name = Text.getText();
						int amount = Integer.parseInt(Text2.getText());
						buy(name, amount);

					}
				});
				acp.activate();
			}
		});

		this.add(buyButton);

		Button sellButton = new Button("Sell");

		sellButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Prompt acp = new Prompt();

				TextField Text = new TextField("Enter Name of the Stock");
				acp.add(Text);
				TextField Text2 = new TextField("Enter The Amount You Want to Sell");
				acp.add(Text2);

				acp.addSubmitListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						String name = Text.getText();
						int amount = Integer.parseInt(Text2.getText());
						sell(name, amount);

					}
				});
				acp.activate();
			}
		});

		this.add(sellButton);

		// Output console
		infoArea.setEditable(false);
		this.add(infoArea);

		// Stock button panel
		//
		StockButtonsPanel = new Panel();
		StockButtonsPanel.setLayout(new GridLayout(0, 1));
		StockButtonsPanel.setVisible(true);
		this.add(StockButtonsPanel);

		// We add a couple of Stocks for testing purposes
		//
		this.addStock("Amazon");
		this.addStock("Netflix");

		// This is just so the X button closes our app
		//
		WindowCloser wc = new WindowCloser();
		this.addWindowListener(wc);

		this.setSize(500, 500);
		this.setLocationRelativeTo(null); // This centres the window on the screen
		this.setVisible(true);

	}

	public static void main(String[] args) {
		new TradingApp();
	}
}
