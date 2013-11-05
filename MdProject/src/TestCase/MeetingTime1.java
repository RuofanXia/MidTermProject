package TestCase;

import static org.junit.Assert.*;

import org.junit.Test;

import SrcClass.ClassTime;

public class MeetingTime1 {

	int class1 = 747;
	int class2 = 513;

	@Test
	public void test() {
		assertTrue(ClassTime.OverLap(class1, class2));
	}

}
