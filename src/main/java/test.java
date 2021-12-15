import java.net.InetAddress;
import java.net.InetSocketAddress;

/**
 * Project name(项目名称)：网络编程基础
 * Package(包名): PACKAGE_NAME
 * Class(类名): test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/12/15
 * Time(创建时间)： 19:05
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class test implements Runnable
{
    @Override
    public void run()
    {
        TCPServer2.main(null);
    }

    public static void main(String[] args)
    {
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 8082);
        System.out.println(inetSocketAddress);
        //返回主机名
        System.out.println(inetSocketAddress.getHostName());
        //获得InetSocketAddress的端口
        System.out.println(inetSocketAddress.getPort());
        //返回一个InetAddress对象（IP对象）
        InetAddress address = inetSocketAddress.getAddress();
        System.out.println(address);
        System.out.println();

        test t = new test();
        Thread thread = new Thread(t);
        thread.start();

        try
        {
            Thread.sleep(200);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        TCPClient2.main(null);
    }
}
