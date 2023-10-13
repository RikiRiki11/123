package ss;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class RedPacket {
    private int amount;
    private Lock lock = new ReentrantLock();

    public RedPacket(int amount) {
        this.amount = amount;
    }

    public int grabRedPacket() {
        lock.lock();
        try {
            if (amount <= 0) {
                return 0; // 红包已抢完
            }

            Random random = new Random();
            int moneyToGrab = random.nextInt(amount) + 1; // 随机分配1至amount之间的金额
            amount -= moneyToGrab;
            return moneyToGrab;
        } finally {
            lock.unlock();
        }
    }

    public int getAmount() {
        return amount;
    }
}

class RedPacketSender {
    private RedPacket redPacket;

    public RedPacketSender(int amount) {
        redPacket = new RedPacket(amount);
    }

    public RedPacket getRedPacket() {
        return redPacket;
    }
}

class RedPacketReceiver implements Runnable {
    private RedPacket redPacket;
    private String receiverName;

    public RedPacketReceiver(RedPacket redPacket, String receiverName) {
        this.redPacket = redPacket;
        this.receiverName = receiverName;
    }

    @Override
    public void run() {
        int totalGrabbedMoney = 0;
        while (true) {
            int moneyToGrab = redPacket.grabRedPacket();
            if (moneyToGrab > 0) {
                totalGrabbedMoney += moneyToGrab;
                System.out.println(receiverName + " 抢到红包金额：" + moneyToGrab + "，累计抢到金额：" + totalGrabbedMoney);
            } else {
                System.out.println(receiverName + " 红包已抢完，累计抢到金额：" + totalGrabbedMoney);
                break;
            }
        }
    }
}
