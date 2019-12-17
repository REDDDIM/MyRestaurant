package config;

import com.fasterxml.jackson.databind.ObjectMapper;
import dto.ErrorDto;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        ErrorDto errorDto = new ErrorDto();
        errorDto.setErrorType("HTTP Status 403");
        errorDto.setMessage(e.getMessage());
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = httpServletResponse.getWriter();
        writer.println(mapper.valueToTree(errorDto));
    }
}
