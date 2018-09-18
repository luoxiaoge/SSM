package com.soecode.lyf.Utils;

import java.util.List;
import java.util.Map;

/**
 * Function: TODO
 *
 * @author Viki
 * @date 2018/9/6 17:05
 */
public class InteralRouterXmlFactoryBean {


    public Map getFunctionsMap() {
        return functionsMap;
    }

    public void setFunctionsMap(Map functionsMap) {
        this.functionsMap = functionsMap;
    }

    public List getConfigLocations() {
        return configLocations;
    }

    public void setConfigLocations(List configLocations) {
        this.configLocations = configLocations;
    }

    private Map functionsMap;

    private List configLocations;


}
