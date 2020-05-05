## Find missing number in integer array from 1 to n.
Given to a list of n-1 integers from the array, find the missing in the list.  
e.g. int arr = {1,2,3,4,6,7,8}, missing is 5, n = 9

```java
int getMissing(int[]a, int n ) {
total = ((n+1)*(n+2)) / 2; //actual array size is 9, added +1 
for(int i = 0; i  < n; i++ ){
  total -=a[i]
return total  
}
```
## Print all permutations of a given string
e.g String is  ABC. Permutations are ABC ACB BAC BCA CBA CAB

```java
  public static void main(String[] args) {
    String str = "AB";
    int n = str.length();
    permute(str, 0, n-1);

  }

  public static String swap(String a, int i, int j)
  {
    char temp;
    char[] arr = a.toCharArray();
    temp = arr[i] ;
    arr[i] = arr[j];
    arr[j] = temp;
    return String.valueOf(arr);
  }

  private static void permute(String str, int l, int r)
  {
    if (l == r)
      System.out.println(str);
    else
    {
      for (int i = l; i <= r; i++)
      {
        str = swap(str,l,i);
        permute(str, l+1, r);
        str = swap(str,l,i);
      }
    }
  }
```

## All k-sum paths in a binary tree
Input :
```
  1
 / \
7   3
    / \
   5   4
```   
k = 8, print all root to leaf paths with given sum 
   
Output : 1,7-3,5-1,3,4

```java
static class Node  
{  
    int data;  
    Node left,right;  
    Node(int x)  
    {  
        data = x;  
        left = right = null;  
    }  
};  
static Vector<Integer> path = new Vector<Integer>(); 
static void printKPathUtil(Node root, int k)  
{  
    if (root == null)  
        return;  
    path.add(root.data);  
    printKPathUtil(root.left, k);  
    printKPathUtil(root.right, k);  
    int f = 0;  
    for (int j = path.size() - 1; j >= 0; j--)  
    {  
        f += path.get(j);  
        if (f == k)  
            printVector(path, j);  
    }  
    path.remove(path.size() - 1);  
}  
```




