package exceptionlib;

public class Calculator {
		
	public static int add(int x, int y){
		int result = x + y;
		return result;
	}

	public static int sub(int x, int y){
		int result = x - y;
		return result;
	}

	public static int multi(int x, int y){
		int result = x * y;
		return result;
	}

	public static int div(int x, int y) throws �����γ������ܿ���, ������������ܿ���{

		if(y==0)
			throw new �����γ������ܿ���();
		
		if(!(0<=x && x<=100))
			throw new ������������ܿ���();
		
		int result = x / y;
		return result;
	}
	
	// �� �Լ����� ����Ϸ��� Calculator ��ü�� �����ؼ� ����ؾ��Ѵ�.
	// ������ ��ü���������� �ۼ��� ���α׷��� �ƴϴ�. this�� ����� �ʿ䰡 ����. ��ü�� �ʿ����.
	// �Լ��� static�� �ٿ��� ��ü���������� ���� �Լ����������� ������ �Ѵ�. (ĸ���� ��� ���� �Ѵ�.)
}

