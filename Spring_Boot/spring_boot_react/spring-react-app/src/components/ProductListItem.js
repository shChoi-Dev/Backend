import React from "react";

const ProductListItem = (props) => { //props로 서버에서 전송된 데이터를 전달받음
    return (
        <tr>
            <td>{props.prd.prdNo}</td>
            <td>{props.prd.prdName}</td>
            <td>{props.prd.prdPrice}</td>
            <td>{props.prd.prdCompany}</td>
            <td>{props.prd.prdStock}</td>
            <td>{props.prd.prdDate}</td>
            <td>수정</td>
            <td>삭제</td>

        </tr>
    );
};

export default ProductListItem;