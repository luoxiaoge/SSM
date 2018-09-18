package com.socode.lyf.interview.OverrideHashMap;

/**
 * Function: TODO
 *
 * @author Viki
 * @date 2018/9/4 9:36
 */
public class HashMap<K,V> implements Map<K,V> {

    public  static int defaultLength = 16;

    private static float defaultLoder = 0.75f;

    private Entry[] table  = null;

    private static  int size = 0;

    public HashMap() {
        this(defaultLength, defaultLoder);
    }

    public HashMap(int length, float loder) {
        defaultLength = length;
        defaultLoder = loder;
        table = new Entry[defaultLength];
    }

    @Override
    public V get(K o) {
        int index  = hash(o);
        if (table[index] == null) {
            return  null;
        }
        //Entry<K,V> entry  = table[index];
        return (V) find(o,table[index]);
    }

    private V find(K k,Entry<K,V> entry){
        if (k == entry.getKey() || k.equals(entry.getKey())){
            return  entry.getValue();
        }else{
            if (entry.next!=null){
                return find(k,entry.next);
            }
        }
        return null;
    }

    @Override
    public V put(K k,V v) {
        size++;
        int index = hash(k);
        Entry<K,V> entry = table[index];
        if (entry == null){
            table[index] = newEntry(k,v,null);
        }else{
            table[index] = newEntry(k,v,entry);
            return (V) table[index].next.getValue();
        }

        return (V) table[index].getValue();
    }

    public Entry<K,V> newEntry(K k,V v,Entry<K,V> next){
        return  new Entry<K, V>(k,v,next);
    }

    public  int hash(K k){
        int m= defaultLength;
        int i = k.hashCode()%m;

        return i>=0?i:-i;
    }

    @Override
    public int size() {
        return size;
    }

    class Entry<K,V> implements Map.Entry<K,V>{

        K k;
        V v;
        Entry<K,V> next;

        public Entry(K k, V v, Entry<K, V> next) {
            this.k = k;
            this.v = v;
            this.next = next;
        }

        @Override
        public K getKey() {
            return k;
        }

        @Override
        public V getValue() {
            return v;
        }
    }

}
