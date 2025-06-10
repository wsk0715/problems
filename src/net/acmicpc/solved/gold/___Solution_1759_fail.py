import sys

# libs
input = sys.stdin.readline


# 암호 만들기 - G5
# https://www.acmicpc.net/problem/1759

# L - 암호 자릿수
# C - 문자의 가짓수
L, C = list(map(int, input().split()))

# vowels - 모음 목록
vowels = {"a", "e", "i", "o", "u"}
alphabets = sorted(input().split())
passwords = []


# idx - int, 현재 알파벳 인덱스
# choice - boolean, 현재 문자 선택 여부
# characters - list, 현재 선택된 문자 목록
def calc(idx, choice, characters):
    global vowels, alphabets, passwords

    # 종료 조건 - 인덱스 초과
    if idx >= C:
        return

    # 암호 선택 로직 수행 - 현재 문자를 선택할지, 안할지
    if idx != -1 and choice:
        characters.append(alphabets[idx])

    # 종료 조건 - 암호 자릿수 충족 여부 확인
    if len(characters) == L:
        vowel_count = sum(1 for c in characters if c in vowels)
        consonant_count = len(characters) - vowel_count
        if vowel_count < 1 or consonant_count < 2:  # 최소 하나의 모음, 두개의 자음을 포함하는지 확인
            return

        passwords.append("".join(str(ch) for ch in characters))  # 생성된 암호 추가

    # 다음 문자를 선택하는 경우
    calc(idx + 1, True, characters[:])

    # 다음 문자를 선택하지 않는 경우
    calc(idx + 1, False, characters[:])


calc(-1, False, [])

result = "\n".join(passwords)
print(result)


# ---
# 실패 원인
# 1. acis와 같이, 초반 인덱스를 포함하는 케이스가 여러 번 출력되는 문제
#    -> idx는 항상 +1을 전달하고, 인덱스가 거슬러 올라갈 이유가 없는데 어째서?
#    -> acis는 4번, acit은 2번, aist는 2번 등 패턴 포착
#    -> 원인
#       -> 이미 acis와 같이 조건이 충족된 상태에서, t, w 등 다음 호출 자체는 실행됨
#       -> 그러나 이미 조건을 만족했기때문에 지금까지 누적 암호를 반환하게 됨
#       -> 따라서 aics -> 2^2(t, w) = 4회 만큼, acit -> 2^1(w) = 2회만큼 중복되는 현상 발생
# 2. cist 이후의 암호가 출력되지 않는 문제
#    -> 반복문 내부 디버그 결과, '암호 선택 로직' 위치가 문제였던 점 확인
#    -> 기존에는 두 가지 종료 조건을 모두 수행한 후 '암호 선택 로직'을 수행하도록 함
#    -> 이 때문에 istw와 같이 마지막 인덱스를 포함하는 암호는 실제로 암호가 추가되기 전 종료조건을 검사하게 되고, 결국 암호가 추가되지 않은 상태로 재귀 호출이 종료됨
# 3. 공간 복잡도 문제
#    -> 모든 재귀 호출에서 리스트를 복제해서 전달하고 있음 -> 메모리 사용량 기하급수적으로 증가(2^C)
