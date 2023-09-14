package com.noej.jun134m.main;

import org.json.simple.parser.JSONParser;
import org.xmlpull.v1.XmlPullParser;

import oracle.jdbc.driver.OracleDriver;

// 이번에도 xml파싱, json파싱
// (mvnrepository.com에서) Maven소스 복사해서
// 프로젝트의 pom.xml에 붙이고 저장 ->

// 메이븐중앙저장소에서 .jar파일 다운받아서
// 컴의 메이븐로컬저장소에 저장
// 프로젝트에 쓸 수 있게 세팅

// 한번이라도 쓴적이 있는거는 C:\사용자\계정\.m2\repository 저장되어 있음
//		pom.xml에 아래의 dependencies에서 검색해서 add할 수 있음
//			안되면 type bundle을 제거

// 메이븐중앙저장소에 없는게 필요하다면 dependencies위에 사설저장소를 추가
// 그 후 dependencies에 추가
public class MMain {
	public static void main(String[] args) {
		OracleDriver od;
		XmlPullParser xpp;
		JSONParser jp;
	}
}
