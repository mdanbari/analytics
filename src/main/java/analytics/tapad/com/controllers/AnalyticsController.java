package analytics.tapad.com.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import analytics.tapad.com.domain.AnalyticsDTO;
import analytics.tapad.com.services.AnalyticsService;

@RestController
@RequestMapping("/analytics")
public class AnalyticsController {

	private final AnalyticsService analyticsService;

	public AnalyticsController(AnalyticsService analyticsService) {
		this.analyticsService = analyticsService;
	}

	@PostMapping
	public void postAnalytics(@RequestBody AnalyticsDTO analyticsDTO) {
		analyticsService.saveOrUpdate(analyticsDTO);
	}

	@GetMapping(path = "/{since_epoch}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String getAnalytics(@PathVariable Long since_epoch) {
		AnalyticsDTO analyticsDTO = new AnalyticsDTO(since_epoch);
		return analyticsService.getAnalytics(analyticsDTO).toString();
	}

}
