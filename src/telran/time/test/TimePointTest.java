package telran.time.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import telran.time.*;

class TimePointTest {

	@Test
	void testBetween() {
		TimePoint point1 = new TimePoint(10, TimeUnit.HOUR);
		TimePoint point2 = new TimePoint(3600 * 20, TimeUnit.SECOND);
		TimePoint point3 = TimeUnit.MINUTE.between(point1, point2);
		assertEquals(600, point3.getAmount());
		TimePoint point4 = TimeUnit.SECOND.between(point1, point2);
		assertEquals(36000, point4.getAmount());
		TimePoint point5 = TimeUnit.HOUR.between(point1, point2);
		assertEquals(10, point5.getAmount());
	}
	@Test
	void convertTest() {
		TimePoint timePoint = new TimePoint(10, TimeUnit.HOUR);
		TimePoint point1Actual = timePoint.convert(TimeUnit.SECOND);
		assertEquals(36000, point1Actual.getAmount());
	}
	@Test
	void plusAdjusterTest() {
		TimePoint timePoint1 = new TimePoint(10, TimeUnit.HOUR);
		TimePoint timePoint2 = new TimePoint(60, TimeUnit.MINUTE);
		TimePoint actual = timePoint2.with(new PlusAdjuster(timePoint1));
		assertEquals(660, actual.getAmount());
		assertEquals(TimeUnit.MINUTE, actual.getTimeUnit());
	}
	@Test
	void timePointEqualsTest() {
		TimePoint point1 = new TimePoint(10,TimeUnit.HOUR);
		TimePoint point2 = new TimePoint(10,TimeUnit.HOUR);
		TimePoint point3 = new TimePoint(5,TimeUnit.HOUR);
	    assertTrue(point1.equals(point2));
	    assertFalse(point1.equals(point3));
	}
	@Test
	void timePointCompareToTest() {
		TimePoint point1 = new TimePoint(10,TimeUnit.HOUR);
		TimePoint point2 = new TimePoint(10,TimeUnit.HOUR);
		TimePoint point3 = new TimePoint(5,TimeUnit.HOUR);
		assertEquals(0,point1.compareTo(point2));
	    assertTrue(point1.compareTo(point3) > 0);
	    assertTrue(point3.compareTo(point1) < 0);
	    
	}
	@Test
	void futureProximityAdjusterTest() {
		 TimePoint[] points = {
				 new TimePoint(60,TimeUnit.MINUTE), 
				 new TimePoint(120,TimeUnit.MINUTE),
				 new TimePoint(180,TimeUnit.MINUTE),
				 };
	        FutureProximityAdjuster adjuster = new FutureProximityAdjuster(points);
	        TimePoint point = new TimePoint(90,TimeUnit.MINUTE);
	        TimePoint expected = new TimePoint(120,TimeUnit.MINUTE);
	        TimePoint actual = adjuster.adjust(point);
	        assertEquals(expected, actual);
	    }
}