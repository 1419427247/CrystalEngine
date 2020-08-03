package pers.crystal.engine.components;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Arrays;

import pers.crystal.engine.application.CEComponent;
import pers.crystal.engine.utility.net.CESocket;

public class CEServer extends CEComponent {
    
    
    CESocket socket = new CESocket(4232);

    @Override
    public void Start() {
        
    }

    @Override
    public void Update() {

    }

    @Override
    public void Destroy() {

    }



}