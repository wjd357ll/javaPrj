package calendar;

import java.util.Calendar;

public class CalendarPrint {
    
    // Calendar �ν��Ͻ� ����
    Calendar cal = Calendar.getInstance();
    
    // ���ϸ� �迭
    private String[] calDay = {"��","��","ȭ","��","��","��","��"};
    
    private String[][] calDate = new String[6][7];  // ��¥ �迭

    private int width=calDay.length; // 7(���� ����) = width
    private int startDay;   
    private int lastDay; 
    private int inputDate=1;  // ��¥ ����� �� ���Ǵ� ����
    private int error=1; // �Է� ��/��/�� ���� ������ ���� ���� �� ����ϴ� ����
    
    private int date;
    
    
    public int getDate() {
      return date;
   }

   public void setDate(int date) {
      this.date = date;
   }
   
   // ������ - �޷� setting
    public CalendarPrint(int year, int month, int date){
       
            // Calendar�� ��,��,�� setting 
            cal.set(Calendar.YEAR, year);
            cal.set(Calendar.MONTH, month-1);
            cal.set(Calendar.DATE, 1);
            
            startDay = cal.get(Calendar.DAY_OF_WEEK);
 
            lastDay = cal.getActualMaximum(Calendar.DATE);
            
            // calDate�� ��¥ setting
            int row = 0;
            for(int i=1; inputDate<=lastDay; i++){
                
                // ���� ������ ���������� ���� ����
                if(i<startDay) calDate[row][i-1]=" ";
                else{
                
                    calDate[row][(i-1)%width]=Integer.toString(inputDate);
                    // (i-1)%width ���� ������ ������ ����. 0�϶� �Ͽ���, 1�϶� ������..
                    inputDate++;
                   
                    // ������ ���� ����(=������̵Ǹ�)�� �ٲ�� �ϹǷ� row �÷���
                    if(i%width==0) row++;
     
            }
        }
    }

    // �������� ���� ��/��/�� �� �Է��� ��� ȣ��Ǵ� �Լ�
    public int inputError(int year, int month, int date){
       
       error = 1;
       
       if(year<1916 || year>2116){ // ���� 1916~2116���� �޷� ��� ����
            System.out.println("\n\t�޷��� Ȯ���� �� ���� �⵵ �Դϴ�.\n");
            error = 0;
            return error;
        }
       
       if(month<1 || month>12){
          System.out.printf("\n\t%d���� �����ϴ�.\n", month);
            System.out.println("\n\t1~12 ������ ���� �Է��ϼ���.\n");
            error = 0;
            return error;
        }
       
       //if(date>lastDay)
       
       if(month==4 || month==6 || month==9 || month==11) // 30�ϱ��� �ִ� ��
          if(date<1 || date>30){
             System.out.println("\n\t1~30 ������ ��¥�� �Է��ϼ���.\n");
             error = 0;
             return error;
          }
       
       // 31�ϱ��� �ִ� ��
       if((month%2==1 && month<8) || month==8 || month==10 || month==12){
          if(date<1 || date>31){
             System.out.println("\n\t1~31 ������ ��¥�� �Է��ϼ���.\n");
             error = 0;
             return error;
          }
       }
       
       // 2���� ������ ��� 29�ϱ���
      if(month==2){
         if((year%4==0) && (!(1<=date && date<=29))){
             System.out.printf("\n\t%d���� �����Դϴ�. 1~29 ������ ��¥�� �Է��ϼ���.\n", year);
             error = 0;
             return error;
         }
         else if((year%4!=0) && (!(1<=date && date<=28))){
            System.out.println("\n\t1~28 ������ ��¥�� �Է��ϼ���.\n");
             error = 0;
             return error;
         }
      }
       return error;
    }

   // �޷� ���
    public void printCal(int year, int month, int date){
        
        // ���ϸ� ���
        for(int i=0; i<width; i++){
            System.out.print("\t" + calDay[i]);
        }
        System.out.println();
        
        // ��¥ ���
        int row=0;
        for(int j=1 ; j<lastDay+startDay; j++){ 
           // lastDay(�ش� ���� ��¥ ��) + startDay(���ۿ��� �������� ���� ��) : �޷¿� ����� �ʿ��� �� ĭ ��(����+��¥)
            
           
           // calDate String�� �迭�̹Ƿ� date���� string������ ����ȯ ���ش�.
           if(calDate[row][(j-1)%width].equals(Integer.toString(getDate())))
              System.out.print("\t" + "[" + date + "]");
           else
              System.out.print("\t" + calDate[row][(j-1)%width]);
           
           // (j-1)%width == width-1 (6�̸� �����) �� �����ϸ� ���� �ٲٰ� row�� �÷���
           if((j-1)%width==width-1){
                System.out.println();
                row++;
            }
        }
    }

    
    // ���θ޴����� 1�� ���ý� ȣ��Ǵ� �� �˻� �Լ� (�����ε�)
    public void printCal(int month){  
        
        // ���ϸ� ��� "�Ͽ�ȭ�������"
        for(int i=0; i<width; i++){
            System.out.print("\t" + calDay[i]);
        }
        System.out.println();
        
        // ��¥ ���
        int row=0;
        for(int j=1 ; j<lastDay+startDay; j++){
                
              System.out.print("\t" + calDate[row][(j-1)%width]);
           
           if((j-1)%width==width-1){
                System.out.println();
                row++;
            }
        }
    }
}