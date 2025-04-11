package setDemo.demo4;

import java.util.*;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName PAT
 * @package setDemo.demo4
 * @className setDemo.demo4.Room
 * @date 2024/11/16 20:01
 * @description 棋牌室
 */
public class Room {
    // 1. 创建牌集合
    private List<Card> cardList = new ArrayList<>();
    private int MAX_SIZE = 54;
    // 2. 实例代码块
    {
        // 1. 增加牌
        String[] cards = { "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        String[] colors = {"红桃", "黑桃", "梅花", "方片"};
        int num = 0;
        for (String color : colors) {
            for (String card_num : cards) {
                // 创建牌，加入集合
                cardList.add(new Card(card_num, color, num));
            }
            num++;
        }

        Collections.addAll(cardList,
                new Card("小王", "", ++num),
                new Card("大王", "", ++num));

        System.out.println(cardList);
    }

    public void start() {
        // 1. 洗牌
//        System.out.println("洗牌前");
//        System.out.println(cardList);
        Collections.shuffle(cardList);
//        System.out.println(cardList);

        // 2. 加入玩家
        Map<String, List<Card>> players = new HashMap<>();
        List<Card> lhb = new ArrayList<>();
        players.put("玩家1", lhb);
        List<Card> lhj = new ArrayList<>();
        players.put("玩家2", lhj);
        List<Card> lhk = new ArrayList<>();
        players.put("玩家3", lhk);

        for(int i = 0; i < cardList.size()-3; i++){
            if(i % 3 == 0){
                // 玩家1
                lhb.add(cardList.get(i));
            }else if(i % 3 == 1){
                // 玩家2
                lhj.add(cardList.get(i));
            }else{
                // 玩家3
                lhk.add(cardList.get(i));
            }
        }
        // 10. 对玩家的牌排序
        // 处理数据不影响源
//        lhb.stream().sorted().forEach(System.out::println);

        sortCards(lhb);
        sortCards(lhj);
        sortCards(lhk);
//        Collections.sort(lhb);
//        Collections.sort(lhj);
//        Collections.sort(lhk);

        // 11. 最后三张底牌
        List<Card> lastCards = cardList.subList(cardList.size()-3, cardList.size());
        lhj.addAll(lastCards);
        // 12. 看牌 遍历集合的key和value
        for(Map.Entry<String, List<Card> > entry : players.entrySet()){
            String name = entry.getKey();
            List<Card> cards = entry.getValue();
//            Collections.sort(cards);
//            System.out.println("nums = " + cards.size());
            System.out.println(name + ":" + cards);
        }

        System.out.println("底牌:" + lastCards);
    }

    public static void main(String[] args) {
        new Room().start();
    }

    public void sortCards(List<Card> cards){
//        Collections.sort(cards, new Comparator<Card>() {
//            @Override
//            public int compare(Card o1, Card o2) {
//
//                return o2.getNumber() - o1.getNumber();
//            }
//        });
        Collections.sort(cards, (o1, o2) -> o2.getNumber() - o1.getNumber());
    }
}
