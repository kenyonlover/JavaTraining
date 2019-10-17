package com.test.net;

import java.io.IOException;
import java.net.*;

public class UdpSend {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();
        String str = "hello,world";
        DatagramPacket dp = new DatagramPacket(str.getBytes(),str.length(), InetAddress.getByName("127.0.0.1"),4321);
        ds.send(dp);
        ds.close();
    }
}
