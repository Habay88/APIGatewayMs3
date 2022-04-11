import { BsFillAlarmFill } from "react-icons/bs";
const NavBar = ()=>{
    return(
<nav className="navbar navbar-expand navbar-dark bg-dark">
<a  href className="navbar-brand ms-1">
<img className="App-logo" />
<BsFillAlarmFill/> 
React
</a>
<div className="navbar-nav ms-auto">
<li className="nav-item">
    <a href="" className="nav-link">
     Admin
    </a>
</li>
<li className="nav-item">
    <a href="" className="nav-link">
     Home
    </a>
</li>
</div>
<div className="navbar-nav ms-auto">
<li className="nav-item">
    <a href="" className="nav-link">
        Sign Up
    </a>
</li>
<li className="nav-item">
    <a href="" className="nav-link">
        Sign In
    </a>
</li>
</div>
</nav>
    )
}
export{NavBar};