// Time Complexity : O(2N) => O(N) 
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We can use a MONOTONIC stack to keep track of the indices of the temperatures.
// We iterate through the temperatures array and for each temperature, we check if it is greater than the temperature at the index on the top of the stack.
//  If it is, we pop the index from the stack and calculate the number of days until a warmer temperature by subtracting the popped index from the current index.
//  We repeat this process until we find a temperature that is not greater than the temperature at the index on the top of the stack or until the stack is empty.
//  Finally, we push the current index onto the stack. This way, we ensure that the indices in the stack are in decreasing order of their corresponding temperatures.
 
import java.util.*;

class Solution {

    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;

        int[] result = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty()
                    && temperatures[i] > temperatures[stack.peek()]) {

                int index = stack.pop();

                result[index] = i - index;
            }

            stack.push(i);
        }

        return result;
    }
}