import com.lemuria.gonoobgo.dubbo.TestService;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestServiceImpl implements TestService {
    @Override
    public String tsTest1(String st) {
        return st+"来自demo小工程";
    }

    @Override
    public Map<String, Object> tsTest2(String s, Object o) {
        HashMap<String, Object> map = new HashMap<>();
        map.put(s, o);
        map.put("哈哈哈", "来自小工程");
        return map;
    }

    @Override
    public List<String> tsTest3(String s) {

        return Collections.singletonList(s+"小工程");
    }
}
