import sys

# libs
input = sys.stdin.readline


# 거짓말 - G4
# https://www.acmicpc.net/problem/1043


def find(parent, x):
    # find 연산 - x가 속한 그룹의 루트 노드를 찾음

    if parent[x] != x:
        parent[x] = find(parent, parent[x])

    return parent[x]


def union(parent, a, b):
    # union 연산 - a와 b를 하나의 그룹으로 연결

    a = find(parent, a)
    b = find(parent, b)

    if a != b:
        parent[b] = a


# N - 사람의 수
# M - 파티의 수
N, M = map(int, input().split())

# L - 진실을 아는 사람 정보 (수, 번호1, 번호2, ..)
truth_info = list(map(int, input().split()))

# 각 파티에 오는 사람 정보 (수, 번호1, 번호2, ..)
party_info = truth_info[1:] if truth_info[0] > 0 else []

# Union-Find 배열
parent = list(range(N + 1))

# 진실을 아는 사람들을 그룹으로 연결 (union 연산)
if party_info:
    for i in range(1, len(party_info)):
        union(parent, party_info[0], party_info[i])

# 파티 목록 배열
parties = []
for _ in range(M):
    # 입력 받기
    party = list(map(int, input().split()))
    party_people = party[1:]
    parties.append(party_people)

    # 파티 참가자들을 모두 연결 (union 연산)
    for i in range(len(party_people) - 1):
        union(parent, party_people[i], party_people[i + 1])

# 진실을 아는 그룹 찾기
truth_groups = set()
if party_info:
    for person in party_info:
        truth_groups.add(find(parent, person))

# 거짓말 가능한 파티 개수 세기
answer = 0
for party in parties:
    can_lie = True
    for person in party:
        if find(parent, person) in truth_groups:
            can_lie = False
            break

    if can_lie:
        answer += 1

print(answer)
