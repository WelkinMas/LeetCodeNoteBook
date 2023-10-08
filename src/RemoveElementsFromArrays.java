//      27.移除元素
//      给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
//      不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
//      元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

import java.util.Arrays;

public class RemoveElementsFromArrays {
    public static void main(String[] args) {
        int[] array = {3,2,2,3};
        int i = removeElement(array, 3);
        System.out.println(i);
        System.out.println(Arrays.toString(array));
    }

    // 这个解法的精髓之处在于，虽然是用left指针进行的for循环，看上去是在对数组从左到右进行遍历
    // 但实际上，for的每次循环，确定的是一个排在数组后部的需要被删除的元素
    // 正向遍历，但确定元素却是反向的
    public static int removeElement(int[] nums, int val) {
        int right = nums.length - 1;
        //从头开始遍历nums，且循环上限会根据每次找到需要移除的元素而减少
        //因为每次right指针移动，都代表了一个需要被删除的元素被放到了数组的最后
        for (int left = 0; left <= right; left++) {
            //如果找到了需要删除的元素,就将左右指针的元素互换
            if (nums[left] == val) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                //交换之后并不代表left指针就可以向右移动了，因为注意观察nums[left]==val
                //这个判断条件确定是nums[left]这个元素我们不需要，所以要交换到数组后面去
                //但我们并没有对从后部交换过来的nums[right]（现在是nums[left]）这个元素进行过判断
                //所以这个nums[right](现在是nums[left])有可能跟val相等
                //所以需要对left指针向左回拨，对交换过来的nums[right](现在是nums[left])再进行判断nums[left]==val
                left--;
                //右指针向左移动,因为符合了if条件，进行了交换操作，此时right指针指向的元素一定是需要被删除的元素
                //那么就不需要再管排在数组后部的需要被删除的元素了，指针向左移动
                right--;
            }
        }
        //right是下标的值，因为要返回最终数组的元素数，所以需要+1
        return right + 1;
    }

}
