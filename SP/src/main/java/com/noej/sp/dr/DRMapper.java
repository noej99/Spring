package com.noej.sp.dr;

import java.util.List;

public interface DRMapper {
	public abstract int delete(DataroomFile df);
	public abstract int upload(DataroomFile df);
	public abstract List<DataroomFile> get1();
	public abstract List<DataroomFile> get2();
	public abstract List<DataroomFile> get3();
	public abstract List<DataroomFile> get4();
	public abstract String getFile(DataroomFile df);
}
