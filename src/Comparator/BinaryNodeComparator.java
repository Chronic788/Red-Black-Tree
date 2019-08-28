
package Comparator;

import Node.BinaryTreeNode;


/**
 *
 * @author <Jared Nelsen>
 */

public class BinaryNodeComparator implements NodeComparator<BinaryTreeNode> {

    @Override
    public boolean isGreaterThan(BinaryTreeNode n, BinaryTreeNode m) {
        return n.getValue() > m.getValue();
    }

    @Override
    public boolean isLessThan(BinaryTreeNode n, BinaryTreeNode m) {
        return n.getValue() < m.getValue();
    }

    @Override
    public boolean isEqualTo(BinaryTreeNode n, BinaryTreeNode m) {
        return n.getValue() == m.getValue();
    } 
    
}