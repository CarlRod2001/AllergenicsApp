import logo from "./allergenicsLogo.png";
import './App.css';

// npm start
    // localhost:3000
// ctrl c

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img className="App-logo" src={logo} alt="logo" />
        <p>
          Allergenics Website Development Server
        </p>
        <a
          className="App-link"
          href="https://github.com/Allergenics"
          target="_blank"
          rel="noopener noreferrer"
        >
          Track our progress!
        </a>
      </header>
    </div>
  );
}

export default App;
