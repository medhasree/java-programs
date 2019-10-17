import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

public class RewardCalculator {

    public static void main(String[] args) {


        List<Transaction> transactions = new ArrayList<Transaction>();

        transactions.add(new Transaction (1, 55, new GregorianCalendar(2013,2,31)));
        transactions.add(new Transaction (2, 167, new GregorianCalendar(2013,2,22)));
        transactions.add(new Transaction (3, 42, new GregorianCalendar(2013,2,15)));
        transactions.add(new Transaction (3, 95, new GregorianCalendar(2013,3,1)));
        transactions.add(new Transaction (4, 15, new GregorianCalendar(2013,3,16)));
        transactions.add(new Transaction (5, 121, new GregorianCalendar(2013,3,23)));
        transactions.add(new Transaction (6, 137, new GregorianCalendar(2013,4,27)));
        transactions.add(new Transaction (7, 68, new GregorianCalendar(2013,4,2)));

        Customer customer = new Customer("john", transactions);

        HashMap<Integer, Integer> calculatedRewards = calculateMonthlyRewards(customer);

        int totalRewards = 0;
        for (Integer i : calculatedRewards.keySet()) {
            totalRewards += calculatedRewards.get(i);
            System.out.println(Month.of(i).name() + ": " + calculatedRewards.get(i) + " Reward Points");
        }

        System.out.println("Total Rewards earned: " + totalRewards);
    }


    public static HashMap<Integer, Integer> calculateMonthlyRewards(Customer customer) {

        int month;
        HashMap<Integer, Integer> rewardsByMonth = new HashMap<Integer, Integer>();
        int rewards;


        for (Transaction tr: customer.getTransactions()) {
            rewards = 0;
            month = tr.getPostedDate().get(Calendar.MONTH);


            if(tr.getAmount()>100) {
                rewards += 50 + (tr.getAmount() - 100)*2;
            } else if(tr.getAmount()>50 && tr.getAmount()<=100) {
                rewards += tr.getAmount() - 50;
            }
            if(rewardsByMonth.get(month) != null) {
                rewardsByMonth.put(month, rewardsByMonth.get(month) + rewards);
            }else {
                rewardsByMonth.put(month, rewards);
            }
        }
        return rewardsByMonth;
    }


}