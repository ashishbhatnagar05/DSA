package leetcodepractise;

public class MaximunSum {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{
                -2, 1, -3, 4, -1, 2, 1, -5, 4
        }));
    }

    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i <= nums.length - 1; i++) {
            sum = sum + nums[i];
            maxi = Math.max(sum, +maxi);
            if (sum < 0)
                sum = 0;
        }
        return maxi;
    }
}
