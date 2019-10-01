package org.floworc.runner.kafka.configs;

import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.core.convert.format.MapFormat;
import lombok.Getter;

import java.util.Map;

@ConfigurationProperties("floworc.kafka.client")
@Getter
public class ClientConfig {
    @MapFormat(transformation = MapFormat.MapTransformation.FLAT)
    Map<String, String> properties;
}

