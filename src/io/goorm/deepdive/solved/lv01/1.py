import sys

# libs
input = sys.stdin.readline


# 기초 수학 - 운동 중독 플레이어
def main():
    # W - 한 세트에서 들어올린 무게
    # R - 반복 횟수
    W, R = list(map(int, input().split()))

    result = int(calc(W, R))

    print(result)


def calc(W, R):
    return W * (1 + R / 30)


main()
