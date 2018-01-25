package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.mapper.TbItemParamItemMapper;
import com.taotao.mapper.TbItemParamMapper;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamExample;
import com.taotao.pojo.TbItemParamItem;
import com.taotao.pojo.TbItemParamItemExample;
import com.taotao.service.ItemParamService;
import com.taotao.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/13.
 */
@Service
public class ItemParamServiceImp implements ItemParamService{

   @Autowired
    private  TbItemParamMapper itemParamMapper ;
  @Autowired
    private TbItemParamItemMapper  itemParamItemMapper;

    @Override
    public TaotaoResult getItemParamByCid(Long cid) {
        TbItemParamExample example = new TbItemParamExample();
        TbItemParamExample.Criteria criteria= example.createCriteria();
        criteria.andItemCatIdEqualTo(cid);

        List<TbItemParam> list=  itemParamMapper.selectByExample(example);

        if (list != null&&list.size() > 0) {
            TbItemParam itemParam = list.get(0);
            return TaotaoResult.ok(itemParam);
        }
        return TaotaoResult.ok();
    }

    @Override
    public TaotaoResult insertItemParam(Long cid, String paramData) {

        TbItemParam itemParam = new TbItemParam();

        itemParam.setItemCatId(cid);

        itemParam.setParamData(paramData);

        itemParam.setCreated(new Date());

        itemParam.setUpdated(new Date());

        itemParamMapper.insert(itemParam);


        return TaotaoResult.ok();
    }

    @Override
    public EasyUIDataGridResult getItemParamList(int page,int rows){

        PageHelper.startPage(page,rows);

        TbItemParamExample example = new TbItemParamExample();

        List<TbItemParam>  list = itemParamMapper.selectByExampleWithBLOBs(example);

        PageInfo<TbItemParam>  pageInfo = new PageInfo<>(list);

        EasyUIDataGridResult result = new EasyUIDataGridResult();

        result.setTotal(pageInfo.getTotal());

        result.setRows(list);

        return result;
    }



}
