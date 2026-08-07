package com.eldernest.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class FacilityServiceRequest {

    private Long facilityId;
    private String serviceName;
    private String description;
    private BigDecimal cost;
    private String category;
    private String serviceStatus;
}