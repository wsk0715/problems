package kr.co.programmers.school.solved;

public class Solution_120838 {
	// 모스부호(1)
	// https://school.programmers.co.kr/learn/courses/30/lessons/120838
	public static void main(String[] args) {
		Solution sol = new Solution();

		String input = ".... . .-.. .-.. ---";
		sol.solution(input);
	}

	static class Solution {
		public String solution(String letter) {
			String[] morse = {
					".-:a", "-...:b", "-.-.:c", "-..:d", ".:e", "..-.:f",
					"--.:g", "....:h", "..:i", ".---:j", "-.-:k", ".-..:l",
					"--:m", "-.:n", "---:o", ".--.:p", "--.-:q", ".-.:r",
					"...:s", "-:t", "..-:u", "...-:v", ".--:w", "-..-:x",
					"-.--:y", "--..:z"};

			String[] arr = letter.split(" ");  // 결과를 담을 배열: 입력받은 모스 부호를 공백을 기준으로 미리 나눈다.
			for (int i = 0; i < arr.length; i++) {  //
				for (String mor : morse) {  // 각각의 모스부호에 대해:
					String[] m = mor.split(":");  // ex. ".-:a" 는 {".-", "a"}로 나누어진다.

					if (arr[i].equals(m[0])) {
						arr[i] = arr[i].replace(m[0], m[1]);  // ex. m[0] : ".-", m[1] : "a"
					}
				}
			}

			StringBuilder result = new StringBuilder();
			for (String s : arr) {
				result.append(s);
			}
			return result.toString();
		}

	}

}
