import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Project name(项目名称)：网络编程基础
 * Package(包名): PACKAGE_NAME
 * Class(类名): TCPServer2
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/12/15
 * Time(创建时间)： 19:34
 * Version(版本): 1.0
 * Description(描述)： 服务端向客户端回写数据
 */

public class TCPServer2
{
    public static void main(String[] args)
    {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        OutputStream os = null;
        try
        {
            //1、创建服务端的ServerSocket，指明自己的端口号
            serverSocket = new ServerSocket(8888);
            //2、调用accept接收到来自于客户端的socket
            socket = serverSocket.accept();//阻塞式监听，会一直等待客户端接入
            //3、获取socket的输入流
            is = socket.getInputStream();


            //4、读取输入流中的数据
            //ByteArrayOutputStream的好处是它可以根据数据的大小自动扩充
            baos = new ByteArrayOutputStream();
            int len = 0;
            byte[] buffer = new byte[1024];
            while ((len = is.read(buffer)) != -1)
            {
                baos.write(buffer, 0, len);
            }
            System.out.println("收到了来自于客户端" + socket.getInetAddress().getHostName()
                    + "的消息：" + baos.toString());
            //===========================回复==========================================
            //5、获取一个输出流，写出回复给客户端
            os = socket.getOutputStream();
            //6、写出数据
            os.write("你好，我是服务端".getBytes());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {//7、关闭资源
            if (serverSocket != null)
            {
                try
                {
                    serverSocket.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
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
            if (is != null)
            {
                try
                {
                    is.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            if (baos != null)
            {
                try
                {
                    baos.close();
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
