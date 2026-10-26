package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.model.EmployeeLeave;
import com.example.service.EmployeeLeaveService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/leaves")
public class EmployeeLeaveController {

    @Autowired
    private EmployeeLeaveService service;

    // GET all leaves
    @GetMapping
    public List<EmployeeLeave> getAllLeaves() {
        return service.getAllLeaves();
    }

    // GET leave by ID
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeLeave> getLeaveById(
            @PathVariable int id) {

        EmployeeLeave leave = service.getLeaveById(id);

        if (leave == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(leave);
    }

    // POST - Add leave
    @PostMapping
    public ResponseEntity<EmployeeLeave> addLeave(
            @Valid @RequestBody EmployeeLeave leave) {

        EmployeeLeave savedLeave = service.addLeave(leave);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedLeave);
    }

    // PUT - Update leave
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeLeave> updateLeave(
            @PathVariable int id,
            @Valid @RequestBody EmployeeLeave leave) {

        EmployeeLeave updated = service.updateLeave(id, leave);

        if (updated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }

    // PATCH - Partial update
    @PatchMapping("/{id}")
    public ResponseEntity<EmployeeLeave> patchLeave(
            @PathVariable int id,
            @RequestBody EmployeeLeave leave) {

        EmployeeLeave updated = service.patchLeave(id, leave);

        if (updated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }

    // DELETE leave
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLeave(
            @PathVariable int id) {

        boolean deleted = service.deleteLeave(id);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(
                "Leave deleted successfully");
    }
}