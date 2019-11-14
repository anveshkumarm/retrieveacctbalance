import java.nio.file.Paths;
import java.util.stream.*;
import java.nio.file.Files;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.stream.Collectors;

public class RetrieveRelativeAcctBalance {
    public static void main(String[] args) {
        String accountId = null;
        String fromDate = null;
        String toDate = null;
        try {
            if (args.length > 0 && args.length <= 3){
                accountId = args[0];
                fromDate = args[1];
                toDate = args[2];
            }
            else { System.out.println("Invalid Input"); System.exit(0);}
            List<Transaction> transactions = new ArrayList<>();
            Stream<String> stream = Files.lines(Paths.get(".//input.csv").toAbsolutePath().normalize());
            stream.skip(1).forEach(
                    (c) -> transactions.add(createTransaction(c.split(",")))
            );
            // uncomment below code to view the actual transactions
            /*for (Transaction t : transactions) {
                System.out.println(t.toString());
            }*/
            Date fromDateConv = new SimpleDateFormat("dd/mm/yyyy HH:mm:ss").parse(fromDate);
            Date toDateConv =  new SimpleDateFormat("dd/mm/yyyy HH:mm:ss").parse(toDate);
            String acctId = accountId;
            List<String> transId = transactions.stream()
                    .map(Transaction::getRelatedTransaction)
                    .collect(Collectors.toList());
            List<Transaction> tfilter = transactions.stream().filter((t) -> !"REVERSAL".equals(t.getTransactionType()) & acctId.equals(t.getFromAccountId()) && !transId.contains(t.getTransactionId()) && t.getCreatedAt().after(fromDateConv) && t.getCreatedAt().before(toDateConv)).collect(Collectors.toList());
            Double sum = tfilter.stream().mapToDouble(i-> Double.parseDouble(i.getAmount().toString())).sum();
            System.out.println("Relative balance for the period is: " +Math.abs(sum) * -1);
            System.out.println("Number of transactions included is:  " +tfilter.size());
        } catch (Exception e) {
            System.out.println("Invalid input data:  "+ e.getMessage());System.exit(0);
        }

    }

    private static Transaction createTransaction(String[] metadata) {
        try {
            String transactionId = metadata[0].trim();
            String fromAccountId = metadata[1].trim();
            String toAccountId = metadata[2].trim();
            Date createdAt = new SimpleDateFormat("dd/mm/yyyy HH:mm:ss").parse(metadata[3].trim());
            float amount = Float.parseFloat(metadata[4].trim());
            String transactionType = metadata[5].trim();
            String relatedTransaction = metadata.length > 6 ? metadata[6].trim() : "";
            return new Transaction(transactionId, fromAccountId, toAccountId, createdAt, amount, transactionType, relatedTransaction);
        } catch (Exception e) {
            System.out.println("Invalid input data:  "+ e.getMessage());System.exit(0);
        }
        return null;
    }
}


