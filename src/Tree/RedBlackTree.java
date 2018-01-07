
package Tree;

import Node.BinaryTreeNode;
import Node.Node;

/**
 *
 * @author <Jared Nelsen>
 */

public class RedBlackTree extends BinaryTree {
    
    public RedBlackTree() {
        
    }
    
    public RedBlackTree(BinaryTreeNode root){
        super(root);
    }

    
//***************************************************************************************************************
//Insertion
//***************************************************************************************************************
    
    @Override
    public BinaryTreeNode insertNode(BinaryTreeNode toInsert) {
        BinaryTreeNode root = insertNode(toInsert, getRoot());
        root.setToBlack();
        return root;
    }
    
    @Override
    public BinaryTreeNode insertNode(BinaryTreeNode toInsert, BinaryTreeNode current) {
        
        //Check for a null
        if(toInsert == null) {
            return null;
        }
        
        //If the tree is empty then we are adding at the root
        if(getRoot() == null) {
            setRoot(toInsert);
            return toInsert;
        }
        
        //We have found the place in the Tree to place the node. Because
        //We set the new node by method of setting it as a child of the parent
        //above this recurrence, all we need to do is return it
        if(current == null) {
            return toInsert;
        }
        
        //The Node is already in the Tree
        if(comparator.isEqualTo(toInsert, current)) {
            return current;
        } else if(comparator.isLessThan(toInsert, current)) {
            //Continue down the left subtree if the node is less than the current node
            //and set the resultant node to the left child
            current.setLeftChild(insertNode(toInsert, current.getLeftChild()));
            toInsert.setParent(current);
        } else if(comparator.isGreaterThan(toInsert, current)) {
            //Continue down the right subtree if the node is greater than the current node
            //and set the resultant node to the right child
            current.setRightChild(insertNode(toInsert, current.getRightChild()));
            toInsert.setParent(current);
        }
        
        //Because one of the three above cases are guaranteed to have tripped we have in effect
        //inserted the node as one of the children
        
        //But now we need to fix right leaning links
        
//        if(toInsert.getRightChild() != null && toInsert.getLeftChild() != null) {
//            if(toInsert.getRightChild().isRed() && toInsert.getLeftChild().isBlack()) {
//                toInsert = rotateLeft(toInsert);
//            }            
//        }
//
//        if(toInsert.getLeftChild() != null && toInsert.getRightChild() != null && toInsert.getRightChild().getLeftChild() != null) {
//            if(toInsert.getLeftChild().isRed() && toInsert.getLeftChild().getLeftChild().isRed()) {
//                toInsert = rotateRight(toInsert);
//            }            
//        }
//
//        if(toInsert.getLeftChild() != null && toInsert.getRightChild() != null) {
//            if(toInsert.getLeftChild().isRed() && toInsert.getRightChild().isRed()) {
//                flipColors(toInsert);
//            }            
//        }
        

//        You tried this to avoid possible misses of the below right leaning link logic
//        boolean rightChildIsRed = false;
//        if(current.getRightChild() != null) {
//            if(current.getRightChild().isRed()) {
//                rightChildIsRed = true;
//            }
//        }
//        
//        boolean rightChildOfRightChildIsRed = false;
//        if(current.getRightChild() != null && current.getRightChild().getRightChild() != null) {
//            if(current.getRightChild().getRightChild().isRed()) {
//                rightChildOfRightChildIsRed = true;
//            }
//        }
//        
//        boolean leftChildIsRed = false;
//        boolean leftChildIsBlack = false;
//        if(current.getLeftChild() != null) {
//            if(current.getLeftChild().isRed()) {
//                leftChildIsRed = true;
//            } else {
//                leftChildIsBlack = true;
//            }
//        }
//        
//        boolean leftChildOfLeftChildIsRed = false;
//        if(current.getLeftChild() != null && current.getLeftChild().getLeftChild() != null) {
//            if(current.getLeftChild().getLeftChild().isRed()) {
//                leftChildOfLeftChildIsRed = true;
//            }
//        }
//        
//        if((rightChildIsRed && leftChildIsBlack) || (rightChildIsRed && rightChildOfRightChildIsRed)) {
//            current = rotateLeft(current);
//        }
//        
//        if(leftChildIsRed && leftChildOfLeftChildIsRed) {
//            current = rotateRight(current);
//        }
//        
//        if(leftChildIsRed && rightChildIsRed) {
//            flipColors(current);
//        }

        //Case 1: toInsert's parent P is black
            //The addition of K did not result in a red black property violation so there is nothing to do
        BinaryTreeNode parent = (BinaryTreeNode)toInsert.getParent();
        if(parent.isBlack()) {
            return toInsert;
        }
        
        //Case 2: toInsert's parent is red
        if(parent.isRed()) {
            //There are two subcases here
            //Case 2a: The Parent's sibling S is black or null
            //If this is true then we need to do a trinode restructuring
            
            if(get sibling is black or null)
            
            //We have:
            //  K, the node to insert
            //  P, K's parent
            //  G, K's grandparent
            
            BinaryTreeNode grandParent = (BinaryTreeNode)parent.getParent();
            
            //To carry out the restructuring:
            //1. We make P the parent of K and G
            toInsert.setParent(parent);
            grandParent.setParent(parent);
            
            //2. Color the parent black
            //3. Color toInsert red
            //4. Color grandparent red
            parent.setToBlack();
            toInsert.setToRed();
            grandParent.setToRed();
            
            //Now we need to ensure that any subtrees of 
            
            
        }
            
           
        
        return toInsert;
    }

//***************************************************************************************************************
//Deletion
//***************************************************************************************************************
    
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
    
