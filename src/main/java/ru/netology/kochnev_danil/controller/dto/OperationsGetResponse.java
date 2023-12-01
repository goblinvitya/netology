package ru.netology.kochnev_danil.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class OperationsGetResponse {
    private final List<OperationsDTO> operations;

}
