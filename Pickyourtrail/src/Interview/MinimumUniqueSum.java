package Interview;

import java.util.Scanner;

public class MinimumUniqueSum {

	public static int getMinimumUniqueSum(int arr[]) {

		int sum = 0;

		// Sort it
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}

		// Finding duplicates and replace by least unique
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == arr[i + 1]) {
				int leastUnique = findNextUnique(1, arr);
				arr[i] = leastUnique;
			}
			sum = sum + arr[i];
		}
		sum = sum + arr[arr.length - 1];

		return sum;
	}

	public static int findNextUnique(int counter, int[] arr) {
		boolean exists = false;
		for (int rec : arr) {
			if (rec == counter) {
				exists = true;
				break;
			}
		}
		if (exists) {
			counter = counter + 1;
			return findNextUnique(counter, arr);
		}
		return counter;
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int n = s.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}

		System.out.println(getMinimumUniqueSum(arr));
		s.close();
	}

}
