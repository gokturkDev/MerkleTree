public class Node {

    private final String hash;
    private final Node leftNode;
    private final Node rightNode;

    Node(String hash, Node leftNode, Node rightNode){
        this.hash = hash;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public String getHash() {
        return hash;
    }
}
