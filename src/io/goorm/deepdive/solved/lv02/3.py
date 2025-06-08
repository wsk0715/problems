import sys

# libs
input = sys.stdin.readline


# 기초 구현 - 과연 승자는
def main():
    # N - 카드의 개수
    N = int(input())

    alice_cards, alice_score = list(map(int, input().split())), 0
    bob_cards, bob_score = list(map(int, input().split())), 0

    for i in range(N):
        alice = alice_cards[i]
        bob = bob_cards[i]

        if alice == bob:
            alice_score += 1
            bob_score += 1
        elif alice < bob:
            if bob - alice == 7:
                alice_score += 3
                bob_score -= 1
            else:
                bob_score += 2
        elif alice > bob:
            if alice - bob == 7:
                bob_score += 3
                alice_score -= 1
            else:
                alice_score += 2

    print(alice_score, bob_score)


main()
