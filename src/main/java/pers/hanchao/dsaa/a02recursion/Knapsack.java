package pers.hanchao.dsaa.a02recursion;

/**
 * 背包问题
 */
public class Knapsack {
    //货物
    private int[] weights;
    //是否被选择
    private boolean[] selects;

    public Knapsack(int[] weights) {
        this.weights = weights;
        selects = new boolean[weights.length];
    }

    /**
     * 找出符合承重的组合
     * @param total 目标总重量
     * @param index 可供选择的重量下标
     */
    public void knapsack(int total,int index){
        //如果目标总重量为负值或无可供选择的重量，则返回
        if(total < 0 || total > 0 && index >= weights.length){
            return;
        }
        //如果总重量为0，则找到解决办法了
        if (total == 0){
            for (int i = 0; i < index; i++) {
                if (selects[i]){
                    System.out.print(weights[i] + " ");
                }
            }
            System.out.println();
            return;
        }
        //
        selects[index] = true;
        knapsack(total - weights[index],index + 1);
        selects[index] = false;
        knapsack(total,index + 1);
    }

    /**
     * <p></p>
     * @author hanchao 2018/5/13 10:27
     **/
    public static void main(String[] args) {
        int array[] = {11,9,7,6,5};
        int total = 20;
        Knapsack k = new Knapsack(array);
        k.knapsack(total, 0);
    }
}
