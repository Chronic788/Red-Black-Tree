package Node;


/**
 *
 * @author <Jared Nelsen>
 */

public class RedBlackBalanceableTreeNode extends Node {

    private boolean isRed = true;
    
    public RedBlackBalanceableTreeNode(int value) {
        super(value);
    }
    
    public void setToRed() {
        this.isRed = true;
    }
    
    public void setToBlack() {
        this.isRed = false;
    }
    
    public void setToNodesColor(RedBlackBalanceableTreeNode node) {
        if(node.isRed()) {
            setToRed();
        } else if(node.isBlack()) {
            setToBlack();
        }
    }
    
    public void flipColor() {
        if(this.isRed()) {
            this.setToBlack();
        } else if(this.isBlack()) {
            this.setToRed();
        }
    }
    
    public boolean isRed() {
        return isRed == true;
    }
    
    public boolean isBlack() {
        return isRed == false;
    }
    
    @Override
    public Node copyNode() {
        RedBlackBalanceableTreeNode node = new RedBlackBalanceableTreeNode(this.getValue());
        if(this.isRed()) {
            node.setToRed();
        } else if(this.isBlack()) {
            node.setToBlack();
        }
        return node;
    }
}