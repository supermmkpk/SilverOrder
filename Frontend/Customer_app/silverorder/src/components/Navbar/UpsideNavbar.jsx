import "./styles/UpsideNavbar.css";
import { useNavigate } from "react-router-dom";

const UpsideNavbar = () => {
  const navigate = useNavigate();

  const handleback = () => {
    navigate(-1); // 뒤로 가기
  };

  return (
    <div className="up-navbar-container">
      <div className="upnav-leftside">
        <img
          className="move-before-page"
          onClick={handleback}
          src="/left_arrow.png"
          alt="뒤로가기"
        />
      </div>
      <div className="upnav-rightside">
        <img className="site-notification" src="/notification.png" alt="알림" />
      </div>
    </div>
  );
};
export default UpsideNavbar;
