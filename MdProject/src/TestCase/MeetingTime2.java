package TestCase;

import static org.junit.Assert.*;

import org.junit.Test;

import SrcClass.ClassTime;

public class MeetingTime2 {

	int Class1 = 520;
	int Class2 = 522;

	@Test
	public void test() {
		assertFalse(ClassTime.OverLap(Class1, Class2));
	}

}
