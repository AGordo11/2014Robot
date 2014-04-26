package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Timer;
import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;
import javax.microedition.io.Connector;
import javax.microedition.io.ServerSocketConnection;
import javax.microedition.io.SocketConnection;

public class CheesyVisionServer implements Runnable{
    Thread serverThread = new Thread(this);
  
    public static CheesyVisionServer instance;
    public Vector connections;
    public int leftCount = 0, rightCount = 0, totalCount = 0;
    public int listenPort;
    public double lastHeartbeatTime = -1;
    public boolean counting = false;
    public boolean curLeftStatus = false, curRightStatus = false;
    public boolean listening = true;

    public static CheesyVisionServer GetInstance(){
        if(instance == null){
            instance = new CheesyVisionServer();
        }
        return instance;
    }
  
    public void Start(){
        serverThread.start();
    }
  
    public void Stop(){
        listening = false;
    }
    
    private CheesyVisionServer(){
        this(1180);
    }

    private CheesyVisionServer(int port){
        listenPort = port;
        connections = new Vector();
    }
  
    public boolean hasClientConnection(){
        return lastHeartbeatTime > 0 && (Timer.getFPGATimestamp() - lastHeartbeatTime) < 3.0; 
    }
  
    public void SetPort(int port){
        listenPort = port;
    }

    private void UpdateCounts(boolean left, boolean right){
        if(counting){
            leftCount += left ? 1 : 0;
            rightCount += right ? 1 : 0;
            totalCount++;
        }
    }

    public void StartSamplingCounts(){
        counting = true;
    }

    public void StopSamplingCounts(){
        counting = false;
    }

    public void Reset(){
        leftCount = rightCount = totalCount = 0;
        curLeftStatus = curRightStatus = false;
    }
  
    public int getLeftCount(){
        return leftCount;
    }
  
    public int getRightCount(){
        return rightCount;
    }
  
    public int getTotalCount(){
        return totalCount;
    }
  
    public boolean getLeftStatus(){
        return curLeftStatus;
    }
  
    public boolean getRightStatus(){
        return curRightStatus;
    }
  
    private class VisionServerConnectionHandler implements Runnable{
        SocketConnection connection;
    
        public VisionServerConnectionHandler(SocketConnection c){
            connection = c;
        }

        public void run(){
            try{
                InputStream is = connection.openInputStream();

                int ch = 0;
                byte[] b = new byte[1024];
                double timeout = 10.0;
                double lastHeartbeat = Timer.getFPGATimestamp();
                CheesyVisionServer.this.lastHeartbeatTime = lastHeartbeat;
                while (Timer.getFPGATimestamp() < lastHeartbeat + timeout){
                    boolean gotData = false;
                    while (is.available() > 0){
                        gotData = true;
                        int read = is.read(b);
                        for (int i = 0; i < read; i++){
                            byte reading = b[i];
                            boolean leftStatus = (reading & (1 << 1)) > 0;
                            boolean rightStatus = (reading & (1 << 0)) > 0;
                            CheesyVisionServer.this.curLeftStatus = leftStatus;
                            CheesyVisionServer.this.curRightStatus = rightStatus;
                            CheesyVisionServer.this.UpdateCounts(leftStatus, rightStatus);
                        }
                        lastHeartbeat = Timer.getFPGATimestamp();
                        CheesyVisionServer.this.lastHeartbeatTime = lastHeartbeat;
                    }
                    try{
                        Thread.sleep(50);
                    }catch(InterruptedException ex){
                        System.out.println("Thread sleep failed.");
                    }
                }
                is.close();
                connection.close();
            }catch(IOException e){}
        }
    }

    public void run(){
        ServerSocketConnection s = null;
        try{
            s = (ServerSocketConnection) Connector.open("serversocket://:" + listenPort);
            while(listening){
                SocketConnection connection = (SocketConnection) s.acceptAndOpen();
                Thread t = new Thread(new CheesyVisionServer.VisionServerConnectionHandler(connection));
                t.start();
                connections.addElement(connection);
                try{
                    Thread.sleep(100);
                }catch (InterruptedException ex){
                    System.out.println("Thread sleep failed.");
                }
            }
        }catch(IOException e){
            System.out.println("Socket failure.");
            e.printStackTrace();
        }
    }
}
