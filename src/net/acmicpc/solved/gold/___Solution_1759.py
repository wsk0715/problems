import sys

# libs
input = sys.stdin.readline


# 암호 만들기 - G5
# https://www.acmicpc.net/problem/1759

# L - 암호 자릿수
# C - 문자의 가짓수
L, C = list(map(int, input().split()))

# vowels - 모음 목록
# alphabets - 사용할 수 있는 알파벳 목록
# passwords - 결과를 저장할 배열
vowels = {"a", "e", "i", "o", "u"}
alphabets = sorted(input().split())
passwords = []


# idx - 현재 알파벳 인덱스
# characters - 현재 선택된 알파벳 목록
def calc(idx, characters):

    # 종료 조건; 암호 조건 만족
    if len(characters) == L:
        vowels_count = sum(1 for c in characters if c in vowels)
        consonants_count = len(characters) - vowels_count
        if vowels_count >= 1 and consonants_count >= 2:
            passwords.append("".join(characters))
        return

    # 종료 조건; 인덱스 초과
    if idx >= C:
        return

    # 현재 알파벳을 선택하는 경우 - 현재 알파벳을 집어넣은 후(선택 처리), 재귀 호출 인자로 전달
    characters.append(alphabets[idx])
    calc(idx + 1, characters)
    characters.pop()  # 재귀 호출 종료 후 원상복구(선택 취소)

    # 현재 알파벳을 선택하지 않는 경우
    calc(idx + 1, characters)


calc(0, [])

print("\n".join(passwords))
