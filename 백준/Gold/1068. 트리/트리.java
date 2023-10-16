import java.util.*;
import java.io.*;

// 지우는 노드가 리프이면 그냥 지워지고,
// 지우는 노드가 리프가 아니면 - 1

// 리스트에서 없애고, PTC 에서도 없애야한다.
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// N 50 이하
		int nodeSize = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int removeNode = Integer.parseInt(br.readLine());

		int[] childToParent = new int[51];
		Arrays.fill(childToParent, -1);

		List<List<Integer>> parentToChildren = new ArrayList<List<Integer>>();
		for (int i = 0; i <= 50; i++)
			parentToChildren.add(new ArrayList<>());

		int idx = 0;
		int pn = 0;
		while (st.hasMoreTokens()) { // 입력이 부모.
			int parentNumber = Integer.parseInt(st.nextToken());
			childToParent[idx] = parentNumber;
			if (parentNumber == -1 || idx == removeNode) {
				idx++;
				continue;
			}
			parentToChildren.get(parentNumber).add(idx);
			idx++;
			pn = parentNumber;
		}

		parentToChildren.get(removeNode).clear();
		int root = findRootNode(childToParent, pn);
		if (removeNode == root) // edge case
			System.out.println(0);
		else
			System.out.println(countLeafNode(parentToChildren, root));
	}

	public static int findRootNode(int[] childToParent, int idx) {
		if (childToParent[idx] == -1)
			return idx;
		return findRootNode(childToParent, childToParent[idx]);
	}

	// 부모가 list로 자식들을 갖고 있어야 한다.
	// 부모에서 자식을 찾아서 개수를 완전탐색
	public static int countLeafNode(List<List<Integer>> parentToChildren, int root) {
		Queue<Integer> q = new LinkedList<>();
		int count = 0;
		q.offer(root);

		while (!q.isEmpty()) {
			int nodeNumber = q.poll();
			List<Integer> list = parentToChildren.get(nodeNumber);
			if (list.size() == 0) {// && nodeNumber != root) {
				count++;
				continue;
			}
			for (int n : list) {
				q.offer(n);
			}
		}
		return count;
	}
}
/*
 * 3 -1 0 1 2 ans = 1
 * 
 * 1 -1 0 ans = 0
 * 
 * 6 1 2 3 4 -1 4 5 ans = 1
 * 
 */