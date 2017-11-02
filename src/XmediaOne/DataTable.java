package XmediaOne;

import java.util.List;

public class DataTable {
	List<String> items;
	boolean isTableText;

	public DataTable(List<String> items, boolean isTableText) {
		this.items = items;
		this.isTableText = isTableText;
	}

	public List<String> getItems() {
		return items;
	}

	public void setItems(List<String> items) {
		this.items = items;
	}

	public Boolean getIsSevivesText() {
		return isTableText;
	}

	public void setIsSevivesText(Boolean isSevivesText) {
		this.isTableText = isSevivesText;
	}
}
