package com.silverorder.domain.store.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseProcSalesDto {
    private ProcSalesDto procSalesDto;
    private List<ProcWeekDto> procWeekDtoList;
}
