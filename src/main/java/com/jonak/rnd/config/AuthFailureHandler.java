package com.jonak.rnd.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jonak.rnd.model.ErrorModel;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 Fahim created at 11/15/2020
 */
@Log4j2
public class AuthFailureHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException ex) throws IOException, ServletException {
        log.info("authentication failed for target URL: {}", request.getRequestURI());
        ErrorModel errorModel = new ErrorModel(ex.getMessage());

        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        OutputStream out = response.getOutputStream();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(out, errorModel);
        out.flush();
    }
}
