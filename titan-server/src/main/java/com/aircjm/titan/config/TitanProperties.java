package com.aircjm.titan.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Dice configuration properties.
 *
 * @author haseochen
 */
@Data
@ConfigurationProperties("titan")
public class TitanProperties {
    /**
     * Doc api disabled. (Default is true)
     */
    private boolean docDisabled = true;
}
