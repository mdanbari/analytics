package analytics.tapad.com.maper;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import analytics.tapad.com.domain.AnalyticsDTO;
import analytics.tapad.com.domain.AnalyticsEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AnalyticsMapper {

	@Mappings({ @Mapping(target = "accessDate", source = "sinceEpoch", qualifiedByName = "epochToDate"),
			@Mapping(target = "accessHour", source = "sinceEpoch", qualifiedByName = "epochToHour") })
	AnalyticsEntity analyticsDTOToAnalyticsEntity(AnalyticsDTO analyticsDTO);

	@Named("epochToDate")
	default String epochToDate(Long epoch) {
		return extractTime(epoch, "date");
	}

	@Named("epochToHour")
	default Integer epochToHour(Long epoch) {
		return Integer.valueOf(extractTime(epoch, "hour"));
	}

	default String extractTime(Long epoch, String type) {
		Timestamp stamp = new Timestamp(epoch);
		Date date = new Date(stamp.getTime());
		SimpleDateFormat sdf = null;
		if ("hour".equals(type))
			sdf = new SimpleDateFormat("h");
		else
			sdf = new SimpleDateFormat("yyyy/dd/MM");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		String formattedDate = sdf.format(date);
		return formattedDate;
	}

}
