package com.javaex.ex01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;


public class PhoneApp {

	public static void main(String[] args) throws IOException{

	    Scanner sc = new Scanner(System.in);
		
		System.out.println("**************************************");
		System.out.println("*          전화번호 관리 프로그램          *");
		System.out.println("**************************************");
		System.out.println("");
		System.out.println(" 1.리스트  2.등록  3.삭제  4.검색  5.종료 ");
		System.out.println("--------------------------------------");
		java.util.List<Person> pList = new ArrayList<Person>();
    	
		Reader fr = new FileReader("/Users/benedict/Desktop/Java_Study/강의자료/미니 프로젝트/PhoneDb.txt");
    	BufferedReader br = new BufferedReader(fr);
    	
    	boolean flag =true;
    	
    	String line = "";
    	
    	while(true) {
    		
    		
    		line = br.readLine();
			
			if(line == null) {
			
				
				break;
			
			
			}
			String[] pInfo = line.split(",");
			
			String name = pInfo[0];
			String hp = pInfo[1];
			String company = pInfo[2];
			
			Person person = new Person(name, hp, company);
			
			pList.add(person);
    	
    	}
		
    	while(flag) {
			System.out.print(">메뉴번호: ");
			int select = sc.nextInt();
			
			switch (select) {
				
			
			
			case 1:{
					
				
					
		    	
		    	
				for(int i = 0; i<pList.size(); i++) {
					
					System.out.print((i+1)+".  ");
					System.out.print(pList.get(i).getName()+"  ");
					System.out.print(pList.get(i).getHp()+"  ");
					System.out.println(pList.get(i).getCompany());
				}	
					
					
					br.close();
				
				
				System.out.println("");
				System.out.println(" 1.리스트  2.등록  3.삭제  4.검색  5.종료 ");
				System.out.println("--------------------------------------");
				break;
			}	
			
			case 2:{ 
				System.out.println("2.등록");
				System.out.print(">이름: ");
				String name1 = sc.next();
				System.out.print(">휴대전화: ");
				String hp1 = sc.next();
				System.out.print(">회사전화: ");
				String company1 = sc.next();
				
				Person nInpo = new Person();
				
				
				
				
				
				nInpo.setName(name1);
				nInpo.setHp(hp1);
				nInpo.setCompany(company1);
				
				pList.add(nInpo);
				
				Writer fw = new FileWriter("/Users/benedict/Desktop/Java_Study/강의자료/미니 프로젝트/PhoneDb01.txt");
				BufferedWriter bw = new BufferedWriter(fw);
				
				for(int i = 0; i<pList.size(); i++) {
					String str = pList.get(i).getName()+","+pList.get(i).getHp()+","+pList.get(i).getCompany();
					bw.write(str);
					bw.newLine();
					bw.flush();
				}
				
				
				System.out.println("[등록되었습니다.]");
				System.out.println("");
				System.out.println(" 1.리스트  2.등록  3.삭제  4.검색  5.종료 ");
				System.out.println("--------------------------------------");
			
				bw.close();
				break;
			
			}
			
			case 3:{
				System.out.println("<3.삭제>");
				System.out.print(">번호 : ");
				int num1 = sc.nextInt();
				pList.remove(num1-1);
				
				
				
				System.out.println("[삭제되었습니다.]");
				System.out.println("");
				System.out.println(" 1.리스트  2.등록  3.삭제  4.검색  5.종료 ");
				System.out.println("--------------------------------------");
				
				
				
				break;
			}
			
			case 4:{
				System.out.println("<4.검색>");
				System.out.print(">이름: ");
				String nam = sc.next();
				
				for(int i = 0; i<pList.size(); i++) {
					if(  (pList.get(i).getName()).contains(nam)  ) {
						System.out.print((i+1)+".  ");
						System.out.print(pList.get(i).getName()+"  ");
						System.out.print(pList.get(i).getHp()+"  ");
						System.out.println(pList.get(i).getCompany());
						
					}	
					
				}
				System.out.println("");
				System.out.println(" 1.리스트  2.등록  3.삭제  4.검색  5.종료 ");
				System.out.println("--------------------------------------");
				break;
			}
			
	
			case 5:{
				flag=false;
				break;
			}
			
			default:{
				System.out.println("[다시 입력해주세요.]");
				break;
				
				
			}
			
			
		
			}
		
			
			
			}
			
			
			
			
			
		
		
		
	
	}
	
	
}
		
		
		

	



	


