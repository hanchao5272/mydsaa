package pers.hanchao.dsaa.ds02stack;

import java.util.Arrays;

/**
 * <p>通过数组实现改进的栈</p>
 * @author hanchao 2018/5/12 11:50
 **/
public class StackByArray02 {
    /**
     * 定义一个数组存放元素
     **/
    private Object[] elements;
    /**
     * 定义容量
     **/
    private int capacity;
    /**
     * 定义当前栈顶所在位置
     */
    private int top;

    public StackByArray02(int capacity) {
        if (capacity <= 0){
            System.out.println("初始容量必须大于0");
        }else {
            this.capacity = capacity;
            elements = new Object[capacity];
            top = -1;
        }
    }

    /**
     * 进栈
     * @param obj 进栈对象
     * @return
     */
    public void push(Object obj){
        //如果当前栈满，则扩容
        if (top == capacity - 1){
            expand();
        }
        //栈顶上浮，数据进栈
        this.elements[ ++ top] = obj;
    }

    /**
     * 扩容：二倍扩容，至多至Integer.MAX_VALUE
     */
    private void expand() {
        //计算新的容量大小：如果二倍容量大于最大值，则使用最大值
        capacity = (capacity * 2 > Integer.MAX_VALUE)? Integer.MAX_VALUE : capacity * 2;
        //暂存老数组
        Object[] oldElements = this.elements;
        //重新初始化新数组
        this.elements = new Object[capacity];
        //将老数组的数据拷贝至新数组
        this.elements = Arrays.copyOf(oldElements,capacity);
        System.out.println("经历一次扩容");
    }

    /**
     * 出栈
     * @return
     */
    public Object pop(){
        //空栈返回null
        if (top == -1){
            System.out.println("空栈");
            return null;
        }
        //获取栈顶元素
        Object obj = elements[top];
        //栈顶元素置为null
        elements[top] = null;
        //栈顶自减
        top --;
        //返回栈顶元素
        return obj;
    }

    /**
     * 获取栈顶元素
     * @return
     */
    public Object peek(){
        //空栈返回最小值
        if (top == -1){
            System.out.println("空栈");
            return null;
        }
        //返回栈顶元素
        return elements[top];
    }

    /**
     * 是否空栈
     * @return
     */
    public boolean isEmpty(){
        return top == -1;
    }

    @Override
    public String toString() {
        Object[] validElements = null;
        if (-1 != top){
            validElements = Arrays.copyOf(this.elements,top + 1);
        }else {
            validElements = new Object[0];
        }
        return "StackByArray02{" +
                "elements=" + Arrays.toString(validElements) +
                ", capacity=" + capacity +
                ", top=" + top +
                '}';
    }

    /**
     * <p>测试</p>
     * @author hanchao 2018/5/12 14:15
     **/
    public static void main(String[] args) {
        //初始化
        StackByArray02 stack = new StackByArray02(5);
        System.out.print("初始栈：" + stack);
        System.out.println(",是否空栈：" + stack.isEmpty());

        //连续进栈
        stack.push(5);
        System.out.println("当前栈：" + stack);
        stack.push(4.2D);
        System.out.println("当前栈：" + stack);
        stack.push(3.5F);
        System.out.println("当前栈：" + stack);
        stack.push(false);
        System.out.println("当前栈：" + stack);
        stack.push("Hello World!");
        System.out.println("当前栈：" + stack);
        stack.push('\u0066');
        System.out.print("当前栈：" + stack);
        System.out.println(",是否空栈：" + stack.isEmpty());

        //连续出栈
        stack.pop();
        System.out.println("当前栈：" + stack);
        stack.pop();
        System.out.println("当前栈：" + stack);
        stack.pop();
        System.out.println("当前栈：" + stack);
        stack.pop();
        System.out.println("当前栈：" + stack);
        stack.pop();
        System.out.print("当前栈：" + stack);
        System.out.print(",是否空栈：" + stack.isEmpty());
        System.out.println();
        stack.pop();

        System.out.println(stack.peek());
    }
}
