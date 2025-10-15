import React, {useEffect, useState} from 'react';
import axios from 'axios'

const AxiosSpring = () => {
    const [data, setData] = useState('');
    const [loading, setLoading] = useState(false);

    // 서버에 데이터 요청해서 받아옴
    // state 이용해서 값 저장

    const loadData = async () => {
        setLoading(true);
        const response = await axios.get('http://localhost:8080/hello');
        console.log(response.data);
        setData(response.data);
        setLoading(false);
    } 

    // ReactComponent가 렌더링 될때마다 특정 작업을 실행해 줌
    useEffect(() => {
        loadData();
    }, [] );
    
    return (
        <div>
            <h3>서버로부터 받아온 값</h3>
            {data}
        </div>
    );
};

export default AxiosSpring;