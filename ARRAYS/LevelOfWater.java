class LevelOfWater{
    public static void main(String[] args) {
        int [] height = {1,8,6,2,5,4,8,3,7};
        int i = 0;
        int j = height.length-1;
        int maxarea = 0;
        while(i<j){
            int area = Math.min(height[i], height[j]) * (j-i);
            maxarea = Math.max(area,maxarea);
            if(height[i] > height[j]){
                j--;
            }else if(height[i] < height[j]){
                i++;
            }else{
                i++;
                j--;
            } 
        }
        System.out.println(maxarea);
    }
}