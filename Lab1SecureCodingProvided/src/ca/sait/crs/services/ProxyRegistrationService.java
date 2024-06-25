
// TODO: Define the ProxyRegistrationService
// TODO: Implement the RegistrationService interface
// TODO: Check student can be registered before passing to RealRegistrationService
// TODO: Make this class immutable.

package ca.sait.crs.services;

import ca.sait.crs.contracts.*;
import ca.sait.crs.exceptions.*;

import java.util.ArrayList;

public class ProxyRegistrationService implements RegistrationService {
    private final RealRegistrationService realRegistrationService;

    public ProxyRegistrationService(RealRegistrationService realRegistrationService) {
        this.realRegistrationService = realRegistrationService;
    }

    @Override
    public Registration register(Student student, Course course) throws CannotCreateRegistrationException {
        if (student == null) {
            throw new CannotCreateRegistrationException("Student cannot be null.");
        }
    
        if (student.getGpa() <= 2.0) {
            throw new CannotCreateRegistrationException("Student GPA does not meet the minimum requirement for course registration.");
        }
    
        return this.realRegistrationService.register(student, course);
    }

    @Override
    public ArrayList<Registration> getRegistrations() {
        return this.realRegistrationService.getRegistrations();
    }
}