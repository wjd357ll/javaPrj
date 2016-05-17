package collection.generic;

public class GCollection <T> { // G = templet
	// ��ü���� �޶����� �κ��� �ִٸ� ���۳��ڴ�.
	// �ڷ����� ����ó�� �׸����μ� ���� ��ü�� �� �ִ� �׸��� �������� �ʴ´�.
	// ���ø��� ����� ���� : �������� ��������, ������ �ڷ����� ���ø��̶�� ������ �ָ� �����Ϸ��� �ϼ��Ѵ�.

	private int current;
	
	private int capacity;
	
	private int amount; 
	
	private T[] data;
	
	public class Iterator {  //thread���� index�� ���� ���������.
		
		private int index;
		
		public Iterator(){
			index = -1;
		}
		
		public T next() {
			
			return data[++index];
		}
	
		public boolean hasNext() {
			
			return index < current;
		}
		
		public void clear() {
			
			index = -1;
			
		}
	}
	public GCollection(){
		
		amount = 5;
		capacity = 3;
		data = (T[]) new Object[capacity];
		current = -1;	
	}

	public int size() {
		
		return current+1;
	}

	public T get(int i) {
	
		return data[i];
	}

	public void add(T exam) { //exam�� �޾Ƽ� ����
		
		++current;
		//���� ������ ���ڶ�� ������ �÷��ش�.
		
		if(current>=capacity)//current = -1 �̾��� ������ ���Ƶ� ������ �ȴ�.
		{
			T[] temp = (T[])new Object[capacity + amount];
		
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
	// ArrayList�� �����ؼ� add�Լ� ȣ���ϴ� ������� ����ϸ� ���� add�Լ� ���� �ʿ� ����. �̹� ���̺귯���� ����

	public Iterator iterator() {           // index�� ���õ� �Լ����� ���� ĸ��ȭ�Ѵ�.
		
		return new Iterator();
	}
}
