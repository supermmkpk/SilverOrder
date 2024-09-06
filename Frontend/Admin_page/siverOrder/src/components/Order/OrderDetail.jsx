import React, { useState } from 'react';
import './styles/OrderDetail.css';
import OrderModal from '../Modal/OrderModal'; 

const OrderDetail = ({ order }) => {
  const [selectedItem, setSelectedItem] = useState(null);

  const handleItemClick = (item) => {
    setSelectedItem(item);
  };

  const closeModal = () => {
    setSelectedItem(null);
  };

  const renderButtons = () => {
    switch (order.status) {
      case "처리 중":
        return <div className="action-buttons"><button className="complete">완료</button></div>;
      case "완료":
        return null;
      default:
        return (
          <div className="action-buttons">
            <button className="accept">수락</button>
            <button className="cancel">취소</button>
          </div>
        );
    }
  };

  return (
    <div className="order-detail">
      <div className="order-header">
        <h3>{order.id}</h3>
        <h4 className='order-status'>{order.status}</h4>
      </div>
      <div className="order-detail-content">
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
              <tr key={index} onClick={() => handleItemClick(item)}>
                <td>{item.name}</td>
                <td>1</td>
                <td>{item.price}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
      <div className="total-and-buttons">
        <p className="total-amount">합계: <span>{order.amount}원</span></p>
        {renderButtons()}
      </div>
      <OrderModal isOpen={!!selectedItem} onClose={closeModal}>
        <h3>{selectedItem?.name}</h3>
        <p>수량: {selectedItem?.count || 1}</p>
        <p>금액: {selectedItem?.price}</p>
        <p>항목 설명: 기타, 항목: 비고</p>
      </OrderModal>
    </div>
  );
};

export default OrderDetail;
