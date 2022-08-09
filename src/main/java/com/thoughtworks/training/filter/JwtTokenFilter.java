package com.thoughtworks.training.filter;

import com.thoughtworks.training.service.UsernamePasswordUserDetailService;
import com.thoughtworks.training.utils.JwtTokenUtil;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {
    @Resource
    private UsernamePasswordUserDetailService usernamePasswordUserDetailService;
    @Resource
    private JwtTokenUtil jwtTokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String token = request.getHeader("Authentication");
        if (token != null && !token.isEmpty()) {
            String username = jwtTokenUtil.getUsernameFromToken(token);
            if (!username.isEmpty()) {
                UserDetails details = usernamePasswordUserDetailService.loadUserByUsername(username);
                if (jwtTokenUtil.validateJwtToken(token, details)) {
                    UsernamePasswordAuthenticationToken
                            authenticationToken = new UsernamePasswordAuthenticationToken(
                            details, null,
                            details.getAuthorities());
                    authenticationToken.setDetails(new
                            WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }
        }
        filterChain.doFilter(request, response);
    }
}
