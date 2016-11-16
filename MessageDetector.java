public interface MessageDetector{
    void receivedMessage (ThreadSocket ts, String msg); 
    void onDisconnected(ThreadSocket ts);
}
