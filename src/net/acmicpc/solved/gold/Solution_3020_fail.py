import sys
import math

# libs
input = sys.stdin.readline


# 개똥벌레 - G5
# https://www.acmicpc.net/problem/3020

# Question
# 장애물(석순, 종유석)이 있는 길이 N, 높이 H의 동굴 (N은 짝수)
# 첫 번째 장애물은 항상 석순이고, 이후부터 번갈아가며 등장
# 개똥벌레는 경로 상의 장애물을 파괴하며 나아간다.
# 개똥벌레가 파괴해야 하는 장애물의 최솟값과, 그에 해당하는 높이의 갯수
#

# 1. 입력받기
# N - 동굴의 길이
# H - 동굴의 높이
N, H = list(map(int, input().split()))

# 2. 장애물 입력받기 & 결과 저장
hits = [0] * H  # 부딪힌 횟수(인덱스 = 높이)
for i in range(N):

    h = int(input())
    if i % 2 == 0:
        # 홀수 번째(짝수 인덱스)일 때; 석순
        for j in range(h):
            # print("j = ", j)
            hits[j] += 1
    elif i % 2 == 1:
        # 짝수 번째일 때; 종유석
        for j in range(H - 1, H - h - 1, -1):
            # print("j = ", j)
            hits[j] += 1

# 3. 최소 충돌 횟수 구하기
min_hit = min(hits)
count = 0
for hit in hits:
    if hit == min_hit:
        count += 1

# 4. 결과 출력
print(min_hit, count)
