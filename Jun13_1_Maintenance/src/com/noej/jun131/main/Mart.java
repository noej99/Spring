package com.noej.jun131.main;

import java.util.Scanner;

// 마트 정책이 포인트를 0.5% 적립하는걸로 바뀜
// -> 프로그램 수정
// 1) 마트 사장은 수정불가
//		.jar : 컴파일된거 압축해놓은거
// => 마트측에서 해결 불가능
// => 개발자 연락
// => 소스수정 -> 재컴파일 -> 재압축 -> 재배포
//포인트적립률 : 자주 바뀔
public class Mart {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int price;
		double point;
		double myPoint = 0;
		while (true) {
			System.out.print("구매한 금액 : ");
			price = s.nextInt();
			point = price * 0.01;
			if (price < 0) {
				break;
			}
			System.out.printf("적립되는 포인트(1%%) : %.1f\r\n", point);
			myPoint += point;
			System.out.printf("내 포인트 : %.1f\r\n", myPoint);
			System.out.println("-----------------------");
		}
		s.close();
	}
}
