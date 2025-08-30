package com.ashuraDev.TaskNest.Infrastructure.Controller;

import com.ashuraDev.TaskNest.Application.DTOs.ProjectRequestDTO;
import com.ashuraDev.TaskNest.Application.DTOs.ProjectResponseDTO;
import com.ashuraDev.TaskNest.Infrastructure.Mapper.ProjectDTOMapper;
import com.ashuraDev.TaskNest.Application.useCases.ProjectUseCaseImpl;
import com.ashuraDev.TaskNest.Domain.Models.Project;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectUseCaseImpl projectUseCaseImpl;

    @PostMapping
    public ResponseEntity<ProjectResponseDTO> create( @RequestBody ProjectRequestDTO dto) {
        Project project = ProjectDTOMapper.toDomain(dto);
        Project saved = projectUseCaseImpl.createProject(project);
        return ResponseEntity.ok(ProjectDTOMapper.toResponse(saved));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectResponseDTO> getById(@PathVariable Long id) {
        return projectUseCaseImpl.getProjectById(id)
                .map(ProjectDTOMapper::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ProjectResponseDTO>> getAll() {
        List<ProjectResponseDTO> projects = projectUseCaseImpl.getALLProjects()
                .stream()
                .map(ProjectDTOMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(projects);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectResponseDTO> update(@PathVariable Long id, @RequestBody ProjectRequestDTO dto) {
        Project project = ProjectDTOMapper.toDomain(dto);
        Project updated = projectUseCaseImpl.updateProject(id, project);
        return ResponseEntity.ok(ProjectDTOMapper.toResponse(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        projectUseCaseImpl.deleteProject(id);
        return ResponseEntity.noContent().build();
    }
}