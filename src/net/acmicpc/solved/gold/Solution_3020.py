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

# 장애물 시작 높이 입력
bottom = [0] * (H + 2)  # 높이 h에서 시작하는 석순 개수
top = [0] * (H + 2)  # 높이 h에서 시작하는 종유석 개수; 석순과 반대 방향이지만 편의상 뒤집어서 저장
for i in range(N):

    h = int(input())
    if i % 2 == 0:
        # 홀수 번째인 경우(짝수 인덱스); 석순
        bottom[h] += 1
    else:
        # 짝수 번째인 경우; 종유석
        top[h] += 1

# 2. 누적 합 계산 (높이 h에서 부딪히는 장애물 개수)
# Idea
# 높이가 작을수록(축에서 가까울수록) 더 많은 장애물에 영향받게 됨
# (높이 h인 장애물에 부딪힌다면 h+1인 장애물에도 반드시 부딪히게 됨)
# -> 따라서 높이 H-1에서 0까지 역순으로 반복 수행
for h in range(H - 1, 0, -1):
    bottom[h] += bottom[h + 1]
    top[h] += top[h + 1]

# 3. 최소값, 빈도 계산
min_hits = math.inf
count = 0
for height in range(1, H + 1):
    hits = bottom[height] + top[H - height + 1] # 종유석은 천장에서부터 자라기때문에, 역방향 인덱스 사용

    if hits < min_hits:
        min_hits = hits
        count = 1
    elif hits == min_hits:
        count += 1

print(min_hits, count)
