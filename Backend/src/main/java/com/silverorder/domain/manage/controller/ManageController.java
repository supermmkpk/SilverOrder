package com.silverorder.domain.manage.controller;

import com.silverorder.domain.manage.dto.ManageRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ManageController {

    @PostMapping("https://finopenapi.ssafy.io/ssafy/api/v1/edu/app/issuedApiKey")
    public ResponseEntity<?> issuedApiKey(ManageRequestDto manageRequestDto) {

        return ResponseEntity.ok(manageRequestDto);
    }


}
