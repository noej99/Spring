package com.noej.jun162smvc.calc;

// 멤버 변수명과 요청파라메터명을 같게
public class XY {
	private int x;
	private int y;

	public XY() {
	}

	public XY(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
