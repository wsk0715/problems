import sys

# libs
input = sys.stdin.readline


# 킹 - S3
# https://www.acmicpc.net/problem/1063


# Question
# - 킹은 주어진 입력에 따라 8방향으로 움직일 수 있다.
# - 킹이 돌과 같은 방향으로 움직일 경우 돌을 킹과 같은 방향으로 한 칸 움직인다.
# - 킹이나 돌이 움직여서 체스판 밖으로 나갈 경우, 그 이동을 무효화한다.
#
def solve():
    # 1. 입력 받기
    # king - 킹의 초기 위치
    # stone - 상대 돌의 초기 위치
    # N - 움직일 횟수
    king, stone, N = list(input().split())
    N = int(N)

    # 초기 위치 설정(x, y)
    king_pos = to_coordinate(king)
    stone_pos = to_coordinate(stone)

    # moves - 킹의 이동 목록
    moves = [input().strip() for _ in range(N)]  # strip - 개행(\n) 제거

    # 방향 배열 설정(x, y)
    directions = {
        "R": (1, 0),
        "L": (-1, 0),
        "B": (0, -1),
        "T": (0, 1),
        "RT": (1, 1),
        "LT": (-1, 1),
        "RB": (1, -1),
        "LB": (-1, -1),
    }

    # 2. 시뮬레이션
    for move in moves:
        dx, dy = directions[move]
        king_nx = king_pos[0] + dx
        king_ny = king_pos[1] + dy

        # 상대 돌 이동 처리
        stone_nx, stone_ny = stone_pos
        if king_nx == stone_pos[0] and king_ny == stone_pos[1]:
            stone_nx = stone_pos[0] + dx
            stone_ny = stone_pos[1] + dy

        # 예외 처리; 킹 또는 돌이 체스판을 벗어난 경우
        if not (0 <= king_nx < 8 and 0 <= king_ny < 8) or not (0 <= stone_nx < 8 and 0 <= stone_ny < 8):
            continue

        # 킹과 돌의 위치 갱신
        king_pos = (king_nx, king_ny)
        stone_pos = (stone_nx, stone_ny)

    # 3. 결과 출력
    print(to_chess_string(king_pos))
    print(to_chess_string(stone_pos))


def to_coordinate(pos):
    x, y = ord(pos[0]) - ord("A"), int(pos[1]) - 1
    return x, y


def to_chess_string(coordinate):
    return chr(coordinate[0] + ord("A")) + str(coordinate[1] + 1)


solve()
