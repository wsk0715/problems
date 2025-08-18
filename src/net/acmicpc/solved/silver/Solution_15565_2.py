import sys
import math

# libs
input = sys.stdin.readline


# 귀여운 라이언 - S1
# https://www.acmicpc.net/problem/15565


# N - 인형의 총 개수
# K - 목표 개수
N, K = map(int, input().split())
dolls = list(map(int, input().split()))  # 인형 목록

# 라이언 인형의 인덱스 저장
pos = [i for i, val in enumerate(dolls) if val == 1]

if len(pos) < K:
    print(-1)
else:
    answer = math.inf
    for i in range(len(pos) - K + 1):
        length = pos[i + K - 1] - pos[i] + 1
        answer = min(answer, length)
    print(answer)
