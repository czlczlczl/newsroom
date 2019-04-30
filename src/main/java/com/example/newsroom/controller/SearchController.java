package com.example.newsroom.controller;

import com.example.newsroom.service.AdminService;
import com.example.newsroom.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/search")
public class SearchController {

    @Autowired
    SearchService searchService;

    @Autowired
    AdminService adminService;

    /**
     * 1. 得到日期搜索列表的表项
     * @return
     */
    @GetMapping(value = "/getstandard")
    public Object GetStandard(){
        return searchService.GetStandard();
    }

    /**
     * 2. 得到某卷的每一期发刊日期以及每一期对应文章数
     * @param year
     * @param httpSession
     * @return
     */
    @GetMapping(value = "/getcontent/year={year}")
    public Object GetContent(@PathVariable(value = "year")int year, HttpSession httpSession){
        return adminService.GetContent(year);
    }


    /**
     * 3. 通过日期搜索
     * @return
     */
    @GetMapping(value = "/bydate/year={year}&term={term}&page={page}")
    public Object SearchByDate(@PathVariable(value = "year")int year, @PathVariable(value = "term")int term, @PathVariable(value = "page" )int page){
        Map<String,Object> date = new HashMap<>();

        date.put("year", year);
        date.put("term", term);
        date.put("page", page);

        return searchService.SearchByDate(date);
    }

    /**
     * 4. 通过关键词搜索
     * @return
     */
    @GetMapping(value = "/bykey/startyear={startyear}&endyear={endyear}&keyword={keyword}&type={type}&page={page}")
    public Object SearchByKey(@PathVariable(value = "startyear")int startyear, @PathVariable(value = "endyear")int endyear,
                              @PathVariable(value = "keyword")String keyword, @PathVariable(value = "type")int type,
                              @PathVariable(value = "page" )int page) throws UnsupportedEncodingException {
        Map<String,Object> key = new HashMap<>();

        key.put("startyear", startyear);
        key.put("endyear", endyear);
        key.put("keyword", keyword);
        key.put("type", type);
        key.put("page", page);

        return searchService.SearchByKey(key);
    }

}
