package com.yj.resource.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yj.common.domain.Payload;
import com.yj.common.utils.JwtUtils;
import com.yj.resource.config.RsaKeyProperties;
import com.yj.resource.domain.SysUser;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: JwtVerifyFilter
 * Author:   yangjian
 * Date:     2020/10/28 23:15
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/10/28 23:15        1.0              描述
 */
public class JwtVerifyFilter extends BasicAuthenticationFilter {

    private RsaKeyProperties prop;

    private AuthenticationManager manager;

    public JwtVerifyFilter(AuthenticationManager authenticationManager, RsaKeyProperties prop) {
        super(authenticationManager);
        this.prop = prop;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader("Authorization");
        System.err.println(header);
        if (header == null || !header.startsWith("Bearer ")) {
            try {
                chain.doFilter(request, response);

                response.setContentType("application/json;charset=utf-8");
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);

                Map<String, Object> map = new HashMap<>();
                map.put("code", HttpServletResponse.SC_FORBIDDEN);
                map.put("msg", "请登录");
                PrintWriter writer = response.getWriter();
                writer.write(new ObjectMapper().writeValueAsString(map));

                writer.flush();
                writer.close();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } else {
            String token = header.replace("Bearer ", "");
            Payload<SysUser> infoFromToken = JwtUtils.getInfoFromToken(token, prop.getPublicKey(), SysUser.class);
            SysUser sysUser = infoFromToken.getUserInfo();
            if (sysUser != null) {
                UsernamePasswordAuthenticationToken authResult = new UsernamePasswordAuthenticationToken(sysUser.getUsername(),
                        null,sysUser.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authResult);
                chain.doFilter(request, response);
            } else {
                try {
                    chain.doFilter(request, response);

                    response.setContentType("application/json;charset=utf-8");
                    response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);

                    Map<String, Object> map = new HashMap<>();
                    map.put("code", HttpServletResponse.SC_NOT_ACCEPTABLE);
                    map.put("msg", "无效的Token");
                    PrintWriter writer = response.getWriter();
                    writer.write(new ObjectMapper().writeValueAsString(map));

                    writer.flush();
                    writer.close();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}
