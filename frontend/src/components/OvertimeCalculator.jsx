import React, { useState } from 'react';
import axios from 'axios';

const OvertimeCalculator = () => {
  const [startDate, setStartDate] = useState('');
  const [endDate, setEndDate] = useState('');
  const [overtime, setOvertime] = useState(null);

  const handleCalculate = async () => {
    const response = await axios.get(`http://localhost:8080/api/overtime/${startDate}/${endDate}`);
    setOvertime(response.data);
  };

  return (
    <div>
      <h2>Calculate Overtime</h2>
      <input
        type="date"
        value={startDate}
        onChange={(e) => setStartDate(e.target.value)}
      />
      <input
        type="date"
        value={endDate}
        onChange={(e) => setEndDate(e.target.value)}
      />
      <button onClick={handleCalculate}>Calculate</button>

      {overtime !== null && (
        <div>
          <h3>Total Overtime: {overtime} hours</h3>
        </div>
      )}
    </div>
  );
};

export default OvertimeCalculator;
