package com.jesson.map;

public class IHashMap<K, V> implements IMap<K, V> {
	
	private static int defaultLen = 16;//默认长度
	private static double defaultLoad = 0.75;//负载因子
	private Entry<K,V>[] table = null;
	private static int size = 0;//元素个数
	
	public IHashMap(){
		this(defaultLen,defaultLoad);
	}
	
	public IHashMap(int length,double defaultLoad){
		this.defaultLen = length;
		this.defaultLoad = defaultLoad;
		table = new Entry[defaultLen];
	}

	@Override
	public void put(K key, V value) {
		
		int index = getIndex(key);
		
		Entry<K,V> e = table[index];
		if(null == e){
			table[index] = new Entry<K, V>(key,value,null,index);
			size ++;
		}else{
			//如果数组中存在数据
			Entry<K,V> next = new Entry<K, V>(key,value,e,index);
			table[index] = next;
		}
	}

	@Override
	public V get(K key) {
		int index = getIndex(key);
		return table[index] != null ? table[index].getValue() : null;
	}

	@Override
	public int size() {
		return size;
	}
	/**
	 * 获取数组下标
	 * @param key
	 * @return
	 */
	private int getIndex(K key){
		int m = this.defaultLen - 1;
		return key.hashCode() % m;
	}
	class Entry<K,V> implements IMap.Entry<K, V>{
		
		private K key;
		private V value;
		private Entry<K,V> next;
		int index;
		Entry(K key,V value,Entry<K,V> next,int index){
			this.key = key;
			this.value = value;
			this.next = next;
			this.index = index;
		}
		

		@Override
		public K getKey() {
			return key;
		}

		@Override
		public V getValue() {
			return value;
		}

		@Override
		public IMap.Entry<K, V> getNext() {
			return next;
		}
		
	}

}
