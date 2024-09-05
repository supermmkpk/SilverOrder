import { Route, Routes } from "react-router-dom";

// 시작 페이지 (들어가자마자 보일 페이지)
import StartPage from "../views/StartPage.jsx";

// 로그인 페이지
import SigninPage from "../views/SigninPage.jsx";
// 회원가입 페이지
import SignupPage from "../views/SignupPage.jsx";

// 가게 페이지
import MainPage from "../views/MainPage.jsx";

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
      <Route path="/store" element={<MainPage />} />
    </Routes>
  );
};

export default PageRoutes;
