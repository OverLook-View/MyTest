package example;

import mypackage.HelloWorld;
import mypackage.HelloWorldService;

public class HelloWorldClient {
    /**
     * ��dos���������� wsimport -s ��srcĿ¼�� -p �����������ڰ����� -keep ��wsdl������ַ��
     * ʾ����wsimport -s C:\User\admin\Desktop\src -p com.sy.test -keep http://127.0.0.1:9000/HelloWorld?wsdl
     */
    public static void main(String[] argv) {
        HelloWorld helloWorldPort = new HelloWorldService().getHelloWorldPort();
        //invoke business method
        String s = helloWorldPort.sayHelloWorldFrom("client");
        System.out.println(s);
    }
}
