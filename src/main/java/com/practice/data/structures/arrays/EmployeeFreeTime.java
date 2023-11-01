package com.practice.data.structures.arrays;

import java.util.*;

public class EmployeeFreeTime {

    public static List<Interval> findEmployeeFreeTime(List<List<Interval>> employeeSchedule){
        List<Interval> employeeSchedules = mergeIntervals(employeeSchedule);
        List<Interval> freeTime = new ArrayList<>();

        for(int i = 1; i < employeeSchedules.size(); i++){
            int start = employeeSchedules.get(i - 1).end;
            int end = employeeSchedules.get(i).start;

            if(end > start){
                freeTime.add(new Interval(start,end));
            }
        }
        return freeTime;
    }

    private static List<Interval> mergeIntervals(List<List<Interval>> employeeSchedule) {
        List<Interval> merged = new ArrayList<>();
        for (List<Interval> intervals : employeeSchedule){
            merged.addAll(intervals);
        }

        if(merged.isEmpty()){
            return merged;
        }

        merged.sort(Comparator.comparingInt(a -> a.start));

        List<Interval> result = new ArrayList<>();
        Interval current = merged.get(0);

        for(int i = 1; i < merged.size(); i++){
            Interval next = merged.get(i);
            if(current.end >= next.start){
                current.end = Math.max(current.end, next.end);
            } else {
                result.add(current);
                current = next;
            }
        }

        result.add(current);
        return result;
    }

    public static void main(String[] args) {
        List<Interval> employee1 = Arrays.asList(new Interval(1, 2), new Interval(5, 6));
        List<Interval> employee2 = Arrays.asList(new Interval(1, 3));
        List<Interval> employee3 = Arrays.asList(new Interval(4, 10));
        List<List<Interval>> schedule = Arrays.asList(employee1, employee2, employee3);

        List<Interval> freeTime = findEmployeeFreeTime_ON(schedule);

        System.out.println("Common Free Time Intervals:");
        for (Interval interval : freeTime) {
            System.out.println(interval.start + " - " + interval.end);
        }
    }

    public static List<Interval> findEmployeeFreeTime_ON(List<List<Interval>> employeeSchedules){
        List<Interval> freeTime = new ArrayList<>();
        PriorityQueue<Interval> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.start));

        for(List<Interval> lstInterval : employeeSchedules){
            minHeap.addAll(lstInterval);
        }

        Interval previous = minHeap.poll();
        while(!minHeap.isEmpty()){
            Interval current = minHeap.poll();

            if(current.start > previous.end){
                freeTime.add(new Interval(previous.end, current.start));
                previous = current;
            } else {
                if(previous.end < current.end){
                    previous.end = current.end;
                }
            }
        }

        return freeTime;
    }
}
