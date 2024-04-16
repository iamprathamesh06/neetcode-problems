package twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

    static List<List<Integer>> ThreeSumSolutionBruteforce(int nums[]) {
        List<List<Integer>> solution = new ArrayList<List<Integer>>();

        HashSet<List<Integer>> solutionSet = new HashSet<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k]));
                        list.sort((a, b) -> a - b);
                        solutionSet.add(list);
                    }
                }
            }
        }

        for (List<Integer> list : solutionSet) {
            solution.add(list);
        }

        return solution;
    }

    static List<List<Integer>> ThreeSumSolutionBetter(int nums[]) {
        List<List<Integer>> solution = new ArrayList<List<Integer>>();
        HashSet<List<Integer>> solutionSet = new HashSet<List<Integer>>();

        for (int i = 0; i < nums.length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                int third = -(nums[i] + nums[j]);
                if (set.contains(third)) {
                    ArrayList<Integer> list = new ArrayList<>(Arrays.asList(nums[i], nums[j], third));
                    list.sort((a, b) -> a - b);
                    solutionSet.add(list);
                }
                set.add(nums[j]);
            }
        }

        for (List<Integer> list : solutionSet) {
            solution.add(list);
        }

        return solution;
    }

    static List<List<Integer>> ThreeSumSolutionBest(int nums[]) {
        List<List<Integer>> solution = new ArrayList<List<Integer>>();

        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    solution.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1])
                        j++;
                    while (j < k && nums[k] == nums[k + 1])
                        k++;
                }

            }
        }

        return solution;
    }

    static void display(List<List<Integer>> solution) {
        for (List<Integer> list : solution) {
            System.out.print("{");
            list.forEach(i -> {
                System.out.print(i + " ");
            });
            System.out.print("}");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int nums[] = { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> list = ThreeSumSolutionBest(nums);
        display(list);
    }
}