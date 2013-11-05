package TestCase;

import static org.junit.Assert.*;

import org.junit.Test;

import SrcClass.ClassTime;


public class TestgetDay {
	int[] ClassInfo = {747,1,3,10,5,11,20};
	int ClassNumber = 747;
	int[] dayInfo = {1,3};
	
//	int[] dayInfo = new int[2];
//	for(int i=0;i<ClassInfo.length;i++){
//			if(i==1||i==2){
//				dayInfo[i-1] = ClassInfo[i];
//			}
//	}
	
	ClassTime ct = new ClassTime(ClassNumber);
	@Test
	public void testGetDay() {
		assertArrayEquals(dayInfo, ct.GetDay());
	}

}
