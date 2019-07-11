package ank.hao.scheduler.controller.api.impl;

import ank.hao.scheduler.controller.api.TestScheduleApi;
import ank.hao.scheduler.service.TestScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestScheduleApiController implements TestScheduleApi {

    @Autowired
    private TestScheduleService testScheduleService;

    public ResponseEntity<Void> testSchedule() {
        testScheduleService.test();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
