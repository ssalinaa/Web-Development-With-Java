import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';

import StartScreen from './StartScreen';
import LogIn from './LogIn';
import CreateAccount from './CreateAccount';
import Contributor from './Contributor';
import Donee from './Donee';
import AboutUs from './AboutUs';

const App = () => {
  return (
    <Router>
      <Routes>
        <Route path='/' element={<StartScreen />} />
        <Route path='/login' element={<LogIn />} />
        <Route path='/create-account' element={<CreateAccount />} />
        <Route path='/contributor' element={<Contributor />} />
        <Route path='/donee' element={<Donee />} />
        <Route path='/about-us' element={<AboutUs />} />
      </Routes>
    </Router>
  );
};

export default App;