import React, {useEffect, useState} from 'react'
import ReactDOM from 'react-dom'
import { BrowserRouter } from 'react-router-dom'

import CanvasGraph from './CanvasGraph'
import Footer from './Footer'
import OutputTable from './OutputTable'

export default function GraphContainer(props) {
    const dot = {
        x: "x",
        y: "y",
        user: "Пользователь",
        accuracy: "Результат",
        date: "Дата"
    }
    const [tableData, setTableData] = useState([dot])
    const [x, setX] = useState(0)
    const [y, setY] = useState(0)

    useEffect(() => {
        fetch("http://localhost:8080/api/getOwnDots", {
            method: "POST",
            headers: {
                'Content-Type': 'application/json'
            },
        }).then(response => response.json()).then(dots => handleTable(dots))
    },[])

    function handleX(evt) {
        setX(evt.target.value)
    }

    function handleY(evt) {
        setY(evt.target.value)
    }
    

    function handleTable(dot) {
        delete dot.id
        setTableData(tableData.concat(dot))
    }

    function handleTableByButton(evt) {
        evt.preventDefault()
        setTableData(tableData.concat({id: null,
            x: x,
            y: y,
            user: null,
            result: null,}))
        
    }
    return (
        <div className='App'>
            <Footer 
            name="Калабухов Максим"
            group="P32131"
            task="Вариант 44526" />
            <div>
                <CanvasGraph 
                coordinatesFromForm={[x,y]}
                handleTable={handleTable}
                inputFuncs={[handleX, handleY]}
                btnFunc={handleTableByButton}
                />
                
            </div>
            <OutputTable 
            data={tableData}
            />
            
        </div>
    )
    
}
