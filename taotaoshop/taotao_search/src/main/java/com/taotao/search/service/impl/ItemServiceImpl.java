package com.taotao.search.service.impl;

import com.taotao.common.pojo.SolrItem;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.search.mapper.ItemMapper;
import com.taotao.search.service.ItemService;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/10/18.
 */
@Service
public class ItemServiceImpl implements ItemService {

  @Autowired
    private ItemMapper itemMapper;
  @Autowired
    private SolrServer solrServer;

    @Override
    public TaotaoResult importAllItems() throws Exception {

        List<SolrItem> list = itemMapper.getItemList();

        for (SolrItem solrItem:list)
        {
            SolrInputDocument document = new SolrInputDocument();
            document.setField("id",solrItem.getId());
            document.setField("item_title", solrItem.getTitle());
            document.setField("item_sell_point", solrItem.getSell_point());
            document.setField("item_price", solrItem.getPrice());
            document.setField("item_image", solrItem.getImage());
            document.setField("item_category_name", solrItem.getItem_cat_name());
            document.setField("item_desc", solrItem.getItem_desc());

            solrServer.add(document);

        }
          solrServer.commit();

        return TaotaoResult.ok();

    }
}
