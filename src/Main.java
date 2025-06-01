
public class Main {
    public static void main(String[] args) {
        // Create LRUCache with capacity 2
        LRUCache lru = new LRUCache(2);

        // Test 1: Insert and get
        lru.put(1, 10);
        lru.put(2, 20);
        System.out.println(lru.get(1));  // Output: 10 (recently used)
        System.out.println(lru.get(2));  // Output: 20

        // Test 2: Evict LRU when capacity exceeded
        lru.put(3, 30);                 // Evicts key 1 (LRU)
        System.out.println(lru.get(1));  // Output: -1 (evicted)
        System.out.println(lru.get(3));  // Output: 30 (now most recent)

        // Test 3: Update existing key
        lru.put(2, 200);                // Updates key 2, makes it MRU
        lru.put(4, 40);                 // Evicts key 3 (LRU)
        System.out.println(lru.get(3));  // Output: -1 (evicted)
        System.out.println(lru.get(2));  // Output: 200 (still in cache)

        // Test 4: Edge case (empty cache)
        LRUCache lru2 = new LRUCache(0);
        lru2.put(1, 100);               // Fails silently (capacity 0)
        System.out.println(lru2.get(1)); // Output: -1
    }
}