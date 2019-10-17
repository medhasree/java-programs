import java.util.List;

public class Customer {

    private String name;
    private List<Transaction> transactions;


    public Customer(String name, List<Transaction> transactions) {
        super();
        this.name = name;
        this.transactions = transactions;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Transaction> getTransactions() {
        return transactions;
    }
    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
