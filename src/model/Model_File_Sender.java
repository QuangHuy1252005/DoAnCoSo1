
package model;

import Event.EventFileSender;
import io.socket.client.Ack;
import io.socket.client.Socket;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.RandomAccess;


public class Model_File_Sender {

    public Model_send_message getMessage() {
        return message;
    }

    public void setMessage(Model_send_message message) {
        this.message = message;
    }

    public int getFileID() {
        return fileID;
    }

    public void setFileID(int fileID) {
        this.fileID = fileID;
    }

    public String getFileExtensions() {
        return fileExtensions;
    }

    public void setFileExtensions(String fileExtensions) {
        this.fileExtensions = fileExtensions;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public RandomAccessFile getAccFile() {
        return accFile;
    }

    public void setAccFile(RandomAccessFile accFile) {
        this.accFile = accFile;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public Model_File_Sender() {
    }

    public Model_File_Sender(File file,  Socket socket, Model_send_message message) throws IOException{
        
       accFile = new RandomAccessFile(file, "r");
       this.file  = file;
       this.socket = socket;
       this.message = message;
       fileExtensions = getExtensions(file.getName());
       fileSize = accFile.length();
    }
    
    
    private Model_send_message message;
    private int fileID;
    private String fileExtensions;
    private File file;
    private long fileSize;
    private RandomAccessFile accFile;
    private Socket socket;




    private EventFileSender event;
    
    
    public synchronized byte[] readFile() throws IOException{
        long filepointer = accFile.getFilePointer();
        if(filepointer != fileSize){
            int max = 2000;
            long length = filepointer + max >= fileSize ? fileSize - filepointer :max;
            byte[] data = new byte[(int) length];
            accFile.read(data);
            return data;
        }
            else{
                    return null;
                    }
        
    }
    
    
    public void initSend() throws IOException{
        System.out.println("Init file to server and wait server");
        socket.emit("send_to_user", message.toJSONObject(), new Ack() {
            @Override
            public void call(Object... os) {
           if(os.length > 0){
               int fileID = (int) os[0];
               try {
                   startSend(fileID);
               } catch (Exception e) {
                   e.printStackTrace();
               }
           }
            }
        });
    }
    
    public void startSend(int fileID) throws  IOException{
        this.fileID = fileID;
        if(event != null){
            event.onStartSending();
        }
        sendingFile();
    }
    
    
    private void sendingFile() throws IOException{
        Model_Package_Sender data = new Model_Package_Sender();
        data.setFileID(fileID);
        byte[] bytes = readFile();
        if(bytes != null){
            data.setData(bytes);
            data.setFinish(false);
        }
        else{
            data.setFinish(true);
            close();
        }
        socket.emit("send_file", data.toJsonObject(), new Ack() {
            @Override
            public void call(Object... os) {
         if(os.length > 0){
             boolean act = (boolean) os[0];
             if(act){
                 try {
                     if(!data.isFinish()){
                             if(event != null){
            event.onSending(getPecentage());
        }
                       sendingFile();
                     }
                     else{
                        service.Service.getInstance().fileSendFinish(Model_File_Sender.this);
                                              if(event != null){
            event.onFinish();
        }
                     }
                 } catch (Exception e) {
                     e.printStackTrace();
                 }
             }
         }
            }
        });
    }
    
    public double getPecentage() throws IOException{
        double percentage;
        long filePointer = accFile.getFilePointer();
        percentage = filePointer *100 /fileSize;
        return percentage;
    }
    
    
    public void close() throws IOException{
        accFile.close();
    }
    
    private String getExtensions(String fileName){
        return fileName.substring(fileName.lastIndexOf("."), fileName.length());
    }
    
    
        public void addEvent(EventFileSender event) {
        this.event = event;
    }
}
