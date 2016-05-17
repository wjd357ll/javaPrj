package calendar;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarMain {

    public static void main(String[] args) {
    	
        int year;
        int month;
        int date;
        int menu;
        
        Scanner scan = new Scanner(System.in);
        
        Calendar calendar = Calendar.getInstance();
       
        year = calendar.get(Calendar.YEAR);
		month = calendar.get(Calendar.MONTH)+1;
		date = calendar.get(Calendar.DATE);
		
        System.out.println("\n      \t����������������������������������������������������������������������������������������������������");
        System.out.printf("      \t��\t               ������ %d�� %d�� %d�� �Դϴ�.\t         ��\n", year, month, date);
		System.out.println("      \t����������������������������������������������������������������������������������������������������\n");
		
		System.out.printf("\t\t\t      %d �� \n\n", month);
		
    	CalendarPrint cal = new CalendarPrint(year, month, date);
    	cal.setDate(date);
        cal.printCal(year, month, date);
        
        calProgram:
        while(true){

			System.out.println("\n\n\t1. �� �˻� ");
			System.out.println("\t2. ��/��/�� �˻�");
			System.out.println("\t3. ����\n\n");
			System.out.print("\t���Ͻô� �޴��� �Է��ϼ��� : ");
			menu = scan.nextInt();

			switch(menu){
			
			case 1:
				
				CalendarPrint thiscal = new CalendarPrint(year, month, date);

		        System.out.print("\t���� �Է��ϼ��� : ");
		        month=scan.nextInt();
		        System.out.println("\n");
		        
		        //�Է� ���� ��� ��� ��ȯ�� error���� 0�̸� ó������ ���ư�
		        if(cal.inputError(year, month, date)==0) 
		        	continue;
				
		        System.out.printf("\t\t\t      %d �� \n\n", month);
		        
		        thiscal.printCal(month);
				break;
				
			case 2:
					
					System.out.print("\n\n\t�⵵�� �Է��ϼ��� : ");
			        year=scan.nextInt();
			        System.out.print("\t���� �Է��ϼ��� : ");
			        month=scan.nextInt();
			        System.out.print("\t��¥�� �Է��ϼ��� : ");
			        date=scan.nextInt();
			        cal.setDate(date);

			        if(cal.inputError(year, month, date)==0)
			        	continue;

		        System.out.printf("\n\t\t\t   %d ��   %d ��  %d ��\n\n", year, month, date);
		        
		        CalendarPrint inputcal = new CalendarPrint(year, month, date);
		        inputcal.setDate(date);
		        inputcal.printCal(year, month, date);
		        break;
		        
			case 3:
				System.out.println("\n\t���α׷��� �����մϴ�.");
				break calProgram;
			default :
				System.out.println("\n\t�߸� �Է��ϼ̽��ϴ�. ���� �޴��� ���ư��ϴ�.");
				continue;
				
			}     
        }     
    }
}
