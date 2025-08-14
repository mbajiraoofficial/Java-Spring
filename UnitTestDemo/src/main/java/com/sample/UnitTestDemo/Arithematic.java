package com.sample.UnitTestDemo;

public class Arithematic {
	public int Sum(int a,int b)
	{
		return a+b;
	}
	
	public int Sub(int a,int b)
	{
		return a-b;
	}
	public int Div(int a,int b)
	{
		if(b==0)
		{
			throw new IllegalArgumentException("Invalid Input. We Can't Divide By Zero");
		}
		return a/b;
	}
}
