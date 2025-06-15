import sys

# libs
input = sys.stdin.readline


# 계단 오르기 - S3
# https://www.acmicpc.net/problem/2579

# N - 계단의 개수
N = int(input())

# scores - 각 계단의 점수
scores = [0] * (N + 1)
for i in range(1, N + 1):
    scores[i] = int(input())

# 예외 처리; 계단이 하나인 경우
if N == 1:
    print(scores[N])
    sys.exit()

# dp - 결과를 누적할 배열
dp = [0] * (N + 1)  # 1-based-index
dp[0] = 0  # 시작점
dp[1] = scores[1]
dp[2] = scores[1] + scores[2]

# 조건
# 1. 계단은 한 번에 (1 or 2)칸씩 오를 수 있다.
# 2. 연속된 세 개의 계단을 함께 밟을 수 없다.
# 3. 마지막 계단은 반드시 밟아야 한다.

# idea
# 점수의 합이 최대가 되도록 점화식을 도출해내야 한다.
# 1칸을 건너오는 경우, 그 앞 계단은 밟을 수 없다. (조건3)
for i in range(3, N + 1):
    val1 = dp[i - 2]  # 2칸을 건너오는 경우
    val2 = dp[i - 3] + scores[i - 1]  # 1칸을 건너오는 경우
    dp[i] = max(val1, val2) + scores[i]  # 현재 계단에서의 점수(dp) = (2칸을 건너오는 경우 vs 1칸을 건너오는 경우) + 현재 계단

print(dp[N])
