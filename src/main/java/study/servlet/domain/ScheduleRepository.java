package study.servlet.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class ScheduleRepository {
    private static final ScheduleRepository instance = new ScheduleRepository();

    private Map<Long, Schedule> store = new ConcurrentHashMap<>();
    private AtomicLong sequence = new AtomicLong();

    private ScheduleRepository() {
    }

    public static ScheduleRepository getInstance() {
        return instance;
    }

    public Schedule save(Schedule schedule) {
        schedule.setId(sequence.incrementAndGet());
        store.put(schedule.getId(), schedule);
        return schedule;
    }

    public Schedule findById(Long id) {
        return store.get(id);
    }

    public List<Schedule> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
