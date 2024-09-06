import React from "react";
import '../styles/LoginPage.css';

const LoginPage = () => {
  return (
    <div className="login-container">
      <img src="/src/logo/logo.png" alt="Logo" className="login-image" />
      <input
        type="text"
        placeholder="아이디를 입력하세요"
        className="login-input"
      />
      <input
        type="password"
        placeholder="비밀번호를 입력하세요"
        className="login-input"
      />
      <button className="login-button">로그인</button>
      <div className="signup-text">
        회원이 아니신가요? <a href="/signup" className="signup-link">회원 가입</a>
      </div>
    </div>
  );
};

export default LoginPage;
