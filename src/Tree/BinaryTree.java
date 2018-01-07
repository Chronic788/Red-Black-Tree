package Tree;

import Comparator.BinaryNodeComparator;
import Comparator.NodeComparator;
import Node.BinaryTreeNode;


/**
 *
 * @author <Jared Nelsen>
 */

public class BinaryTree extends Tree<BinaryTreeNode> {

    public BinaryNodeComparator comparator = new BinaryNodeComparator();
    
    public BinaryTree() {
        
    }
    
    public BinaryTree(BinaryTreeNode root) {
        super(root);
    }
    
    @Override
    public BinaryTreeNode search(BinaryTreeNode key, BinaryTreeNode current) {
        
        //Null means that we have reached the bottom of the tree which means
        //that the tree does not contain the Node
        if(current == null) {
            return current;
        }
        
        //We have found the node so return it
        if(comparator.isEqualTo(key, current)) {
            return current;
        }
        
        //The node will be in the left sub tree
        if(comparator.isLessThan(key, current)) {
            return search(key, current.getLeftChild());
        } 
        
        //The node will be in the right subtree
        return search(key, current.getRightChild());
    }

    @Override
    public BinaryTreeNode insertNode(BinaryTreeNode toInsert, BinaryTreeNode current) {
        
        //If for some reason a null was passed in we quit the insertion
        if(toInsert == null) {
            return null;
        }
        
        //If the tree is empty then we are adding at the root
        if(getRoot() == null) {
            setRoot(toInsert);
            return toInsert;
        }
        
        //If the Node is already in the tree we do not need to insert
        if(comparator.isEqualTo(toInsert, current)) {
            return toInsert;
        }
        
        //If the Node to insert is less than the current Node and has no left
        //child, we have found the place to insert the new Node
        if(comparator.isLessThan(toInsert, current) && !current.hasLeftChild()) {
            current.setLeftChild(toInsert);
            current.getLeftChild().setParent(current);
        } else if(comparator.isLessThan(toInsert, current)) {
            //If the current node does have a left child and the node to insert is less
            //than the current node, continue down the left subtree
            insertNode(toInsert, current.getLeftChild());
        }
        
        //If the Node to insert in greater than the current Node and has no right
        //child, we have found the place to insert the new Node
        if(comparator.isGreaterThan(toInsert, current) && !current.hasRightChild()) {
            current.setRightChild(toInsert);
            current.getRightChild().setParent(current);
        } else if(comparator.isGreaterThan(toInsert, current)) {
            //If the current node does have a right child and the node to insert is greater
            //than the current node, continue down the right subtree
            insertNode(toInsert, current.getRightChild());
        }
        
        return toInsert;
    }
    
    /**
     * Find and extract the NODE in the tree with the given VALUE represented by the given Node.
     * 
     * Use this method to pass in some specifically valued Node and extract it from the tree.
     * 
     * The reason I pass in a Node instead of a numerical value is that we can rely on the comparator
     * to compare based on some specified implementation-specific dimension. Although this may not be
     * necessary for generic implementation, I wanted to make this implementation encourage the use of
     * abstract comparison dimensions using application specific comparisons.
     * 
     * @param toExtract : The Node who's value we will use to reference the Node in the tree to extract
     * @return 
     */
    @Override
    public BinaryTreeNode extractEqivalentlyValuedNodeInTree(BinaryTreeNode toExtract) {
        return extractNode(search(toExtract, getRoot()));
    }
    
