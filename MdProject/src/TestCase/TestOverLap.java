package TestCase;

import static org.junit.Assert.*;

import org.junit.Test;

import SrcClass.ClassTime;


public class TestOverLap {
	int class1Info = 747;
	int class2Info = 513;
	@Test
	public void test() {
		assertTrue(ClassTime.OverLap(class1Info, class2Info));
	}

}
