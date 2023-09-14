package com.noej.sp.member;

import java.util.List;

public interface MemberMapper {
	public abstract int reg(Member m);
	public abstract Member getMemberByID(Member m);
	public abstract int delete(Member m);
	public abstract int update(Member m);
	public abstract List<Member> getMemberIDByID(Member m);
}
