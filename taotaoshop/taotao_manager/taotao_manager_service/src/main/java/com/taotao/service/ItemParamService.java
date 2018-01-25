package com.taotao.service;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;

/**
 * Created by Administrator on 2017/9/13.
 */
public interface ItemParamService {

    TaotaoResult getItemParamByCid(Long cid);

    TaotaoResult insertItemParam(Long cid, String paramData);

    EasyUIDataGridResult  getItemParamList(int page,int rows);


}
