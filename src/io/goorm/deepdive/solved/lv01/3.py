import sys

# libs
input = sys.stdin.readline


# 기초 수학 - 여유 황금비
def main():
    # N - 테스트케이스 갯수
    N = int(input())

    result = 0
    for _ in range(N):
        # A, B 중 작은 수의 1.6배 이상, 1.63배 이하에 큰 수가 존재하는지 확인
        A, B = list(map(int, input().split()))

        if min(A, B) * 1.6 <= max(A, B) <= min(A, B) * 1.63:
            result += 1

    print(result)


main()
