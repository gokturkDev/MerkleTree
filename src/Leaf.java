public class Leaf extends Node{

    Transaction transaction;

    Leaf(String hash, Transaction transaction) {
        super(hash, null, null);
        this.transaction = transaction;
    }
}
