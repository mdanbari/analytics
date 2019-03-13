package analytics.tapad.com.domain;

public class AnalyticsInfo {

	private Integer num_unique_users;
	private Integer num_clicks;
	private Integer num_impressions;

	public AnalyticsInfo() {
	}

	public AnalyticsInfo(Integer num_unique_users, Integer num_clicks, Integer num_impressions) {
		this.num_unique_users = num_unique_users;
		this.num_clicks = num_clicks;
		this.num_impressions = num_impressions;
	}

	public Integer getNum_unique_users() {
		return num_unique_users;
	}

	public void setNum_unique_users(Integer num_unique_users) {
		this.num_unique_users = num_unique_users;
	}

	public Integer getNum_clicks() {
		return num_clicks;
	}

	public void setNum_clicks(Integer num_clicks) {
		this.num_clicks = num_clicks;
	}

	public Integer getNum_impressions() {
		return num_impressions;
	}

	public void setNum_impressions(Integer num_impressions) {
		this.num_impressions = num_impressions;
	}

	@Override
	public String toString() {
		return "unique_users, " + "{" + num_unique_users + "}" + "\n" + "clicks, " + "{" + num_clicks + "}" + "\n"
				+ "impressions, " + "{" + num_impressions + "}";
	}

}
