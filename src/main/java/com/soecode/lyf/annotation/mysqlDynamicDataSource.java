package com.soecode.lyf.annotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Function: TODO
 *
 * @author Viki
 * @date 2018/9/7 10:31
 */
public class mysqlDynamicDataSource extends AbstractRoutingDataSource {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * Determine the current lookup key. This will typically be
     * implemented to check a thread-bound transaction context.
     * <p>Allows for arbitrary keys. The returned key needs
     * to match the stored lookup key type, as resolved by the
     * {@link #resolveSpecifiedLookupKey} method.
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return DbContextHolder.getDbKey();
    }
}
