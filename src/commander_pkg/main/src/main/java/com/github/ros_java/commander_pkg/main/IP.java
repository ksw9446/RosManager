package com.github.ros_java.commander_pkg.main;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * Created by ailab on 17. 10. 13.
 */

public class IP {
    public final static int INET4ADDRESS = 1;
    public final static int INET6ADDRESS = 2;

    public static String getLocalIpAddress(int type) {
        try {
            for (Enumeration en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements(); ) {
                NetworkInterface intf = (NetworkInterface) en.nextElement();
                for (Enumeration enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                    InetAddress inetAddress = (InetAddress) enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        switch (type) {
                            case INET6ADDRESS:
                                if (inetAddress instanceof Inet6Address) {
                                    return inetAddress.getHostAddress().toString();
                                }
                                break;
                            case INET4ADDRESS:
                                if (inetAddress instanceof Inet4Address) {
                                    return inetAddress.getHostAddress().toString();
                                }
                                break;
                        }

                    }
                }
            }
        } catch (SocketException ex) {
        }
        return null;
    }


}
