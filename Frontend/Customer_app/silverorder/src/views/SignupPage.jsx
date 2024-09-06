import "../styles/SignupPage.css";
import { useState } from "react";
import { useNavigate } from "react-router-dom";

const SignupPage = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");
  const [birthcode, setBirthcode] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();
  };

  const navigate = useNavigate();

  const handleCancel = () => {
    navigate("/");
  };

  return (
    <div className="sign-up-container">
      <form className="sign-up-contents" onSubmit={handleSubmit}>
        <img
          className="sign-up-logo"
          src="/icon-512x512.png"
          alt="로그인 페이지 로고"
        />
        <div>
          <div className="signup-input-box">
            <input
              id="signup-input01"
              type="text"
              placeholder="이메일"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              required // 해당 필드가 반드시 채워져야 함 (빈 상태로 제출 방지)
            />
          </div>
          <div className="signup-input-box">
            <input
              id="signup-input02"
              type="password"
              placeholder="비밀번호"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              required // 해당 필드가 반드시 채워져야 함 (빈 상태로 제출 방지)
            />
          </div>
          <div className="signup-input-box">
            <input
              id="signup-input03"
              type="password"
              placeholder="비밀번호 확인"
              value={confirmPassword}
              onChange={(e) => setConfirmPassword(e.target.value)}
              required // 해당 필드가 반드시 채워져야 함 (빈 상태로 제출 방지)
            />
          </div>
          <div className="signup-input-box">
            <input
              id="signup-input04"
              type="text"
              placeholder="주민번호 앞 6자리"
              value={birthcode}
              onChange={(e) => setBirthcode(e.target.value)}
              required // 해당 필드가 반드시 채워져야 함 (빈 상태로 제출 방지)
            />
          </div>
        </div>
        <div className="signup-btn-box">
          <div>
            <button type="submit" className="signup-btn">
              가 입
            </button>
          </div>
          <div>
            <button className="signup-cancel-btn" onClick={handleCancel}>
              취 소
            </button>
          </div>
        </div>
      </form>
    </div>
  );
};

export default SignupPage;
