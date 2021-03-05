package edu.uark.registerapp.commands.employees;
import edu.uark.registerapp.commands.exceptions.NotFoundException;
import edu.uark.registerapp.models.repositories.EmployeeRepository;

public class ActiveEmployeeExistsQuery{
    @Override
	public void execute() {
		if (!this.employeeRepository.existsByIsActive(true)) {
			throw new NotFoundException("Employee");
		}
	}

}