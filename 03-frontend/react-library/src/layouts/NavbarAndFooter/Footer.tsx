import { Link } from "react-router-dom";

export const Footer = () =>{
    return(
        <div className="main-color">
            <footer className="container d-flex flex-wrap justify-content-between align-items-center py-5 main-color">
                <p className="col-md-4 mb-0 text-white">© Example Library app, Inc</p>
                <ul className="nav navbar-dark col-md-4 justify-content-end">
                    <Link className="nav-item" to="/home">
                        <a className="nav-link px-2 text-white" >Home</a>
                    </Link>
                    <Link className="nav-item" to="/search">
                        <a  className="nav-link px-2 text-white">Search Books</a>
                    </Link>
                    
                </ul>
            </footer>
        </div>
    );
}