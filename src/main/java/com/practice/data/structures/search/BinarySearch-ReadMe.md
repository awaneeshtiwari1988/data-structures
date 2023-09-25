<h1>Binary Search</h1>

The binary search divides the input array by half at every step. After every step, either we find the index we are looking for, or we discard half of the array.

<h3>Binary Search Applications</h3>
<p>
    Binary search is a widely used and efficient algorithm for finding a specific target value, within a <b>sorted array or list</b>.It works by repeatedly 
dividing the search interval in half until the target value is found or it is determined that the value does not exist in the array.
</p>

Binary search is significantly faster than linear search, especially for large datasets, because it eliminates half of the remaining elements at each step.

<h3>Working of Binary Search Algorithm</h3>

<h4>Step 1: Initialization</h4> Binary search begins with a sorted array or list and two pointers, one pointing to the start of the array (left) and the other to the end of the array (right).
<h4>Step 2: Finding Middle</h4> Calculate the midpoint between the left and right pointers. This is usually done by taking the average of the two pointers, i.e., mid = left + (right-left) / 2. This covers all use cases.
<h4>Step 3: Comparison</h4> Compare the value at the midpoint with the target value <br/>
    <b>-</b> If the value at the midpoint is equal to the target value, the search is successful.<br/>
    <b>-</b> If the value at the midpoint is greater than the target value, update the right pointer to be one less than the midpoint, effectively eliminating the right half of the search interval.<br/>
    <b>-</b> If the value at the midpoint is less than the target value, update the left pointer to be one more than the midpoint, effectively eliminating the left half of the search interval.<br/>
<h4>Step 4: Iteration</h4> Repeat steps 2 and 3 until one of the following conditions is met:
    <b>-</b> The target value is found (the value at the midpoint equals the target). This will be handled by breaking out of the loop.<br/> 
    <b>-</b> The left pointer is greater than the right pointer, indicating that the target value is not in the array. This will be handled by checking (left <= right)<br/>

<h3>Time Complexity</h3>
Binary search continues to divide the search interval in half with each iteration, which means it can quickly narrow down the possible locations of the target value. <br/>

<b>Its time complexity is O(log n)</b>, where n is the number of elements in the sorted array.
This is in contrast to <b>linear search, which has a time complexity of O(n)</b> and would require examining every element in the worst case.

<h3>Space Complexity</h3>
The non-recursive solution has space complexity of O(1), whereas recursive solution has O(log n).

<b>Note:</b> Binary search is an essential algorithm used in various applications, including searching in databases, dictionaries, and phonebooks, as well as in many programming tasks where efficient searching is required.