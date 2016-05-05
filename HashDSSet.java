package com.abc.dsproj.hashset;

import java.util.NoSuchElementException;

//import ChainDSHashTable.Bucket;







import com.abc.ds.DSTools;
import com.abc.ds.action.*;
import com.abc.ds.filter.*;
import com.abc.ds.hash.*;
import com.abc.ds.iterator.*;
import com.abc.ds.keyvalue.DSKeyValuePair;
import com.abc.ds.sack.*;
import com.abc.ds.set.*;
import com.programix.util.*;

public class HashDSSet<T> implements DSSet<T> {
    // Dummy value to share for all the values in the hash table
    private static final Object DUMMY_VALUE = new Object();
    
    
    //private final T[] keyZeroLenArray;

	//private static final T[][] T = null;

  


    private final DSHashTable<T, Object> hashTable;
    //private ChainDSHashTable chain = new ChainDSHashTable<K,V>;	

	private DSKeyValuePair<T, Object>[][] slots;
	private T[] slots1;

    public HashDSSet(Class<T> itemType, int bucketCount) {
        ObjectTools.paramNullCheck(itemType, "itemType");
        hashTable = new ChainDSHashTable<>(itemType, Object.class, bucketCount);
    }

    @Override
    public Class<T> getItemType() {
        return hashTable.getKeyType();
    }

    @Override
    public int count() {
        return hashTable.count();
    }

    @Override
    public boolean isEmpty() {
    	return hashTable.isEmpty();
        //throw new RuntimeException("not implemented yet"); // FIXME
    }

    @Override
    public void clear() {
    	hashTable.clear();
        //throw new RuntimeException("not implemented yet"); // FIXME
    }

    @Override
    public boolean add(T item) {
        int countBefore = hashTable.count();
        hashTable.insert(item, DUMMY_VALUE);
        return hashTable.count() > countBefore;
    }

    @SuppressWarnings("unchecked")
    @Override
    public int addAll(T... items) {
    	if ( items == null || items.length == 0 ) {
            return 0;
          }
    	for (T item : items){
    		hashTable.insert(item, DUMMY_VALUE);
    	}
		
    return hashTable.count();

    	
       // throw new RuntimeException("not implemented yet"); // FIXME
    }

    @Override
    public int addAll(DSSack<T> otherSack) {
    	
    	if(otherSack ==null||otherSack.isEmpty()){
    		return 0;
        //throw new RuntimeException("not implemented yet"); // FIXME
    	}
    	return addAll(otherSack.peekAll());
    }

    @Override
    public boolean remove(T item) {
    	
    	//hashTable.delete(item);
    		return (hashTable.containsKey(item));
    }
    @Override
    public int removeAndCountMatches(DSFilter<T> filter) {
        int countmatches=0;
        int beforeRemove=count();
    	hashTable.deleteKeyMatches(filter);
    	int afterRemove=count();
    	return beforeRemove-afterRemove;
    	//throw new RuntimeException("not implemented yet"); // FIXME
    }

    @Override
    public T[] removeAndReturnMatches(DSFilter<T> filter) {
    	
    	//DSKeyValuePair<K,V> payload = hashTable.extractValues(filter); 
    	DSKeyValuePair<T, Object> [] someItems = hashTable.peekKeyMatches(filter);
    	T[] keyItems= hashTable.extractKeys(someItems);
    	
    	for(T anyItem:keyItems ){
    		remove(anyItem);
    	}
		return keyItems;
    	
    	//for()
    	
       
    	
    	//throw new RuntimeException("not implemented yet"); // FIXME
    }

    @SuppressWarnings("rawtypes")
	@Override
    public T[] removeAll() {
        
    	
    	return removeAndReturnMatches(new MatchEverythingDSFilter());
    	
    	//throw new RuntimeException("not implemented yet"); // FIXME
    }

    @Override
    public boolean contains(T item) {
    	
    	return hashTable.containsKey(item);
    
        //throw new RuntimeException("not implemented yet"); // FIXME
    }

   
	@SuppressWarnings("unchecked")
	@Override
    public T[] peekMatches(DSFilter<T> filter) {
		
    		//extract key and peak matches
    	
		return hashTable.extractKeys(hashTable.peekKeyMatches(filter));
	}
    	
   // return  hashTable.peekKeyMatches(filter); 
	
    

    /*private T[] createPairArray(int count) {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
    public int countMatches(DSFilter<T> filter) {
    	
    	// newLength=hashTable.peekKeyMatches(filter).length;
    return hashTable.peekKeyMatches(filter).length;
   // System.out.println(peekMatchValues);
        //throw new RuntimeException("not implemented yet"); // FIXME
    }
    
	
	 @SuppressWarnings("unchecked")
	public T pop(){
	        if ( isEmpty() ) {
	        	return null;
	            //throw new NoSuchElementException("stack is empty");
	            
	        }
	        
	       int count=count();
	        count--;
	       T item=slots1[count];
			// t =(DSKeyValuePair<T, Object>[]) slots[count()];
	        slots1[count] = null;  // allow garbage collection
	        return item;
	    }

   
    
    @Override
    public T[] peekAll() {
    	
    	return hashTable.extractKeys(hashTable.peekAll());
    	        }
    	        
    
   
	

	@Override
    public int performOnMatches(DSFilter<T> filter, DSAction<T> action) {
		DSKeyValuePair<T, Object> [] someItems = hashTable.peekKeyMatches(filter);
    	T[] keyItems= hashTable.extractKeys(someItems);
    	
    	for(T anyItem:keyItems ){
    		action.perform(anyItem);
    	}
    	return keyItems.length;
		
	
      //  throw new RuntimeException("not implemented yet"); // FIXME
    }

    @Override
    public void performOnAll(DSAction<T> action) {
    	DSKeyValuePair<T, Object> [] someItems = hashTable.peekAll();
    	T[] keyItems=hashTable.extractKeys(someItems);
    	
    	for(T anyItem:keyItems ){
    		action.perform(anyItem);
    	
    	}
	
       // throw new RuntimeException("not implemented yet"); // FIXME
    }

    @Override
    public DSIterator<T> createIterator() {
    	
		return null;
    	
        //throw new RuntimeException("not implemented yet"); // FIXME
    }

    @Override
    public int union(DSSet<T> otherSet) {
    	hashTable.createIterator();
    	
    	
        throw new RuntimeException("not implemented yet"); // FIXME
    }

    @Override
    public void intersection(DSSet<T> otherSet) {
        throw new RuntimeException("not implemented yet"); // FIXME
    }

    @Override
    public void subtract(DSSet<T> otherSet) {
        throw new RuntimeException("not implemented yet"); // FIXME
    }
}
