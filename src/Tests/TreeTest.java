
package Tests;

import Node.BinaryTreeNode;
import Tree.BinaryTree;
import Tree.Tree;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author <Jared Nelsen>
 */

public class TreeTest extends Test {

    private static Tree tree;
    
    public static void test(BinaryTree btree) {
        tree = btree;
        binaryTreeTest();
    }
    
    private static void binaryTreeTest() {
//        singleElementTest();
//        thousandElementsTest();
//        singleSpecificElementTest();
//        fiftySpecificElementsTest();
        degenerateBinaryTreeHeightTest(true);
    }
    
    private static void singleElementTest() {
        tree.clear();
        print("Single element test");
        
        print("Adding 1 element");
        tree.insertNode(new BinaryTreeNode(randomInt()));
        print("The tree now has " + tree.size() + " elements in it");
        
        print("Removing 1 element from root");
        tree.removeRoot();
        print("The tree now has " + tree.size() + " elements in it");
        
        print("Single element test complete");
        System.out.println("");
    }
    
    private static void thousandElementsTest() {
        tree.clear();
        print("Thousand elements test");
        
        int aMillion = 1000;
        
        print("Adding 1 thousand elements");
        for (int i = 0; i < aMillion; i++) {
            tree.insertNode(new BinaryTreeNode(randomInt()));
        }
        
        int size = tree.size();
        print("The tree now has " + size + " elements in it");
        
        if(size == aMillion) {
            print("That is 1 thousand elements!");
        }
        
        print("Removing 1 thousand elements from the root...");
        for (int i = 0; i < aMillion; i++) {
            tree.removeRoot();
        }
        
        print("The tree now has " + tree.size() + " elements in it");
        
        print("Thousand element test complete");
        System.out.println("");
    }
    
    private static void singleSpecificElementTest() {
        tree.clear();
        print("Single specific element test");
        
        print("Creating single Node");
        
        int value = randomInt();
        BinaryTreeNode node = new BinaryTreeNode(value);
        
        tree.insertNode(node);
        
        print("Single node inserted...");
        
        print("Removing that value from the tree...");
        
        tree.extractEqivalentlyValuedNodeInTree(new BinaryTreeNode(value));
        
        print("The tree now has " + tree.size() + " elements in it");
        
        print("Single Specific element test complete");
        System.out.println("");
    }
    
    private static void fiftySpecificElementsTest() {
        tree.clear();
        print("Fifty specific elements test");
        
        print("Creating 100 specific Nodes");
        List<BinaryTreeNode> nodes = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            nodes.add(new BinaryTreeNode(randomInt()));
        }
        print("100 elements created...");
        
        print("Saving 50 of those elements to remove");
        List<BinaryTreeNode> toDelete = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            toDelete.add(nodes.get(i).copyNode());
        }
        
        print("Adding all 100 elements to tree");
        for(BinaryTreeNode node : nodes) {
            tree.insertNode(node);
        }
        
        print(tree.size() + " elements inserted");
        
        print("Now removing the 50 elements we recorded");
        
        for(BinaryTreeNode node : toDelete) {
            tree.extractEqivalentlyValuedNodeInTree(node);
        }
        
        print("The tree now has " + tree.size() + " elements in it");
                
        print("Fifty specific elements test complete");
        System.out.println("");
    }
    
    private static void degenerateBinaryTreeHeightTest(boolean increasing) {
        tree.clear();
        
        print("Degenerate Binary Tree height test");
        
        
        if(increasing) {
            print("Inserting 10 elements of increasing value");
            for (int i = 0; i < 10; i++) {
                tree.insertNode(new BinaryTreeNode(i));
            }       
        } else {
            print("Inserting 10 elements of decreasing value");
            for (int i = 10; i >= 0; i--) {
                tree.insertNode(new BinaryTreeNode(i));
            }
        }

        
        print(tree.size() + " elements inserted");
        
        print("The height of the tree should be 10");
        
        print("The height of the tree was found to be " + tree.height());
    }
    
}