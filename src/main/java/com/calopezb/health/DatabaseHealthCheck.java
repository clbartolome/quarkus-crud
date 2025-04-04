package com.calopezb.health;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;
import jakarta.inject.Inject;
import javax.sql.DataSource;

@Readiness
@ApplicationScoped
public class DatabaseHealthCheck implements HealthCheck {

    @Inject
    DataSource dataSource;

    @Override
    public HealthCheckResponse call() {
        try {
            dataSource.getConnection().isValid(1000);
            return HealthCheckResponse.up("Database connection is healthy");
        } catch (Exception e) {
            return HealthCheckResponse.down("Database connection failed");
        }
    }
}