package telran.time;

public class FutureProximityAdjuster implements TimePointAdjuster{
TimePoint[] timePoints;
public FutureProximityAdjuster(TimePoint[] points) {
     this.timePoints = points;
}
	@Override
	public TimePoint adjust(TimePoint point) {
		TimePoint nearestFuturePoint = null;
		for(TimePoint futurePoint : timePoints) {
			if(futurePoint.compareTo(point) > 0 && 
		            (nearestFuturePoint == null || futurePoint.compareTo(nearestFuturePoint) < 0)) {
	            nearestFuturePoint = futurePoint;
	        }
	    }
	    return nearestFuturePoint;
}
}