package com.compare;

import java.util.Comparator;

import com.entity.User;

public class Compare implements Comparator<User> {

	@Override
	public int compare(User o1, User o2) {
		// TODO Auto-generated method stub
		if(o1.getName().compareTo(o2.getName())>0) {
			return -1;
		}else if(o1.getName().compareTo(o2.getName())<0){
			return 1;
		}else {
			return 0;
		}
	}
	
}
