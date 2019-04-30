package com.example.newsroom.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.newsroom.dao.SearchMapper;
import com.example.newsroom.entity.Article;
import com.example.newsroom.entity.Standard;
import com.example.newsroom.service.SearchService;
import com.example.newsroom.util.ToDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
@Transactional
public class SearchServiceImpl implements SearchService{

    @Autowired
    SearchMapper searchMapper;

    @Override
    public Map<String, Object> GetStandard() {
        List<HashMap<String,Object>> standardlist;
        Map<String,Object> map = new HashMap<>();

        standardlist = searchMapper.GetStandard();
        if(standardlist != null){
            map.put("result",1);
            map.put("standardlist",standardlist);
        }else {
            map.put("result",0);
        }
        return map;
    }

    @Override
    public Map<String, Object> SearchByDate(Map<String,Object> date) {
        List<HashMap<String,Object>> articlelist;
        Map<String,Object> map = new HashMap<>();
        Integer count;

        HashMap<String, Object> content = searchMapper.SearchContent((int)date.get("year"));
        Standard standard= JSON.parseObject((String) content.get("content"),Standard.class);
        Date ddl[] = standard.getDdl();
        Date start = ddl[(int) date.get("term")];

        int page = (int) date.get("page");
        date.put("page",(page-1)*10);

        count = searchMapper.SearchCountByDate(start);
        articlelist = searchMapper.SearchByDate(start, (int)date.get("page"));

        ResultMap(articlelist, map, count);
        return map;
    }

    @Override
    public Map<String, Object> SearchByKey(Map<String, Object> key) {
        List<HashMap<String,Object>> articlelist;
        Map<String,Object> map = new HashMap<>();
        Map<String,Date> datemap;
        Integer count;

        datemap = ToDate.TodateInByKey(key);
        int page = (int) key.get("page");
        key.put("page",(page-1)*10);
        count = searchMapper.SearchCountByKey(datemap.get("start"),datemap.get("end"),(String) key.get("keyword"),(int)key.get("type"));
            articlelist = searchMapper.SearchByKey(datemap.get("start"),datemap.get("end"),(String) key.get("keyword"),(int)key.get("type"), (int)key.get("page"));

        ResultMap(articlelist, map, count);
        return map;
    }

    private void ResultMap(List<HashMap<String, Object>> articlelist, Map<String, Object> map, Integer count) {
        if(count!= null){
            count = count/10 + 1;
        }
        if(articlelist != null){
            map.put("result",1);
            map.put("count",count);
            map.put("articlelist",articlelist);
        } else {
            map.put("result",0);
        }
    }
}
