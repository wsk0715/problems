import sys

# libs
input = sys.stdin.readline


# 구간 합 구하기 - S1
# https://www.acmicpc.net/problem/11660

# Question
# N×N 크기의 표에 수가 채워져 있다.
# (x1, y1)부터 (x2, y2)까지 합을 구하는 프로그램을 작성
#

# 1. 입력받기
# N - 표의 크기
# M - 합을 구해야 하는 횟수
N, M = list(map(int, input().split()))

# 2. 표 입력 받기
matrix = []
for _ in range(N):
    row = list(map(int, input().split()))
    matrix.append(row)

# 3. 누적합 계산
prefix_sum = [[0] * (N + 1) for _ in range(N + 1)]
for i in range(1, N + 1):
    for j in range(1, N + 1):
        prefix_sum[i][j] = (
            matrix[i - 1][j - 1]  # 현재 위치핞 좌표의 값
            + prefix_sum[i - 1][j]  # 위쪽 누적합
            + prefix_sum[i][j - 1]  # 왼쪽 누적합
            - prefix_sum[i - 1][j - 1]  # 중복된 영역 제거(왼쪽 위)
        )

# 4. 결과 계산 & 출력
for _ in range(M):
    x1, y1, x2, y2 = map(int, input().split())
    result = prefix_sum[x2][y2] - prefix_sum[x1 - 1][y2] - prefix_sum[x2][y1 - 1] + prefix_sum[x1 - 1][y1 - 1]
    print(result)
