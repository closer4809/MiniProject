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
		
		
		
		java.util.List<Person> pList = new ArrayList<Person>(); //전화번호 리스트 저장할 어레이리스트 생
    	
		Reader fr = new FileReader("/Users/benedict/Java_Study/강의자료/미니 프로젝트/PhoneDb.txt"); //파일리더로 텍스트에서 파일 읽어옴
    	BufferedReader br = new BufferedReader(fr); // 버퍼드를 활용하여 빠르게 읽어
    	
    	String line = ""; //텍스트로 읽어서 담을 변수생성 및 초기
    	
    	while(true) { 
    		line = br.readLine(); //한줄씩 읽어
			
			if(line == null) {
				break; //미리 생성해둔 라인안에 들어오는 자료가 없으면 break
			}
			
			String[] pInfo = line.split(",");	// 배열을 생성, 스플릿을 활용하여 "," 단위로 이름, 전화번호, 회사번호 구
			
			String name = pInfo[0];				// 스플릿하여 받아온 정보를 person 클래스의 필드에 저 
			String hp = pInfo[1];
			String company = pInfo[2];
			
			Person person = new Person(name, hp, company);	// person이라는 생성자를 만들어 저
			
			pList.add(person); // 리스트의 add 메소드를 활용하여 pList에 정보추가 
    	
    	}
		
    	boolean flag =true;	// while 문의 탈출조건 생
    	
    	while(flag) {
    		System.out.println(" 1.리스트  2.등록  3.삭제  4.검색  5.종료 ");
    		System.out.println("--------------------------------------");
    		System.out.print(">메뉴번호: ");	// 계속 반복될 것
			
    		int select = sc.nextInt();	// 키보드로 숫자를 받아와서 메뉴 선
			
			switch (select) { // switch문을 활용하여 1:1 대입되는 시스템 만들것
				
			
			
			case 1:{	// 1을 입력하였을
				
				for(int i = 0; i<pList.size(); i++) { // 가지고있는 pList의 정보를 내가 지정한 형태로 표
					
					System.out.print((i+1)+".  ");						
					System.out.print(pList.get(i).getName()+"  ");		// 이부분은 따로 ShowInfo메소드로 생성가
					System.out.print(pList.get(i).getHp()+"  ");
					System.out.println(pList.get(i).getCompany());
				}	
					
				//
				
				
				System.out.println("");
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
				
				Writer fw = new FileWriter("/Users/benedict/Java_Study/강의자료/미니 프로젝트/PhoneDb01.txt");
				BufferedWriter bw = new BufferedWriter(fw);
				
				for(int i = 0; i<pList.size(); i++) {
					String str = pList.get(i).getName()+","+pList.get(i).getHp()+","+pList.get(i).getCompany();
					bw.write(str);
					bw.newLine();
					bw.flush();
				}
				
				
				System.out.println("[등록되었습니다.]");
				System.out.println("");
			
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
		
		
		

	



	


