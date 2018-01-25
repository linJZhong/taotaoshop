package com.taotao.controller;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/8/16.
 */

@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;



    @RequestMapping("/item")
    public String print(){

        System.out.print("11111");
        return "item";
    }

    @RequestMapping(value ="/item/{itemId}",produces = "application/json;charset=utf-8")
    @ResponseBody
    private TbItem getItemById(@PathVariable Long itemId) {
        TbItem item = itemService.getItemById(itemId);
        return item;
    }

    @RequestMapping("/item/list")
    @ResponseBody
    public EasyUIDataGridResult getItemList(Integer page, Integer rows) {
        EasyUIDataGridResult result = itemService.getItemList(page, rows);
        return result;
    }

    @RequestMapping(value="/item/save", method= RequestMethod.POST)
    @ResponseBody
    public TaotaoResult createItem(TbItem item, String desc,String itemParam) {
        TaotaoResult result = itemService.createItem(item, desc,itemParam);
        return result;
    }

    @RequestMapping("page/item/{itemId}")
    public String showItemParam(@PathVariable Long itemId, Model model) {
        String html = itemService.getItemParamHtml(itemId);
        model.addAttribute("html", html);
        return"item-param";
    }

}
