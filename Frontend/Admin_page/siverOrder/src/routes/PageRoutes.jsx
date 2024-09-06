import { Route, Routes, Navigate } from "react-router-dom";


// 로그인 페이지
import LoginPage from "../views/LoginPage.jsx";
// 회원 가입 페이지
import Signup from "../views/Signup.jsx";
const PageRoutes = () => {


    return (
        <Routes>
            {/* 로그인 */}
            <Route path="/login" element={<LoginPage />} />
            {/* 회원가입 */}
            <Route path="/signup" element={<Signup />} />

        </Routes>
    )
}

export default PageRoutes;