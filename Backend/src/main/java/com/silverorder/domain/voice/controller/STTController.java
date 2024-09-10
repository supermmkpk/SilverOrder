package com.silverorder.domain.voice.controller;

import com.silverorder.domain.voice.service.STTService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Tag(name = "STT", description = "CLOVA CSR STT")
@RestController
@RequestMapping("/voice/stt")
@RequiredArgsConstructor
public class STTController {

    private final STTService sttService;

    @PostMapping("/process")
    public ResponseEntity<String> processSpeech(@RequestParam("file") MultipartFile file) {
        try {
            File tempFile = File.createTempFile("temp", null);
            file.transferTo(tempFile);
            String result = sttService.clovaSpeechToText(tempFile.getAbsolutePath());
            tempFile.delete();

            JSONObject jsonResult = new JSONObject(result);
            String text = jsonResult.getString("text");

            System.out.println(text);

            if (text.contains("네") || text.contains("예")) {
                return ResponseEntity.ok("긍정적인 응답입니다.");
            } else if (text.contains("아니오") || text.contains("아니요")) {
                return ResponseEntity.ok("부정적인 응답입니다.");
            } else {
                return ResponseEntity.ok("명확한 응답이 아닙니다.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("오류 발생: " + e.getMessage());
        }
    }
}