import sys

# libs
input = sys.stdin.readline


# 기초 구현 - 합 계산기
def main():
    # T - 식의 개수
    T = int(input())

    r = 0
    for _ in range(T):
        # 계산식은 <정수> <연산 기호> <정수> 형태로 주어진다.
        N, op, M = input().split()

        N = int(N)
        M = int(M)
        if op == "+":
            r += N + M
        elif op == "-":
            r += N - M
        elif op == "*":
            r += N * M
        elif op == "/":
            r += N // M

    print(r)


main()
