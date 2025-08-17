import sys

# libs
input = sys.stdin.readline


# 좋다 - G4
# https://www.acmicpc.net/problem/1253


N = int(input())  # 숫자 개수
A = list(map(int, input().split()))  # 수 목록
A.sort()

result = 0
for i in range(N):
    target = A[i]

    # 탐색
    left, right = 0, N - 1  # 범위 설정
    while left < right:
        # 범위 확인
        if left == i:
            left += 1
            continue
        if right == i:
            right -= 1
            continue

        # 결과 계산
        sum = A[left] + A[right]
        if sum == target:
            result += 1
            break
        elif sum < target:
            left += 1
        else:
            right -= 1

print(result)
