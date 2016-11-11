/*
155. Min Stack

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
*/

public class MinStack {
    
    private final Stack<Integer> min;
    private final Stack<Integer> stk;

    /** initialize your data structure here. */
    public MinStack() {
        this.min = new Stack<Integer>();
        this.stk = new Stack<Integer>();
    }
    
    public void push(int x) {
        this.stk.push(x);
        if (this.min.size() == 0 || x <= this.min.peek()) {
            this.min.push(x);
        }
    }
    
    public void pop() {
        int last = this.stk.pop();
        if (last == this.min.peek()) {
            this.min.pop();
        }
    }
    
    public int top() {
        return this.stk.peek();
    }
    
    public int getMin() {
        return this.min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

 /* Test case
["MinStack","push","push","push","push","pop","getMin","pop","getMin","pop","getMin"]
[[],[512],[-1024],[-1024],[512],[],[],[],[],[],[]]
*/