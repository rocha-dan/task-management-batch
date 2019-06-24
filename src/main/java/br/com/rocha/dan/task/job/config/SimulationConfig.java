package br.com.rocha.dan.task.job.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class SimulationConfig {

	private static final String FRAUD_SCREENING = "FRAUD_SCREENING";
	private static final String IAM = "IAM";

	@Value("#{'${simulation.features.list}'.split(',')}")
	private List<String> simulationFeaturesList;



}
