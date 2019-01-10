package Interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class CountingPairs {

	static Map<Integer, Integer> pairs = new HashMap<Integer, Integer>();

	public static int countPairs(int arr[], int k) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if ((arr[i] <= arr[j]) && ((arr[i] + k) == arr[j])) {
					if (!checkIfPairExists(arr[i], arr[j])) {
						pairs.put(arr[i], arr[j]);
					}
				}
			}
		}
		return pairs.size();
	}

	public static boolean checkIfPairExists(int a, int b) {

		for (Entry<Integer, Integer> entry : pairs.entrySet()) {
			if (entry.getKey() == a && entry.getValue() == b) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}
		int k = s.nextInt();

		System.out.println(countPairs(arr, k));
		s.close();
	}

}
