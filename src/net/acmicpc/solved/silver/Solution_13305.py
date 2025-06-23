import sys

# libs
input = sys.stdin.readline


# 주유소 - S3
# https://www.acmicpc.net/problem/13305

# N - 도시 개수
N = int(input())

# roads - 도로 길이 리스트 (길이 N-1)
roads = list(map(int, input().split()))

# prices - 도시 별 기름 가격 (길이 N)
prices = list(map(int, input().split()))

# Question
# 1km 이동 = 1L 소비
# 각 도시에서 기름을 넣고, 다음 도시까지 주행
# 처음 도시에서 마지막 도시까지 이동하는 최소 비용을 구하는 문제

# Idea
# 전형적인 그리디(Greedy) 알고리즘 문제
# -> 지금까지 만난 주유소 중 가장 싼 곳에서만 계속 주유
# -> 더 싼 곳이 나타나면 주유소를 바꾼다 (나타나지 않으면 유지)
# -> 리터당 가격의 최소값을 유지하며 (거리 * 최소 가격)을 계산

# min_price - 지금까지의 최소 기름 가격; 초기값 첫 번째 도시
min_price = prices[0]

# total_cost - 총 비용
total_cost = 0

for i in range(N - 1):
    # i번째 도로를 지나기 위한 비용 = 현재까지의 최소 가격 * 현재 도로 거리
    total_cost += min_price * roads[i]

    # 다음 도시의 주유소가 더 싸면 최소 가격을 갱신
    if prices[i + 1] < min_price:
        min_price = prices[i + 1]

print(total_cost)

# Constraints
# 도시의 개수 N; 2 <= N <= 100,000
# 제일 왼쪽 도시부터 오른쪽 도시까지의 거리 x; 1 <= x <= 10^9
# 리터당 가격 x; 1 <= x <= 10^9

# Result
# 시간 복잡도 - O(N)
#   - N-1 범위의 반복문 사용
# 공간 복잡도 - O(N)
#   - roads, prices - 길이 N인 배열
