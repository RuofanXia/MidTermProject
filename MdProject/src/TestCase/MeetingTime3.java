package TestCase;

import static org.junit.Assert.*;

import org.junit.Test;

import SrcClass.ClassTime;

public class MeetingTime3 {

	int Class1 = 791;
	int Class2 = 822;

	@Test
	public void test() {
		assertFalse(ClassTime.OverLap(Class1, Class2));
	}
}
