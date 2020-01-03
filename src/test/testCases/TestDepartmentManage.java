import api.DepartmentManage;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class TestDepartmentManage {

    static DepartmentManage departmentManage = new DepartmentManage();

    @Test
    public void TestgetDeptList(){
        departmentManage.getDepartmentList(departmentManage.deptId);
    }

    @Test(dependsOnMethods = {"TestDeteleDept"})
    public void TestCreateDept(){
        departmentManage.createDept("shirley创建部门验证",2,999,10);
    }

    @Test
    public void TestDeteleDept(){
        departmentManage.deleteDept(999);
    }
}
