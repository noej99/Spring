package com.noej.jul072rac.coffee;

import java.util.List;

public interface CoffeeMapper {
	public abstract List<Coffee> get();
	public abstract int reg(Coffee c);
}
