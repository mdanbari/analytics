package analytics.tapad.com.services;

import static org.springframework.data.cassandra.core.query.Criteria.where;

import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.query.Query;
import org.springframework.data.cassandra.core.query.Update;
import org.springframework.stereotype.Service;

import analytics.tapad.com.domain.AnalyticsDTO;
import analytics.tapad.com.domain.AnalyticsEntity;
import analytics.tapad.com.domain.AnalyticsInfo;
import analytics.tapad.com.maper.AnalyticsMapper;
import analytics.tapad.com.repositories.AnalyticsRepository;

@Service
public class AnalyticsServiceImpl implements AnalyticsService {

	private final AnalyticsRepository analyticsRepository;
	private final AnalyticsMapper analyticsMapper;
	private final CassandraOperations cassandraOperations;

	public AnalyticsServiceImpl(AnalyticsRepository analyticsRepository, AnalyticsMapper analyticsMapper,
			CassandraOperations cassandraTemplate, CassandraOperations cassandraOperations) {
		this.analyticsRepository = analyticsRepository;
		this.analyticsMapper = analyticsMapper;
		this.cassandraOperations = cassandraOperations;
	}

	@Override
	public void saveOrUpdate(AnalyticsDTO analyticsDTO) {
		AnalyticsEntity analyticsEntity = analyticsMapper.analyticsDTOToAnalyticsEntity(analyticsDTO);

		cassandraOperations.update(
				Query.query(where("access_date").is(analyticsEntity.getAccessDate()))
						.and(where("access_hour").is(analyticsEntity.getAccessHour()))
						.and(where("username").is(analyticsEntity.getUserName())),
				Update.empty().increment("click", analyticsEntity.getClick()).increment("impression",
						analyticsEntity.getImpression()),
				AnalyticsEntity.class);

	}

	@Override
	public AnalyticsInfo getAnalytics(AnalyticsDTO analyticsDTO) {
		AnalyticsEntity analyticsEntity = analyticsMapper.analyticsDTOToAnalyticsEntity(analyticsDTO);
		AnalyticsInfo analyticsInfo = new AnalyticsInfo();
		analyticsInfo.setNum_unique_users(analyticsRepository.countByUserName(analyticsEntity.getAccessDate(),
				analyticsEntity.getAccessHour()));
		analyticsInfo.setNum_clicks(analyticsRepository.getClicks(analyticsEntity.getAccessDate(),
				analyticsEntity.getAccessHour()));
		analyticsInfo.setNum_impressions(analyticsRepository.getImpressions(analyticsEntity.getAccessDate(),
				analyticsEntity.getAccessHour()));
		return analyticsInfo;
	}

	// @Override
	// public List<AnalyticsEntity> listAll() {
	// List<AnalyticsEntity> products = new ArrayList<>();
	// productRepository.findAll().forEach(products::add); //fun with Java 8
	// return products;
	// }
	//
	// @Override
	// public AnalyticsEntity getById(UUID id) {
	// return productRepository.findById(id).orElse(null);
	// }

}
