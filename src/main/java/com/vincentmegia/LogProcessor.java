package com.vincentmegia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LogProcessor {
    public List<String> process(List<String> rawLogs, int maxSpan) {
        List<Log> logs = new ArrayList<>();
        for (String rawLog: rawLogs) {
            String[] tokens = rawLog.split(" ");
            logs.add(new Log(tokens[0], Integer.parseInt(tokens[1]), tokens[2]));
        }

        List<String> result = new ArrayList<>();
        for (Log log : logs) {
            List<Log> records = logs.stream().filter(l -> l.getUserid().equals(log.getUserid())).collect(Collectors.toList());
            if (records.size() == 1) continue;;
            int span = Math.abs(records.get(0).getTimestamp() - records.get(1).getTimestamp());
            if (span <= maxSpan) {
                if (!result.contains(log.getUserid()))
                    result.add(log.getUserid());
            }
        }
        Collections.sort(result, Comparator.comparingInt(value -> Integer.parseInt(value)));
        return result;
    }
}
