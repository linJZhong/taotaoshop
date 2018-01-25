package com.taotao.service;

import com.taotao.common.pojo.EasyUITreeNode;

import java.util.List;

/**
 * Created by Administrator on 2017/8/31.
 */
public interface ItemCatService {

    List<EasyUITreeNode> getItemCatList(long parentId);

}
