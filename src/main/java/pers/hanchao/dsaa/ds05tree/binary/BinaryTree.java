package pers.hanchao.dsaa.ds05tree.binary;

/**
 * 二叉树
 */
public class BinaryTree {
    //根节点
    private Node root;
    //遍历根节点

    public Node getRoot() {
        return root;
    }

    /**
     * 查找节点
     * 时间复杂度为O(logn),底数为2
     *
     * @param value
     * @return
     */
    public Node find(int value) {
        //获取根节点
        Node current = root;
        //当前节点不为空，循环查找
        while (current != null) {
            //如果目标值大于当前节点的值，则查找右子树
            if (value > current.getValue()) {
                current = current.rightChild;
            } else if (value < current.getValue()) {
                //如果目标值小于当前节点的值，则查找左子树
                current = current.leftChild;
            } else {
                //如果目标值=当前节点的值，则找到结果，返回
                return current;
            }
        }
        //如果没有找到结果，返回null
        return null;
    }

    /**
     * 插入节点
     *
     * @param value
     * @return
     */
    public boolean insert(int value) {
        //定义新节点
        Node Node = new Node(value);
        //如果为空树，直接插入在根节点
        if (root == null) {
            root = Node;
            return true;
        } else {
            //定义临时节点
            Node current = root;
            //定义临时节点的父节点
            Node parent = null;
            while (current != null) {
                parent = current;
                //如果插入的值大于当前节点，则将其插入到右子树上
                if (value > current.getValue()) {
                    //切换至右子树
                    current = current.rightChild;
                    //如果右子树为空，则插入节点，否则继续向下查询
                    if (current == null) {
                        parent.rightChild = Node;
                        return true;
                    }
                } else {
                    //如果插入的值小于等于当前节点，则将其插入到左子树上
                    //切换至左子树
                    current = current.leftChild;
                    //如果左子树为空，则插入节点，否则继续向下查询
                    if (current == null) {
                        parent.leftChild = Node;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 前序遍历
     * @param current
     */
    public void preOrder(Node current) {
        //如果当前节点不空
        if (current != null) {
            //打印当前节点
            System.out.print(current.getValue() + " ");
            //递归左子树
            preOrder(current.leftChild);
            //递归右子树
            preOrder(current.rightChild);
        }
    }

    /**
     * 中序遍历
     * @param current
     */
    public void midOrder(Node current) {
        //如果当前节点不空
        if (current != null) {
            //递归左子树
            midOrder(current.leftChild);
            //打印当前节点
            System.out.print(current.getValue() + " ");
            //递归右子树
            midOrder(current.rightChild);
        }
    }

    /**
     * 后序遍历
     * @param current
     */
    public void postOrder(Node current) {
        //如果当前节点不空
        if (current != null) {
            //递归左子树
            postOrder(current.leftChild);
            //递归右子树
            postOrder(current.rightChild);
            //打印当前节点
            System.out.print(current.getValue() + " ");
        }
    }

    /**
     * 查找最大节点-一路向右
     * @return
     */
    public Node findMax() {
        Node current = root;
        Node maxNode = current;
        while (current != null){
            maxNode = current;
            current = current.rightChild;
        }
        return maxNode;
    }

    /**
     * 查找最小节点-一路向左
     * @return
     */
    public Node findMin() {
        Node current = root;
        Node maxNode = current;
        while (current != null){
            maxNode = current;
            current = current.leftChild;
        }
        return maxNode;
    }

    /**
     * 删除节点
     *
     * @param value
     * @return
     */
    public boolean delete(int value) {
        //定义当前节点
        Node current = root;
        Node parent = null;
        //是否是左子节点
        boolean isLeftChild = false;
        //查找删除值，找不到返回
        while(current.getValue() != value){
            parent = current;
            if (value > current.getValue()){
                isLeftChild = false;
                current = current.rightChild;
            }else {
                isLeftChild = true;
                current = current.leftChild;
            }
            //如果没找到
            if (current == null){
                return false;
            }
        }
        //如果删除节点是叶节点
        if (current.leftChild == null && current.rightChild == null){
            //如果当前节点是根节点
            if (current == root){
                root = null;
            }else if (isLeftChild){//如果是左子节点
                parent.leftChild = null;
            }else{//如果是右子节点
                parent.rightChild = null;
            }
            return true;
        }else if (current.leftChild != null && current.rightChild == null){//如果删除节点有只有一个左子节点
            //如果当前节点是根节点
            if (current == root){
                root = root.leftChild;
            }else if (isLeftChild){//如果是左子节点
                parent.leftChild = current.leftChild;
            }else{//如果是右子节点
                parent.rightChild = current.leftChild;
            }
            return true;
        }else if (current.leftChild == null && current.rightChild != null){//如果删除节点有只有一个右子节点
            //如果当前节点是根节点
            if (current == root){
                root = root.rightChild;
            }else if (isLeftChild){//如果是左子节点
                parent.leftChild = current.rightChild;
            }else{//如果是右子节点
                parent.rightChild = current.rightChild;
            }
            return true;
        }else{//当前存在两个子节点
            //获取当前节点的后继节点：中序遍历的后继节点
            Node successor = getSuccessor(current);
            //如果当前节点是根节点
            if (current == root){
                successor = root;
            }else if (isLeftChild){//如果是左子节点
                parent.leftChild = successor;
            }else{//如果是右子节点
                parent.rightChild = successor;
            }
            //交接工作
            successor.leftChild = current.leftChild;
            return true;
        }
    }

    /**
     * 获取节点的中序遍历后续节点
     * @param delNode
     * @return
     */
    private Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;
        //寻找中序遍历的后继节点
        while (current!= null){
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        //将后继节点替换删除节点
        if (successor != delNode.rightChild){
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }

    /**
     * <p>测试二叉树</p>
     * @author hanchao 2018/5/13 15:56
     **/
    public static void main(String[] args) {
         BinaryTree bt = new BinaryTree();
         bt.midOrder(bt.getRoot());

         //插入节点
        bt.insert(1);
        bt.insert(9);
        bt.insert(2);
        bt.insert(4);
        bt.insert(7);
        bt.insert(8);
        bt.midOrder(bt.getRoot());
        //查找最值
        System.out.println("\nmax:" + bt.findMax().getValue());
        System.out.println("min:" + bt.findMin().getValue());
    }
}
