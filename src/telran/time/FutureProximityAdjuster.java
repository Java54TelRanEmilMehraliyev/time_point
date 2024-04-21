package telran.time;

import telran.util.Arrays;
import java.util.Comparator;

public class FutureProximityAdjuster implements TimePointAdjuster{
TimePoint[] timePoints;
public FutureProximityAdjuster(TimePoint[] points) {
     this.timePoints = points;
     Arrays.bubbleSort(timePoints, Comparator.naturalOrder());
}
	@Override
	public TimePoint adjust(TimePoint point) {
		TimePoint nearestFuturePoint = null;
		int i = 0;
		while(i < timePoints.length && timePoints[i].compareTo(point) <= 0) {
			i++;
		}
			if(i < timePoints.length) { 
	            nearestFuturePoint = timePoints[i];
	        }
	    return nearestFuturePoint;
}
}