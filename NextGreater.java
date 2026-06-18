// Time Complexity : O(4N) => O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yES
// Any problem you faced while coding this : NO 


// Your code here along with comments explaining your approach
// We can use a MONOTONIC stack to keep track of the indices of the elements in the array.
// We iterate through the array twice (to handle the circular nature) and for each element, we check if it is greater than the element at the index on the top of the stack.
// If it is, we pop the index from the stack and set the result for that index to the current element.
//  We repeat this process until we find an element that is not greater than the element at the index on the top of the stack or until the stack is empty. 
// Finally, we push the current index onto the stack. This way, we ensure that the indices in the stack are in decreasing order of their corresponding elements.
// as it is circular we use the modulo operator to get the correct index in the original array.
//  We only push indices from the first pass to avoid overwriting results from the second pass.



import java.util.*;

class Solution {

    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;

        int[] result = new int[n];
        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 2 * n; i++) {

            while (!stack.isEmpty()
                    && nums[i % n] > nums[stack.peek()]) {

                int index = stack.pop();

                result[index] = nums[i % n];
            }

            if (i < n) {
                stack.push(i);
            }
        }

        return result;
    }
}