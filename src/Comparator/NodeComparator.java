package Comparator;

import Node.Node;

/**
 * *******************************************************************************
 *
 * All code contained herein is the sole property of CollaborateMD, Inc. and may
 * not be used, copied, or duplicated in any manner without express written
 * permission from CollaborateMD, Inc.
 *
 * (c) 2017, all rights reserved
 *
 * Created Jul 13, 2017 7:03:17 PM
 *
 * ********************************************************************************
 */


/**
 *
 * @author <Jared Nelsen>
 */

public interface NodeComparator<T extends Node> {

    //Is n.(valueInQuestion) greater than m.(valueInQuestion)?
    public abstract boolean isGreaterThan(T n, T m);
    
    //Is n.(valueInQuestion) less than m.(valueInQuestion)?
    public abstract boolean isLessThan(T n, T m);
    
    //Is n.(valueInQuestion) equal to m.(valueInQuestion)?
    public abstract boolean isEqualTo(T n, T m);
    
}