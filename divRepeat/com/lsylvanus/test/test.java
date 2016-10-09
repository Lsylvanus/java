package com.lsylvanus.test;

import java.util.Arrays;
import java.util.List;

import com.lsylvanus.util.ExcludeUtil;

public class test {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(new Integer[]{5,2,3,1,3,4,1});
		List<Integer> newList = ExcludeUtil.exclude(list);
		System.out.println(newList);
	}
}
