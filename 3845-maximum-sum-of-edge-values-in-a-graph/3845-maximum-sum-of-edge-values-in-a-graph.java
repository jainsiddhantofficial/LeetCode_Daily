class Solution {
    // Helper to find connected path from a node using BFS
    private void findPath(List<List<Integer>> graph, int src, boolean[] visited, List<Integer> path) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        visited[src] = true;

        while (!queue.isEmpty()) {
            int top = queue.poll();
            path.add(top);
            for (int next : graph.get(top)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }

    public long maxScore(int n, int[][] edges) {
        // Build graph and degree map
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; ++i) graph.add(new ArrayList<>());
        int[] degree = new int[n];
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        int[] values = new int[n];
        Arrays.fill(values, -1);
        boolean[] visited = new boolean[n];
        int valueToAssign = 1;

        // Step 1: Handle isolated nodes
        for (int i = 0; i < n; ++i) {
            if (degree[i] == 0) values[i] = valueToAssign++;
        }

        // Step 2: Handle path-like components (trees)
        List<List<Integer>> normalPaths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (degree[i] == 1 && !visited[i]) {
                path.clear();
                findPath(graph, i, visited, path);
                normalPaths.add(new ArrayList<>(path));
            }
        }

        // Sort by size to assign bigger values to longer paths
        normalPaths.sort(Comparator.comparingInt(List::size));
        for (List<Integer> normalPath : normalPaths) {
            int size = normalPath.size();
            int low = 0, high = size - 1;
            while (low <= high) {
                values[normalPath.get(low)] = valueToAssign++;
                if (low != high) values[normalPath.get(high)] = valueToAssign++;
                ++low;
                --high;
            }
        }

        // Step 3: Handle cyclic paths
        List<List<Integer>> cyclicPaths = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (degree[i] == 2 && !visited[i]) {
                path.clear();
                findPath(graph, i, visited, path);
                cyclicPaths.add(new ArrayList<>(path));
            }
        }

        for (List<Integer> cyclePath : cyclicPaths) {
            for (int node : cyclePath) {
                values[node] = valueToAssign++;
            }
        }

        // Step 4: Compute final score
        long ans = 0;
        for (int[] edge : edges) {
            ans += (long) values[edge[0]] * values[edge[1]];
        }

        return ans;
    }
}