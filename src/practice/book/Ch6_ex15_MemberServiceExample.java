package practice.book;

public class Ch6_ex15_MemberServiceExample {

	public static void main(String[] args) {
		
		Ch6_ex15_MemberService memberService = new Ch6_ex15_MemberService();
		
		boolean result = memberService.login("hong", "12345");
		
		if(result){
			System.out.println("\n\t�α��� �Ǿ����ϴ�.");
			memberService.logout("hong");
		}
		else{
			System.out.println("id �Ǵ� password�� �ùٸ��� �ʽ��ϴ�.");
		}

	}

}
