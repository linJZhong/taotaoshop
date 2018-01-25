package com.taotao.controller;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/9/13.
 */
@Controller
@RequestMapping("/item/param")
public class ItemParamController {

    @Autowired
    private ItemParamService itemParamService;

    @RequestMapping("/query/itemcatid/{cid}")
    @ResponseBody
   public TaotaoResult getItemCatByCid(@PathVariable  long cid)
    {
        TaotaoResult result = itemParamService.getItemParamByCid(cid);
        return result;

    }


    @RequestMapping("/save/{cid}")
    @ResponseBody
    public TaotaoResult insertItemParam(@PathVariable Long cid, String paramData) {
        TaotaoResult result = itemParamService.insertItemParam(cid, paramData);
        return result;
    }

    @RequestMapping("/list")
    @ResponseBody
    public  EasyUIDataGridResult getItemParamList(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "30") Integer rows)
    {

        EasyUIDataGridResult result = itemParamService.getItemParamList(page, rows);
        return result;


    }


}
