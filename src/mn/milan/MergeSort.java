package mn.milan;

public class MergeSort {
	public static void main(String[] args) {
		int arr[] = { 12, 11, 13, 5, 6, 7 };
		
        System.out.println("Given Array");
        printArray(arr);

        MergeSort sortObject = new MergeSort();
        sortObject.sort(arr, 0, arr.length-1);
        
        System.out.println("\nSorted array");
        printArray(arr);        
	}
	
	void sort(int arr[], int l, int r) {
		if(l<r) {
			//find mid point
			int m = l + (r-l)/2;
			
			//sort 1st and 2nd half
			sort(arr, l, m);
			sort(arr, m+1, r);
			
			//merge
			merge(arr, l, m, r);
		}
	}
	
	void merge(int arr[], int l, int m, int r) {
		
		//size of 2 sub array to be merged
		int n1 = m-l+1;
		int n2 = r-m;
		
		//create temp arr
		int L[] = new int[n1];
		int R[] = new int[n2];
		
		//copy data to temp array
		for(int i = 0; i < n1; ++i) {
			L[i] = arr[l+i];
		}
		for(int j = 0; j < n2; ++j) {
			R[j] = arr[m+1+j];
		}
		
		///merge 2 sub arrays
		int i=0;
		int j=0;
		int k = l;
		
		while(i<n1 && j < n2) {
			if(L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			}else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		
		//copy remaining of L[] if any
		while(i<n1) {
			arr[k] = L[i];
			i++;
			k++;
		}
		
		//copy remaining of L[] if any
		while(j<n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}
	
	/* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
