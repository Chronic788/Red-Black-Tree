/**
 * *******************************************************************************
 *
 * All code contained herein is the sole property of CollaborateMD, Inc. and may
 * not be used, copied, or duplicated in any manner without express written
 * permission from CollaborateMD, Inc.
 *
 * (c) 2017, all rights reserved
 *
 * Created Jul 13, 2017 7:26:47 PM
 *
 * ********************************************************************************
 */

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