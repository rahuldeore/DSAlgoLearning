package com.rahul.dsalgo.datastructureImpl.logical;

import com.rahul.dsalgo.datastructure.logical.HashSet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rahul on 1/17/22
 */
public class HashSetImpl implements HashSet{
    ArrayList<Integer>[] hashSet;
    public HashSetImpl(){
        hashSet= new ArrayList[1000 + 1];
    }

    private Integer getHash(Integer key) {
        return key/1000;
    }

    @Override
    public void add(int key) {
        int index = getHash(key);
        if (hashSet[index] == null) {
            hashSet[index] = new ArrayList<Integer>();
        }
        ArrayList<Integer> list = hashSet[index];
        if (!list.contains(key)) {
            list.add(key);
            System.out.println("Key: " + key + " added to list");
        } else {
            System.out.println("Key: " + key + " already present in the list");
        }

    }

    @Override
    public void remove(int key) {
        Integer hashIndex = getHash(key);
        Integer index = getKeyIndex(key);
        if (hashIndex != null && index != null) {
            List<Integer> list = hashSet[hashIndex];
            list.remove((int)index);
        }
    }

    private Integer getKeyIndex(int key) {
        int indexHash = getHash(key);
        List<Integer> list = hashSet[indexHash];

        if (list != null) {
            for(int i=0; i<list.size(); i++){
                if(list.get(i) == key){
                    return i;
                }
            }
        }
        return null;
    }

    @Override
    public boolean contains(int key) {
        return getKeyIndex(key) != null;
    }

    public static void main(String... args) {
        HashSetImpl hashSetImpl = new HashSetImpl();
        hashSetImpl.add(1);
        hashSetImpl.add(2);
        System.out.println(hashSetImpl.contains(1));
        System.out.println(hashSetImpl.contains(3));
        hashSetImpl.add(2);
        System.out.println(hashSetImpl.contains(2));
        hashSetImpl.remove(2);
        System.out.println(hashSetImpl.contains(2));

    }
}
