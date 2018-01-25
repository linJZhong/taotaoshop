package com.taotao.rest.controller;

import com.taotao.rest.pojo.ItemCatResult;
import com.taotao.rest.service.ItemCatService;
import com.taotao.utils.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/9/19.
 */
@Controller
@RequestMapping("/item/cat")
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping(value="/list", produces= MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
    @ResponseBody
    public String getItemCatList(String callback) {
        ItemCatResult result = itemCatService.getItemCatList();
        //判断是否是jsonp调用
        if (StringUtils.isBlank(callback)) {
            System.out.print(JsonUtils.objectToJson(result));

            return JsonUtils.objectToJson(result);

        }

        return callback + "(" + JsonUtils.objectToJson(result) + ");";
    }

}
