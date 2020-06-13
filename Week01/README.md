

### 算法作业

1.移动零

> 双指针法：j 记录非零元素的个数，指向数组中第一个0的位置

```java
class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 1){
            return ;
        }
        for (int i = 0, j = 0; i < nums.length; i++){
            if (nums[i]  != 0){
                if (i != j){
                    nums[j] = nums[i];
                    nums[i] = 0;
                } 
                j++;
            }
        }
    }
}
```

2.两数之和

> 解法一：暴力法

```java
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return null;
    }
}
```

> 解法二：哈希法(将元素存到哈希表，降低查找元素的时间复杂度)

```java
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        Map<Integer,Integer> temp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int res = target - nums[i];
            Integer j;
            if ((j = temp.get(res)) != null) {
                return new int[] { i, j };
            }
            temp.put(nums[i], i);
        }
        return null;
    }
}
```





