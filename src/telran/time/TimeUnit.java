package telran.time;

public enum TimeUnit {
	HOUR(3600), MINUTE(60), SECOND(1);

	int value;

	private TimeUnit(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public TimePoint between(TimePoint point1, TimePoint point2) {
		int time1InSeconds = point1.getAmount() * point1.getTimeUnit().getValue();
		int time2InSeconds = point2.getAmount() * point2.getTimeUnit().getValue();
		int differenceInSeconds = Math.abs(time1InSeconds - time2InSeconds);

		int result = differenceInSeconds / this.getValue();

		return new TimePoint(result, this);
	}
}