import sys

# libs
input = sys.stdin.readline


# 에디터 - S2
# https://www.acmicpc.net/problem/1406

S = input().strip()
N = int(input())
pointer = len(S)  # 안써도 됨.

left = list(S)    # 커서 기준 왼쪽
right = []        # 커서 기준 오른쪽; 스택으로 사용할거기 때문에 뒤집혀 있다고 생각하기

for i in range(N):
    command = input().split()

    # 커서 이동 - 왼쪽
    if command[0] == 'L':
        if left:
            right.append(left.pop())  # 커서 기준, 오른쪽 스택에서 빼서, 왼쪽 스택에 삽입

    # 커서 이동 - 오른쪽
    elif command[0] == 'D':
        if right:
            left.append(right.pop())  # 커서 기준, 왼쪽 스택에서 빼서, 오른쪽에 삽입

    # 삭제 (커서 왼쪽)
    elif command[0] == 'B':
        if left:
            left.pop()  # 왼쪽 스택(커서 기준 좌측)에 문자 제거

    # 삽입 (커서 왼쪽)
    elif command[0] == 'P':
        left.append(command[1])  # 왼쪽 스택(커서 기준 좌측)에 문자 삽입
        

print(''.join(left + right[::-1]))  # right 스택은 뒤집혀 있기 때문에 다시 뒤집기