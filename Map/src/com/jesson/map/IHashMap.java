package com.jesson.map;

public class IHashMap<K, V> implements IMap<K, V> {
	
	private static int defaultLen = 16;//Ĭ�ϳ���
	private static double defaultLoad = 0.75;//��������
	private Entry<K,V>[] table = null;
	private static int size = 0;//Ԫ�ظ���
	
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
			//��������д�������
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
	 * ��ȡ�����±�
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
