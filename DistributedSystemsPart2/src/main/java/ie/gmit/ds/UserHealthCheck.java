package ie.gmit.ds;

import com.codahale.metrics.health.HealthCheck;

public class UserHealthCheck extends HealthCheck{
	@Override
	protected Result check() throws Exception {
		//in case of bugs
		return Result.healthy();
	}

}
