package edu.uark.registerapp.commands.employees;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uark.registerapp.commands.ResultCommandInterface;
import edu.uark.registerapp.models.api.Employee;
import edu.uark.registerapp.models.entities.EmployeeEntity;
import edu.uark.registerapp.models.repositories.EmployeeRepository;
import edu.uark.registerapp.commands.exceptions.NotFoundException;

@Service
public class EmployeeQuery implements ResultCommandInterface<Employee> {
    private UUID employeeId;
    
    @Autowired
	private EmployeeRepository employeeRepository;

    @Override
	public Employee execute() {
		Optional<EmployeeEntity> employeeEntity = this.employeeRepository.findById(this.employeeId);
        if (employeeEntity.isPresent()){
            return new Employee(employeeEntity.get());
        }else{
                throw new NotFoundException("Employee");
        }
	}

	// Properties
    public UUID getEmployeeID(){
        return this.employeeId;
    }

	public EmployeeQuery setEmployeeId(final UUID employeeId) {
		this.employeeId = employeeId;
		return this;
	}
}