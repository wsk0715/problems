import sys

# libs
input = sys.stdin.readline


# 회전 초밥 - S1
# https://www.acmicpc.net/problem/2531


# 1. 입력 받기
# n - 접시 수
# d - 초밥의 가짓수
# k - 연속해서 먹는 접시 수
# c - 쿠폰 번호
n, d, k, c = map(int, input().split())
arr = [int(input()) for _ in range(n)]

# 초밥 개수 배열 초기화
sushi_count = {}
for i in range(k):
    if arr[i] not in sushi_count:
        sushi_count[arr[i]] = 0
    sushi_count[arr[i]] += 1

# 쿠폰 초밥 추가
if c not in sushi_count:
    sushi_count[c] = 0
sushi_count[c] += 1

max_sushi = len(sushi_count)

# 슬라이딩 윈도우 이동
for i in range(1, n):
    # 새 초밥 추가
    new_sushi = arr[(i + k - 1) % n]
    if new_sushi not in sushi_count:
        sushi_count[new_sushi] = 0
    sushi_count[new_sushi] += 1

    # 이전 초밥 제거
    old_sushi = arr[i - 1]
    sushi_count[old_sushi] -= 1
    if sushi_count[old_sushi] == 0:
        del sushi_count[old_sushi]

    max_sushi = max(max_sushi, len(sushi_count))

print(max_sushi)
