import React from 'react'
import ReactDOM from 'react-dom'

export default function OutputTable(props) {
    return (
        <div>
            Последние результаты:
            <table class="container">
                <tbody>
                    {
                        props.data.map(function (item) {
                            return (
                                
                                <tr>
                                    <td>{item.x}</td>
                                    <td>{item.y}</td>
                                    <td>{item.user}</td>
                                    <td>{item.accuracy === 'Результат' ? "Результат" : item.accuracy.toString()}</td>
                                    <td>{item.date}</td>
                                </tr>
                            )
                        })
                    }
                </tbody>
            </table>
        </div>
    )
}