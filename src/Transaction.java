public class Transaction {

    public String payer;
    public String payee;
    public int amount;

    public Transaction(String payer, String payee, int amount) {
        this.payer = payer;
        this.payee = payee;
        this.amount = amount;
    }

    public String getHash(){
        String transactionString = toString();
        return HashFunction.hash(transactionString);
    }

    @Override
    public String toString(){
        return payer + payee + amount;
    }
}
