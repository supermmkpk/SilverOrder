import React, { useState, useEffect } from 'react';
import '../styles/Signup.css';

const Signup = () => {
  const [password, setPassword] = useState('');
  const [confirmPassword, setConfirmPassword] = useState('');
  const [isPasswordMismatch, setIsPasswordMismatch] = useState(false);

  useEffect(() => {
    // 비밀번호와 비밀번호 재입력 값이 다르면 하이라이트 설정
    setIsPasswordMismatch(password !== confirmPassword && confirmPassword.length > 0);
  }, [password, confirmPassword]);

  return (
    <div className="signup-container">
      <img src="/src/logo/logo.png" alt="Logo" className="signup-image" />
      <input
        type="text"
        placeholder="아이디를 입력하세요"
        className="signup-input"
      />
      <input
        type="password"
        placeholder="비밀번호 입력"
        className="signup-input"
        value={password}
        onChange={(e) => setPassword(e.target.value)} // 비밀번호 입력 핸들러
      />
      <input
        type="password"
        placeholder="비밀번호 재입력"
        className={`signup-input ${isPasswordMismatch ? 'error' : ''}`} // 비밀번호 불일치 시 'error' 클래스 추가
        value={confirmPassword}
        onChange={(e) => setConfirmPassword(e.target.value)} // 비밀번호 재입력 핸들러
      />
      <input
        type="text"
        placeholder="가맹점 ID를 넣어주세요"
        className="signup-input"
      />
      <input
        type="text"
        placeholder="우편 번호 찾기"
        className="signup-input"
      />
      <button className="signup-button">회원 가입</button>
    </div>
  );
};

export default Signup;
