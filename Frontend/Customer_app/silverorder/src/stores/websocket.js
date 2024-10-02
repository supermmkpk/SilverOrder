import { create } from "zustand";
import SockJS from "sockjs-client";
import { Stomp } from "@stomp/stompjs";

const useWebSocketStore = create((set, get) => ({
  stompClient: null, // STOMP 클라이언트 초기화
  connectionStatus: "Disconnected", // 연결 상태 초기화

  connect: () => {
    // // 현재 페이지의 프로토콜이 https일 경우 https, 아니면 http를 사용
    // const protocol = window.location.protocol === "https:" ? "https:" : "http:";
    // console.log(window.location.protocol);
    // // 현재 호스트를 기준으로 소켓 URL을 동적으로 설정
    // const socket = new SockJS(
    //   `${protocol}//${window.location.host}/silverorder/ws-stomp`
    // );
    // console.log(`${protocol}//${window.location.host}/silverorder/ws-stomp`);

    // const client = Stomp.over(socket);

    // SockJS를 사용하여 WebSocket 서버에 연결
    const socket = new SockJS("http://localhost:8080/silverorder/ws-stomp");
    const client = Stomp.over(socket);

    // STOMP 클라이언트 연결 설정
    client.connect(
      {},
      (frame) => {
        console.log("STOMP Client 연결 성공:", frame); // 연결 성공 시 로그 출력
        set({ connectionStatus: "Connected", stompClient: client }); // 상태 업데이트

        // 필요한 topic 구독 설정
        // 여기서는 주문 상태 변경을 위한 구독 설정 예시입니다.
        // subscribeToOrder() 함수를 사용하여 동적으로 주문 ID에 따라 구독할 수 있습니다.
      },
      (error) => {
        console.error("STOMP Client 연결 오류:", error); // 연결 오류 시 로그 출력
        set({ connectionStatus: "Error: " + error }); // 상태 업데이트
      }
    );
  },

  subscribeToOrder: (orderId) => {
    // 주문 ID를 인자로 받아 해당 주문의 상태 변경을 구독
    if (orderId && get().stompClient && get().stompClient.connected) {
      get().stompClient.subscribe(
        `/topic/orderStatus/${orderId}`,
        (message) => {
          try {
            // 수신된 메시지를 JSON으로 변환하고 응답 구조에 맞게 처리
            const { orderId, orderStatus } = JSON.parse(message.body);

            console.log("Order ID:", orderId); // 주문 ID 출력
            console.log("Order Status:", orderStatus); // 주문 상태 출력

            // 주문 상태에 따라 필요한 작업 수행
            // 예: UI 업데이트 또는 알림 처리 등
          } catch (error) {
            console.error("Failed to parse message:", error); // JSON 변환 오류 처리
          }
        }
      );
      console.log(
        `지금부터 ${orderId}번 주문의 상태를 알림으로 확인할 수 있습니다.`
      ); // 구독 성공 로그 출력
    } else {
      console.warn("아직 연결되지 않았거나, orderId가 유효하지 않습니다."); // 연결되지 않았거나 잘못된 주문 ID 경고
    }
  },

  disconnect: () => {
    set((state) => {
      if (state.stompClient && state.stompClient.connected) {
        state.stompClient.disconnect(() => {
          console.log("STOMP Client 연결 해제"); // 연결 해제 시 로그 출력
        });
      }
      return { stompClient: null, connectionStatus: "Disconnected" }; // 연결 해제 후 상태 초기화
    });
  },
}));

export default useWebSocketStore;