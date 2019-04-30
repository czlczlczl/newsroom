package com.example.newsroom.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface SearchService {

    public Map<String, Object> GetStandard ();

    public Map<String, Object> SearchByDate (Map<String,Object> date);

    public Map<String, Object> SearchByKey (Map<String,Object> key);

}
