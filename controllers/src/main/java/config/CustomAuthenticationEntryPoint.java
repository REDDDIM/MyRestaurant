package config;

import com.fasterxml.jackson.databind.ObjectMapper;
import dto.ErrorDto;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class CustomAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

    @Override
    public void commence(
            HttpServletRequest request, HttpServletResponse response, AuthenticationException authEx)
            throws IOException, ServletException {
        response.addHeader("WWW-Authenticate", "Basic realm=\"\" + getRealmName() + \"\"");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        ErrorDto errorDto = new ErrorDto();
        errorDto.setErrorType("HTTP Status 401");
        errorDto.setMessage(authEx.getMessage());
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = response.getWriter();
        writer.println(mapper.valueToTree(errorDto));
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        setRealmName("MyRestaraunt");
        super.afterPropertiesSet();
    }



}
