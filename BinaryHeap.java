import java.util.Arrays;
/**
 * 
 * @author Stephen Tselikov
 * Assignment 9 - 11/7/2019
 *
 */
public class BinaryHeap {
	int[] data;
	int size;

	BinaryHeap() {
		this.size = 0;
		this.data = new int[10];
	}

	//adds a value passed to the heap
	public void add(int i) {

		if (size == data.length) {
			data = Arrays.copyOfRange(data,0, data.length * 2);
		}
		data[size++] = i;
		int child = size - 1;
		int parent = (child - 1) / 2;
		while (child != 0 && data[child] < data[parent]) {
			swap(data, child, parent);
			child = parent;
			parent = (parent-1) / 2;
		}

	}
	
	//removes and returns the min element in the binary heap
	public int remove() {
		swap(data, 0, size - 1);
		size--;
		if (size > 0) {
			siftdown(0);
		}
		return data[size];

	}

	//places the element that is at the root of the heap in the right place so that the heap would maintain the correct priority order
	private void siftdown(int i) {

		int parent = i;
		int left = 2 * parent + 1;
		int right = 2 * parent + 2;
		if (left >= size || right >= size) {
			return;
		}

		if (data[left] > data[right] && data[right] < data[parent]) {
			swap(data, parent, right);
			siftdown(right);
		} else if (data[right] > data[left] && data[left] < data[parent]) {
			swap(data, parent, left);
			siftdown(left);
		}

	}
	
	//grows the array, increases by the factor of length*2
	void growArray() {
		int[] new_data = Arrays.copyOfRange(data, 0, data.length * 2);
		data = new_data;
	}

	//swaps the data of two elements in the heap
	public void swap(int[] data, int index1, int index2) {
		int temp = data[index1];
		data[index1] = data[index2];
		data[index2] = temp;
	}

//	public static void main(String[] args)
//	{
//		BinaryHeap b = new BinaryHeap();
//		b.add(1);
//		System.out.println(Arrays.toString(b.data));
//		b.add(2);
//		
//	}

}