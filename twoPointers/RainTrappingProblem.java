public class RainTrappingProblem {

    static public int trap(int[] height) {
        int waterBlocks = 0;
        int n = height.length;
        int left[] = new int[n];
        int right[] = new int[n];

        int maxHeightLeft = height[0];
        int maxHeightRight = height[n - 1];
        for (int i = 0; i < n; i++) {
            if (height[i] > maxHeightLeft) {
                maxHeightLeft = height[i];
            }
            left[i] = maxHeightLeft;
        }
        for (int i = n - 1; i >= 0; i--) {
            if(height[i] > maxHeightRight){
                maxHeightRight = height[i];
            }
            right[i] = maxHeightRight;
        }


        for(int i=0;i<n;i++){
            waterBlocks += Math.min(left[i],right[i])-height[i];
        }
        return waterBlocks;
    }

    static void display(int arr[]) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        int waterBlocks = trap(height);
        System.out.println(waterBlocks);
    }
}