    /**
     * Extract a known Node in the tree with the VALUE represented by the NODE passed in.
     * 
     * This method can be deceptive. This method is an OPERATION on a NODE, not on the TREE.
     * What this means is that we can not simply pass in a node that is not part of the
     * referential structure of the tree and expect it to be removed. This method performs
     * operations on a node IN THE TREE.
     * 
     * I made this as a design decision for a reason. This method is intended to be called on
     * nodes that exist in the tree that some other caller already has reference to.
     * 
     * Use extractNodeWithValue() to extract Nodes from the tree with some specified value
     * 
     * @param toExtract - The reference to the node representing the VALUE that we want to remove.
     * @return 
     */
    @Override 
    public BinaryTreeNode extractNode(BinaryTreeNode toExtract) {
        
        //If for some reason a null Node was passed in we quit the extraction
        if(toExtract == null){
            return null;
        }
        
        //If the parent of the node to extract is null that means we are extracting from the root
        if(toExtract.getParent() == null) {
            setRoot(null);
            return toExtract;
        }
        
        //Case #1 : The Node has no children
            //If the Node has no children all we have to do to delete it is set it's parent's
            //reference to it to null
        if(toExtract.hasNoChildren()) {
            
            //Set the parent's references to this node as null as applicable
            BinaryTreeNode parent = (BinaryTreeNode)toExtract.getParent();
         
            if(parent.getLeftChild().equals(toExtract)) {
                parent.setLeftChild(null);
            } else if(parent.getRightChild().equals(toExtract)) {
                parent.setRightChild(null);
            }
            
        }
        
        //Case #2: The Node has one subtree
            //If the node has a single child (a subtree) then we must
            //reshuffle the tree so that the Node's single child takes the place
            //of the Node itself. We can do this because all subtrees of a binary
            //search tree are valid binary search trees
        if(toExtract.hasASingleChild()) {
            
            BinaryTreeNode parent = (BinaryTreeNode)toExtract.getParent();
            
            //If the extraction Node has a left subtree
            if(toExtract.hasLeftChild()) {
                
                //If the extraction Node is the root
                if(toExtract.equals(getRoot())) {
                    //Set the left child as the root
                    setRoot(toExtract.getLeftChild());
                } else {
                
                    //If the extraction Node is it's parent's left child
                    if(toExtract.equals(parent.getLeftChild())) {
                        //Set it's parent's left child to the extraction Node's left child
                        parent.setLeftChild(toExtract.getLeftChild());
                        //And set the correct parent reference
                        parent.getLeftChild().setParent(parent);
                    }

                    //If the extraction Node is it's parent's right child
                    if(toExtract.equals(parent.getRightChild())) {
                        //Set it's parent's right child to the extraction Node's left child
                        parent.setRightChild(toExtract.getLeftChild());
                        //And set the correct parent reference
                        parent.getRightChild().setParent(parent);
                    }
                    
                }
            }
            
            //If the extraction Node has a right subtree
            if(toExtract.hasRightChild()) {
                
                //If the extraction Node is the root
                if(toExtract.equals(getRoot())) {
                    //Set the right child as the root
                    setRoot(toExtract.getRightChild());
                } else {
                
                    //If the extraction Node is it's parent's left child
                    if(toExtract.equals(parent.getLeftChild())) {
                        //Set it's parent's left child to the extraction Node's right child
                        parent.setLeftChild(toExtract.getRightChild());
                        //And set the correct parent reference
                        parent.getLeftChild().setParent(parent);
                    }

                    //If the extraction Node is it's parent's right child
                    if(toExtract.equals(parent.getRightChild())) {
                        //Set it's parent's right child to the extraction Node's left child
                        parent.setRightChild(toExtract.getRightChild());
                        //And set the correct parent reference
                        parent.getRightChild().setParent(parent);
                    }
                    
                }
            }
            
        }
        
        //Case #3: The Node has two subtrees
            //1. Find the minimum valued Node in the right subtree
            //2. Replace the value(s) of the node to be removed with the minimum node but do
            //   NOT remove it
            //3. Apply the remove function to the right subtree with a copy of the node
            //   to remove to remove the now-duplicate Node
        if(toExtract.hasBothChildren()) {
            //Remove the Min from the bottom of the right subtree
            BinaryTreeNode min = extractMinNode(toExtract.getRightChild());
            
            //Make a copy of the node to extract before changing the value of its reference in the tree
            BinaryTreeNode preAlteredState = toExtract.copyNode();
            
            //Set the VALUE of the Min node to the VALUE of the node to remove
            //IGNORING the references
            toExtract.copyNodeValuesFrom(min);
            
            //Return the copy of the removed node
            return preAlteredState;
        }
        
        return toExtract;
    }
    
    @Override
    public boolean containsNode(BinaryTreeNode n) {
        return search(n, (BinaryTreeNode)getRoot()) != null;
    }
    
    public BinaryTreeNode getMinNode(BinaryTreeNode node) {
        //Either this is the root or the programmer is dumb
        if(node == null) {
            return null;
        }
        
        //If the node has no left child, we have found the minimum valued node
        if(!node.hasLeftChild()) {
            return node;
        } else {
            //If it does have a left child, keep searching left
            return getMinNode(node.getLeftChild());
        }
    }
    
    public BinaryTreeNode extractMinNode(BinaryTreeNode node) {
        //This means the root is null
        if(node == null) {
            return null;
        }
        
        //If the node has no left child, we have found the minimally valued Node
        if(!node.hasLeftChild()) {
            //So extract it and return it
            return extractNode(node);
        } else {
            //If it has a left child, keep searching left
            return extractMinNode(node.getLeftChild());
        }
    }
    
    public BinaryTreeNode getMaxNode(BinaryTreeNode node) {
        //This means the root is null
        if(node == null) {
            return null;
        }
        
        //If the root has no right child, we have found the maximally valued Node
        if(!node.hasRightChild()) {
            return node;
        } else {
            //If it does have a right child, keep searching right
            return getMaxNode(node.getRightChild());
        }
    }
    
    public BinaryTreeNode extractMaxNode(BinaryTreeNode node) {
        //This means the root is null
        if(node == null) {
            return null;
        }
        
        //If the root has no right child, we have found the maximally valued Node
        if(!node.hasRightChild()) {
            //Se extract the max and return it
            return extractNode(node);
        } else {
            //If it does have a right child, keep searching right
            return extractMaxNode(node.getRightChild());
        }
    }
    
    @Override
    public int size() {
        return countElementsUnder((BinaryTreeNode)getRoot());
    }
    
    public int countElementsUnder(BinaryTreeNode parent) {
        //If the parent is null we are done counting down the tree
        if(parent == null) {
            return 0;
        }
        
        return countElementsUnder(parent.getLeftChild()) + countElementsUnder(parent.getRightChild()) + 1;
    }
    
    public void setComparator(BinaryNodeComparator comparator) {
        this.comparator = comparator;
    }
    
    public NodeComparator getComparator() {
        return this.comparator;
    }
    
}