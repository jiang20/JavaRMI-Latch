package Main;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteHello extends Remote {//创建remoteHello接口继承Remote接口，提供hello远程服务
    String sayHello(String name) throws RemoteException;
    String sayWeather(String weather) throws RemoteException;
}
