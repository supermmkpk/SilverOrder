import "./Styles/MenuList.css"; // CSS 파일을 가져옴
import MenuInfo from "./MenuInfo"; // MenuInfo 컴포넌트를 가져옴

const MenuList = () => {
  // 더미 데이터를 객체로 정의
  const DummyMenu = {
    products: [
      {
        id: 1,
        name: "아메리카노",
        description: "깔끔한 아메리카노",
        price: 1500,
        imageUrl: "/Ice-americano.jpg",
        options: [
          { id: 1, name: "샷 추가", price: 500 },
          { id: 2, name: "얼음 추가", price: 0 },
          { id: 3, name: "사이즈업", price: 500 },
        ],
      },
      {
        id: 2,
        name: "카페라떼",
        description: "포근한 카페라떼",
        price: 2500,
        imageUrl: "/Ice-americano.jpg",
        options: [
          { id: 1, name: "샷 추가", price: 500 },
          { id: 2, name: "우유 오트밀로 변경", price: 500 },
        ],
      },
      {
        id: 3,
        name: "빅-아메리카노",
        description: "커다랗고 깔끔한 아메리카노",
        price: 3000,
        imageUrl: "/Ice-americano.jpg",
        options: [{ id: 1, name: "샷 추가", price: 500 }],
      },
    ],
  };

  return (
    <div className="menulist-container">
      {/* DummyMenu 데이터를 MenuInfo 컴포넌트에 전달 */}
      <MenuInfo data={DummyMenu} />
    </div>
  );
};

export default MenuList;
