import sys

# libs
input = sys.stdin.readline


# 여행 가자 - G4
# https://www.acmicpc.net/problem/1976


def find(parent, x):
    # find 연산
    if parent[x] != x:
        parent[x] = find(parent, parent[x])

    return parent[x]


def union(parent, a, b):
    # union 연산
    root_a = find(parent, a)
    root_b = find(parent, b)

    if root_a != root_b:
        parent[root_b] = root_a


# 1. 입력 받기
N = int(input())  # N - 도시의 수
M = int(input())  # M - 여행 계획에 포함된 도시의 수

# Union-Find 배열 초기화
parent = list(range(N + 1))

# 2. 도시 연결 정보 입력 및 도시 연결 (union 연산)
for i in range(1, N + 1):
    connections = list(map(int, input().split()))
    for j in range(N):
        if connections[j] == 1:
            union(parent, i, j + 1)  # i번 도시와 (j + 1)번 도시를 연결

# 3. 여행 계획 입력
travel_plan = list(map(int, input().split()))

# 4. 여행 계획의 모든 도시가 같은 그룹에 속하는지 확인 (find 연산)
first_city_group = find(parent, travel_plan[0])
possible = True
for city in travel_plan[1:]:
    if find(parent, city) != first_city_group:
        possible = False
        break

# 5. 결과 출력
if possible:
    print("YES")
else:
    print("NO")
