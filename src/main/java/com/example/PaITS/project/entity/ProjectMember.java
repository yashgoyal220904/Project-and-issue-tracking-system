package com.example.PaITS.project.entity;

import com.example.PaITS.user.entity.User;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Represents a user's membership in a project.
 * Maps to the project_members table defined in the DB design.
 * Stores the user's role within the project (e.g. LEADER, CONTRIBUTOR)
 * and when they joined.
 */
@Entity
@Table(
        name = "project_members",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uq_pm_project_user",
                        columnNames = {"project_id", "user_id"}
                )
        }
)
public class ProjectMember {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "role_in_project", nullable = false, length = 30)
    private String roleInProject = "CONTRIBUTOR";

    @Column(name = "joined_at", nullable = false, updatable = false)
    private LocalDateTime joinedAt;

    // =================== Lifecycle ===================

    @PrePersist
    public void onJoin() {
        this.joinedAt = LocalDateTime.now();
    }

    // =================== Constructors ===================

    public ProjectMember() {}

    public ProjectMember(Project project, User user, String roleInProject) {
        this.project = project;
        this.user = user;
        this.roleInProject = roleInProject;
    }

    // =================== Getters & Setters ===================

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public Project getProject() { return project; }
    public void setProject(Project project) { this.project = project; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public String getRoleInProject() { return roleInProject; }
    public void setRoleInProject(String roleInProject) { this.roleInProject = roleInProject; }

    public LocalDateTime getJoinedAt() { return joinedAt; }
    public void setJoinedAt(LocalDateTime joinedAt) { this.joinedAt = joinedAt; }
}
