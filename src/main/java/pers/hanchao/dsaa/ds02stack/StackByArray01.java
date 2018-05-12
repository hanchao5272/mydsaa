package pers.hanchao.dsaa.ds02stack;

import java.util.Arrays;

/**
 * <p>通过数组实现简单的栈</p>
 *
 * @author hanchao 2018/5/12 11:17
 **/
public class StackByArray01 {
    /**
     * 定义一个数组存放元素
     **/
    private int[] elements;
    /**
     * 定义容量
     **/
    private int capacity;
    /**
     * 定义当前栈顶所在位置
     */
    private int top;

    public StackByArray01(int capacity) {
        this.capacity = capacity;
        //空栈时栈顶为-1
        top = -1;
        elements = new int[capacity];
    }

    /**
     * 进栈
     *
     * @param value
     */
    public void push(int value) {
        //如果满栈，则不能再进入
        if (top >= capacity - 1) {
            System.out.println("满栈!");
        } else {
            //栈顶上浮
            top++;
            //赋值
            elements[top] = value;
        }
    }

    /**
     * 出栈
     */
    public int pop() {
        //如果空栈，则不能pop
        if (top == -1) {
            System.out.println("空栈！");
            return Integer.MIN_VALUE;
        } else {
            //获取栈顶值
            int value = elements[top];
            //栈顶下降
            top--;
            return value;
        }
    }

    /**
     * 访问栈顶并不弹出
     *
     * @return
     */
    public int peek() {
        //如果空栈，则不能pop
        if (top == -1) {
            System.out.println("空栈！");
            return Integer.MIN_VALUE;
        } else {
            //获取栈顶值
            return elements[top];
        }
    }

    /**
     * 是否空栈
     *
     * @return
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 是否满栈
     *
     * @return
     */
    public boolean isFull() {
        return top == capacity - 1;
    }

    @Override
    public String toString() {
        int[] now;
        if (!isEmpty()){
           now = Arrays.copyOfRange(elements,0,top + 1);
        }else {
            now = new int[0];
        }
        return "StackByArray01{" +
                "elements=" + Arrays.toString(now) +
                ", capacity=" + capacity +
                ", top=" + top +
                '}';
    }

    /**
     * <p>测试</p>
     *
     * @author hanchao 2018/5/12 11:31
     **/
    public static void main(String[] args) {
        //初始化
        StackByArray01 stack = new StackByArray01(5);
        System.out.print("初始栈：" + stack);
        System.out.print(",是否空栈：" + stack.isEmpty());
        System.out.println(",是否满栈：" + stack.isFull());

        //连续进栈
        stack.push(5);
        System.out.println("当前栈：" + stack);
        stack.push(4);
        System.out.println("当前栈：" + stack);
        stack.push(3);
        System.out.println("当前栈：" + stack);
        stack.push(2);
        System.out.println("当前栈：" + stack);
        stack.push(1);
        System.out.println("当前栈：" + stack);
        stack.push(0);
        System.out.print("当前栈：" + stack);
        System.out.print(",是否空栈：" + stack.isEmpty());
        System.out.println(",是否满栈：" + stack.isFull());

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
        System.out.println(",是否满栈：" + stack.isFull());
        stack.pop();

        System.out.println(stack.peek());
    }
}
