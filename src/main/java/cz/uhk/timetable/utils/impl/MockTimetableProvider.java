package cz.uhk.timetable.utils.impl;

import cz.uhk.timetable.model.Activity;
import cz.uhk.timetable.model.LocationTimetable;
import cz.uhk.timetable.utils.TimetableProvider;

import java.time.LocalTime;
import java.util.List;

//falesna trida providera se vzorem

public class MockTimetableProvider implements TimetableProvider {
    @Override
    public LocationTimetable read(String building, String room) {
        var tt  = new LocationTimetable(building, room);
        var activities = List.of(
                new Activity("PRO1", "Programovani I", "Utery",
                        LocalTime.of(12, 25), LocalTime.of(13, 55),"Kozel"),
                new Activity("ZMI2", "Zaklady matematiky II", "Pondeli",
                        LocalTime.of(13, 10), LocalTime.of(14, 20),"Bauer"));
        return null;
    }
}
