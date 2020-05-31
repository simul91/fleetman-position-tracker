package com.virtualpairprogrammers;

import org.junit.Test;

public class TestTimestampParsing 
{
	@Test
	public void timestampsParseCorrectly() 
	{
		// Format: EEE MMM dd HH:mm:ss zzz yyyy	
		Position position = new Position("23", "21", "Monday January 09 16:15:00 +0000 2017");
	
		// would throw exception if invalid
	}

	@Test(expected=java.lang.RuntimeException.class)
	public void invalidTimestampsFailCorrectly() 
	{
		// Format: EEE MMM dd HH:mm:ss zzz yyyy		
		Position position = new Position("23", "21", "Monday January 75 aa:15:00 +0000 2017");
	}
	
}
