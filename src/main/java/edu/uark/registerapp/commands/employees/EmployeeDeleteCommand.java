package edu.uark.registerapp.commands.employees;

import java.util.Optional;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.uark.registerapp.commands.VoidCommandInterface;
import edu.uark.registerapp.models.entities.EmployeeEntity;
import edu.uark.registerapp.models.repositories.EmployeeRepository;
import javassist.NotFoundException;

@Service
public class EmployeeDeleteCommand implements VoidCommandInterface {
    private UUID employeeId;
    
    @Autowired
	private EmployeeRepository employeeRepository;

    @Transactional
    @Override
	public void execute() {
		Optional<EmployeeEntity> employeeEntity = this.employeeRepository.findById(this.employeeId);
        try{
		    if(!employeeEntity.isPresent())
                throw new NotFoundException("Product");
        } catch (NotFoundException e) {}

        this.employeeRepository.delete(employeeEntity.get());
	}

	// Properties
    public UUID getEmployeeID(){
        return this.employeeId;
    }

	public EmployeeDeleteCommand setInitialEmployee(final UUID productId) {
		this.employeeId = productId;
		return this;
	}
}