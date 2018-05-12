package pers.hanchao.dsaa.ds02stack;

/**
 * <p>匹配括号</p>
 *
 * @author hanchao 2018/5/12 14:48
 **/
public class MatchBrackets {
    /**
     * <p>通过栈匹配括号</p>
     *
     * @author hanchao 2018/5/12 14:48
     **/
    public static void main(String[] args) {
        //定义测试数据
        String[] strs = {"{11[33(4)7]2}", "{11[33(4]7)2}","11}33]22)"};
        //定义栈
        StackByArray02 stack = new StackByArray02(10);
        for (String str : strs) {
            //定义是否匹配
            boolean match = true;
            //String=>char[]
            char[] chars = str.toCharArray();
            for (char ch : chars) {
                switch (ch) {
                    case '{':
                    case '[':
                    case '(':
                        stack.push(ch);
                        break;
                    case '}':
                    case ']':
                    case ')':
                        //如果栈不空，则进行括号比对
                        if (!stack.isEmpty()) {
                            //获取元素
                            char c = (char) stack.pop();
                            if (ch == '}' && c != '{' || ch == ']' && c != '[' || ch == ')' && c != '(') {
                                System.out.println("括号匹配失败！");
                                match = false;
                            }
                        }else {//如果栈为空，说明新进入的右括号多了，肯定不匹配
                            System.out.println("括号匹配失败！");
                            match = false;
                        }
                        break;
                    default:
                        break;
                }
            }
            System.out.print(str);
            System.out.println(match ? "==>匹配" : "==>不匹配");
            System.out.println();
        }
    }
}
