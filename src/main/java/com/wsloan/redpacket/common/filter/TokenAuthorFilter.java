package com.wsloan.redpacket.common.filter;


import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Title:TokenAuthorFilter
 * Description:token过滤
 * Company:李山聚财网络科技
 * @author XUFEI
 * @date 2017-09-28
 */
//@Slf4j
@Component
@WebFilter(urlPatterns={"/*"}, filterName="tokenAuthorFilter")
public class TokenAuthorFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest)request;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");

        HttpServletResponse resp = (HttpServletResponse) response;
        //这里填写你允许进行跨域的主机ip
        resp.setHeader("Access-Control-Allow-Origin", "*");
        //允许的访问方法
        resp.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE, PATCH");
        //Access-Control-Max-Age 用于 CORS 相关配置的缓存
        resp.setHeader("Access-Control-Max-Age", "3600");
        resp.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        chain.doFilter(request, response);
        return;




/*
        String token = req.getHeader("token");

        String url = req.getRequestURI();
        System.out.print(url);
        if (!url.startsWith(serverPath+"/api/") || url.startsWith(serverPath+"/api/product") ) {
            chain.doFilter(request, response);
            return;
        }

        Response res = new Response();

        boolean isFilter = false;
        if (null == token || token.isEmpty()) {
            res.setSuccess(false);
            res.setErrorCode("403");
            res.setErrorMessage("token没有认证通过!原因为：客户端请求参数中无token信息");
        } else {
            //验证Token
            Integer userId = Loot7Utils.GetUid(token);
             System.out.print(userId);
            if(userId!=null && userId!=0){
                WsUser wu = new WsUser();
                wu.setFid(userId);
                WsUser user = wsUserService.queryWsUserByFid(wu);
                if(user!=null){
                    request.setAttribute(ATTTUser.USER_TOKEN,user);
                    isFilter = true;
                    res.setSuccess(true);
                }else{
                    res.setSuccess(false);
                    res.setErrorCode("403");
                    res.setErrorMessage("token没有认证通过!原因为：用户不存在");
                }
            }else{
                res.setSuccess(false);
                res.setErrorCode("403");
                res.setErrorMessage("token没有认证通过!原因为：客户端请求中认证的token信息无效，请查看申请流程中的正确token信息");
            }
        }
        if(!res.getSuccess()){
            HttpServletResponse hsp = (HttpServletResponse)response;
            hsp.setHeader("content-type","text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            ApiResult result = new ApiResult(403,"Token authentication fail",res);
            String resJSON = JSONObject.toJSONString(result);

            out.print(resJSON);


            return;
        }
        if(isFilter){
           // log.info("token filter过滤ok!");
            chain.doFilter(request, response);
        }*/

    }

    @Override
    public void destroy() {

    }






}
