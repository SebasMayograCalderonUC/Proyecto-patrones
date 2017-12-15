package com.cenfotec.grupo4.suite;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.cenfotec.grupo4.entities.DepartmentTest;
import com.cenfotec.grupo4.entities.EmployeeTest;
import com.cenfotec.grupo4.entities.ProcedureTest;
import com.cenfotec.grupo4.entities.TaskTest;
import com.cenfotec.grupo4.interfaces.use.StatusActiveTest;
import com.cenfotec.grupo4.interfaces.use.StatusFinalizedTest;
import com.cenfotec.grupo4.utils.JsonManagerTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    TaskTest.class,
    DepartmentTest.class,
    EmployeeTest.class,
    ProcedureTest.class,
    StatusActiveTest.class,
    StatusFinalizedTest.class,
    JsonManagerTest.class,
})

public class SuiteTests {

}
 
