package com.jesson.map;

public interface IMap<K,V> {
	
	public void put(K key,V value);
	
	public V get(K key);
	
	public int size();
	
	interface Entry<K,V>{
		
		K getKey();
		V getValue();
		
		Entry<K,V> getNext();
	}

}
