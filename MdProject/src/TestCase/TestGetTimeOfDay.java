package TestCase;

import static org.junit.Assert.*;

import org.junit.Test;

import SrcClass.ClassTime;


public class TestGetTimeOfDay {
	int[] ClassInfo = {747,1,3,10,5,11,20};
	int ClassNumber = 747;
	String timeInfo = "Start Time:10:05;Stop Time:11:20";
			
	ClassTime ct = new ClassTime(ClassNumber);		

	@Test
	public void test() {
		assertEquals(timeInfo, ClassTime.GetTimeOfDay(ct.GetTime()));
	}

}
