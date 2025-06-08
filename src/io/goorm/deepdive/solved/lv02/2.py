import sys

# libs
input = sys.stdin.readline


# 기초 구현 - 합리적 소비
def main():
    # N - 정리된 물품의 개수
    N = int(input())

    max_name, max_price = "", 0  # 가격 최소값 - 1
    min_name, min_price = "", 100_001  # 가격 최대값 + 1

    for _ in range(N):
        name, price = input().split()
        price = int(price)

        if price > max_price:
            max_name = name
            max_price = price

        if price < min_price:
            min_name = name
            min_price = price

    print(max_name, max_price)
    print(min_name, min_price)


main()