    @Override
    public BinaryTreeNode extractNode(BinaryTreeNode toExtract) {
        return extractNode(toExtract, getRoot());
    }
    
    //Document this
    private BinaryTreeNode extractNode(BinaryTreeNode toExtract, BinaryTreeNode current) {
        
        if(toExtract == null) {
            return toExtract;
        }
        
        if(toExtract.equals(getRoot())) {
            setRoot(null);
            return toExtract;
        }
        
        //If the node to delete is lesser than the current node
        if(comparator.isLessThan(toExtract, current)) {
            if(toExtract.getLeftChild() != null && toExtract.getLeftChild().getLeftChild() != null) {
                if(toExtract.getLeftChild().isBlack() && toExtract.getLeftChild().getLeftChild().isBlack()) {
                    toExtract = moveRedLeft(toExtract);
                }                
            }
            toExtract.setLeftChild(extractNode(toExtract.getLeftChild(), current));
        } else {
            
            //If the node to delete is greater than the current Node
            if(toExtract.getLeftChild() != null) {
                if(toExtract.getLeftChild().isRed()) {
                    toExtract = rotateRight(toExtract);
                }                
            }
            
            if(comparator.isEqualTo(toExtract, current) && toExtract.getRightChild() == null) {
                return null;
            }
            
            if(toExtract.getRightChild() != null && toExtract.getRightChild().getLeftChild() != null) {
                if(toExtract.getRightChild().isBlack() && toExtract.getRightChild().getLeftChild().isBlack()) {
                    toExtract = moveRedRight(toExtract);
                }                
            }

            //If we've found the node
            if(comparator.isEqualTo(toExtract, current)) {
                Node y = getMinNode(toExtract.getRightChild());
                //Set the found node to the VALUE of the minimum node
                toExtract.setValue(y.getValue());
                //And now delete the minimum in the right subtree
                toExtract.setRightChild(extractMinNode(toExtract.getRightChild()));
            } else {
                //We havent found the node so keep trying to delete
                toExtract.setRightChild(extractNode(toExtract.getRightChild(), current));
            }
        }
        
        return balance(toExtract);
    }
        
    public void deleteMin() {
        if(this.isEmpty()) {
            return;
        }
        
        //If both children of the root are black we must set the root's color to red to set up the algorithm below
        //to restore the coloring
        if(getRoot().getLeftChild().isBlack() && getRoot().getRightChild().isBlack()) {
            getRoot().setToRed();
        }
        
        //Reshuffle the root of the tree to reflect the newly red root
        setRoot(extractMinNode(getRoot()));
        
        //If the tree is not empty set the root to black. The root of a Red Black tree is always Black
        if(!isEmpty()) {
            getRoot().setToBlack();
        }
    }
    
