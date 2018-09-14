package com.soecode.lyf.annotation;

import com.soecode.lyf.Utils.HashFunction;
import org.apache.commons.lang.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Function: TODO
 *
 * @author Viki
 * @date 2018/9/7 10:53
 */
@Service
public class DbRouterImpl implements  DbRouter {

    private org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());
    /**
     * 配置列表
     */
    private List<RouterSet> routerSetList;

    @Autowired
    private  HashFunction hashFunction;

    @Override
    public String dbRoute(String fieldId) {
        if (StringUtils.isEmpty(fieldId)) {
            throw new IllegalArgumentException("dbsCount and tablesCount must be both positive!");
        }
        int routeFieldInt = hashFunction.user(fieldId);
        String dbKey = getDbKey(routerSetList, routeFieldInt);
        return dbKey;
    }



    @Override
    public String dbRouteResources(String resourceCode) {
        if (StringUtils.isEmpty(resourceCode)) {
            throw new IllegalArgumentException("dbsCount and tablesCount must be both positive!");
        }
        int routeFieldInt = hashFunction.user(resourceCode);
        //int routeFieldInt = Integer.valueOf(resourceCode);
        //String dbKey = getDbKey(routerSetList, routeFieldInt);
        DbContextHolder.setDbKey("db"+routeFieldInt);
        return "db"+routeFieldInt;
    }


    /**
     * @Description 根据数据字段来判断属于哪个段的规则,获得数据库key
     * @Autohr supers【weChat:13031016567】
     */
    private String getDbKey(List<RouterSet> routerSets, int routeFieldInt) {
        RouterSet routerSet = null;
        if (routerSets == null || routerSets.size() <= 0) {
            throw new IllegalArgumentException("dbsCount and tablesCount must be both positive!");
        }
        String dbKey = null;
        for (RouterSet item : routerSets) {
            if (item.getRuleType() == routerSet.RULE_TYPE_STR) {
                routerSet = item;
                if (routerSet.getDbKeyArray() != null && routerSet.getDbNumber() != 0) {
                    long dbIndex = 0;
                    long tbIndex = 0;
                    //默认按照分库进行计算
                    long mode = routerSet.getDbNumber();
                    //如果是按照分库分表的话，计算
                    if (item.getRouteType() == RouterSet.ROUTER_TYPE_DBANDTABLE && item.getTableNumber() != 0) {
                        mode = routerSet.getDbNumber() * item.getTableNumber();
                        dbIndex = routeFieldInt % mode / item.getTableNumber();
                        tbIndex = routeFieldInt % item.getTableNumber();
                        String tableIndex = getFormateTableIndex(item.getTableIndexStyle(), tbIndex);
                        DbContextHolder.setTableIndex(tableIndex);
                    } else if (item.getRouteType() == RouterSet.ROUTER_TYPE_DB) {
                        mode = routerSet.getDbNumber();
                        dbIndex = routeFieldInt % mode;
                    } else if (item.getRouteType() == RouterSet.ROUTER_TYPE_TABLE) {
                        tbIndex = routeFieldInt % item.getTableNumber();
                        String tableIndex = getFormateTableIndex(item.getTableIndexStyle(), tbIndex);
                        DbContextHolder.setTableIndex(tableIndex);
                    }
                    dbKey = routerSet.getDbKeyArray().get(Long.valueOf(dbIndex).intValue());
                    log.debug("getDbKey resource:{}------->dbkey:{},tableIndex:{},", new Object[]{routeFieldInt, dbKey, tbIndex});
                    DbContextHolder.setDbKey(dbKey);
                }
                break;
            }
        }
        return dbKey;
    }


    /**
     * @Description 此方法是将例如+++0000根式的字符串替换成传参数字例如44 变成+++0044
     * @Autohr supers【weChat:13031016567】
     */
    private static String getFormateTableIndex(String style, long tbIndex) {
        String tableIndex = null;
        DecimalFormat df = new DecimalFormat();
        if (StringUtils.isEmpty(style)) {
            //在格式后添加诸如单位等字符
            style = RouterConstants.ROUTER_TABLE_SUFFIX_DEFAULT;
        }
        df.applyPattern(style);
        tableIndex = df.format(tbIndex);
        return tableIndex;
    }

    public List<RouterSet> getRouterSetList() {
        return routerSetList;
    }

    public void setRouterSetList(List<RouterSet> routerSetList) {
        this.routerSetList = routerSetList;
    }

}
