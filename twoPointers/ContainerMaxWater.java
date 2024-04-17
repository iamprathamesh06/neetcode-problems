public class ContainerMaxWater {

    static public int maxArea(int[] height) {
        int maximumArea = 0;
        int n = height.length;

        // for (int start = 0; start < n; start++) {
        //     for (int end = start + 1; end < n; end++) {
        //         int width = end - start;
        //         int minHeight = Math.min(height[start],height[end]);
        //         maximumArea = Math.max(maximumArea, minHeight * width);
        //     }
        // }


        int start = 0;
        int end = n-1;

        while(start<end){
            int minHeight = Math.min(height[start],height[end]);
            int width = end - start;
            maximumArea = Math.max(maximumArea, width*minHeight);

            while(start<end && height[start]<=minHeight) start++;
            while(start<end && height[end]<=minHeight) end--;
            
        }

        return maximumArea;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        int maximumArea = maxArea(arr);
        System.out.println(maximumArea);
    }
}