class Solution {
    public boolean stoneGameIX(int[] stones) {
        int[] arr = new int[3];
        for(int s : stones){
            arr[s % 3]++;
        }
        if(arr[1] == 0 && arr[2] == 0){
            return false;
        }
        if(arr[2] > 0){
            int left = Math.min(arr[2] - 1, arr[1]);
            int c = 1 + arr[0] + left + left;
            if(c % 2 == 1 && (arr[1] - left > 0)){
                return true;
            }else if(c % 2 == 0 && (arr[2] - left - 1 > 1)){
                return true;
            }
        }
        if(arr[1] > 0){
            int left = Math.min(arr[2], arr[1] - 1);
            int c = 1 + arr[0] + left + left;
            if(c % 2 == 1 && (arr[2] - left > 0)){
                return true;
            }else if(c % 2 == 0 && (arr[1] - left - 1 > 1)){
                return true;
            }
        }
        return false;
    }
}