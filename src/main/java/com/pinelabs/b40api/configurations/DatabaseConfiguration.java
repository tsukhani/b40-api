package com.pinelabs.b40api.configurations;

import com.pinelabs.b40api.models.Family;
import com.pinelabs.b40api.repositories.FamilyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfiguration {
    private static final Logger LOG = LoggerFactory.getLogger(DatabaseConfiguration.class);

    @Bean
    CommandLineRunner initDatabase(FamilyRepository repository) {
        return args -> {
            var family = Family.builder()
                    .familyName("Joni Family")
                    .familySize(4)
                    .householdIncome(100000d)
                    .lat(34.55f)
                    .lon(-77.554f)
                    .numberOfChildren(2)
                    .race("Malay")
                    .religion("Muslim")
                    .build();

            var family2 = Family.builder()
                    .familyName("Millers")
                    .familySize(4)
                    .householdIncome(100000d)
                    .lat(34.55f)
                    .lon(-77.554f)
                    .numberOfChildren(2)
                    .race("Malay")
                    .religion("Muslim")
                    .build();


            var family3 = Family.builder()
                    .familyName("Ishak Family")
                    .familySize(4)
                    .householdIncome(100000d)
                    .lat(34.55f)
                    .lon(-77.554f)
                    .numberOfChildren(2)
                    .race("Malay")
                    .religion("Muslim")
                    .build();

            var family4 = Family.builder()
                    .familyName("Cena Family")
                    .familySize(4)
                    .householdIncome(100000d)
                    .lat(34.55f)
                    .lon(-77.554f)
                    .numberOfChildren(2)
                    .race("Malay")
                    .religion("Muslim")
                    .build();

            // Add data to repository
            repository.save(family);
            repository.save(family2);
            repository.save(family3);
            repository.save(family4);

            // Remove data from repository
            repository.delete(family4);

        };
    }
}
