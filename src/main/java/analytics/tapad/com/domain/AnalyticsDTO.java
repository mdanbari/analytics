package analytics.tapad.com.domain;

public class AnalyticsDTO {

	private String userName;
	private Long sinceEpoch;
	private Integer click;
	private Integer impression;

	public AnalyticsDTO() {
	}

	public AnalyticsDTO(Long sinceEpoch) {
		this.sinceEpoch = sinceEpoch;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getSinceEpoch() {
		return sinceEpoch;
	}

	public void setSinceEpoch(Long sinceEpoch) {
		this.sinceEpoch = sinceEpoch;
	}

	public Integer getClick() {
		return click;
	}

	public void setClick(Integer click) {
		this.click = click;
	}

	public Integer getImpression() {
		return impression;
	}

	public void setImpression(Integer impression) {
		this.impression = impression;
	}

}
