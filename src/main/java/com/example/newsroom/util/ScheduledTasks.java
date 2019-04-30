package com.example.newsroom.util;

import com.example.newsroom.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    @Autowired
    AdminService adminService;

    /**
     * 每年一月一日执行生成新的newsroominfo
     */
    @Scheduled(cron = "0 0 0 1 1 ?")
    public void InsertInfo() {
        adminService.InsertInfo();
    }

    @Scheduled(cron = "0 0 0 1,10,20 * ?")
    public void ClearSrc() {
        adminService.ClearSrc();
    }

}