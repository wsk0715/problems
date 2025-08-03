import sys

# libs
input = sys.stdin.readline


# 감시 - G3
# https://www.acmicpc.net/problem/15683


# 방향: 오른쪽, 아래, 왼쪽, 위
directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]

# CCTV별 가능한 방향 조합
cctv_dirs = {
    1: [[0], [1], [2], [3]],
    2: [[0, 2], [1, 3]],
    3: [[0, 3], [0, 1], [1, 2], [2, 3]],
    4: [[0, 1, 3], [0, 1, 2], [1, 2, 3], [0, 2, 3]],
    5: [[0, 1, 2, 3]]
}

# CCTV 동작 시뮬레이션
def watch(x, y, dirs, temp):
    for d in dirs:
        nx, ny = x, y
        while True:
            nx += directions[d][0]
            ny += directions[d][1]
            if not (0 <= nx < N and 0 <= ny < M):
                break
            if temp[nx][ny] == 6:  # 벽
                break
            if temp[nx][ny] == 0:  # 감시 표시
                temp[nx][ny] = '#'

def dfs(depth, office):
    global min_blind
    
    if depth == len(cams):
        # 사각지대 계산
        blind = sum(row.count(0) for row in office)
        min_blind = min(min_blind, blind)
        return

    x, y, cctv_type = cams[depth]
    for dirs in cctv_dirs[cctv_type]:
        temp = [row[:] for row in office]
        watch(x, y, dirs, temp)
        dfs(depth + 1, temp)

# 입력 처리 & 결과 계산
N, M = map(int, input().split())
offices = []
cams = []

for i in range(N):
    row = list(map(int, input().split()))
    offices.append(row)
    for j in range(M):
        if 1 <= row[j] <= 5:
            cams.append((i, j, row[j]))

min_blind = N * M
dfs(0, offices)
print(min_blind)