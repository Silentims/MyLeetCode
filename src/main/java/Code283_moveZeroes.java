import java.util.Arrays;

/**
 * @author xiangjx
 * @description 移动零
 * @date 2021/4/7 4:52 下午
 * @Version 1.0
 */
public class Code283_moveZeroes {

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     * 示例:
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     *
     * 说明:
     * 必须在原数组上操作，不能拷贝额外的数组。
     * 尽量减少操作次数。
     *
     * @param args
     */
    public static void main(String[] args) {

        int[] nums = {0,1,0,0,3,12,0,0,1,0};
        Code283_moveZeroes method = new Code283_moveZeroes();
        System.out.println("nums 移动前= " + Arrays.toString(nums));
        method.moveZeroes(nums);
        System.out.println("=================");
        method.moveZeroes2(nums);

    }


    /**
     * 这种方法用到两次 for 循环，时间复杂度为 O(N²)
     *
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.7 MB, 在所有 Java 提交中击败了59.30%的用户
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int index = 0;
        //移动所有非零元素
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                nums[index] = nums[i];
                index++;
            }
        }
        //将 index 后边的元素直接添加为零
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
        System.out.println("nums 移动后= " + Arrays.toString(nums));

    }

    /**
     * 优化方案：在原本交换的基础上，直接将 index 位置上的零给 i 位置，这样一来，每次交换非零数之后，原本非零位置就都是 0
     */
    public void moveZeroes2(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                index++;
            }
        }
        System.out.println("nums 移动后= " + Arrays.toString(nums));

    }



}
