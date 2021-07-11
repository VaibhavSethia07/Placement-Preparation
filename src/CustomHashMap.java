import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class CustomHashMap {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Entry entry = new Entry();

		bw.write("Add the person with his/her phone number in database\n");
		bw.write("Number of entries: ");
		bw.flush();

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String[] person = br.readLine().split(" ");
			entry.put(person[0], person[1]);
		}

		bw.write(entry.get("Vaibhav") + "\n");
		bw.flush();
	}
}

class Entry implements Map<Object, Object> {
	final int SIZE = 26;
	LinkedList customMap[];

	public Entry() {
		this.customMap = new LinkedList[SIZE];
		for (int i = 0; i < SIZE; i++)
			customMap[i] = new LinkedList();
	}

	class Node {
		private int hash;
		private Object name;
		private Object phoneNumber;
		private Node next;

		public Node(int hash, Object key, Object value) {
			this.hash = hash;
			this.name = key;
			this.phoneNumber = value;
		}

		@Override
		public String toString() {
			return "Node [hash=" + hash + ", name=" + name + ", phoneNumber=" + phoneNumber + ", next=" + next + "]";
		}

	}

	class LinkedList {
		private Node head;

		public void insert(Node node) {
			if (head == null) {
				head = node;
				return;
			}

			Node curr = head;
			while (curr.next != null) {
				if (curr == node)
					return;
				curr = curr.next;
			}

			curr.next = node;

		}

		public Node getNode(Object key) {

			Node curr = head;
			while (curr != null) {

				if (curr.name.equals(key))
					return curr;
				curr = curr.next;
			}

			return null;
		}
	}

	int hashCode(Object key) {
		int hash = 7;
		for (int i = 0; i < (int) ((String) key).length(); i++) {
			hash = hash * 31 + ((String) key).charAt(i);
		}
		return hash;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object get(Object key) {
		int hash = hashCode((String) key);
		int index = hash % SIZE;

		return customMap[index].getNode(key);

	}

	@Override
	public Object put(Object key, Object value) {
		int hash = hashCode(key);
		Node node = new Node(hash, key, value);
		int index = hash % SIZE;

		customMap[index].insert(node);

		return null;
	}

	@Override
	public Object remove(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putAll(Map<? extends Object, ? extends Object> m) {
		// TODO Auto-generated method stub

	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public Set<Object> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Object> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<java.util.Map.Entry<Object, Object>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

}
