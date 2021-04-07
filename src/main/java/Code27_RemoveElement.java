public class Code27_RemoveElement {

    /**
     * 移除元素
     *
     * 示例 1：
     * 输入：nums = [3,2,2,3], val = 3
     * 输出：2, nums = [2,2]
     * 解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
     *
     * 示例 2：
     * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
     * 输出：5, nums = [0,1,4,0,3]
     * 解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。
     */

    public static void main(String[] args) {

        int[] nums = {3,2,2,3,1};
        int val = 3;
        Code27_RemoveElement methmod = new Code27_RemoveElement();
        int result = methmod.removeElement(nums, val);
        System.out.println("result = " + result);

    }

    /**
     * 双指针法
     *
     * 定义指针l和r，l从左侧开始，只要不等于val就往右移动，r相反，只要等于val就往左移动，都不移动时，将l和r的值对调
     *      3,2,2,3
     *      ↑   ↑
     *      l   r
     * 此时对调后，数组为2,2,3,3
     * l继续移动，直到
     *      2,2, 3,3
     *          ↑↑
     *          lr
     *  此时因为需要返回的预期值是长度2，所以l或r的索引下标就是2，直接返回l或r
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        if (nums ==null || nums.length ==0) {
            return 0;
        }
        int l = 0;
        int r = nums.length - 1;
        while ( l < r){
            while (l < r && nums[l] != val){
                l++;
            }
            while (l < r && nums[r] == val){
                r--;
            }
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
        }

        if (nums[l] == val){
            return l;
        }else {
            return l+1;
        }

    }

    /**
     * 优化：
     * 采用类似移动零那一题的思路，重新定义数组下标从0开始，for循环数组，只要不等于val就重新往新定义的下标赋值
     * 这样只要等于val的就会被舍弃，就像移动零那一题末尾填充0的做法，只不过这里不需要单独填充，因为只返回数组的长度
     */



}