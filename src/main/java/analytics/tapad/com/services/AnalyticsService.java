package analytics.tapad.com.services;

import analytics.tapad.com.domain.AnalyticsDTO;
import analytics.tapad.com.domain.AnalyticsInfo;

public interface AnalyticsService {


    void saveOrUpdate(AnalyticsDTO analyticsDTO);

	AnalyticsInfo getAnalytics(AnalyticsDTO analyticsDTO);

}
