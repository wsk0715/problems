import sys
from collections import deque

# libs
input = sys.stdin.readline


# 뱀 - G4
# https://www.acmicpc.net/problem/3190

# 1. 입력 받기
# 보드 생성
# N - 보드의 크기
N = int(input())
board = [[0] * N for _ in range(N)]  # 0 - 빈 공간

# 사과 위치 입력
# K - 사과의 개수
K = int(input())
for _ in range(K):
    y, x = list(map(int, input().split()))
    board[y - 1][x - 1] = 1  # 1 - 사과

# 방향 전환 입력
# L - 방향 전환 횟수
turns = {}
L = int(input())
for _ in range(L):
    t, d = input().split()  # time, direction
    turns[int(t)] = d

# 2. 초기 설정(오른쪽-위-왼쪽-아래)
dy = [0, 1, 0, -1]
dx = [1, 0, -1, 0]
direction = 0  # 초기 방향: 오른쪽

snake = deque()  # 뱀의 상태를 저장할 덱
snake.append((0, 0))  # 초기 위치: 좌측 상단
board[0][0] = 2

# 3. 시뮬레이션
time = 0  # 진행 시간
y, x = 0, 0  # 뱀의 머리
while True:
    time += 1
    ny = y + dy[direction]
    nx = x + dx[direction]

    # 종료 조건
    # a. 머리가 보드를 벗어나거나
    # b. 자기자신과 닿은 경우
    if not (0 <= ny < N and 0 <= nx < N) or board[ny][nx] == 2:
        break

    # 이동
    if board[ny][nx] == 1:
        # 이동한 칸에 사과가 있는 경우, 꼬리를 이동하지 않음
        board[ny][nx] = 2
        snake.append((ny, nx))
    else:
        # 사과가 없는 경우, 꼬리 이동
        board[ny][nx] = 2
        snake.append((ny, nx))
        tail_y, tail_x = snake.popleft()
        board[tail_y][tail_x] = 0

    # 머리 위치 갱신
    y, x = ny, nx

    # 방향 전환
    if time in turns:
        if turns[time] == "D":
            direction = (direction + 1) % 4  # 오른쪽으로 회전
        elif turns[time] == "L":
            direction = (direction - 1) % 4  # 왼쪽으로 회전

print(time)
