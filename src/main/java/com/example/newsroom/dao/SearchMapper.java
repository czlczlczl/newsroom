package com.example.newsroom.dao;

import com.example.newsroom.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface SearchMapper {

    List<HashMap<String,Object>> GetStandard();

    Integer SearchCountByDate(@Param(value = "start") Date start);

    List<HashMap<String,Object>> SearchByDate(@Param(value = "start") Date start, @Param(value = "page") int page);

    HashMap<String,Object> SearchContent(int year);

    Integer SearchCountByKey(@Param(value = "start") Date start, @Param(value = "end") Date end, @Param(value = "keyword") String keyword, @Param(value = "type") int type);

    List<HashMap<String,Object>> SearchByKey(@Param(value = "start") Date start, @Param(value = "end") Date end, @Param(value = "keyword") String keyword, @Param(value = "type") int type, @Param(value = "page") int page);

}