    @Override
    public BinaryTreeNode extractMinNode(BinaryTreeNode node) {
        if(node.getLeftChild() == null) {
            return null;
        }
        
        if(node.getLeftChild().isBlack() && node.getLeftChild().getLeftChild().isBlack()) {
            node = moveRedLeft(node);
        }
        
        node.setLeftChild(extractMinNode(node.getLeftChild()));
        return balance(node);
    }
    
    public void deleteMax() {
        if(isEmpty()) {
            return;
        }
        
        if(getRoot().getLeftChild().isBlack() && getRoot().getRightChild().isBlack()) {
            getRoot().setToRed();
        }
        
        setRoot(extractMaxNode(getRoot()));
        
        if(isEmpty()) {
            getRoot().setToBlack();
        }
    }
    
    @Override
    public BinaryTreeNode extractMaxNode(BinaryTreeNode node) {
        if(node.getLeftChild().isRed()) {
            node = rotateRight(node);
        }
        
        if(node.getRightChild() == null) {
            return null;
        }
        
        if(node.getRightChild().isBlack() && node.getRightChild().getLeftChild().isBlack()) {
            node = moveRedRight(node);
        }
        
        node.setRightChild(extractMaxNode(node.getRightChild()));
        
        return balance(node);
    }
    

    
//***************************************************************************************************************
//Helpers
//***************************************************************************************************************
    
    private BinaryTreeNode rotateRight(BinaryTreeNode node) {
        BinaryTreeNode x = node.getLeftChild();
        node.setLeftChild(x.getRightChild());
        x.setRightChild(node);
        x.setToNodesColor(x.getRightChild());
        x.getRightChild().setToRed();
        //Says set size here?
        
        return x;
    }
    
    private BinaryTreeNode rotateLeft(BinaryTreeNode node) {
        BinaryTreeNode x = node.getRightChild();
        node.setRightChild(x.getLeftChild());
        x.setLeftChild(node);
        x.setToNodesColor(x.getLeftChild());
        x.getLeftChild().setToRed();
        //Says set to size here?
        
        return x;
    }
    
    private void flipColors(BinaryTreeNode node) {
        node.flipColor();
        node.getLeftChild().flipColor();
        node.getRightChild().flipColor();
    }
    
    private BinaryTreeNode moveRedLeft(BinaryTreeNode node) {
        
        flipColors(node);
        
        if(node.getRightChild().getLeftChild().isRed()) {
            node.setRightChild(rotateRight(node.getRightChild()));
            node = rotateLeft(node);
            flipColors(node);
        }
        
        return node;
    }
    
    private BinaryTreeNode moveRedRight(BinaryTreeNode node) {
        
        if(node.getRightChild().isRed()) {
            node = rotateLeft(node);
        }
        
        if(node.getLeftChild().isRed() && node.getLeftChild().getLeftChild().isRed()) {
            node = rotateRight(node);
        }
        
        if(node.getLeftChild().isRed() && node.getRightChild().isRed()) {
            flipColors(node);
        }
        
        //Size call?
        return node;
    }
    
    //Restores the Red Black property
    private BinaryTreeNode balance(BinaryTreeNode node) {
        
        if(node.getRightChild() != null) {
            if(node.getRightChild().isRed()) {
                node = rotateLeft(node);
            }            
        }

        if(node.getLeftChild() != null && node.getLeftChild().getLeftChild() != null) {
            if(node.getLeftChild().isRed() && node.getLeftChild().getLeftChild().isRed()) {
                node = rotateRight(node);
            }            
        }

        if(node.getLeftChild() != null && node.getRightChild() != null) {
            if(node.getLeftChild().isRed() && node.getRightChild().isRed()) {
                flipColors(node);
            }            
        }
        
        return node;
    }
    
}