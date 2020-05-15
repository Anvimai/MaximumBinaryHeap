package MaxBinHeap_A3;

import java.lang.Math; 

public class MaxBinHeap implements Heap_Interface {
  private double[] array; //load this array
  private int size;
  private static final int arraySize = 10000; //Everything in the array will initially 
                                              //be null. This is ok! Just build out 
                                              //from array[1]

  public MaxBinHeap() {
    this.array = new double[arraySize];
    array[0] = Double.NaN;  //0th will be unused for simplicity 
                            //of child/parent computations...
                            //the book/animation page both do this.
  }
    
  //Please do not remove or modify this method! Used to test your entire Heap.
  @Override
  public double[] getHeap() { 
    return this.array;
  }

@Override
public void insert(double element) {
	// TODO Auto-generated method stub
	
	if(size==0) {array[1]=element; size++; return;}
	
	if(element<array[(int) Math.floor(((size+1.0)/2.0))]) {
		array[size+1]=element; size++; return;
	}else {
		int currentIndex = size+1;
		int parentIndex = (int) Math.floor(((size+1.0)/2.0)); 
		while(element>array[parentIndex]) {
			double temp = array[parentIndex];
			array[parentIndex] = element;
			array[currentIndex] = temp;
			currentIndex = parentIndex;
			parentIndex = (int) Math.floor(((parentIndex)/2.0));
			
		}
	}
	
	size++;
	return;
	
}

@Override
public void delMax() {
	// TODO Auto-generated method stub
	if(size==0) {return;}
	
	int currentIndex = 1;
	array[currentIndex] = 0.0;
	double temp = array[size];
	array[size] = 0.0;
	array[currentIndex] = temp;
	size--;
    for (int i = 1; i >= 0; i--) { 
        heapOrder(array, size, i); 
    } 	

	
}

@Override
public double getMax() {
	// TODO Auto-generated method stub
	return array[1];
}

@Override
public void clear() {
	// TODO Auto-generated method stub
	size = 0;
	for (int i = 1; i < array.length; i++) {
	      array[i] = 0.0;
	    }
	
}

@Override
public int size() {
	// TODO Auto-generated method stub
	return size;
}

@Override
public void build(double[] elements) {
	// TODO Auto-generated method stub
	clear();
	size = elements.length;
	
	for(int i = 1; i <= elements.length; i++) {
	array[i] = elements[i-1];
}	

	
	
    // Index of last non-leaf node 
    int start = ((size) / 2); 


    for (int i = start; i >= 0; i--) { 
        heapOrder(array, size, i); 
    } 	

	
	
	
	
	
}

@Override
public double[] sort(double[] elements) {
	// TODO Auto-generated method stub
	clear();
	build(elements);
	double[] inOrder = new double[elements.length];
	for(int i = size-1; i >= 0; i--) {
		inOrder[i] = getMax();
		delMax();
	}
	return inOrder;
}

  // add your method implementstions

static void heapOrder(double arr[], int n, int i) 
{ 
    int root = i; 
    int leftChild = (2 * i); 
    int rightChild = (2 * i) + 1; 
    

    if ((leftChild <= n) && (arr[leftChild] > arr[root])) 
        root = leftChild; 

    if ((rightChild <= n) && (arr[rightChild] > arr[root])) 
        root = rightChild; 

    if (root != i) { 
        double swap = arr[i]; 
        arr[i] = arr[root]; 
        arr[root] = swap; 

        heapOrder(arr, n, root); 
    }  
} 

}