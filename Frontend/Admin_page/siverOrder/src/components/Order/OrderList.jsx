import React from 'react';

const OrderList = ({ selectedTab, onOrderSelect }) => {
  const orders = [
    { id: '0003', date: '2024.09.03 14:03:00', amount: 12000, status: '대기', items: [{ name: '샤인머스캣그린주스', price: 6000 }, { name: '레드오렌지자몽주스', price: 6000 }] },
    // 더 많은 주문 데이터
  ];

  const filteredOrders = orders.filter(order => order.status === selectedTab);

  return (
    <div className="order-list">
      <table>
        <thead>
          <tr>
            <th>주문 번호</th>
            <th>주문 날짜</th>
            <th>총합 금액</th>
            <th>주문 상태</th>
          </tr>
        </thead>
        <tbody>
          {filteredOrders.map(order => (
            <tr key={order.id} onClick={() => onOrderSelect(order)}>
              <td>{order.id}</td>
              <td>{order.date}</td>
              <td>{order.amount}</td>
              <td>{order.status}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default OrderList;
