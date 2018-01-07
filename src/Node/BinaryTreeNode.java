package Node;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author <Jared Nelsen>
 */

public class BinaryTreeNode extends RedBlackBalanceableTreeNode {
    
    private BinaryTreeNode leftChild;
    private BinaryTreeNode rightChild;
    
    public BinaryTreeNode(int value) {
        super(value);
    }
    
    public BinaryTreeNode getLeftChild() {
        return leftChild;
    }
    
    public void setLeftChild(BinaryTreeNode leftChild) {
        this.leftChild = leftChild;
    }
    
    public boolean hasLeftChild() {
        return leftChild != null;
    }
    
    public BinaryTreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryTreeNode rightChild) {
        this.rightChild = rightChild;
    }
    
    public boolean hasRightChild() {
        return rightChild != null;
    }
    
    public boolean hasASingleChild() {
        return (hasLeftChild() && !hasRightChild()) || (!hasLeftChild() && hasRightChild());
    }
    
    public boolean hasBothChildren() {
        return hasLeftChild() && hasRightChild();
    }
    
    public boolean hasNoChildren() {
        return !hasLeftChild() && !hasRightChild();
    }
        
    @Override
    public List<Node> getChildren() {
        List<Node> children = new ArrayList<>();
        
        if(leftChild != null) {
            children.add(leftChild);
        }
        if(rightChild != null) {
            children.add(rightChild);
        }
        
        return children;
    }
    
    @Override
    public int childCount() {
        if(leftChild == null && rightChild == null) {
            return 0;
        } else if((leftChild != null && rightChild == null) || 
                  (leftChild == null && rightChild != null)) {
            return 1;
        } else {
            return 2;
        }
    }
    
    public void copyNodeValuesFrom(BinaryTreeNode x) {
        this.setValue(x.getValue());
    }
    
    @Override
    public BinaryTreeNode copyNode() {
        BinaryTreeNode copy = new BinaryTreeNode(this.getValue());
        if(this.isRed()) {
            copy.setToRed();
        } else if(this.isBlack()) {
            copy.setToBlack();
        }
        copy.setLeftChild(leftChild);
        copy.setRightChild(rightChild);
        return copy;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BinaryTreeNode other = (BinaryTreeNode)obj;
        if(this.getValue() != other.getValue()) {
            return false;
        }
        
        return true;
    }
    
    
}