package Main;

import java.rmi.RemoteException;

public class RemoteHelloImpl implements RemoteHello {
    @Override
    public String sayHello(String name) throws RemoteException {
        return "Hello"+name + " !";
    }

    @Override
    public String sayWeather(String weather) throws RemoteException {
        return "the weather is so " + weather + " !";
    }
}
