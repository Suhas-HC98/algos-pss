package com.shared.algo.controller;

import com.shared.algo.utils.GenericResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.shared.algo.utils.SharedAlgosResponseBuilder.wrapWithGenericResponse;

@RestController
@RequestMapping(value = "/health")
public final class HealthCheckController {

    @Operation(method = "GET", description = "Health Check", tags = "health")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")})
    @GetMapping(value = "/health-check", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponse<?>> healthCheck() {
        return new ResponseEntity<>(wrapWithGenericResponse("Health Check success"), HttpStatus.OK);
    }
}
