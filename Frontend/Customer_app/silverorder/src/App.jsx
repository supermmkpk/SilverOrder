import "./App.css";
import PageRoutes from "./routes/PageRoutes";
import UpsideNavbar from "./components/Navbar/UpsideNavbar";
import DownsideNavbar from "./components/Navbar/DownsideNavbar";
import useInfoStore from "./stores/infos";

function App() {
  const { isLogin } = useInfoStore();

  if (!isLogin) {
    return (
      <div id="app-container">
        <div className="scrollable-content">
          <PageRoutes />
        </div>
      </div>
    );
  }

  return (
    <div id="app-container">
      <div className="fixed-top">
        <UpsideNavbar />
      </div>
      <div className="scrollable-content">
        <PageRoutes />
      </div>
      <div className="fixed-bottom">
        <DownsideNavbar />
      </div>
    </div>
  );
}

export default App;
