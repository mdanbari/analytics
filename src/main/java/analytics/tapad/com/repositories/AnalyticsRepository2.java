package analytics.tapad.com.repositories;

import java.util.UUID;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import analytics.tapad.com.domain.AnalyticsInfo;

@Repository
public interface AnalyticsRepository2 extends CrudRepository<AnalyticsInfo, UUID> {


	@Query("select count(username),sum(click),sum(impression) from analytics where access_date = :accessDate and access_hour = :accessHour")
	AnalyticsInfo getAnalytics(@Param("accessDate") String accessDate,@Param("accessHour")  Integer accessHour);

}
