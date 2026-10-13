class Pair<K, V> {
    private K key;
    private V value;

    public void put(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public void get(){
        System.out.println("key is " + this.key);
        System.out.println("value is " + this.value);
    }
}

public class MultipleGenericTypes {
    public static void main(String[] args) {
        Pair<String, Integer> pairObj = new Pair<>();
        pairObj.put("hello", 1235);
        pairObj.get();
    }
}
