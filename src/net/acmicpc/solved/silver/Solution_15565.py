import sys
import math

# libs
input = sys.stdin.readline


# 귀여운 라이언 - S1
# https://www.acmicpc.net/problem/15565


# N - 인형의 총 개수
# K - 목표 라이언 개수
N, K = map(int, input().split())
dolls = list(map(int, input().split()))  # 인형 목록

# 포인터 초기화
left = 0
right = 0
lion_count = 0
result = math.inf

# 탐색
while True:
    if lion_count < K:  # 탐색 구간에 라이언이 K개 미만인 경우
        if right == N:  # 종료 조건; 오른쪽 포인터가 끝에 도달
            break

        # 오른쪽 포인터 이동
        if dolls[right] == 1:
            lion_count += 1
        right += 1
    else:  # 탐색 구간에 라이언이 K개 이상인 경우
        # 결과 갱신
        result = min(result, right - left)

        # 왼쪽 포인터 이동
        if dolls[left] == 1:
            lion_count -= 1
        left += 1

print(result if result != math.inf else -1)
