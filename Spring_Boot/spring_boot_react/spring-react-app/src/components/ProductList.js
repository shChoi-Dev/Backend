import React, {useState, useEffect} from "react";
import axios from "axios";
import ProductListItem from "./ProductListItem";

const ProductList = () => {
    const [data, setData] = useState([]); //특정 테이블의 레코드 모두 반환
    const [loading, setLoading] = useState(false);

    // 서버에 요청해서 데이터 받아오는 함수
    const loadData = async () => {
        setLoading(true);
        const response = await axios.get('http://localhost:8080/product/productList');
        console.log(response.data);
        setData(response.data);
        setLoading(false);
    }

    useEffect( () => {
        loadData();
    }, [] );

    return(
        <div>
            <h3>상품 정보 조회</h3>
            <table border="1">
                <thead>
                    <th>상품번호</th>
                    <th>상품명</th>
                    <th>가격</th>
                    <th>제조회사</th>
                    <th>재고</th>
                    <th>제조일</th>
                    <th>수정</th>
                    <th>삭제</th>
                </thead>
                <tbody>
                    {/*여기에 컴포넌트 이용해서 출력 */}
                    {
                        data.map(function(prd, i){
                            return <ProductListItem prd={prd} key={i} />
                        })
                    }
                </tbody>
            </table>
        </div>
    );
}

export default ProductList;