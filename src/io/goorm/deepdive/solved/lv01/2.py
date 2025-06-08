import sys

# libs
input = sys.stdin.readline


# 기초 수학 - 울타리 치기
def main():
    # N - 농장을 이루는 땅의 수
    N = int(input())
    farms = list(map(int, input().split()))

    # 위/아래 면 -> N * 2
    result = N * 2

    # 좌측 끝
    result += farms[0]

    # 중간
    for i in range(1, N):
        result += abs(farms[i] - farms[i - 1])

    # 우측 끝
    result += farms[N - 1]

    print(result)


main()
