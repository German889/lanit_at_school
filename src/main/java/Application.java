import animals.Kotik;

import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        Kotik black = new Kotik("black","meoooow",2,3);

        Kotik white = new Kotik("white");
        white.setSatiety(3);
        white.setVoice("meeeeauuw");
        white.setWeight(2);
        String[] actions = white.liveAnotherDay();
        for(String act : actions){
            System.out.println(act);
        }
        System.out.println(white.getName());
        System.out.println(white.getWeight());

        System.out.println("Котики звучат одинаково и это "
                +compareVoice(black,white));
        System.out.println(Kotik.getCount());
    }
    public static boolean compareVoice(Kotik kotik1, Kotik kotik2){
        return (kotik1 != null && kotik2 != null)
                && Objects.equals(kotik1.getVoice(), kotik2.getVoice());
    }
}
