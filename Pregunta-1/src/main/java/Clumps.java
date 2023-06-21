public class Clumps {

    public static int countClumps(int []nums){
        int count = 0, temp, val = 0;
        if(nums == null || nums.length ==0 ){
            return 0;
        }
        for (int i = 0; i < nums.length-1; i++) {
            temp = nums[i+1];
            if (nums[i] == temp && val == 0){
                count++;
                val ++;
            }
            if (nums[i] != temp) {
                val = 0;
            }
        }
        return count;
    }
}
