import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

class RandomizedSet {

  private Map<Integer, Integer> buffer;
  private List<Integer> pointers;
  private Random rand;

  public RandomizedSet() {
    buffer = new HashMap<>();
    pointers = new ArrayList<>();
    rand = new Random();
  }

  public boolean insert(int val) {
    // if we are asked to insert number 10, check for the magnitude of the pointers buffer.
    // Example: if magnitude is 0, then store 10 -> 0 in buffer (Map) and store 10 at index 0 in pointers (list).
    if (buffer.containsKey(val)) return false;
    buffer.put(val, pointers.size());
    pointers.add(val);
    return true;
  }

  public boolean remove(int val) {
    if (!buffer.containsKey(val)) return false;
    int idx = buffer.get(val);
    // Get value at last index
    int lastIndexValue = pointers.size() - 1;
    pointers.set(idx, pointers.get(lastIndexValue));
    // Search for it in buffer and get its index
    // int bufferIndex = buffer.get(lastIndexValue);
    buffer.put(pointers.get(lastIndexValue), idx);
    buffer.remove(val);
    pointers.remove(pointers.size() - 1);
    return true;
  }

  public int getRandom() {
    return pointers.get(rand.nextInt(pointers.size()));
  }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

public class _380_Insert_Delete_GetRandom_O_1_ {

  public static void main(String[] args) {
    RandomizedSet rs = new RandomizedSet();
    rs.insert(-10);
    rs.insert(5);
    rs.insert(89);
    rs.insert(89);
    rs.remove(5);
    System.out.println(rs.getRandom());
  }
}
