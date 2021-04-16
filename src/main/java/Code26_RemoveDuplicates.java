import java.util.Arrays;

public class Code26_RemoveDuplicates {

    /**
     * 26. 【数组题】删除有序数组中的重复项
     *
     * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     *
     *示例 1：
     *
     * 输入：nums = [1,1,2]
     * 输出：2, nums = [1,2]
     * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
     * 示例 2：
     *
     * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
     * 输出：5, nums = [0,1,2,3,4]
     * 解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
     */
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        Code26_RemoveDuplicates method = new Code26_RemoveDuplicates();
        int result = method.removeDuplicates(nums);

        System.out.println("result = " + result);
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length ==0){
            return 0;
        }
        //从第一个数开始循环，后边一个数i如果与之j不相等，则移动开始的数j，将不相等的数i移植初始值j的后边一位（这个逻辑就会过滤比 j 大的重复的数，），然后从循环结束
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }
        }
        System.out.println("Arrays.toString(nums) = " + Arrays.toString(nums));
        return j+1;
        
    }

    /**
     * {0,0,1,1,1,2,2,3,3,4};
     *  ↑ ↑
     *  j i
     *
     * {0,1,1,1,1,2,2,3,3,4};
     *
     *
     */

}
