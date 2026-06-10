import java.util.*;

class SegmenetTree {

    class Node {
        int max;
        int min;
        int start;
        int end;

        Node left;
        Node right;

        Node() {}

        Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    Node root;

    SegmenetTree(int[] arr) {
        root = buildTree(arr, 0, arr.length - 1);
    }

    private Node buildTree(int[] arr, int start, int end) {

        Node node = new Node(start, end);

        if (start == end) {
            node.max = arr[start];
            node.min = arr[start];
            return node;
        }

        int mid = start + (end - start) / 2;

        node.left = buildTree(arr, start, mid);
        node.right = buildTree(arr, mid + 1, end);

        node.max = Math.max(node.left.max, node.right.max);
        node.min = Math.min(node.left.min, node.right.min);

        return node;
    }

    public int[] query(int qs, int qe) {
        return query(root, qs, qe);
    }

    private int[] query(Node node, int qs, int qe) {

        // Complete overlap
        if (node.start >= qs && node.end <= qe) {
            return new int[]{node.min, node.max};
        }

        // No overlap
        if (node.end < qs || node.start > qe) {
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        }

        // Partial overlap
        int[] leftResult = query(node.left, qs, qe);
        int[] rightResult = query(node.right, qs, qe);

        int min = Math.min(leftResult[0], rightResult[0]);
        int max = Math.max(leftResult[1], rightResult[1]);

        return new int[]{min, max};
    }
}

class Solution {

    public long maxTotalValue(int[] nums, int k) {

        int n = nums.length;

        SegmenetTree t = new SegmenetTree(nums);

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

        for (int i = 0; i < n; i++) {

            int[] qr = t.query(i, n - 1);

            pq.offer(new int[]{ qr[1] - qr[0], i, n - 1} );
        }

        long ans = 0;

        while (!pq.isEmpty() && k > 0) {

            int[] pair = pq.poll();

            ans += pair[0];

            int l = pair[1];
            int r = pair[2];

            

            if (l < r) {

                int[] qr = t.query(l, r - 1);

                pq.offer(new int[]{ qr[1] - qr[0] , l, r - 1 });
            }

            k--;
        }

        return ans;
    }
}