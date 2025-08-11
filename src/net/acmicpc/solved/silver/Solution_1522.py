import sys
import math

# libs
input = sys.stdin.readline


# 문자열 교환 - S1
# https://www.acmicpc.net/problem/1522


S = input().strip()

# 문자열 내 모든 a를 붙여야 함 -> a의 개수가 윈도우 크기
count_a = S.count("a")

# 문자열 순환 처리
S += S

result = math.inf
for i in range(len(S) // 2):
    current_str = S[i : i + count_a]

    count_b = current_str.count("b")

    if count_b < result:
        result = count_b

print(result)
