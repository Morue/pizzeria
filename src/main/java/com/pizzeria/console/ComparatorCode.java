package com.pizzeria.console;
import java.util.Comparator;
public class ComparatorCode implements Comparator<Pizza> {
	@Override
	public int compare(Pizza o1, Pizza o2) {
		// tri décroissant sur le code
		return o2.getCode().compareTo(o1.getCode());
	}
}
