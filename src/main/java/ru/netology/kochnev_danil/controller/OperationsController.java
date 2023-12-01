package ru.netology.Alexeev_N.controller;

import org.springframework.web.bind.annotation.*;
import ru.netology.kochnev_danil.controller.dto.OperationsDTO;
import ru.netology.kochnev_danil.controller.dto.OperationsGetResponse;
import ru.netology.kochnev_danil.domain.operation.Operation;
import ru.netology.kochnev_danil.service.StatementService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/operations/")
public class OperationsController {
    private final StatementService statementService;

    public OperationsController(StatementService statementService) {
        this.statementService = statementService;
    }

    @GetMapping("{customerId}")
    public OperationsGetResponse checkOperationsByCustomerId(@PathVariable("customerId") int customerId){
        List<Operation> operations = statementService.getOperationOnId(customerId);
        List<OperationsDTO> operationsDTOS = operations.stream()
                .map(operation ->
                        new OperationsDTO(operation.getId(), operation.getSum(),operation.getCurrency(), operation.getMerchant())).collect(Collectors.toList());
        return new OperationsGetResponse(operationsDTOS);
    }

    @PostMapping()
    public OperationsDTO addOperation(@RequestBody Operation operation){
        statementService.saveOperation(operation);
        return new OperationsDTO(operation.getId(),operation.getSum(),operation.getCurrency(),operation.getMerchant());
    }

    @DeleteMapping("/delete/{customerId}")
    public void deleteOperation(@PathVariable("customerId") int id){
        statementService.removeOperationsOnCustomerId(id);
    }
}
