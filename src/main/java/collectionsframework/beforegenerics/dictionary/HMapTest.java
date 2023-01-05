package collectionsframework.beforegenerics.dictionary;

import java.util.LinkedHashMap;

public class HMapTest {
    public static void main(String[] args) {
        var hMap = new HMap<String, String>();
        System.out.println(hMap.put("java", "1996-01-23"));
        System.out.println(hMap.put("java", "1996-01-08"));
        System.out.println(hMap.put("python", "1989-12-21"));
        System.out.println(hMap.get("java"));
    }
}
