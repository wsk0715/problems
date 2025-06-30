import sys
import heapq

# libs
input = sys.stdin.readline


# 간선 이어가기 2 - G5
# https://www.acmicpc.net/problem/14284

# 1. 입력 받기
# N - 정점의 개수
# M - 간선의 개수
N, M = map(int, input().split())

# 그래프 초기화
graph = [[] for _ in range(N + 1)]

# 간선 입력
for _ in range(M):
    u, v, w = map(int, input().split())
    graph[u].append((v, w))
    graph[v].append((u, w))  # 양방향 간선

# S - 시작 정점
# T - 도착 정점
S, T = map(int, input().split())

# Question
# 정점 S에서 T까지 가는 최소 비용을 구하는 문제

# Idea
# 가중치가 양수인 그래프에서 한 정점에서 다른 정점까지의 최소 비용 → 다익스트라 알고리즘
# 우선순위 큐(최소 힙)를 이용해 매번 가장 가까운 정점부터 탐색
# -> 누적 비용이 더 적은 경우에만 갱신하며 진행

# 비용을 저장할 배열
dist = [float("inf")] * (N + 1)
dist[S] = 0

# 우선순위 큐(최소 힙)
heap = [(0, S)]  # (누적 비용, 정점)

while heap:
    # 현재까지 최소 비용이 가장 낮은 노드를 꺼냄
    cost, node = heapq.heappop(heap)

    # 이미 더 짧은 경로로 방문한 적이 있는지 확인
    if dist[node] < cost:
        continue

    # 현재 정점과 연결된 모든 노드에 대해
    for neighbor, weight in graph[node]:
        next_cost = cost + weight  # 현재 경로를 통해 이웃한 정점까지 가는 비용
        
        # 현재 경로가 기존 비용보다 더 저렴한 경우
        if dist[neighbor] > next_cost:
            # 최소 비용 갱신
            dist[neighbor] = next_cost
            heapq.heappush(heap, (next_cost, neighbor))

# 결과 출력
print(dist[T])
