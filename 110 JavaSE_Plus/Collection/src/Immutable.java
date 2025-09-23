
/***
 * 不可变类在日常工作中经常用到，如JDK中的String类和所有的包装类。
 * 使用不可变类有很多好处，
 * 1. 就有多线程里很重要的线程安全。
 * 2. 缓存友好，
 * 3. 防止状态不一致
 *
 * 缺点：
 * 1. 性能问题，复制会创建新对象
 * 还有使用简单，不用担心被人有意无意改掉实例的状态等优点。
 * 那么如何实现一个不可变类呢？本文将介绍在Java中如何实现一个不可变类并用实战代码来帮助读者理解。

 */

public class Immutable {
    public static void main(String[] args) {
        String s = "hello";
        String s2 = s.replace('l', 'd');
        System.out.println(s2);

        StringBufferTest();
    }

    public static void StringBufferTest() {
        /***
         * 1. String
         * 2. StringBuffer
         * 3. StringBuilder
         */

        StringBuilder sb = new StringBuilder("hello");
        sb.replace(2, 4, "dd");
        sb.append(" world");
        System.out.println(sb);

        char c =    sb.charAt(3);
        System.out.println(c);
    }
//    public static String replace(byte[] value, char oldChar, char newChar) {
//        if (canEncode(oldChar)) {
//            int len = value.length;
//            int i = -1;
//            while (++i < len) {
//                if (value[i] == (byte)oldChar) {
//                    break;
//                }
//            }
//            if (i < len) {
//                if (canEncode(newChar)) {
//                    byte[] buf = StringConcatHelper.newArray(len);
//                    for (int j = 0; j < i; j++) {    // TBD arraycopy?
//                        buf[j] = value[j];
//                    }
//                    while (i < len) {
//                        byte c = value[i];
//                        buf[i] = (c == (byte)oldChar) ? (byte)newChar : c;
//                        i++;
//                    }
//                    return new String(buf, LATIN1);
//                } else {
//                    byte[] buf = StringUTF16.newBytesFor(len);
//                    // inflate from latin1 to UTF16
//                    inflate(value, 0, buf, 0, i);
//                    while (i < len) {
//                        char c = (char)(value[i] & 0xff);
//                        StringUTF16.putChar(buf, i, (c == oldChar) ? newChar : c);
//                        i++;
//                    }
//                    return new String(buf, UTF16);
//                }
//            }
//        }
//        return null; // for string to return this;
//    }
}
