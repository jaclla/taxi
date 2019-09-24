package com.logic.taxi.controller;

import cn.hutool.cache.CacheUtil;
import cn.hutool.cache.impl.TimedCache;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import com.logic.taxi.core.http.HttpKit;
import com.logic.taxi.utils.JWTUtil;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class BaseController {

    /**
     * 创建缓存，默认5分钟过期
     */
    protected TimedCache<String, Map<String, String>> timedCache = CacheUtil
        .newTimedCache(DateUnit.MINUTE.getMillis() * 5);

    protected HttpServletRequest getHttpServletRequest() {
        return HttpKit.getXSSWrapperRequest();
    }

    protected HttpServletResponse getHttpServletResponse() {
        return HttpKit.getResponse();
    }

    protected HttpSession getSession() {
        return HttpKit.getXSSWrapperRequest().getSession();
    }

    protected HttpSession getSession(Boolean flag) {
        return HttpKit.getXSSWrapperRequest().getSession(flag);
    }

    protected String getPara(String name) {
        return HttpKit.getXSSWrapperRequest().getParameter(name);
    }

    protected Integer getParaInt(String name) {
        if (StrUtil.isEmpty(getPara(name))) {
            return null;
        }
        return Integer.valueOf(getPara(name));
    }

    protected Long getParaLong(String name) {
        if (StrUtil.isEmpty(getPara(name))) {
            return null;
        }
        return Long.valueOf(getPara(name));
    }

    protected void setAttr(String name, Object value) {
        HttpKit.getXSSWrapperRequest().setAttribute(name, value);
    }

    protected Object getAttr(String name) {
        return HttpKit.getXSSWrapperRequest().getAttribute(name);
    }

    /**
     * 返回前台文件流
     *
     * @author fengshuonan
     * @since 2017年2月28日 下午2:53:19
     */
    protected ResponseEntity<byte[]> renderFile(String fileName, String filePath) {
        byte[] bytes = FileUtil.readBytes(filePath);
        return renderFile(fileName, bytes);
    }

    /**
     * 返回前台文件流
     *
     * @author fengshuonan
     * @since 2017年2月28日 下午2:53:19
     */
    protected ResponseEntity<byte[]> renderFile(String fileName, byte[] fileBytes) {
        String dFileName = null;
        try {
            dFileName = new String(fileName.getBytes("gb2312"), "iso8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", dFileName);
        return new ResponseEntity<>(fileBytes, headers, HttpStatus.CREATED);
    }

    protected String loginToken() {
        String tokenHeader = getHttpServletRequest().getHeader(JWTUtil.HEAD);
        return StringUtils.isEmpty(tokenHeader) ? null : tokenHeader.substring(7);
    }

    /**
     * 获取登录ID--由调用方来判断是企业管理员还是员工ID
     */
    public Long loginID() {
        return Objects.requireNonNull(JWTUtil.getUserID(loginToken()));
    }

//    /**
//     * 当前登录者所属的企业ID
//     */
//    public Long loginEnterpriseID() {
//        BizManager bizManager = new BizManager().selectById(loginID());
//        return bizManager.getEnterpriseID();
//    }
}
