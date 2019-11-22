package Main;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.CountDownLatch;

public class RMIServer {
    public static void main(String[] args) throws InterruptedException {

        newRegistry();//创建远程服务注册表

        RemoteHello remoteHello = new RemoteHelloImpl();//创建remoteHello远程服务实例
        try {
            RemoteHello stub = (RemoteHello) UnicastRemoteObject.exportObject(remoteHello, 4000); //导出服务，使用4000端口
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099); //获取Registry
            registry.bind("hello", stub); //使用名字hello，将服务注册到Registry
        } catch (AlreadyBoundException | IOException e) {
            e.printStackTrace();
        }
        CountDownLatch latch=new CountDownLatch(1);
        latch.await();  //挂起主线程，否则应用会退出
    }

    private static void newRegistry(){
        try {
            LocateRegistry.createRegistry(1099);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
