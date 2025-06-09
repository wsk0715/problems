import sys

# libs
input = sys.stdin.readline


N = 0
ingredients = []
min_diff = 10**9 + 1


# 도영이가 만든 맛있는 음식 - S2
# https://www.acmicpc.net/problem/2961
def main():
    global N, ingredients, min_diff

    # N - 재료의 개수, 1 <= N <= 10
    N = int(input())

    for _ in range(N):
        ingredients.append(list(map(int, input().split())))

    calc(0, 1, 0)  # 신맛은 곱이기때문에 1에서 시작

    print(min_diff)


# idea
# 신맛과 쓴맛의 차이가 가장 적은 요리를 만들어야 함
# -> 각 재료를 선택하는 경우와 선택하지 않는 경우로 나눌 수 있다.
def calc(index, current_sour, current_bitter):
    global ingredients, min_diff

    # 종료 조건 - 모든 재료를 선택(탐색)한 경우(더 이상 선택할 재료가 없을 때)
    if index == N:
        if current_bitter != 0:  # 재료를 하나라도 선택해야 함
            diff = abs(current_sour - current_bitter)
            min_diff = min(min_diff, diff)  # 누적된 최소값과 비교
        return

    # 재귀 호출; 현재 재료를 선택하지 않는 경우
    calc(index + 1, current_sour, current_bitter)

    # 재귀 호출; 현재 재료를 선택한 경우
    new_sour = current_sour * ingredients[index][0]  # 신맛 = 사용한 신맛의 곱
    new_bitter = current_bitter + ingredients[index][1]  # 쓴맛 = 사용한 쓴맛의 합
    calc(index + 1, new_sour, new_bitter)


main()
