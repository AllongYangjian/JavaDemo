package com.example.springsecurityjwt.filter;

import com.example.springsecurityjwt.domain.SysUser;
import com.example.springsecurityjwt.utils.JwtUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: TokenFilter
 * Author:   YJ
 * Date:     2020/11/27 16:30
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * YJ       2020/11/27 16:30        1.0              描述
 */
public class TokenFilter extends BasicAuthenticationFilter {

    public TokenFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            String token = header.replace("Bearer ", "");
            SysUser sysUser = JwtUtils.decodeToken(token);
            if (sysUser != null) {
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(sysUser.getUsername(), null,
                        sysUser.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }
        chain.doFilter(request,response);
    }
}
