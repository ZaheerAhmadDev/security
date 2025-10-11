package com.zaheer.springsecurity.configuration;
import com.zaheer.springsecurity.service.JWTservice;
import com.zaheer.springsecurity.service.userservice;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
public class JwtFilter extends OncePerRequestFilter {
    @Autowired
    private JWTservice jwTservice;
    @Autowired
    ApplicationContext context;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");
        String token = null;
        String username = null;
        if(authHeader != null && authHeader.startsWith("Bearer")) {
          token = authHeader.substring(7);
    username = jwTservice.extractUserName(token);
        }
        if (username!= null &&
                SecurityContextHolder.getContext().getAuthentication()==null)
        {
            UserDetails userdetails = context.getBean(userservice.class).loadUserByUsername(username);
            if (jwTservice.validateToken(token,userdetails)) {
                UsernamePasswordAuthenticationToken token1  =
                        new UsernamePasswordAuthenticationToken(userdetails,null,userdetails.getAuthorities());
          token1.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(token1);
            }
        }
        filterChain.doFilter(request,response);
    }

}
