//The idea here is to keep the elements in stack until we find the next greater element for linear time. This way, we first find the next greater element for the element on top of stack first.
//Because the given array is a circular array and there is a possibility of finding the next greater element to the left of an element, we traverse the array again and do the same thing.
//Time Complexity: O(n)
//Space Complexity: O(n)

import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        for(int i = 0; i < 2*n; i++){
            int k = i%n;
            while(!st.isEmpty() && nums[k] > nums[st.peek()]){
                int poppedIdx = st.pop();
                result[poppedIdx] = nums[k];
            }
            if(i < n){
                st.push(i);
            }
        }
        return result;
    }
}