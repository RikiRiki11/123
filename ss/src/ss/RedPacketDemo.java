package ss;

public class RedPacketDemo {
	
    public static void main(String[] args) {
    	
        RedPacketSender sender = new RedPacketSender(100); // 发100元红包
        sender.getRedPacket();
        RedPacket redPacket = sender.getRedPacket(); // 获取redPacket对象
        Thread receiver1 = new Thread(new RedPacketReceiver(sender.getRedPacket(), "Jack"));
        Thread receiver2 = new Thread(new RedPacketReceiver(sender.getRedPacket(), "Rose"));
        Thread receiver3 = new Thread(new RedPacketReceiver(sender.getRedPacket(), "Rikio"));
        receiver1.start();
        receiver2.start();
        receiver3.start();
    }
}