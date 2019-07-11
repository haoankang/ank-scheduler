package ank.hao.scheduler.core.component;


import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @@author tangdijia
 */
@Component
@Slf4j
public class UserClient {

    public static final String SMARTLEARNING_AUTH = "SMARTLEARNING-AUTH";

    @Autowired
    private HttpServletRequest request;

    public String getCurrentUserName() {
        Object userName = request.getAttribute("schedulerUserName");
        if (userName != null) {
            return String.valueOf(userName);
        }

        String auth = request.getHeader(SMARTLEARNING_AUTH);

        if (auth == null || "".equals(auth)) {
            throw new SecurityException("UNAUTHORIZED");
        }
        return JSONObject.parseObject(auth).getString("username");
    }

    public List<String> getAuthorities() {
        String auth = request.getHeader(SMARTLEARNING_AUTH);

        if (auth == null || "".equals(auth)) {
            throw new SecurityException("UNAUTHORIZED");
        }

        return JSONObject.parseObject(auth).getJSONArray("authorities").toJavaList(String.class);
    }
}
