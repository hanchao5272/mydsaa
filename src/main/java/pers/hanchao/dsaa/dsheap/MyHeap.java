package pers.hanchao.dsaa.dsheap;

import org.apache.commons.lang3.RandomUtils;

/**
 * <p>自定义堆</p>
 * @author hanchao 2018/5/13 22:00
 **/
public class MyHeap {
    /** 用数组存储堆节点 */
    private Node[] heapArray;
    /** 容量 */
    private int capacity;
    /** 用量 */
    private int size;

    public MyHeap(int capacity) {
        this.capacity = capacity;
        heapArray = new Node[this.capacity];
        this.size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == capacity;
    }

    /**
     * 插入
     * @param value
     */
    public void insert(int value){
        //满返回
        if (isFull()){
            return;
        }
        //将新节点添加到最后的空白节点上
        Node node = new Node(value);
        //获取最后空白节点下标
        int index = size;
        heapArray[index] = node;
        //将新添加的节点进行向上调整
        upward(index);
        size ++;
    }

    /**
     * 向上调整
     * 下标index的父节点下标为（index - 1）/2
     * @param index
     */
    private void upward(int index) {
        //获取父节点下标
        int parentIndex = (index - 1) / 2;
        //获取新添加的节点
        Node current = heapArray[index];
        //如果当前节点值大于父节点，则向上调整
        while (index > 0 && current.getDate() > heapArray[parentIndex].getDate()){
            //将父节点值复制至当前节点
            heapArray[index] = heapArray[parentIndex];
            //将当前节点下标上升至父节点下标出
            index = parentIndex;
            //重新计算父节点
            parentIndex = (index - 1) / 2;
        }
        //对最终上升到的下标位置继续赋值
        heapArray[index] = current;
    }

    /**
     * 删除根节点
     * @return
     */
    public Node remove(){
        //获取根节点
        Node temp = heapArray[0];
        //获取最后一个节点的下标
        int index = size - 1;
        //将最后一个节点移动至根节点
        heapArray[0] = heapArray[index];
        //对当前根节点进行向下调整
        downward(0);
        //将用量自减
        size --;
        return temp;
    }

    /**
     * 向下调整
     * 下标index的左子节点下标：2*index + 1
     * 下标index的右子节点下标：2*index + 2
     * @param index
     */
    private void downward(int index) {
        //获取父节点
        Node parent = heapArray[index];
        //定义最大子节点的下标
        int largerChildIndex;
        //当节点至少有一个子节点时
        while(index < size / 2){
            //左子节点下标
            int leftChildIndex = 2 * index + 1;
            //右子节点左边
            int rightChildIndex = leftChildIndex + 1;
            //找到比当前父节点大的子节点
            //如果右子节点存在且右子节点大于左子节点，则选用右子节点
            if (rightChildIndex < size //有节点存在
                    && heapArray[rightChildIndex].getDate() > heapArray[leftChildIndex].getDate()){
                largerChildIndex = rightChildIndex;
            }else {//其他情况都是左子节点大，选用左子节点
                largerChildIndex = leftChildIndex;
            }
            //如果当前父节点大于等于最大的子节点,则调整完毕，结束循环
            if(parent.getDate() >= heapArray[largerChildIndex].getDate()){
                break;
            }
            //继续循环
            //将大的子节点向上移动
            heapArray[index] = heapArray[largerChildIndex];
            //将当前父节点向下移动
            index = largerChildIndex;
        }
        //将节点值赋值给最终停留的下标位置
        heapArray[index] = parent;
    }

    /**
     * 按照下标修改值
     * @param index
     * @param newValue
     * @return
     */
    public boolean change(int index,int newValue){
        //不合法判断
        if (index < 0 || index >= size){
            return false;
        }
        //获取旧值
        int oldValue = heapArray[index].getDate();
        //修改值
        heapArray[index].setDate(newValue);
        //如果当前值变大了，则需要向上调整
        if (newValue > oldValue){
            upward(index);
        }else if (newValue < oldValue){
            //如果当前值变小了，则需要向下调整
            downward(index);
        }
        return true;
    }

    public void display(){
        System.out.print("heap[");
        for (int i = 0; i < size; i++) {
            if (heapArray[i] != null){
                System.out.print(heapArray[i] + " ");
            }else {
                System.out.println("_ ");
            }
        }
        System.out.println("]");
    }

    /**
     * <p>测试堆</p>
     * @author hanchao 2018/5/13 22:41
     **/
    public static void main(String[] args) {
         MyHeap heap = new MyHeap(10);
         heap.display();
         //入堆
        for (int i = 0; i < 10; i++) {
            heap.insert(RandomUtils.nextInt(10,100));
            heap.display();
        }
        System.out.println();
        //出堆
        for (int i = 0; i < 10; i++) {
            System.out.print(heap.remove().getDate() + " ");
        }
    }
}
