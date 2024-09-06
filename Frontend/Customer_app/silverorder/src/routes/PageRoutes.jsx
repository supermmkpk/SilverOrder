import { Route, Routes } from "react-router-dom";

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

// 회원 정보 변경 페이지
import ChangeInfoPage from "../views/ChangeInfoPage.jsx";

// 주문 현황 확인 페이지
import OrderstatePage from "../views/OrderstatePage.jsx";

// 주문 내역 확인 페이지
import OrderlistPage from "../views/OrderlistPage.jsx";

import MycardPage from "../views/MycardPage.jsx";

const PageRoutes = () => {
  return (
    <Routes>
      {/* 시작 페이지 */}
      <Route path="/" element={<StartPage />} />

      {/* 회원가입 */}
      <Route path="/signup" element={<SignupPage />} />

      {/* 로그인 */}
      <Route path="/signin" element={<SigninPage />} />

      {/* 가게 페이지 */}
      <Route path="/store" element={<StorePage />} />

      {/* 마이 페이지 */}
      <Route path="/mypage" element={<MyPage />} />

      {/* 회원정보 변경 페이지 */}
      <Route path="/changeInfo" element={<ChangeInfoPage />} />

      {/* 주문 현황 확인 페이지 */}
      <Route path="/orderstate" element={<OrderstatePage />} />

      {/* 주문 내역 확인 페이지 */}
      <Route path="/orderlist" element={<OrderlistPage />} />

      {/* 내 카드 페이지 */}
      <Route path="/mycard" element={<MycardPage />} />
    </Routes>
  );
};

export default PageRoutes;
