package pers.hanchao.dsaa.ds05tree.binary;

/**
 * <p>二叉树的节点</p>
 * @author hanchao 2018/5/13 14:37
 **/
public class Node {
    //节点数据
    private int value;
    //左子节点的引用
    public Node leftChild;
    //右子节点的引用
    public Node rightChild;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
