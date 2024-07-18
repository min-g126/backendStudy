package chap05interceptorpractice;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@Component
public class LoggingInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        log.info("[preHandle][{}][{}]{}", request.getMethod(), request.getRequestURI(), request.getQueryString() != null ? "?" + request.getQueryString() : "");
        return true;
    }

}
