import { Route, Routes, Navigate } from "react-router-dom";
import useInfoStore from "../stores/infos.js";

// 시작 페이지 (들어가자마자 보일 페이지)
import StartPage from "../views/StartPage.jsx";

// 로그인 페이지
import SigninPage from "../views/SigninPage.jsx";
// 회원가입 페이지
import SignupPage from "../views/SignupPage.jsx";

// 가게 페이지
import StorePage from "../views/StorePage.jsx";

// 마이 페이지
import MyPage from "../views/MyPage.jsx";

// 주문 현황 확인 페이지
import OrderstatePage from "../views/OrderstatePage.jsx";

// 주문 내역 확인 페이지
import OrderlistPage from "../views/OrderlistPage.jsx";

// 내 카드 페이지
import MycardPage from "../views/MycardPage.jsx";

// 매장 외부에서 접속할 때의 페이지
import OutdoorPage from "../views/OutdoorPage.jsx";

// 주변 매장 찾기 페이지
import FindStorePage from "../views/FindStorePage.jsx";

// 장바구니 페이지
import CartPage from "../views/CartPage.jsx";

// 옵션 선택 페이지
import OptionChoicePage from "../views/OptionChoicePage.jsx";

const PageRoutes = () => {
  const { isLogin } = useInfoStore();

  return (
    <Routes>
      {/* QR 코드를 찍어서 들어왔을 때의 시작 페이지 */}
      <Route path="/" element={<StartPage />} />

      {/* 회원가입 */}
      <Route path="/signup" element={<SignupPage />} />

      {/* 로그인 */}
      <Route path="/signin" element={<SigninPage />} />

      {/* QR 코드를 찍지 않고 들어왔을 때의 시작 페이지 */}
      <Route path="/outdoor" element={<OutdoorPage />} />

      {/* 주변 매장 찾아볼 페이지 */}
      <Route path="/findstore" element={<FindStorePage />} />

      {/* 로그인 여부에 따라 페이지 접근 제한 */}
      {isLogin ? (
        <>
          {/* 가게 페이지 */}
          <Route path="/store" element={<StorePage />} />

          {/* 마이 페이지 */}
          <Route path="/mypage" element={<MyPage />} />

          {/* 주문 현황 확인 페이지 */}
          <Route path="/orderstate" element={<OrderstatePage />} />

          {/* 주문 내역 확인 페이지 */}
          <Route path="/orderlist" element={<OrderlistPage />} />

          {/* 내 카드 페이지 */}
          <Route path="/mycard" element={<MycardPage />} />

          {/* 장바구니 페이지 */}
          <Route path="/shoppingcart" element={<CartPage />} />

          {/* 옵션 선택 페이지 */}
          <Route path="/choiceoption" element={<OptionChoicePage />} />
        </>
      ) : (
        <Route path="*" element={<Navigate to="/signin" />} />
      )}
    </Routes>
  );
};

export default PageRoutes;
