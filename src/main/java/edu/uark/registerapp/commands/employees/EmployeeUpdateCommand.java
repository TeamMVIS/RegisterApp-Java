package edu.uark.registerapp.commands.employees;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.apache.commons.lang3.StringUtils;
import edu.uark.registerapp.commands.ResultCommandInterface;
import edu.uark.registerapp.commands.exceptions.UnprocessableEntityException;
import edu.uark.registerapp.models.api.Employee;
import edu.uark.registerapp.models.entities.EmployeeEntity;
import edu.uark.registerapp.models.enums.EmployeeClassification;
import edu.uark.registerapp.models.repositories.EmployeeRepository;
import edu.uark.registerapp.commands.exceptions.NotFoundException;

@Service
public class EmployeeUpdateCommand implements ResultCommandInterface<Employee> {
    private UUID employeeId;
    private Employee apiEmployee;

    @Autowired
	private EmployeeRepository employeeRepository;

    @Override
	public Employee execute() {
		this.validateProperties();
        this.updateEmployeeEntity();
        return this.apiEmployee;
	}

    private void validateProperties(){
        if (StringUtils.isBlank(this.apiEmployee.getFirstName())) {
            throw new UnprocessableEntityException("First Name");
        }
        if(StringUtils.isBlank(this.apiEmployee.getLastName())){
            throw new UnprocessableEntityException("Last Name");
        }
        if(EmployeeClassification.map(this.apiEmployee.getClassification()) == EmployeeClassification.NOT_DEFINED){
            throw new UnprocessableEntityException("Classification");
        }
    }

    @Transactional
	private void updateEmployeeEntity() {
		Optional<EmployeeEntity> queriedEmployeeEntity = this.employeeRepository.findById(this.employeeId);

		if (!queriedEmployeeEntity.isPresent()){
			throw new NotFoundException("Employee");
		}

		this.apiEmployee = queriedEmployeeEntity.get().synchronize(this.apiEmployee);
        this.employeeRepository.save(queriedEmployeeEntity.get());
	}

	// Properties
    public UUID getEmployeeID(){
        return this.employeeId;
    }

	public EmployeeUpdateCommand setEmployeeId(final UUID employeeId) {
		this.employeeId = employeeId;
		return this;
	}
    public Employee getApiEmployee() {
		return this.apiEmployee;
	}
    public EmployeeUpdateCommand setApiEmployee(final Employee apiEmployee) {
		this.apiEmployee = apiEmployee;
		return this;
	}
}