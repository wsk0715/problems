import sys
import heapq

# libs
input = sys.stdin.readline


# 강의실 - G5
# https://www.acmicpc.net/problem/1374

# N - 강의 개수
N = int(input())

# 강의 목록 입력
lectures = []
for _ in range(N):
    # idx - 강의 번호
    # start - 강의 시작 시간
    # end - 강의 종료 시간
    _idx, start, end = map(int, input().split())
    lectures.append((start, end))

# Question
# 한 강의실에서 2개 이상의 강의를 진행할 수 없음
# 서로 다른 강의의 종료시간과 시작시간은 겹칠 수 있음(종료와 동시에 시작 가능)
# 필요한 최소 강의실의 수를 구하는 문제

# Idea
# 사용 가능한 강의실이 있다면 사용하고, 없다면 새로 만드는 그리디 문제
# 시작 시간이 빠른 순으로 정렬
# -> 가장 먼저 끝나는 강의실과 비교하여 겹치지 않으면 재사용
# -> 겹치면 새 강의실 배정 => 우선순위 큐 이용

# 시작 시간이 빠른 순으로 정렬
lectures.sort()

# rooms - 종료 시간을 저장할 힙(기본값 min-heap)
rooms = []
heapq.heappush(rooms, lectures[0][1])  # 첫 강의 종료 시간 push

for i in range(1, N):
    start, end = lectures[i]

    # 가장 빨리 끝나는 강의보다 시작 시간이 늦거나 같으면(=빈 강의실이면) 해당 강의실 사용
    if rooms[0] <= start:
        heapq.heappop(rooms)

    heapq.heappush(rooms, end)

print(len(rooms))
