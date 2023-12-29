package study.servlet.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class ScheduleRepositoryTest {
    ScheduleRepository scheduleRepository = ScheduleRepository.getInstance();

    @AfterEach
    void afterEach() {
        scheduleRepository.clearStore();
    }

    @Test
    void save() {
        // given
        Schedule schedule = new Schedule("머루랑 산책하기", "2023-12-23", "Personal");

        // when
        Schedule savedSchedule = scheduleRepository.save(schedule);

        // then
        Schedule foundSchedule = scheduleRepository.findById(savedSchedule.getId());
        assertEquals(savedSchedule, foundSchedule);
    }

    @Test
    void findAll() {
        // given
        Schedule schedule1 = new Schedule("머루랑 산책하기", "2023-12-23", "Personal");
        Schedule schedule2 = new Schedule("가리 츄르주기", "2023-12-24", "Personal");

        scheduleRepository.save(schedule1);
        scheduleRepository.save(schedule2);

        // when
        List<Schedule> schedules = scheduleRepository.findAll();

        // then
        assertThat(schedules).hasSize(2)
                .containsExactly(schedule1, schedule2);
    }

}