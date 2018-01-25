package com.taotao.rest.service.impl;

import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.rest.pojo.CatNode;
import com.taotao.rest.pojo.ItemCatResult;
import com.taotao.rest.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/19.
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private TbItemCatMapper itemCatMapper;

    @Override
    public ItemCatResult getItemCatList() {

        ItemCatResult result = new ItemCatResult();
        result.setData(getList(0l));
        return result;
    }
    private List<?> getList(Long parentId)
    {

        TbItemCatExample example = new TbItemCatExample();

        TbItemCatExample.Criteria criteria=example.createCriteria();

        criteria.andParentIdEqualTo(parentId);

        List<TbItemCat>  list = itemCatMapper.selectByExample(example);

        List resultlist = new ArrayList<>();

        int count =0;

        for (TbItemCat tbItemCat:list)
        {

            if (tbItemCat.getIsParent())
            {
                CatNode node = new CatNode();
                node.setURL("/products/" + tbItemCat.getId() + ".html");
                if (parentId == 0) {
                    node.setName("<a href='"+node.getURL()+"'>"+tbItemCat.getName()+"</a>");
                } else {
                    node.setName(tbItemCat.getName());
                }
                node.setItems(getList(tbItemCat.getId()));
              resultlist.add(node);
            }
             else {

                String node = "/products/"+tbItemCat.getId()+".html|" + tbItemCat.getName();
                resultlist.add(node);
            }

            count++;
            //第一个层循环，只取14条记录
            if (parentId == 0 && count >= 14) {
                break;
            }

        }
      return  resultlist;

    }

}
