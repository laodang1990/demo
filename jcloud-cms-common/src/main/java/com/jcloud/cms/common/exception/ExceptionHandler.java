package com.jcloud.cms.common.exception;

import com.jcloud.cms.common.model.ResponsesDT;
import com.jcloud.cms.common.model.ReturnCode;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ExceptionHandler implements HandlerExceptionResolver {

    private static final Logger log = LoggerFactory.getLogger(ExceptionHandler.class);

    private List<String> exceptionMappings;

    public List<String> getExceptionMappings() {
        return exceptionMappings;
    }

    public void setExceptionMappings(List<String> exceptionMappings) {
        this.exceptionMappings = exceptionMappings;
    }

    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response, Object handler, Exception ex) {
        log.info("---------------resolveException---------------");
        boolean flag = false;
        log.error(ex.getMessage(), ex);
        try {
            ResponsesDT responsesDTO = new ResponsesDT(ReturnCode.ACTIVE_EXCEPTION);
            Iterator<String> it = exceptionMappings.iterator();
            while (it.hasNext()){
                if(ex.getClass().toString().contains(it.next())){
                    flag = true;
                    responsesDTO.setCode(ReturnCode.ACTIVE_FAILURE.code());
                    responsesDTO.setMsg(it.next());
                    break;
                }
            }
//            if(responsesDTO.getCode() == -1){
//                responsesDTO.setMsg(ex.getMessage());
//            }
            String requestURI = request.getRequestURI();
            if(requestURI.contains("/api")){
                response.getWriter().write(JSONObject.fromObject(responsesDTO).toString());
                response.getWriter().flush();
            }else{
                Map<String, Object> model = new HashMap<String, Object>();
                model.put("ex", ex);
                return new ModelAndView(new InternalResourceView("/WEB-INF/error/404.html"));
            }

        } catch (Exception e){
            log.error("error",e);
        }
        return null;
    }

    public static void renderJson(HttpServletResponse response, String contentType, String text) {
        response.setContentType(contentType);
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        try {
            response.getWriter().write(text);
        } catch (IOException e) {
            //logger.error(e.getMessage(), e);
        }
    }
}
