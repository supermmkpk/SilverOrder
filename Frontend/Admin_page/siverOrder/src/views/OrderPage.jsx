import React, { useState } from 'react';
import Navbar from '../components/Navbar/Navbar'
import OrderTabs from '../components/Order/OrderTabs';
import OrderList from '../components/Order/OrderList';
import OrderDetail from '../components/Order/OrderDetail';
import '../styles/OrderPage.css';

const OrderPage = () => {
  const [selectedTab, setSelectedTab] = useState('대기'); // 현재 선택된 탭
  const [selectedOrder, setSelectedOrder] = useState(null); // 선택된 주문

  const handleTabChange = (tab) => {
    setSelectedTab(tab);
    setSelectedOrder(null); // 탭이 바뀔 때 선택된 주문 초기화
  };

  const handleOrderSelect = (order) => {
    setSelectedOrder(order);
  };

  return (
    <div>
      <Navbar />
      <div>
        <OrderTabs selectedTab={selectedTab} onTabChange={handleTabChange} />
        <div>
          <OrderList selectedTab={selectedTab} onOrderSelect={handleOrderSelect} />
          {selectedOrder && <OrderDetail order={selectedOrder} />}
        </div>
      </div>
    </div>
  );
};

export default OrderPage;
