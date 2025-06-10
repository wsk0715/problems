import sys
from itertools import combinations

# libs
input = sys.stdin.readline


# 암호 만들기 - G5
# https://www.acmicpc.net/problem/1759

# L - 암호 자릿수
# C - 문자의 가짓수
L, C = list(map(int, input().split()))

# vowels - 모음 목록
# alphabets - 사용할 수 있는 알파벳 목록
vowels = {"a", "e", "i", "o", "u"}
alphabets = sorted(input().split())


# 모든 조합 생성
for comb in combinations(alphabets, L):
    # 모음/자음 개수 세기
    vowel_count = sum(1 for c in comb if c in vowels)
    consonant_count = L - vowel_count

    # 조건 확인; 최소 1개 모음, 2개 이상 자음
    if vowel_count >= 1 and consonant_count >= 2:
        print("".join(comb))
