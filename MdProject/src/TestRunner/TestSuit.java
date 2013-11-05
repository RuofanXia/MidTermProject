package TestRunner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import TestCase.MeetingTime1;
import TestCase.MeetingTime2;
import TestCase.MeetingTime3;


@RunWith(Suite.class)
@SuiteClasses({
	MeetingTime1.class,
	MeetingTime2.class,
	MeetingTime3.class
})
public class TestSuit {

}
