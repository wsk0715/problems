import sys

# libs
input = sys.stdin.readline


N = 0
ingredients = []
min_diff = 10**9 + 1


# (비트마스킹을 이용한 풀이)
# 도영이가 만든 맛있는 음식 - S2
# https://www.acmicpc.net/problem/2961
def main():
    global N, ingredients, min_diff

    # N - 재료의 개수, 1 <= N <= 10
    N = int(input())

    for _ in range(N):
        ingredients.append(list(map(int, input().split())))

    # idea
    # 신맛과 쓴맛의 차이가 가장 적은 요리를 만들어야 함
    # -> 각 재료를 선택하는 경우와 선택하지 않는 경우로 나눌 수 있다.

    for i in range(1, 1 << N):  # 재료를 사용하지 않는 경우는 허용하지 않음, 1부터 시작
        sour = 1
        bitter = 0

        for j in range(N):
            # j번째 비트가 1인지(j번째 재료를 포함하는지) 확인
            if i & (1 << j):
                sour *= ingredients[j][0]  # 신맛 = 사용한 신맛의 곱
                bitter += ingredients[j][1]  # 쓴맛 = 사용한 쓴맛의 합

        diff = abs(sour - bitter)
        min_diff = min(min_diff, diff)

    print(min_diff)


main()
