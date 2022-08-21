package com.hp.gekko.ordermanagement.util;

public class StaticMethodArgsWithoutArgs{

	public static int staticMethodwithargs(int a,int b)
	{
		return a+b;
	}
	public static MockDto staticMethodwithargs(MockDto mockDto)
	{
		return mockDto;
	}
	public static String staticMethodWithotArs()
	{
		return "static without args";
	}
}
