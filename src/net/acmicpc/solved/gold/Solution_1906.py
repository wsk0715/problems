import sys
import heapq
import math

# libs
input = sys.stdin.readline


# 최소 비용 구하기 - G5
# https://www.acmicpc.net/problem/1916

# Question
# N개의 도시가 있고, 두 도시를 잇는 버스 노선이 M개 있다.
# A 도시에서 B 도시까지 가는 데 드는 최소 비용을 구하는 문제
# (출발점에서 도착점에 도달할 수 있는 경우만 입력으로 주어진다.)

# Idea
# 가중치가 모두 양수이며, 최소 비용을 구해야 하므로 다익스트라 알고리즘 이용

# N - 도시의 개수 (1 <= N <= 1000)
N = int(input())

# M - 버스의 개수 (1 <= M <= 1e5)
M = int(input())

# 1. 간선 정보 입력
# graph - 각 정점(N)의 노선 정보를 저장할 배열 (1-based-index)
graph = [[] for _ in range(N + 1)]
for i in range(M):
    # 1-a. 간선 정보 입력
    departure, destination, cost = list(map(int, input().split()))  # [출발 도시, 도착지 도시, 버스 비용]

    # 1-b. 출발지 노드에 도착/비용 정보 삽입 (방향 존재)
    graph[departure].append([destination, cost])

# 2. 출발/목표 도시 입력
A, B = list(map(int, input().split()))

# 3. 최단거리 탐색
# A에서 각 정점까지의 최소 비용을 저장할 배열
dist = [math.inf for _ in range(N + 1)]
# heap - (누적 비용, 정점)을 저장할 힙
heap = [(0, A)]

while heap:
    # 현재까지 누적 비용이 가장 적은 정점 꺼내기
    cost, node = heapq.heappop(heap)
    
    # 이미 더 짧은 경로로 처리된 노드인 경우, 무시
    if (dist[node] < cost):
        continue
    
    # 종료 조건; 다익스트라 알고리즘의 성질을 이용, 큐에서 목표 노드가 빠져나온 순간이 최소값이 결정되는 순간
    if node == B:
        print(cost)
        break

    # 현재 노드와 인접한 모든 노드를 탐색
    for neighbor, weight in graph[node]:
        # 누적 비용 계산
        next_cost = cost + weight
        
        # 기존 비용보다 적은 비용으로 이동할 수 있다면, 비용 및 힙 갱신
        if (dist[neighbor] > next_cost):
            dist[neighbor] = next_cost
            heapq.heappush(heap, (next_cost, neighbor))

# Constraints
# 다익스트라 알고리즘
# - "현재 상황에서 가장 짧은 경로는, 앞으로도 절대 더 짧아질 수 없다"는 가정을 기반으로 함 → 그리디 성질을 띔
# - 만약 음수 가중치가 존재한다면 이러한 그리디적인 전제가 모순되므로,
#   잘못된 경로(현재 상황에서는 최단거리지만, 추후 더 짧은 거리가 등장할 수 있음)를 고정할 수 있게 됨
#   -> 따라서 음수 가중치가 존재하는 경우에는 다른 알고리즘을 사용해야 함

# Result
# 시간 복잡도: O(V + E) log V); E - 버스 개수, V - 도시 개수
# 공간 복잡도: O(V + E); 그래프, 거리 배열, 힙
