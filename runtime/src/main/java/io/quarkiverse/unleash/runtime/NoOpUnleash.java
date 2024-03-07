package io.quarkiverse.unleash.runtime;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.BiPredicate;

import io.getunleash.EvaluatedToggle;
import io.getunleash.FeatureToggle;
import io.getunleash.MoreOperations;
import io.getunleash.Unleash;
import io.getunleash.UnleashContext;
import io.getunleash.Variant;

public class NoOpUnleash implements Unleash {

    @Override
    public boolean isEnabled(String toggleName, UnleashContext context, BiPredicate<String, UnleashContext> fallbackAction) {
        if (fallbackAction != null) {
            return fallbackAction.test(toggleName, context);
        } else {
            return false;
        }
    }

    @Override
    public Variant getVariant(String toggleName, UnleashContext context) {
        return null;
    }

    @Override
    public Variant getVariant(String toggleName, UnleashContext context, Variant defaultValue) {
        return defaultValue;
    }

    @Override
    public Variant deprecatedGetVariant(String toggleName, UnleashContext context) {
        return null;
    }

    @Override
    public Variant deprecatedGetVariant(String toggleName, UnleashContext context, Variant defaultValue) {
        return defaultValue;
    }

    @Override
    public List<String> getFeatureToggleNames() {
        return Collections.emptyList();
    }

    @Override
    public MoreOperations more() {
        return more;
    }

    private final MoreOperations more = new MoreOperations() {

        @Override
        public List<String> getFeatureToggleNames() {
            return Collections.emptyList();
        }

        @Override
        public Optional<FeatureToggle> getFeatureToggleDefinition(String toggleName) {
            return Optional.empty();
        }

        @Override
        public List<EvaluatedToggle> evaluateAllToggles() {
            return Collections.emptyList();
        }

        @Override
        public List<EvaluatedToggle> evaluateAllToggles(UnleashContext context) {
            return Collections.emptyList();
        }

        @Override
        public void count(String toggleName, boolean enabled) {
        }

        @Override
        public void countVariant(String toggleName, String variantName) {
        }
    };
}
