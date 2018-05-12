package pers.hanchao.dsaa.ds02stack;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * <p>字符串翻转</p>
 * @author hanchao 2018/5/12 14:42
 **/
public class ReversalString {
    /**
     * <p>通过栈实现字符串翻转</p>
     * @author hanchao 2018/5/12 14:43
     **/
    public static void main(String[] args) {
        //随机生产一个字符串
         String str = RandomStringUtils.random(10);
         //将字符串转化成char数组
        char[] chars = str.toCharArray();
        //定义一个栈
        StackByArray02 stack = new StackByArray02(5);
        //将字符依次进栈
        for (char item : chars){
            stack.push(item);
            System.out.println(stack);
        }
        for (int i = 0; i < chars.length; i++) {
            System.out.print(stack.pop() + " ");
        }
    }
}
