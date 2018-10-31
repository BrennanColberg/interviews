import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Tracker {
	
	public static void main(String[] args) {
		Tracker tracker = new Tracker();
		System.out.println(tracker.allocate("apibox"));
		System.out.println(tracker.allocate("apibox"));
		tracker.deallocate("apibox1");
		System.out.println(tracker.allocate("apibox"));
		System.out.println(tracker.allocate("sitebox"));
	}
	
	// [host type] -> [list of numbers]
	private Map<String, List<Integer>> allocated;
	
	// initalization
	public Tracker() {
		allocated = new HashMap<>();
	}
	
	// PRE: type must only be alphabetic
	public String allocate(String type) {
		
		// instantiate entry if type has not been used before
		if (!allocated.containsKey(type))
			allocated.put(type, new LinkedList<>());
		
		System.out.println(allocated.get(type));
		
		// get next number, "create server" with that number
		int next = nextAvailableServer(allocated.get(type));
		allocated.get(type).add(next);
		return type + next;
		
	}
	
	// PRE: name must begin with a valid type
	// PRE: instance must be allocated
	public void deallocate(String name) {
		
		for (String type : allocated.keySet()) {
			if (name.startsWith(type)) {
				
				// parse out the number of the instance
				int number = Integer.parseInt(name.substring(type.length()));
				
				// check to make sure box has been allocated
				if (!allocated.get(type).contains(number))
					throw new IllegalArgumentException();
				
				// remove instance from allocated numbers
				allocated.get(type).remove((Integer) number);
				
			}
		}
		
		//throw new IllegalArgumentException();
		
	}
	
	private static int nextAvailableServer(List<Integer> servers) {
		servers = new ArrayList<Integer>(servers);
		int result = 1;
		while (servers.contains(result)) result++;
		return result;
	}
	
}
