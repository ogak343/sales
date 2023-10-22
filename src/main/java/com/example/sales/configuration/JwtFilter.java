package com.example.sales.configuration;

import com.example.sales.service.JwtService;
import jakarta.annotation.Nonnull;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Component
public class JwtFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final ApplicationConfiguration configuration;

    public JwtFilter(JwtService jwtService, ApplicationConfiguration configuration) {
        this.jwtService = jwtService;
        this.configuration = configuration;
    }

    @Override
    protected void doFilterInternal(@Nonnull HttpServletRequest request,
                                    @Nonnull HttpServletResponse response,
                                    @Nonnull FilterChain filterChain) throws ServletException, IOException {
        final String header = request.getHeader(AUTHORIZATION);

        if (header != null) {
            final String token = header.substring("Bearer ".length());
            final String username = jwtService.extractUsername(token);
            UserDetails user = configuration.userDetailsService().loadUserByUsername(username);
            if (SecurityContextHolder.getContext().getAuthentication() == null) {
                SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        null,
                        user.getAuthorities()
                ));
            }
        }
        filterChain.doFilter(request, response);
    }
}
