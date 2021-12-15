import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Project name(项目名称)：网络编程基础
 * Package(包名): PACKAGE_NAME
 * Class(类名): TCPClient
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/12/15
 * Time(创建时间)： 19:24
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class TCPClient
{
    public static void main(String[] args)
    {
        Socket socket = null;
        OutputStream os = null;
        try
        {
            //1、创建Socket对象，它的第一个参数需要的是服务端的IP，第二个参数是服务端的端口
            InetAddress inet = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet, 8090);
            //2、获取一个输出流，用于写出要发送的数据
            os = socket.getOutputStream();
            //3、写出数据
            os.write("你好，我是客户端！".getBytes());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {//4、释放资源
            if (socket != null)
            {
                try
                {
                    socket.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            if (os != null)
            {
                try
                {
                    os.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
