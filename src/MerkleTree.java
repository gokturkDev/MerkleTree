
import java.util.ArrayList;

public class MerkleTree {


    public String rootHash; //root hash will be given from a trusted source
    private Node rootNode;

    MerkleTree(String rootHash, Transaction[] transactions){
        this.rootHash = rootHash;


        ArrayList<Node> nodes = new ArrayList<>();

        for(Transaction transaction : transactions){
            String hashOfTransaction = transaction.getHash();
            Node node = new Leaf(hashOfTransaction, transaction);
            nodes.add(node);
        }

        int initialSizeOfNodes = nodes.size();
        createTheTree(nodes, initialSizeOfNodes);
        Node rootNode = nodes.get(0);
    }




    private void createTheTree(ArrayList<Node> nodes, int initialSizeOfNodes) {
        for (int x = 0; x < Math.log(initialSizeOfNodes); x++){
            createTheNextBranch(nodes);
        }
    }

    private void createTheNextBranch(ArrayList<Node> nodes) {
        for (int i = 0; i < nodes.size(); i++){
            Node rightNode;
            Node leftNode;
            leftNode = nodes.remove(i);
            try {
                rightNode = nodes.remove(i);
            } catch (IndexOutOfBoundsException e){
                rightNode = leftNode;
            }

            Node parentNode = createParentNode(rightNode, leftNode);
            nodes.add(i, parentNode);

        }
    }

    private Node createParentNode(Node rightNode, Node leftNode) {
        String hashOfParentNode = HashFunction.hash(rightNode.getHash() + leftNode.getHash());
        return new Node(hashOfParentNode, leftNode, rightNode);
    }


}
