package com.datapar.shared.config.flyway;

import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class MigrationService {

    private static final Logger LOGGER = LoggerFactory.getLogger("MigrationService");

    @Inject
    private Flyway flyway;

    public void checkMigration() {
        System.out.println(flyway.info().current().getVersion().toString());
    }
}
