import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Home from "./pages/Home";
import Vision from "./pages/Vision";
import Features from "./pages/Features";
import Roadmap from "./pages/Roadmap";
import Architecture from "./pages/Architecture";
import Api from "./pages/Api";
import Download from "./pages/Download";
import {Route} from "react-router-dom";
import {Routes} from "react-router-dom";
import Header from './components/Header';
import Footer from './components/Footer';

function App() {
  return (
    <div className="App">
            <Header />
            <div className="container mt-2" style={{ marginTop: 40 }}>
                <Routes>
                    <Route path='/' element={<Home />} />
                    <Route path='/vision' element={<Vision />} />
                    <Route path='/features' element={<Features />} />
                    <Route path='/roadmap' element={<Roadmap />} />
                    <Route path='/architecture' element={<Architecture />} />
                    <Route path='/api' element={<Api />} />
                    <Route path='/download' element={<Download />} />
                </Routes>
            </div>
        <Footer />
    </div>
  );
}

export default App;