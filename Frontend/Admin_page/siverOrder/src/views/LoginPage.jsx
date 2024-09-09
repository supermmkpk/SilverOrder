import React from "react";
import useInfoStore from "../../stores/infos";
import '../styles/LoginPage.css';

const LoginPage = () => {
  const { sendLoginRequest } = useInfoStore();
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [error] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();
    const success = await sendLoginRequest(email, password);
    if (success) {
      Notiflix.Notify.success('로그인 성공');
    } else {
      Notiflix.Notify.failure('비밀번호가 일치하지 않습니다.');
    }
  };

  return (
    <div className="login-container">
      <form onSubmit={handleSubmit}>
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
      </form>
      
    </div>
  );
};

export default LoginPage;
