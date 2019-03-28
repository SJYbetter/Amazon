/*
Create a temporary stack say tmpStack.
While input stack is NOT empty do this:
Pop an element from input stack call it temp
while temporary stack is NOT empty and top of temporary stack is greater than temp,
pop from temporary stack and push it to the input stack
push temp in temporary stack
The sorted numbers are in tmpStack
*/

public Stack<Integer> stackSort(int[] nums){
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    for (int i : nums){
        stack1.push(i);
    }

    while ( !stack1.isEmpty() ){
        // pop out the first element
        int temp = stack1.pop();
        // while temporary stack is not empty and top of stack is greater than temp
        while (!stack2.isEmpty() && stack2.peek() > temp){
            stack1.push(stack2.pop());
        }
        // push temp in tempory of stack 
        stack2.push(temp);
    }

    return stack2;

}
