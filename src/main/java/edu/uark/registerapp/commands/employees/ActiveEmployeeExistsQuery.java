package edu.uark.registerapp.commands.employees;
import edu.uark.registerapp.commands.exceptions.NotFoundException;
import edu.uark.registerapp.models.repositories.EmployeeRepository;
import edu.uark.registerapp.commands.VoidCommandInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActiveEmployeeExistsQuery implements VoidCommandInterface{
    @Override
	public void execute() {
		if (!this.EmployeeRepo.existsByIsActive(true)) {
			throw new NotFoundException("Employee");
		}
	}
	@Autowired
	private EmployeeRepository EmployeeRepo;

}