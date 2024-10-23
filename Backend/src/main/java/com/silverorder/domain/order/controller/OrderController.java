package com.silverorder.domain.order.controller;

import com.silverorder.domain.menu.dto.ResponseMenuDto;
import com.silverorder.domain.order.dto.*;
import com.silverorder.domain.order.service.OrderService;
import com.silverorder.domain.user.dto.CustomUserDetails;
import com.silverorder.domain.user.dto.UserRole;
import com.silverorder.global.exception.CustomException;
import com.silverorder.global.exception.ErrorCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


/**
 * <pre>
 *     주문 관리 컨트롤러 클래스
 * </pre>
 *
 * @author 박봉균
 * @since JDK17 Eclipse Temurin
 */
@Tag(name = "Order", description = "주문 관리")
@RestController
@RequestMapping("/order")
//@CrossOrigin("*")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;


    /**
     * 주문(결제) 진행
     */
    @Operation(
            summary = "주문(결제) 진행",
            description = "가맹점ID, 간편결제수단ID, 메뉴, 요청사항, 금액 등을 입력 받아 결제를 진행하고, 성공 시, 주문 정보를 저장합니다.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "성공",
                            content = @Content(schema = @Schema(implementation = OrderInDto.class)))
            }
    )
    @PostMapping("/transaction")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> orderTransaction(
            @RequestBody OrderDto orderDto,
            @AuthenticationPrincipal CustomUserDetails customUserDetails
    ) throws Exception {
        OrderInDto orderInDto = orderService.saveOrder(orderDto, customUserDetails.getUser().getUserApiKey())
                .orElseThrow(() -> new CustomException(ErrorCode.ORDER_FAILED));

        return new ResponseEntity<>(orderInDto, HttpStatus.OK);
    }


    /**
     * 주문 상태 변경
     */
    @Operation(
            summary = "주문 상태 변경",
            description = "'ORDER_IN', 'ORDER_CANCELED', ORDER_DENIED', 'ORDER_ACCEPTED', 'ORDER_IN_PROGRESS', 'ORDER_DONE' 중 하나로 상태 변경.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "성공",
                            content = @Content(schema = @Schema(type = "string", example = "주문 상태 변경 성공")))
            }
    )
    @PatchMapping("/change-status")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> changeOrderStatus(
            @RequestBody OrderStatusChangeDto orderStatusChangeDto
    ) throws Exception {

        orderService.changeOrderStatus(orderStatusChangeDto);
        return new ResponseEntity<>("주문 상태 변경 성공", HttpStatus.OK);
    }


    /**
     * 주문 내역 조회
     */
    @Operation(
            summary = "주문 내역 조회",
            description = "유저가 주문한 내역을 조회합니다.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "성공",
                            content = @Content(
                                    array = @ArraySchema(schema = @Schema(implementation = ResponseOrderDto.class)))
                    )
            }
    )
    @GetMapping("/myOrder")
    public ResponseEntity<?> userOrderList(
            @AuthenticationPrincipal CustomUserDetails userDetails
    ) throws Exception {
        long userId = userDetails.getUser().getUserId();
        List<ResponseOrderDto> userOrderList = orderService.userOrderList(userId);
        return ResponseEntity.ok(userOrderList);
    }


    /**
     * 주문 내역 상세조회
     */
    @Operation(
            summary = "주문 내역 상세조회",
            description = "주문한 메뉴를 조회합니다.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "성공",
                            content = @Content(
                                    array = @ArraySchema(schema = @Schema(implementation = ResponseOrderDetailDto.class)))
                    )
            }
    )
    @GetMapping("/orderDetail/{orderId}")
    public ResponseEntity<?> storeOrderDetail(
            @PathVariable Long orderId,
            @AuthenticationPrincipal CustomUserDetails userDetails
    ) throws Exception {
        long userId = userDetails.getUser().getUserId();
        ResponseOrderStoreDto orderDetail = orderService.userOrderDetailList(userId, orderId);
        return ResponseEntity.ok(orderDetail);
    }


    /**
     * 금일의 가게 주문 내역 조회
     */
    @Operation(
            summary = "금일의 가게 주문 내역 조회",
            description = "금일 가게의 주문 내역을 조회합니다.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "성공",
                            content = @Content(
                                    array = @ArraySchema(schema = @Schema(implementation = ResponseOrderStoreDto.class)))
                    )
            }
    )
    @GetMapping("/storeOrder/{storeId}")
    public ResponseEntity<?> userOrderDetailList(
            @PathVariable Long storeId,
            @AuthenticationPrincipal CustomUserDetails userDetails
    ) throws Exception {
        long userId = userDetails.getUser().getUserId();
        List<ResponseOrderStoreDto> responseOrderStoreDtoList = orderService.storeOrderList(userId, storeId);
        return ResponseEntity.ok(responseOrderStoreDtoList);
    }

}
