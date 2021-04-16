import java.util.Arrays;
import java.util.HashMap;

public class Code01_TwoSum {

    /**
     * 1. 【数组题】两数之和
     *
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那两个整数，并返回它们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * 你可以按任意顺序返回答案。
     *
     * 示例 1：
     *
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     * 示例 2：
     *
     * 输入：nums = [3,2,4], target = 6
     * 输出：[1,2]
     * 示例 3：
     *
     * 输入：nums = [3,3], target = 6
     * 输出：[0,1]
     *
     */
    public static void main(String[] args) {
        int[] nums = {2,5,5,22};
        int target = 10;
        Code01_TwoSum method = new Code01_TwoSum();
        //暴力解法 time complexity is O(N²)
        int[] twoSum = method.twoSum(nums, target);
        System.out.println("Result 1 = " + Arrays.toString(twoSum));
        //哈希表 time complexity is O(N)
        int[] twoSum2 = method.twoSum2(nums, target);
        System.out.println("Result 2 = " + Arrays.toString(twoSum2));
    }


    /**
     * 解法一：暴力解法
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    /**
     * 解法二：哈希表
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        int len = nums.length;
        HashMap<Integer, Integer> hashMap = new HashMap<>(len - 1);
        hashMap.put(nums[0],0);
        for (int i = 1 ; i < len; i++) {
            if (hashMap.containsKey(target - nums[i])){
                return new int[]{i,hashMap.get(target - nums[i])};
            }
            hashMap.put(nums[i],i);
        }
        return new int[0];
    }
}
