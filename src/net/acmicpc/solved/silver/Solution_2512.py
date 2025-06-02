import sys

# libs
input = sys.stdin.readline


# 예산 - S2
# https://www.acmicpc.net/problem/2512
def main():
    # 1. 입력받기
    N = int(input())  # 예산요청 수
    budget_requests = list(map(int, input().split()))  # 예산요청 목록
    M = int(input())  # 최대 예산

    # idea
    # 예산요청 개수의 범위는 3 <= N <= 100,000 -> 완전 탐색 가능
    # 예산의 범위는 1 <= M <= 1,000,000,000 -> 완전 탐색 불가능
    # -> 예산요청 목록에 대해 예산을 늘리거나 줄이는 식으로 이분 탐색을 수행한다.
    # 이 경우, 최악의 경우 탐색 횟수는 대략 N * log2(M)
    # -> 10^5 * log2(10^9 ~= 2^30) -> 3,000,000회

    # 2. 결과 계산
    # 2-1. 변수 선언
    left = N
    right = max(budget_requests)

    # 2-2. 결과 계산
    result = 0
    while left <= right:
        budget = (left + right) // 2

        # 예산 총합 계산 - 예산이 요청금액보다 많은 경우, 요청 금액만큼만 반영
        total = sum(min(budget, b) for b in budget_requests)

        # 예산 초과 시
        if total > M:
            right = budget - 1
        # 그 외; 예산 미달 시, 예산 일치 시
        else:
            result = budget  # 현재 예산을 기록
            left = budget + 1

    # 3. 결과 출력
    print(result)


main()
