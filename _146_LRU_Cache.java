// import java.util.ArrayDeque;
// import java.util.HashMap;
// import java.util.Map;
// import java.util.Queue;

// class LRUCache {

//   private int capacity;
//   private Map<Integer, Integer> hm;
//   private Queue<Integer> Q;

//   public LRUCache(int capacity) {
//     this.capacity = capacity;
//     this.hm = new HashMap<>();
//     this.Q = new ArrayDeque<>();
//   }

//   public int get(int key) {
//     if (!hm.containsKey(key)) return -1;
//     int val = hm.get(key);
//     Q.remove(key);
//     Q.offer(key);
//     return val;
//   }

//   public void put(int key, int value) {
//     if (hm.containsKey(key)) {
//       Q.remove(key);
//       Q.add(key);
//       hm.put(key, value);
//     } else {
//       if (Q.size() >= capacity) {
//         int lru = Q.poll();
//         hm.remove(lru);
//       }
//       Q.offer(key);
//       hm.put(key, value);
//     }
//   }
// }

// public class _146_LRU_Cache {

//   public static void main(String[] args) {
//     LRUCache obj = new LRUCache(10);
//     int param_1 = obj.get(1);
//     obj.put(1, 2);
//   }
// }

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {

  private final int capacity;
  private final LinkedHashMap<Integer, Integer> cache;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.cache = new LinkedHashMap<>(capacity, 0.75f, true) {
      @Override
      protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > LRUCache.this.capacity;
      }
    };
  }

  public int get(int key) {
    return cache.getOrDefault(key, -1);
  }

  public void put(int key, int value) {
    cache.put(key, value);
  }
}
