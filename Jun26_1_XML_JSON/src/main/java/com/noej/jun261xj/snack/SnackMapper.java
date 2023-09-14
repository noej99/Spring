package com.noej.jun261xj.snack;

import java.util.List;

public interface SnackMapper {

	public abstract List<Snack> get(SnackSelector ss);
	public abstract int count();
}
