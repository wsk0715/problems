import sys

# libs
input = sys.stdin.readline


# 로또 - S2
# https://www.acmicpc.net/problem/6603


# numbers - 숫자를 꺼낼 목록
# current - 현재 선택된 숫자 목록
# start - 탐색을 시작할 인덱스
# k - 고를 숫자 개수
def dfs(numbers, current, start, k):
    # 종료 조건; 6개의 숫자가 모인 경우
    if len(current) == 6:
        print(" ".join(map(str, current)))
        return

    # start 인덱스부터 끝까지 탐색
    for i in range(start, k):
        current.append(numbers[i])  # 1. 삽입 처리
        dfs(numbers, current, i + 1, k)  # 2. 재귀 호출
        current.pop()  # 3. 원상 복구(삽입 취소)


while True:
    given = list(map(int, input().split()))  # 입력 숫자 목록
    k = given[0]  # 고를 숫자의 개수

    # 입력 종료 조건
    if k == 0:
        break

    # 결과 계산 & 출력
    numbers = given[1:]
    dfs(numbers, [], 0, k)
    print()
