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
@Table(name = "monitoring_result")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MonitoringResult {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "check_date")
    private LocalDateTime checkDate;

    @NotNull
    @Column(name = "http_status_code")
    private Integer httpStatusCode;

    @NotNull
    @Column(name = "returned_payload")
    private String returnedPayload;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "monitored_endpoint_id")
    private MonitoredEndpoint monitoredEndpoint;
}
