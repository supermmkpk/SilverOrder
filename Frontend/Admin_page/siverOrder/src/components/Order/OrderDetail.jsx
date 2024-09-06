import React from 'react';

const OrderDetail = ({ order }) => {
  return (
    <div className="order-detail">
      <h3>{order.id}</h3>
      <p>{order.status} 중</p>
      <table>
        <thead>
          <tr>
            <th>메뉴</th>
            <th>수량</th>
            <th>금액</th>
          </tr>
        </thead>
        <tbody>
          {order.items.map((item, index) => (
            <tr key={index}>
              <td>{item.name}</td>
              <td>1</td>
              <td>{item.price}</td>
            </tr>
          ))}
        </tbody>
      </table>
      <p>합계: {order.amount}원</p>
    </div>
  );
};

export default OrderDetail;
