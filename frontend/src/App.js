import React from 'react';
import EmployeeList from './components/EmployeeList';
import OvertimeCalculator from './components/OvertimeCalculator';
import './App.css';

const App = () => {
  return (
    <div className="App">
      <h1>Employee Overtime Application</h1>
      <EmployeeList />
      <OvertimeCalculator />
    </div>
  );
};

export default App;
