import React, {useState, useEffect} from "react";
import axios from "axios";
import { useParams } from "react-router-dom";

const ProductDetailView = () =>{
    
    const {prdNo} = useParams();

    const [prd, setPrd] = useState({
        prdName:'',
        prdPrice:'',
        prdCompany:'',
        prdStock:'',
        prdDate:''
    });
    const [loading, setLoading]=useState(false);

    const loadData = async () => {
        setLoading(true);
        //const response = await axios.get('http://localhost:8080/product/productDetailView/' + prdNo);
        const response = await axios.get(`http://localhost:8080/product/productDetailView/${prdNo}` );
        console.log("detail : ", response.data);
        setPrd({
            prdName: response.data.prdName,
            prdPrice: response.data.prdPrice,
            prdCompany: response.data.prdCompany,
            prdStock: response.data.prdStock,
            prdDate: response.data.prdDate
        } );
        setLoading(false);
    }

    useEffect( ()=>{
        loadData();
    }, []);

    let moment = require('moment');
    let date = moment(prd.prdDate).format('YYYY-MM-DD');

    return(
        <div>
            <h3>상품 상세 정보 조회</h3>
            <table border="1" width="500">
                <thead>
                    <tr><td>상품번호</td><td>{prdNo}</td></tr>
                    <tr><td>상품명</td><td>{prd.prdName}</td></tr>
                    <tr><td>가격</td><td>{prd.prdPrice}</td></tr>
                    <tr><td>제조회사</td><td>{prd.prdCompany}</td></tr>
                    <tr><td>재고</td><td>{prd.prdStock}</td></tr>
                    <tr><td>제조일</td><td>{date}</td></tr>
                </thead>
            </table>

        </div>
    );

}
export default ProductDetailView;