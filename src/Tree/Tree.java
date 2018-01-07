package Tree;


import Node.Node;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author <Jared Nelsen>
 */

public abstract class Tree<T extends Node> {
    
    private T root;
    
    public Tree() {
        
    }
    
    public Tree(T root) {
        this.root = root;
    }
    
    public void setRoot(T root) {
        this.root = root;
    }
    
    public T getRoot() {
        return root;
    }
    
    //May want to delete this method.
    public Node removeRoot() {
        Node theRoot = root;
        this.root = null;
        return theRoot;
    }
    
    public boolean isEmpty() {
        return root == null;
    }
    
    public abstract T search(T key, T current);
    
    public abstract T extractEqivalentlyValuedNodeInTree(T toExtract);
    
    public abstract T extractNode(T toExtract);

    public T insertNode(T toInsert) {
        return insertNode(toInsert, getRoot());
    }
    
    public abstract T insertNode(T toInsert, T current);
    
    public abstract boolean containsNode(T n);
    
    public abstract int size();
    
    public int height(){
        return heightFrom(1, getRoot());
    }
    
    private int heightFrom(int height, T parent) {
        
        int max = height;
        if(parent.hasChildren()) {
            for(Node n : parent.getChildren()) {
                max = Math.max(max, heightFrom(height + 1, (T)n));
            }
        }
        
        return max;
    }
    
    public void clear() {
        root = null;
    }
    
    /**
     * Enumerates all Nodes in the Tree in Depth First order.
     * 
     * @param currentNode The current Node in the Tree in Focus
     * @param nodeList : The list to collect the nodes in
     *                    **NOTE: Pass in the root of the tree and an empty list to start
     * 
     * @return The Nodes in Breadth First order
     */
    public List<Node> enumerateDepthFirst(Node currentNode, List<Node> nodeList) {
        //Add the current Node to the list
        nodeList.add(currentNode);
        
        //Enumerate the children of the Node
        List<Node> children = currentNode.getChildren();
        //And for each T, add its children's children
        for(Node child : children) {
            enumerateDepthFirst(child, nodeList);
        }
        
        return nodeList;
    }
    
    /**
     * Enumerates all Nodes in the Tree in Breadth First order.
     * 
     * @param nodeList - The list collecting the Nodes in this order
     *                   **NOTE: Pass in an empty list to start
     * 
     * @return The Nodes in Breadth First order
     */
    public List<Node> enumerateBreadthFirst(List<Node> nodeList) {
        
        if(root == null) {
            return nodeList;
        }
        
        //Create the queue to order the Nodes in
        Queue<Node> nodeQueue = new LinkedList<>();
        
        //Enqueue the root
        nodeQueue.add(root);
        
        //While the queue is not empty
        while(!nodeQueue.isEmpty()) {
            //Dequeue the next node
            Node dequeuedNode = nodeQueue.remove();
            
            //Add it in its order
            nodeList.add(dequeuedNode);
            
            //And add all of its children to the node List
            nodeQueue.addAll(dequeuedNode.getChildren());
        }
        
        return nodeList;
    }
}
