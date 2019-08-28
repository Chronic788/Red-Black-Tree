package Comparator;

import Node.Node;

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