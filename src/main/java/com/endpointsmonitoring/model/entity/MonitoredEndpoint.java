package com.endpointsmonitoring.model.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "monitored_endpoint")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MonitoredEndpoint {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "endpoint_name")
    private String endpointName;

    @NotNull
    @Column(name = "url")
    private String url;

    @NotNull
    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @NotNull
    @Column(name = "last_check_date")
    private LocalDateTime lastCheckDate;

    @NotNull
    @Column(name = "monitored_interval")
    private Integer monitoredInterval;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "owner_user_id")
    private User user;
}
