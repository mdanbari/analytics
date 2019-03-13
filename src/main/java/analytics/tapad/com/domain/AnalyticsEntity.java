package analytics.tapad.com.domain;

import java.io.Serializable;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import com.datastax.driver.core.DataType;

@Table("analytics")
public class AnalyticsEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@PrimaryKeyColumn(name = "access_date", type = PrimaryKeyType.PARTITIONED, ordinal = 0)
	@CassandraType(type = DataType.Name.TEXT)
	private String accessDate;

	@PrimaryKeyColumn(name = "access_hour", type = PrimaryKeyType.PARTITIONED, ordinal = 1)
	@CassandraType(type = DataType.Name.INT)
	private Integer accessHour;

	@PrimaryKeyColumn(name = "username", type = PrimaryKeyType.CLUSTERED, ordinal = 2)
	@CassandraType(type = DataType.Name.TEXT)
	private String userName;

	@Column("click")
	@CassandraType(type = DataType.Name.COUNTER)
	private Integer click;

	@Column("impression")
	@CassandraType(type = DataType.Name.COUNTER)
	private Integer impression;

	public String getAccessDate() {
		return accessDate;
	}

	public void setAccessDate(String accessDate) {
		this.accessDate = accessDate;
	}

	public Integer getAccessHour() {
		return accessHour;
	}

	public void setAccessHour(Integer accessHour) {
		this.accessHour = accessHour;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
