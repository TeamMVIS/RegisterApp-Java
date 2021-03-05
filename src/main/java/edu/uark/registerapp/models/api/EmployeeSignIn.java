package edu.uark.registerapp.models.api;
import org.apache.commons.lang3.StringUtils;

public class EmployeeSignIn {
    private String employeeId;
    private String password;

    public EmployeeSignIn setEmployeeId(String empId)
    {
        this.employeeId = empId;
        return this;
    }

    public EmployeeSignIn setPassword(String pw)
    {
        this.password = pw;
        return this;
    }

    public String getEmployeeId()
    {
        return this.employeeId;
    }

    public String getPassword()
    {
        return this.password;
    }

    public EmployeeSignIn()
    {
        this.employeeId = StringUtils.EMPTY;
        this.password = StringUtils.EMPTY;
    }
}
