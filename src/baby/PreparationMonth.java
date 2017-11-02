package baby;

public class PreparationMonth {
	private int month;
	private boolean isBoy;
	public PreparationMonth(int month,boolean isBoy){
		this.month=month;
		this.isBoy=isBoy;
	}
	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public boolean isBoy() {
		return isBoy;
	}

	public void setBoy(boolean isBoy) {
		this.isBoy = isBoy;
	}
}
