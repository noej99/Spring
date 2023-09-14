package com.noej.jun131.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

// 마트 정책이 포인트를 0.5% 적립하는걸로 바뀜
// -> 프로그램 수정
// -> 마트사장이 point.txt수정하면 됨
// => 마트측에서 해결 가능

// 뭔가가 .java에 -> 컴파일 당해서 -> 수정불가능하게
// 앞으로 말하는 유지보수에 용이 : 
//		수정 일어날만한거는 .java에 하지말고 외부 파일에

//	eGovFramework
//		MyBatis	: Java + DB 유지보수에 용이 
//		Maven	: .jar관리 유지보수에 용이
//		Spring	: Java객체 유지보수에 용이

public class Mart2 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		BufferedReader br = null;
		try {
			FileInputStream fis = new FileInputStream("C:/Users/soldesk/Desktop/point.txt");
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");
			br = new BufferedReader(isr);
			String p = br.readLine();
			double pointRate = Double.parseDouble(p);
			
			int price;
			double point;
			double myPoint = 0;
			while (true) {
				System.out.print("구매한 금액 : ");
				price = s.nextInt();
				point = price * pointRate;
				if (price < 0) {
					break;
				}
				System.out.printf("적립되는 포인트 : %.1f\r\n", point);
				myPoint += point;
				System.out.printf("내 포인트 : %.1f\r\n", myPoint);
				System.out.println("-----------------------");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			br.close();
		} catch (IOException e) {
		}
		s.close();
	}
}
