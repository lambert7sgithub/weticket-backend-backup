package com.thoughtworks.training.service;

import com.thoughtworks.training.utils.DateUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DateService {
    public DateUtil dateUtil = new DateUtil();

    public List<String> generateThreeDates() {
        List<String> dateStrings = new ArrayList<>();
        dateStrings.add(dateUtil.getTodayDateString());
        dateStrings.add(dateUtil.getFutureDateString(1));
        dateStrings.add(dateUtil.getFutureDateString(2));
        return dateStrings;
    }

    public List<String> generateDates() {
        return generateThreeDates();
    }
}
