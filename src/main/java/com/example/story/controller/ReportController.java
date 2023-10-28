package com.example.story.controller;

import com.example.story.entity.ReportEntity;
import com.example.story.repository.ReportRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "api/report")
public class ReportController {
    private final ReportRepository reportRepository;

    public ReportController(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @PostMapping(value = "/add-report")
    public ResponseEntity<?> addReport(@RequestBody ReportEntity reportEntity){
        reportRepository.save(reportEntity);
        return ResponseEntity.ok("success");
    }

    @GetMapping(value = "get-report")
    public ResponseEntity<?> getReport(@RequestBody ReportEntity reportEntity){

        List<ReportEntity>list=reportRepository.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @DeleteMapping(value = "delete-report/{id}")
    private ResponseEntity<?> deleteReportById(@PathVariable int id){
        reportRepository.deleteById((long) id);
        return ResponseEntity.ok("success");
    }
}
