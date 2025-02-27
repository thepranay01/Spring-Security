package com.wipro.Wipro_Security.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;

@Component
public class customAutenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        boolean isAdmin= authentication.getAuthorities().stream().anyMatch(auth->auth.getAuthority().equals("ROLE_ADMIN"));
        if(isAdmin){
            setDefaultTargetUrl("/admin");
        }else{
            setDefaultTargetUrl("/user");
        }
        super.onAuthenticationSuccess(request,response,authentication);
    }
}
