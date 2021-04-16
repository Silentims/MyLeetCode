public class Code485_FindMaxConsecutiveOnes {


    /**
     * 485. 【数组题】最大连续 1 的个数
     *
     *
     *
     * 给定一个二进制数组， 计算其中最大连续 1 的个数。
     *
     * @param args
     */
    public static void main(String[] args) {

        int[] nums = new int[]{1,1,1,0,1,1,1,1,0,1,1,0};

        Code485_FindMaxConsecutiveOnes method = new Code485_FindMaxConsecutiveOnes();
        int maxConsecutiveOnes = method.findMaxConsecutiveOnes(nums);
        System.out.println("count max = " + maxConsecutiveOnes);

    }


    /**
     * 初次的写法
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        //当数组为空时直接返回0
        int count =0;
        if (nums == null || nums.length == 0){
            return count;
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            //等于1时，计数
            if (nums[i] == 1) {
                count++;
            }
            //等于0时，count需要清零，若count比result大，则将清零前的count作为result
            if (nums[i] == 0){
                if (count > result){
                    result = count;
                }
                count = 0;

            }
        }
        //因为for最后一个可能是1，则循环里的count是计数，所以循环结束后需要再次与result进行比较
        if (count > result){
            result = count;
        }
        return result;
    }


    /**
     * 可以优化的写法
     */
    public int findMaxConsecutiveOnes_2(int[] nums) {
        //当数组为空时直接返回0
        if (nums == null || nums.length == 0){
            return 0;
        }
        int count =0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            //等于1时，计数
            if (nums[i] == 1) {
                count++;
            }else {
                //等于0时，count需要清零，若count比result大，则将清零前的count作为result
                result = Math.max(count, result);
                count =  0;
            }
        }
        //因为for最后一个可能是1，则循环里的count是计数，所以循环结束后需要再次与result进行比较
        result = Math.max(count, result);
        return result;
    }
}