package com.logic.taxi.service.impl;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.logic.taxi.core.ret.RetResponse;
import com.logic.taxi.core.ret.RetResult;
import com.logic.taxi.entity.SysDictionaryItem;
import com.logic.taxi.entity.TaxiInfo;
import com.logic.taxi.entity.UserInfo;
import com.logic.taxi.mapper.SysDictionaryItemMapper;
import com.logic.taxi.mapper.TaxiInfoMapper;
import com.logic.taxi.mapper.UserInfoMapper;
import com.logic.taxi.service.TelegramService;
import javax.annotation.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class TelegramServiceImpl implements TelegramService {

  @Resource
  private TaxiInfoMapper taxiInfoMapper;
  @Resource
  private UserInfoMapper userInfoMapper;
  @Resource
  private SysDictionaryItemMapper sysDictionaryItemMapper;

  @Override
  public RetResult sendMsg(String message, String sender, Long taxiID) {
    if (StrUtil.isEmpty(message)) {
      message="我想上车, 请问还有位置吗?";
    }
    String url = "https://api.telegram.org/bot892496141:AAGjGhDpDD4xYnJYgeDttJgUfEsLEBIECdU/sendMessage";
    TaxiInfo taxiInfo = taxiInfoMapper.selectById(taxiID);
    Long id = userInfoMapper
        .selectOne(new QueryWrapper<UserInfo>().eq("username", taxiInfo.getUsername())).getId();
    MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
    map.add("chat_id", id);
    String format = StrUtil
        .format("@{} 对您发布的信息兴趣.\n\n留言内容:\n{}\n\n原始信息:\n{} {}\n{}", sender, message,
            sysDictionaryItemMapper.selectOne(new QueryWrapper<SysDictionaryItem>().eq("typeID", 2)
                .eq("itemValue", taxiInfo.getRegion())).getItemname(),
            sysDictionaryItemMapper.selectOne(new QueryWrapper<SysDictionaryItem>().eq("typeID", 1)
                .eq("itemValue", taxiInfo.getType())).getItemname(), taxiInfo.getDescription());
//    @nirayxu 对您发布的信息兴趣.
//
//    留言内容:
//    我想上车, 请问还有位置吗?
//
//    原始信息:
//    土区 Netflix
//    至少订阅 6 个月
//    自用信用卡开，可提供支付记录！稳定不换号，4K套餐，还有4个位置，最好微信支付，支付宝也可以，加入去进微信群，方便交流和沟通！加微信时备注一下合租！

    map.add("text", format);
    //设置响应头
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
    //封装参数响应头
    HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(map, headers);
    RestTemplate template = new RestTemplate();
    //执行请求，并接受返回结果
    ResponseEntity<String> result = template.exchange(url, HttpMethod.POST, entity, String.class);
    return RetResponse.makeOKRsp(result.getBody());
  }
}
