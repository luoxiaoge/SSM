package com.soecode.lyf.annotation;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author think
 */
@Aspect
@Component
class DbRouterInterceptor {

    private static final Logger log = LoggerFactory.getLogger(DbRouterInterceptor.class);

    @Autowired
    private DbRouter dBRouter;

    @Pointcut("@annotation( com.soecode.lyf.annotation.Router)")
    public void aopPoint() {
    }


    @Before("aopPoint()")
    public Object doRoute(JoinPoint jp) throws Throwable {
        long t1 = System.currentTimeMillis();
        boolean result = true;
        Method method = getMethod(jp);
        Router router = method.getAnnotation(Router.class);
        String routeField = router.routerField();
        Object[] args = jp.getArgs();
        if (args != null && args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                long t2 = System.currentTimeMillis();
                String routeFieldValue = BeanUtils.getProperty(args[i],
                        routeField);
                log.debug("routeFieldValue{}" + (System.currentTimeMillis() - t2));
                if (StringUtils.isNotEmpty(routeFieldValue)) {
                    if (RouterConstants.ROUTER_FIELD_DEFAULT.equals(routeField)) {
                        dBRouter.dbRouteResources(routeFieldValue);
                        break;
                    } else {
                        this.searchParamCheck(routeFieldValue);
                        String resource = routeFieldValue.substring(routeFieldValue.length() - 4);
                        dBRouter.dbRouteResources(resource);
                        break;
                    }
                }
            }
        }
        log.debug("doRouteTime{}" + (System.currentTimeMillis() - t1));
        return result;
    }

    private Method getMethod(JoinPoint jp) throws NoSuchMethodException {
        Signature sig = jp.getSignature();
        MethodSignature msig = (MethodSignature) sig;
        return getClass(jp).getMethod(msig.getName(), msig.getParameterTypes());
    }

    private Class<? extends Object> getClass(JoinPoint jp)
            throws NoSuchMethodException {
        return jp.getTarget().getClass();
    }


    /**
     * 查询支付结构参数检查
     *
     * @param payId
     */
    private void searchParamCheck(String payId) {
        if (payId.trim().equals("")) {
            throw new IllegalArgumentException("payId is empty");
        }
    }

    public DbRouter getdBRouter() {
        return dBRouter;
    }

    public void setdBRouter(DbRouter dBRouter) {
        this.dBRouter = dBRouter;
    }



}

