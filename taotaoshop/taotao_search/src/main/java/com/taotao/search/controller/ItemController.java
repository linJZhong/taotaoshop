package com.taotao.search.controller;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.search.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * Created by Administrator on 2017/10/18.
 */
@Controller

public class ItemController {
    @Autowired
    private ItemService itemService;

    @RequestMapping("/importall")
    @ResponseBody
    public TaotaoResult importAll() {
        try {
            TaotaoResult result = itemService.importAllItems();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return TaotaoResult.build(500, com.taotao.utils.ExceptionUtil.getStackTrace(e));
        }
    }
}

