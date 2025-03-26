import React, { useState, useEffect } from "react";

const EmployeeList = () => {
  const [employees, setEmployees] = useState([]);

  // Fetch employees data from the backend
  useEffect(() => {
    const fetchEmployees = async () => {
      const response = await fetch("http://localhost:8081/api/employes");
      const data = await response.json();
      setEmployees(data);
    };

    fetchEmployees();
  }, []);

  return (
    <div className="container mt-3">
      <h2 className="text-center mb-3">Employee List</h2>
      {employees.length === 0 ? (
        <p>No employees available</p>
      ) : (
        <table className="table table-striped">
          <thead>
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Position</th>
            </tr>
          </thead>
          <tbody>
            {employees.map((employee) => (
              <tr key={employee.id}>
                <td>{employee.id}</td>
                <td>{employee.nom} {employee.prenom}</td>
                <td>{employee.poste}</td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
};

export default EmployeeList;
