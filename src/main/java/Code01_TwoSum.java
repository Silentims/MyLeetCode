import javax.xml.transform.Result;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author xiangjx
 * @description 两数之和
 * @date 2021/4/3 1:59 上午
 */
public class Code01_TwoSum {

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
