package com.learn.easy.open.config.interceptor;

import com.gitee.easyopen.ApiParam;
import com.gitee.easyopen.bean.Consts;
import com.gitee.easyopen.interceptor.ApiInterceptorAdapter;
import com.learn.easy.open.config.result.MyResult;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

/**
 * @author 张伟
 * @version V1.0.0
 * @projectName learn_parent
 * @title LogInterceptor
 * @package com.learn.easy.open.config.interceptor
 * @description 拦截器
 * @date 2018/12/28 10:19
 */
public class LogInterceptor extends ApiInterceptorAdapter {

    /**
     * com.learn.easy.open.config.interceptor.LogInterceptor.preHandle
     * @param request 请求
     * @param response 返回
     * @param serviceObj 本次请求映射到的apiService 的CGLIB动态代理类
     * @param argu 参数数组，暂时未知用处
     * @description 拦截请求头 <BR>
     * @return boolean 返回 true才能继续向下执行
     * @throws Exception 异常
     * @author 张伟
     * @createTime 2018/12/28 10:31
     * @version V1.0.0
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object serviceObj, Object argu) throws Exception {

        // 获取请求信息并打印
        ApiParam param = (ApiParam)request
                .getAttribute("com.gitee.easyopen.ApiContextparam");

        String name = param.getString("name");

        logger.info("*******请求url：{} ",request.getRequestURL().toString());
        logger.info("*******请求api名称：{} ",name);

        // 获取当前时间，计算调用时间
        long startTime = System.currentTimeMillis();
        
        request.setAttribute("startTime",startTime);

        logger.info("******* 开始调用接口 *******");

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object serviceObj, Object argu, Object result) throws Exception {
        //计算调用接口用时
        long startTime = (long) request.getAttribute("startTime");
        long usedTime = System.currentTimeMillis() - startTime;
        logger.info("******* 接口执行完毕,用时{}毫秒 *******",usedTime);
        
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object serviceObj, Object argu, Object result, Exception e) throws Exception {
        logger.info("============ 数据封装完毕,进行一层加密 ============");
        MyResult myResult = (MyResult) result;
        Object data = myResult.getData();
        String dataStr = ApiParam.toJSONString(data);
        if (!StringUtils.isEmpty(dataStr)) {
            dataStr = URLEncoder.encode(dataStr, Consts.UTF8);
            myResult.setData(dataStr);
        }
    }
}
