package org.example.service;

import org.example.entity.LogInfo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LogService {
    private final Map<String, List<LogInfo>> logMap = new HashMap<>();

    public List<LogInfo> showInfo(String token) {
        return logMap.get(token);
    }

    public void putInfo(String token, LogInfo logInfo){
        List<LogInfo> logInfoFromKey = logMap.get(token);
        if (logInfoFromKey == null){
            List<LogInfo> logInfos = new ArrayList<>();
            logInfos.add(logInfo);
            logMap.put(token, logInfos);
        }
        else {
            logInfoFromKey.add(logInfo);
        }
    }
}
