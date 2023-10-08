//  88.合并两个有序数组
//  给你两个按非递减顺序排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
//  请你合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
//  注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。
//  为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。
//  nums2 的长度为 n 。

import java.util.Arrays;

public class CombineSortedArrays {
    public static void main(String[] args) {
        int[] array1 = {0};
        int[] array2 = {1};
        merge(array1,0,array2,1);
        System.out.println(Arrays.toString(array1));
    }


    public static void merge(int[] nums1, int m, int[] nums2, int n){
        //nums1的指针
        int pointer1 = m-1;
        //nums2的指针
        int pointer2 = n-1;
        //nums1的尾部指针
        int current = m+n-1;
        //
        while(pointer1>=0||pointer2>=0){
            //遍历完的pointer一定会过界即-1
            //反过来理解，过界了的pointer代表着某一个数组已经遍历完毕
            //nums1遍历完毕，而nums2没有遍历完毕的情况下，代表着nums1中的所有元素都比nums2中剩下未遍历的元素要大
            //所以不停地放入nums2的元素直到nums2的元素遍历完即可
            //vice versa
            if(pointer1==-1){
                nums1[current--] = nums2[pointer2--];
            }else if(pointer2==-1){
                nums1[current--] = nums1[pointer1--];
            }else if(nums1[pointer1]>nums2[pointer2]) {
                nums1[current--] = nums1[pointer1--];
            }else{
                nums1[current--] = nums2[pointer2--];
            }
        }
    }
}
