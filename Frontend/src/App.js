import './App.css';
import {BrowserRouter, Routes, Route} from 'react-router-dom';


import Register from './component/Register Component/Register';
import Table from './component/Admin Component/Table';
import Userdashboard from './component/User Component/Userdashboard';
import AddFlight from './component/Admin Component/AddFlight';
import Book from './component/User Component/Book';
import PaymentOpen from './component/Payment Component/PaymentOpen';
import Home from './component/Home Component/Home';
import Login from './component/Login Component/Login';
import Admindashboard from './component/Admin Component/Admindashboard';
import AddVacancy from './component/Admin Component/AddVacancy';
import UpdateFlight from './component/Admin Component/UpdateFlight';

function App() {
  return (
    <BrowserRouter>
    <div className="App">
    <Routes>
    <Route path='/' element={<Home />} />
    <Route path='/home' element={<Home />} />
    <Route path='/login' element={<Login />} />
    <Route path='/signup' element={<Register />} />
    <Route path='/flightcrud' element={<Table />} />
    <Route path='/userdashboard' element={<Userdashboard />} />
    <Route path='/addflight' element={<AddFlight />} />
    <Route path='/updateflight' element={<UpdateFlight />} />
    <Route path='/admindashboard' element={<Admindashboard />} />
    <Route path='/addvacancy' element={<AddVacancy />} />
    <Route path='/book' element={<Book />} />
    <Route path='/payment' element={<PaymentOpen />} />
    </Routes>
    </div>
    </BrowserRouter>
    
     
    
  );
}

export default App;
