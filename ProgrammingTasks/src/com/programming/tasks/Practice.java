package com.programming.tasks;

import java.util.Objects;

final public class Practice {
	
	String str;
	static Practice practice;
	private Practice() {
		
	}
	
	public Practice(String s) {
		this.str = s;
	}


	static Practice getInstance() {
		try {
			if (Objects.isNull(practice)) {
				practice  = new Practice();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return practice;
	}
}
