package com.cenfotec.grupo4.suite;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.cenfotec.grupo4.encrypt.EncryptManagerAsymetricTest;
import com.cenfotec.grupo4.encrypt.EncryptManagerSymetricTest;
import com.cenfotec.grupo4.encrypt.EncryptorTest;
import com.cenfotec.grupo4.entities.DepartmentTest;
import com.cenfotec.grupo4.entities.EmployeeTest;
import com.cenfotec.grupo4.entities.ProcedureTest;
import com.cenfotec.grupo4.entities.TaskTest;
import com.cenfotec.grupo4.gestor.GestorTest;
import com.cenfotec.grupo4.interfaces.use.StatusActiveTest;
import com.cenfotec.grupo4.interfaces.use.StatusFinalizedTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    TaskTest.class,
    DepartmentTest.class,
    EmployeeTest.class,
    ProcedureTest.class,
    StatusActiveTest.class,
    StatusFinalizedTest.class,
    EncryptManagerAsymetricTest.class,
    EncryptManagerSymetricTest.class,
    EncryptorTest.class,
    GestorTest.class,
})

public class SuiteTests {

}
 
