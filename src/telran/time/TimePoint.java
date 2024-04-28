package telran.time;

public class TimePoint implements Comparable<TimePoint> {
	int amount;
	TimeUnit timeUnit;

	public TimePoint(int amount, TimeUnit timeUnit) {
		this.amount = amount;
		this.timeUnit = timeUnit;
	}

	public int getAmount() {
		return amount;
	}

	public TimeUnit getTimeUnit() {
		return timeUnit;
	}

	public TimePoint convert(TimeUnit unit) {
		int amountInSeconds = this.amount * this.timeUnit.getValue();
		int newAmount = amountInSeconds / unit.getValue();
		return new TimePoint(newAmount, unit);
	}

	public TimePoint with(TimePointAdjuster adjuster) {
		if (adjuster == null) {
			return this;
		}
		return adjuster.adjust(this);
	}

	@Override
	public int compareTo(TimePoint o) {
		int thisSeconds = this.amount * this.timeUnit.getValue();
		int otherSeconds = o.getAmount() * o.getTimeUnit().getValue();

		return thisSeconds - otherSeconds;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof TimePoint)) {
			return false;
		}
		TimePoint other = (TimePoint) obj;
		int thisInSeconds = this.amount * this.timeUnit.getValue();
		int otherInSeconds = other.getAmount() * other.getTimeUnit().getValue();
		return thisInSeconds == otherInSeconds;
	}
}