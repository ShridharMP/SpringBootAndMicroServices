package com.patil.software.solutions.APIGateWay.configuration;

import java.time.Duration;

import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;

@Configuration
public class Resilience4JConfiguration {
	@Bean
	public Customizer<Resilience4JCircuitBreakerFactory> globalCustomConfiguration() {

		// the circuitBreakerConfig and timeLimiterConfig objects
//		CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom().failureRateThreshold(50)
//				.waitDurationInOpenState(Duration.ofMillis(1000)).slidingWindowSize(2).build();
//		TimeLimiterConfig timeLimiterConfig = TimeLimiterConfig.custom().timeoutDuration(Duration.ofSeconds(4)).build();
//
//		return factory -> factory.configureDefault(id -> new Resilience4JConfigBuilder(id)
//				.timeLimiterConfig(timeLimiterConfig).circuitBreakerConfig(circuitBreakerConfig).build());
		return factory -> factory.configureDefault(id -> new Resilience4JConfigBuilder(id)
															.circuitBreakerConfig(CircuitBreakerConfig.ofDefaults())
															.build());
	}
}
