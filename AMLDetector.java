import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AMLDetector {

    private HashMap<String, String> blackList = new HashMap<>();
    private HashMap<String, Integer> incomingCount = new HashMap<>();
    private HashMap<String, String> lastSenderMap = new HashMap<>();

    public static void main(String[] args) {
        AMLDetector detector = new AMLDetector();
        detector.addToBlackList("666-666", "Fraudulent account");

        List<Transaction> txList = new ArrayList<>();

        // 1. 샘플 거래 데이터 추가 (이게 있어야 출력이 나옵니다!)
        txList.add(new Transaction("111-111", "222-222")); // 정상
        txList.add(new Transaction("666-666", "222-222")); // 블랙리스트 발신자
        txList.add(new Transaction("333-333", "777-777")); // 집금 1회
        txList.add(new Transaction("444-444", "777-777")); // 집금 2회
        txList.add(new Transaction("555-555", "777-777")); // 집금 3회 -> 경고!
        txList.add(new Transaction("222-222", "111-111")); // 111->222 직후 222->111 순환 거래 -> 경고!

        for (Transaction tx : txList) {
            detector.analyze(tx);
        }
    }

    public void addToBlackList(String account, String reason) {
        blackList.put(account, reason);
    }

    public void analyze(Transaction tx) {
        String sender = tx.getSender();
        String receiver = tx.getReceiver();
        System.out.println("\n[검사 중] " + sender + " -> " + receiver);

        // 규칙 1: 블랙리스트 확인
        if (blackList.containsKey(sender)) {
            System.out.println("  🚨 Alert: Sender " + sender + " is on the blacklist.");
        }
        if (blackList.containsKey(receiver)) {
            System.out.println("  🚨 Alert: Receiver " + receiver + " is on the blacklist.");
        }

        // 규칙 2: 집금 계좌 탐지 (receiver 기준으로 횟수 누적)
        int count = incomingCount.getOrDefault(receiver, 0) + 1;
        incomingCount.put(receiver, count);
        if (count >= 3) {
            System.out.println("  🚨 Alert: Smurfing detected! Receiver " + receiver + " received " + count + " transfers.");
        }

        // 규칙 3: 순환 거래 (A -> B -> A) 확인 (put 하기 전에 먼저 검사!)
        if (receiver.equals(lastSenderMap.get(sender))) {
            System.out.println("  🚨 Alert: Circular transaction detected between " + sender + " and " + receiver + "!");
        }
        lastSenderMap.put(receiver, sender);
    }
}

// AMLDetector 클래스 중괄호 바깥으로 분리!
class Transaction {
    private String sender;
    private String receiver;

    public Transaction(String sender, String receiver) {
        this.sender = sender;
        this.receiver = receiver;
    }

    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }
}