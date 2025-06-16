import sys

# libs
input = sys.stdin.readline


# 파도반 수열 - S3
# https://www.acmicpc.net/problem/9461


def solve():
    # T - 테스트 케이스 개수
    T = int(input())

    # dp - 결과를 담을 배열
    dp = [0] * 101  # N <= 100, 1-based index

    # 예외 값 처리
    dp[1] = dp[2] = dp[3] = 1
    dp[4] = dp[5] = 2

    # idea
    # 점화식 도출하기
    # P(1) = 1
    # P(2) = 1
    # P(3) = 1
    # P(4) = 2
    # P(5) = 2
    # P(6) = 3
    # P(7) = 4
    # P(8) = 5
    # P(9) = 7
    # P(10) = 9
    # 그림 참고(Notion)

    # 점화식을 이용하여 미리 dp 테이블 채우기
    for i in range(6, 101):  # P(6)부터 P(100)까지
        dp[i] = dp[i - 1] + dp[i - 5]

    # 각 테스트 케이스에 대해 N에 해당하는 값 출력
    for _ in range(T):
        N = int(input())
        print(dp[N])


solve()
