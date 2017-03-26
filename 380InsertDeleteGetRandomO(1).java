/*
380. Insert Delete GetRandom O(1)
Design a data structure that supports all following operations in average O(1) time.

insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
Example:

// Init an empty set.
RandomizedSet randomSet = new RandomizedSet();

// Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomSet.insert(1);

// Returns false as 2 does not exist in the set.
randomSet.remove(2);

// Inserts 2 to the set, returns true. Set now contains [1,2].
randomSet.insert(2);

// getRandom should return either 1 or 2 randomly.
randomSet.getRandom();

// Removes 1 from the set, returns true. Set now contains [2].
randomSet.remove(1);

// 2 was already in the set, so return false.
randomSet.insert(2);

// Since 2 is the only number in the set, getRandom always return 2.
randomSet.getRandom();
*/

// HashMap,ArrayList

//假如我们用ArrayList来实现,我们知道在ArrayList末尾插入的时间复杂度是O(1),根据ArrayList的下标获取数值的时间复杂度也是O(1),但是从ArrayList当中删除数字的时候,后面的元素是需要逐个往前移动的,也就是时间复杂度是O(n),那我们应该怎么实现呢?

//我们可以这样来实现,我们把插入的数字和它的下标都存到一个map中,然后当需要删除数字的时候,我们先取得它的下标,然后和ArrayList末尾的数字交换,然后把ArrayList末尾的数字删除即可,因为每次都是删除末尾的数字,不涉及到元素的移动,所以时间复杂度是O(1)。

// rand.nextInt(int n) 返回0(包括)和n(不包括)之间的一个伪随机数

import java.util.Random;
public class RandomizedSet {

    List<Integer> list;
    Map<Integer,Integer> map;
    Random rand;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        list=new ArrayList<>();
        map=new HashMap<>();
        rand=new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        map.put(val,list.size());
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int index=map.get(val);
        if(index!=list.size()-1){
            int last=list.get(list.size()-1);
            list.set(index,last);
            map.put(last,index);
        }
        map.remove(val);
        list.remove(list.size()-1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */