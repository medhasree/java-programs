
import java.time.Month;
import java.util.Calendar;


public class Transaction {

    private int id;
    private int amount;
    private Calendar postedDate;


    public Transaction(int id, int amount, Calendar date) {
        super();
        this.id = id;
        this.amount = amount;
        this.postedDate = date;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public Calendar getPostedDate() {
        return postedDate;
    }
    public void setPostedDate(Calendar postedDate) {
        this.postedDate = postedDate;
    }


}