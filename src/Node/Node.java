package Node;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author <Jared Nelsen>
 */

public abstract class Node {
    
    private int value;
    
    private Node parent;
    
    private final List<Node> children = new ArrayList<>();
    
    public Node(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
    
    public void setValue(int value) {
        this.value = value;
    }
    
    public Node getParent() {
        return parent;
    }
    
    public void setParent(Node node) {
        this.parent = node;
    }
    
    public void addChild(Node child) {
        children.add(child);
    }
    
    public List<Node> getChildren() {
        List<Node> nonNullChildren = new ArrayList<>();
        for(Node child : children) {
            if(child != null) {
                nonNullChildren.add(child);
            }
        }
        return nonNullChildren;
    }
    
    public boolean hasChildren() {
        return childCount() != 0;
    }
    
    public int childCount() {
        return getChildren().size();
    }
    
    public abstract Node copyNode();
    
}