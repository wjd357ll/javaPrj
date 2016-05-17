package collection;

public class ExamCollection { // exam�� �����ϴ� �÷���

	private int current;
	
	private int capacity;
	
	private int amount; // �迭 ũ�� �߰� ������
	
	private Exam[] exams; // ĸ���� ���� �ʵ��� private
	
	public ExamCollection(){
		
		amount = 5;
		capacity = 3;
		exams = new Exam[capacity];
		current = -1;	
	}

	public int size() {
		
		return current+1;
	}

	public Exam get(int i) {
	
		return exams[i];
	}

	public void add(Exam exam) { //exam�� �޾Ƽ� ����
		
		++current;
		//���� ������ ���ڶ�� ������ �÷��ش�.
		
		if(current>=capacity)//current = -1 �̾��� ������ ���Ƶ� ������ �ȴ�.
		{
			Exam[] temp = new Exam[capacity + amount];
		
			// exams �迭�� �ִ� ��ü�� temp �迭�� �ű��.
			for(int i=0; i<capacity; i++)
				temp[i] = exams[i];
			
			//������ �迭�� ������ �ʿ䰡 �ְ� ���ο� �迭�� ���� �����Ǵ� �迭�� �Ǿ�� �Ѵ�.
			exams = temp;
			
			//�þ �뷮�� ���ο� ������ ��ġ�Ǿ�� �Ѵ�.
			capacity += amount;
		}	
		exams[current] = exam;
		
	}
}
