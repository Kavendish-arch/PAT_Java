import java.util.Date;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName PAT_Java
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME.testDate
 * @date 2025/11/24 21:00
 * @description @todo
 */
public class testDate {
//    @Test
    public static void testDate(){
        Date current = new Date();
        System.out.println(current.toString());

        System.out.println(current.toLocaleString());

        System.out.println(current.toGMTString());
    }

    public static void main(String[] args) {
        testDate();
    }
}
