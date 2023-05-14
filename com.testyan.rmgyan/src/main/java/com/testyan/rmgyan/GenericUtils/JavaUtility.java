package com.testyan.rmgyan.GenericUtils;

import java.util.Random;

public class JavaUtility
{
	/**
	 * @author HARI HARAN
	 * This method will generate a random number
	 * @return
	 */
	public int randomNumber()
	{
		Random random= new Random();
		int randomData = random.nextInt(5000);
		return randomData;

	}
}
