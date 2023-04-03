
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Vertex implements Comparable<Vertex> {
		int no, minDistance;// 정점번호, 출발지에서 자신으로의 최소 비용

		public Vertex(int no, int minDistance) {
			super();
			this.no = no;
			this.minDistance = minDistance;
		}

		@Override
		public String toString() {
			return "Vertex [no=" + no + ", minDistance=" + minDistance + "]";
		}

		@Override
		public int compareTo(Vertex o) {
			return this.minDistance - o.minDistance;
		}
	}

	static class Node {
		Vertex vertex;// 정점
		Node link;// 다음 정점 링크

		public Node(Vertex vertex, Node link) {
			this.vertex = vertex;
			this.link = link;
		}

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", link=" + link + "]";
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		Node[][] list = new Node[N + 1][N + 1];
		// 오는 길
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			for (int j = 1; j <= N; j++) {
				list[j][from] = new Node(new Vertex(to, weight), list[j][from]);
			}
		}
		int[][] distance=new int[N+1][N+1];
		boolean[][] visited=new boolean[N+1][N+1];
		// 집 가는길->학생마다 다익스트라 구현 : X->각 번호마다의 경비 구하기
		for (int i = 1; i <= N; i++) {
			dijkstra(i, N, list[i],distance[i],visited[i]);
		}
		int max=-1;
		for(int i=1;i<=N;i++) {
			max=Math.max(max,distance[i][X]+distance[X][i]);
		}
		System.out.println(max);
	}

	static void dijkstra(int X, int N, Node[] list, int[] distance, boolean[] visited) {
		// int end=V;
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[X] = 0;// 시작점 0으로
		// visited[K] = true;
		PriorityQueue<Vertex> pQueue = new PriorityQueue<Vertex>();

		pQueue.offer(new Vertex(X, distance[X]));
		while (!pQueue.isEmpty()) {
			// 단계1 : 최소 비용이 확정되지 않은 정점 중 최소 비용의 정점 선택
			Vertex current = pQueue.poll();
			if (visited[current.no]) {
				continue;
			}
			visited[current.no] = true;
			for (Node temp = list[current.no]; temp != null; temp = temp.link) {
				if (!visited[temp.vertex.no] && temp.vertex.minDistance != 0
						&& distance[temp.vertex.no] > distance[current.no] + temp.vertex.minDistance) {
					distance[temp.vertex.no] = distance[current.no] + temp.vertex.minDistance;
					temp.vertex.minDistance = distance[temp.vertex.no];
					pQueue.offer(temp.vertex);
				}
			}
		}
	}
}