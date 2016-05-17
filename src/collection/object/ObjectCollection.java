package collection.object;

public class ObjectCollection { // exam�� �����ϴ� �÷���

	private int current;
	
	private int capacity;
	
	private int amount; // �迭 ũ�� �߰� ������
	
	private Object[] data; // ĸ���� ���� �ʵ��� private
	
	public ObjectCollection(){
		
		amount = 5;
		capacity = 3;
		data = new Object[capacity];
		current = -1;	
	}

	public int size() {
		
		return current+1;
	}

	public Object get(int i) {
	
		return data[i];
	}

	public void add(Object exam) { //exam�� �޾Ƽ� ����
		
		++current;
		//���� ������ ���ڶ�� ������ �÷��ش�.
		
		if(current>=capacity)//current = -1 �̾��� ������ ���Ƶ� ������ �ȴ�.
		{
			Object[] temp = new Object[capacity + amount];
		
			// exams �迭�� �ִ� ��ü�� temp �迭�� �ű��.
			for(int i=0; i<capacity; i++)
				temp[i] = data[i];
			
			//������ �迭�� ������ �ʿ䰡 �ְ� ���ο� �迭�� ���� �����Ǵ� �迭�� �Ǿ�� �Ѵ�.
			data = temp;
			
			//�þ �뷮�� ���ο� ������ ��ġ�Ǿ�� �Ѵ�. 
			capacity += amount;
		}	
		data[current] = exam;
		
	}
}
