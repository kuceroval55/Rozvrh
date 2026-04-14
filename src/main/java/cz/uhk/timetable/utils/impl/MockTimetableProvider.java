package cz.uhk.timetable.utils.impl;

import cz.uhk.timetable.model.Activity;
import cz.uhk.timetable.model.LocationTimetable;
import cz.uhk.timetable.utils.TimetableProvider;

import java.time.LocalTime;
import java.util.List;

/**
 * Falesna trida providera se vzorovymi daty
 */

public class MockTimetableProvider implements TimetableProvider {

    @Override
    public LocationTimetable read(String building, String room) {
        var tt = new LocationTimetable( building,room);
        var activities = List.of(
                new Activity("PRO1","Programovani I", "Utery", LocalTime.of(10,25),LocalTime.of(13,55), "Kozel"),
                new Activity("ZMAT2","Základy matematiky pro informatiky II ", "Čtvrtek", LocalTime.of(9,55),LocalTime.of(11,30), "Medková"),
                new Activity("DIMA","Diskrétní matematika", "Středa", LocalTime.of(11,35),LocalTime.of(13,10), "Ševčíková")
        );
        tt.setActivities(activities);
        return tt;
    }
}