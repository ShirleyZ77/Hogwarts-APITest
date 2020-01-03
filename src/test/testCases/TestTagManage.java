import api.TagManage;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class TestTagManage {

    static TagManage tagManage = new TagManage();

    @Test(dependsOnMethods = {"TestDeteleTag"})
    public void TestCreateTag(){
        tagManage.CreateTag("shirley77",999);
    }

    @Test
    public void TestDeteleTag(){
        tagManage.DeleteTag(999);
    }
}
