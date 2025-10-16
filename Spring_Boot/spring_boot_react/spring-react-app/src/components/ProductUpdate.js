import React, {useState, useEffect} from "react";
import axios from "axios";
import { useParams, useNavigate } from "react-router-dom";

const ProductUpdate = () => {
    const {prdNo} = useParams();

    const [prd, setPrd] = useState({
        prdName:'',
        prdPrice:'',
        prdCompany:'',
        prdStock:'',
        prdDate:''
    });
    const [loading, setLoading]=useState(false);
    //상품 수정 등록 완료 후 상품 정보 조회 화면으로 포워딩 : useNavigate() 훅 사용
    let history = useNavigate();

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

    //input태그에 값 입력시 처리 함수
    const onChange =(e)=>{
        //e.target에서 변경을 일으킨 객체의 value와 name을 추출
        const {value, name} = e.target;
        //값 설정
        setPrd({
            ...prd, //기존 prd 객체 복사한 뒤
            [name]: value //name 키의 원소 value 변경
        }
        )
    }

    //취소 버튼 클릭시 처리 함수
    const onReset = () => {
        setPrd({
            prdNo: prd.prdNo,
            prdName: '',
            prdPrice: '',
            prdCompany: '',
            prdStock: '',
            prdDate: prd.prdDate 
        });
    }

    //등록버튼 눌렀을 때 submit 처리
    const onSubmit = (e) => {
        e.preventDefault();
        let frmData = new FormData(document.frmUpdate);
        //axios.post('http://localhost:8080/product/update',frmData)
        axios.put('http://localhost:8080/product/update',frmData)
             .then(
                response=>{
                    alert("수정 완료");
                    history('/productList');//location.href 가능
                }
             )
            }


    return(
        <div>
            <h3>상품 상세 정보 수정</h3>
            <form name='frmUpdate' onSubmit={onSubmit} onReset={onReset}>
            <table border="1" width="500">
            <thead>
                        <tr>
                            <td>상품번호</td>
                            <td> <input
                                type="text"
                                name="prdNo"
                                value={prdNo}
                                readOnly
                                 />
                            </td>
                        </tr>
                        <tr>
                            <td>상품명</td>
                            <td> <input
                                type="text"
                                name="prdName"
                                value={prd.prdName}
                                onChange={onChange}
                                 />
                            </td>
                        </tr>
                        <tr>
                            <td>가격</td>
                            <td> <input
                                type="text"
                                name="prdPrice"
                                value={prd.prdPrice}
                                onChange={onChange}
                                 />
                            </td>
                        </tr>
                        <tr>
                            <td>제조회사</td>
                            <td> <input
                                type="text"
                                name="prdCompany"
                                value={prd.prdCompany}
                                onChange={onChange}
                                />
                            </td>
                        </tr>
                        <tr>
                            <td>재고</td>
                            <td> <input
                                type="text"
                                name="prdStock"
                                value={prd.prdStock}
                                onChange={onChange}
                                />
                            </td>
                        </tr>
                        <tr>
                            <td>제조일</td>
                            <td> <input
                                type="text"
                                name="prdDate"
                                value={date}
                                onChange={onChange}
                                 />
                            </td>
                        </tr>
                        <tr>
                            <td colSpan="2">
                                <input type="submit" value="등록" />
                                <input type="reset" value="취소" />
                            </td>
                        </tr>
                    </thead>
            </table>
            </form>
        </div>
    );

}
export default ProductUpdate;