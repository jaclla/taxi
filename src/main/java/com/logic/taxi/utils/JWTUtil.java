package com.logic.taxi.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.util.Date;
import java.util.UUID;

public class JWTUtil {
    // 过期时间 24 小时
    public static final long EXPIRE_TIME = 60 * 24 * 60;
    // 密钥
    public static final String SECRET = "eyuangong";

    public static final String HEAD = "Authorization";

    /**
     * @param phone 手机号码
     * @return 加密的token
     */
    public static String createPhoneToken(String phone, Integer channel) {
        try {
            Date date = new Date(System.currentTimeMillis());
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            // 附带userID信息
            return JWT.create()
                    //唯一值
                    .withJWTId(UUID.randomUUID().toString())
                    .withClaim("phone", phone)
                    .withClaim("channel", channel)
                    //签发时间
                    .withIssuedAt(date)
                    //创建一个新的JWT，并使用给定的算法进行标记
                    .sign(algorithm);
        } catch (JWTCreationException e) {
            return null;
        }
    }

    /**
     * @param userID 用户ID
     * @return 加密的token
     */
    public static String createToken(Long userID, Integer channel) {
        try {
            Date date = new Date(System.currentTimeMillis());
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            // 附带userID信息
            return JWT.create()
                    //唯一值
                    .withJWTId(UUID.randomUUID().toString())
                    .withClaim("userID", userID)
                    .withClaim("channel", channel)
                    //签发时间
                    .withIssuedAt(date)
                    //创建一个新的JWT，并使用给定的算法进行标记
                    .sign(algorithm);
        } catch (JWTCreationException e) {
            return null;
        }
    }

    /**
     * 生成 captcha token
     *
     * @param text 验证码
     * @return 加密的token
     */
    public static String createCaptchaToken(String text, Integer expireTime) {
        try {
            Date date = new Date(System.currentTimeMillis() + expireTime);
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            return JWT.create()
                    .withClaim("text", text)
                    //到期时间
                    .withExpiresAt(date)
                    //创建一个新的JWT，并使用给定的算法进行标记
                    .sign(algorithm);
        } catch (JWTCreationException e) {
            return null;
        }
    }

    /**
     * 校验 phone token 是否正确
     *
     * @param token 密钥
     * @param phone 手机号码
     * @return 是否正确
     */
    public static boolean phoneVerify(String token, String phone) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("phone", phone)
                    .build();
            //验证 token
            verifier.verify(token);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    /**
     * 校验 captcha token 是否正确
     *
     * @param token 密钥
     * @param text  验证码
     * @return 是否正确
     */
    public static boolean captchaVerify(String token, String text) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("text", text)
                    .build();
            //验证 token
            verifier.verify(token);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    /**
     * 校验 token 是否正确
     *
     * @param token  密钥
     * @param userID 用户ID
     * @return 是否正确
     */
    public static boolean verify(String token, Long userID) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            //在token中附带了userID信息
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("userID", userID)
                    .build();
            //验证 token
            verifier.verify(token);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    /**
     * 获得token中的信息，无需secret解密也能获得
     *
     * @return token中包含的用户ID
     */
    public static Long getUserID(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("userID").asLong();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 获得token中的信息，无需secret解密也能获得
     *
     * @return token中包含的channel
     */
    public static Integer getChannel(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("channel").asInt();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 获得token中的信息，无需secret解密也能获得
     *
     * @return token中包含的phone
     */
    public static String getPhone(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("phone").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }
}
