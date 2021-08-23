package Ali_Interview;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
//public class Ali_Interview.Hongbao {
//
//    private int totalval;
//    private int peopleNum;
//    private List<Integer> vaList;
//
//    public Ali_Interview.Hongbao(int total, int peopleNum){
//        this.totalval = total;
//        this.peopleNum = peopleNum;
//        this.vaList = new ArrayList<Integer>();
//
//        int restAmount = totalval;
//        int restpeopleNum = peopleNum;
//        Random random = new Random();
//        // 分配金额
//        for (int i = 0; i < peopleNum - 1; i++){
//            int amount = random.nextInt(restAmount/ restpeopleNum * 2 - 1) + 1;
//            // 如果超过30%，重新选值
//            while (amount >= 0.3*totalval){
//                amount = random.nextInt(restAmount/ restpeopleNum * 2 - 1) + 1;
//            }
//            restAmount -= amount;
//            restpeopleNum--;
//            vaList.add(amount);
//        }
//        vaList.add(restAmount);
//    }
//
//    public synchronized int getMoney(){
//
//        int money = 0;
//        if (peopleNum > 0){
//            money = vaList.get(peopleNum-1);
//        }
//        peopleNum--;
//        return money;
//    }
//
//    public class UserThread implements Runnable{
//        private Ali_Interview.Hongbao hongbao;
//    }
//}

public class test implements Runnable{
    private Hongbao hongbao;

    public test(Hongbao hongbao){
        this.hongbao = hongbao;
    }

    @Override
    public void run() {
        int money = hongbao.getMoney();
        System.out.println(money);
    }

    public static void main(String[] args) {
        Integer a;
        Integer b;

    }
}
