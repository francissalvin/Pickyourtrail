package Interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SuperStack {

	Node head;

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}

	}

	void push(int key, Node headNode) {
		Node newNode = new Node(key);
		newNode.next = head;
		head = newNode;
	}

	int pop() {
		if (head == null) {
			return -1;
		} else {
			int poppedData = head.data;
			head = head.next;
			return poppedData;
		}
	}

	String peek() {
		if (head == null) {
			return "EMPTY";
		} else {
			return String.valueOf(head.data);
		}
	}

	Node incrNElements(SuperStack mainStack, int n, int incrVal) {
		SuperStack tmpStack = new SuperStack();
		// Pushing from main stack to temp stack
		while (true) {
			tmpStack.push(mainStack.pop(), mainStack.head);
			if (mainStack.head == null) {
				break;
			}
		}

		// Incrementing while pushing back from temp to main stack
		int counter = 0;
		while (true) {
			if (counter != n) {
				mainStack.push(tmpStack.pop() + incrVal, tmpStack.head);
				counter += 1;
			} else {
				mainStack.push(tmpStack.pop(), tmpStack.head);
			}
			if (tmpStack.head == null) {
				break;
			}
		}
		return mainStack.head;

	}

	public static void main(String args[]) {

		SuperStack ss = new SuperStack();

		List<String> op = new ArrayList<String>();

		Scanner s = new Scanner(System.in);
		int n = Integer.parseInt(s.nextLine());

		for (int i = 0; i < n; i++) {
			String type = s.nextLine();
			if (type.equalsIgnoreCase("push")) {
				int val = Integer.parseInt(s.nextLine());
				ss.push(val, ss.head);
				op.add(ss.peek());
			} else if (type.equalsIgnoreCase("pop")) {
				ss.pop();
				op.add(ss.peek());
			} else if (type.equalsIgnoreCase("inc")) {
				int positions = Integer.parseInt(s.nextLine());
				int incrVal = Integer.parseInt(s.nextLine());

				ss.head = ss.incrNElements(ss, positions, incrVal);
				op.add(ss.peek());
			}
		}

		for (String rec : op) {
			System.out.println(rec);
		}
		s.close();

	}

}
