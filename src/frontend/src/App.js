import React, {useEffect, useState} from 'react'
import ReactDOM from 'react-dom'
import { BrowserRouter, Route, Routes } from 'react-router-dom'

import GraphContainer from './components/GraphContainer'
import LoginPage from './auth'

export default function App(props) {
    return (
        <div className='App'>
            <Routes>
                <Route path='/graph' element={<GraphContainer />}/>
                <Route path='/login' element={<LoginPage />} />
            </Routes>
        </div>
    )
    
}
