package io.quarkiverse.unleash.runtime;

import java.lang.annotation.Annotation;

import jakarta.enterprise.inject.*;
import jakarta.enterprise.inject.spi.InjectionPoint;
import jakarta.inject.Inject;

import io.getunleash.Unleash;
import io.quarkiverse.unleash.FeatureToggle;

public class FeatureToggleProducer {

    @Inject
    Unleash unleash;

    @Produces
    @FeatureToggle(name = "ignored")
    boolean getRequestFeatureToggle(InjectionPoint injectionPoint) {
        FeatureToggle ft = null;
        for (Annotation qualifier : injectionPoint.getQualifiers()) {
            if (qualifier.annotationType().equals(FeatureToggle.class)) {
                ft = (FeatureToggle) qualifier;
                break;
            }
        }
        return unleash.isEnabled(ft.name(), ft.defaultValue());
    }
}
