package pers.hanchao.dsaa.dsheap;

/**
 * <p>堆节点</p>
 * @author hanchao 2018/5/13 21:18
 **/
public class Node {
    /** 节点数据 */
    private int date;

    public Node(int date) {
        this.date = date;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Node{" +
                "date=" + date +
                '}';
    }
}
