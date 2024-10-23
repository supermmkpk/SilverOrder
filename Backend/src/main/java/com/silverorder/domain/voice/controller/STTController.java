package com.silverorder.domain.voice.controller;

import com.silverorder.domain.user.dto.CustomUserDetails;
import com.silverorder.domain.voice.dto.ResponseJupyter;
import com.silverorder.domain.voice.service.STTService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * STT 컨트롤러 클래스
 *
 * @author 박봉균
 * @since JDK17 Eclipse Temurin
 */

@Tag(name = "STT", description = "CLOVA Speech To Text")
@RestController
@RequestMapping("/voice/stt")
@RequiredArgsConstructor
@CrossOrigin("*")
public class STTController {

    private final STTService sttService;

    @Operation(summary = "텍스트 변환", description = "녹음 음성 파일을 받아 텍스트로 변환합니다.")
    @PostMapping("/process")
    public ResponseEntity<String> processSpeech(@RequestParam("file") MultipartFile file) throws Exception {
        //음성 파일 받아서 임시 파일 생성
        File tempFile = File.createTempFile("temp", null);
        file.transferTo(tempFile);

        //임시 파일 텍스트 변환 후 삭제
        String result = sttService.clovaSpeechToText(tempFile.getAbsolutePath());
        tempFile.delete();
        System.out.println(result);

        //결과 처리
        JSONObject jsonResult = new JSONObject(result);
        String text = jsonResult.getString("text");

        if (text.contains("네") || text.contains("예")) {
            return ResponseEntity.ok("긍정적인 응답입니다.");
        } else if (text.contains("아니오") || text.contains("아니요")) {
            return ResponseEntity.ok("부정적인 응답입니다.");
        } else {
            return ResponseEntity.ok("명확한 응답이 아닙니다.");
        }
    }

    @Operation(summary = "음성인식 메뉴추천", description = "음성에 따라 메뉴를 추천합니다.")
    @PostMapping("/testing/{storeId}")
    public ResponseEntity<?> getSpeech(
            @RequestParam("file") MultipartFile file,
            @PathVariable Long storeId,
            @AuthenticationPrincipal CustomUserDetails userDetails) throws Exception {
        long userId = userDetails.getUser().getUserId();

        //음성 파일 받아서 임시 파일 생성
        File tempFile = File.createTempFile("temp", null);
        file.transferTo(tempFile);

        //임시 파일 텍스트 변환 후 삭제
        ResponseJupyter responseJupyter =
                sttService.menuRecommand(storeId, tempFile.getAbsolutePath(), userId);
        tempFile.delete();

        return ResponseEntity.ok(responseJupyter);
    }

}