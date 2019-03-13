package analytics.tapad.com.repositories;

import java.util.UUID;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import analytics.tapad.com.domain.AnalyticsEntity;

@Repository
public interface AnalyticsRepository extends CrudRepository<AnalyticsEntity, UUID> {



	@Query("select count(username) from analytics where access_date = :accessDate and access_hour = :accessHour")
	Integer countByUserName(@Param("accessDate") String accessDate,@Param("accessHour")  Integer accessHour);

	@Query("select sum(click) from analytics where access_date = :accessDate and access_hour = :accessHour")
	Integer getClicks(@Param("accessDate") String accessDate,@Param("accessHour")  Integer accessHour);

	@Query("select sum(impression) from analytics where access_date = :accessDate and access_hour = :accessHour")
	Integer getImpressions(@Param("accessDate") String accessDate,@Param("accessHour")  Integer accessHour);

}
