//The idea here is to put all the elements in stack until we find a next greater temperature for an element. When we find the next greater temperature of the element on the top of the stack, we resolve that first by popping it and putting in result and we continue doing that till the stack is empty and temperature is greater than all elements in stack.
//If we pass through and we don't find the next greater temperature, we keep it as 0 in result and return it
//Time Complexity: O(n) where n is the length of the array
//Space Complexity: O(n)

import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int [] result = new int[temperatures.length];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<temperatures.length; i++){
            int curr = temperatures[i];
            while(!st.isEmpty() && curr > temperatures[st.peek()]){
                int poppedIdx = st.pop();
                result[poppedIdx] = i - poppedIdx;
            }
            st.push(i);
        }
        return result;
    }
}