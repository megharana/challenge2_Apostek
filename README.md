# challenge2_Apostek
Regarding best index

# Best Index
You are given an array **A** of **N** elements. Now you need to choose the best index of this array A. An index of the array is called best if the special sum of this index is maximum across the special sum of all the other indices.

To calculate the special sum for any index ***i*** , you pick the first element that is **A**[***i*** ] and add it to your sum. Now you pick next two elements i.e. **A**[***i+1***] and  **A**[***i+2***]  and add both of them to your sum. Now you will pick the next 3 elements and this continues till the index for which it is possible to pick the elements. For example:

If our array contains 10 elements and you choose index to be  then your special sum is denoted by - (**A**[***i+3***])+(**A**[***i+4***]+**A**[***i+5***])+(**A**[***i+6***]+**A**[***i+7***]+**A**[***i+8***]), beyond this its not possible to add further elements as the index value will cross the value .

Find the best index and in the output print its corresponding special sum. Note that there may be more than one best indices but you need to only print the maximum special sum.

# Input
First line contains an integer  as input. Next line contains  space separated integers denoting the elements of the array .
# Output
In the output you have to print an integer that denotes the maximum special sum

# Sample Input
6
-3 2 3 -4 3 1
# Sample Output
3
