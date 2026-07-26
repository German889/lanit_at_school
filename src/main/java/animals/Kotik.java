package animals;

public class Kotik {

    public Kotik(){
        count++;
    }
    public Kotik(String name, String voice, int satiety, int weight){
        count++;
        this.name = name;
        this.voice = voice;
        this.satiety = satiety;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    public int getSatiety() {
        return satiety;
    }

    public void setSatiety(int satiety) {
        this.satiety = satiety;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    private String name;
    private String voice;
    private int satiety = 0;
    private int weight;
    private static int count = 0;
    private static final int METHODS = 5;

    public static int getCount(){
        return count;
    }

    public String[] liveAnotherDay(){
        String[] dailyActions = new String[24];
        for( int i=0; i<24; i++){
            String actionName = "";
            int actionNumber = (int) (Math.random() * METHODS) + 1;
            boolean isActionPerformed = false;
            switch (actionNumber){
                case 1:
                    isActionPerformed = play();
                    actionName = "играл";
                    break;
                case 2:
                    isActionPerformed = sleep();
                    actionName = "спал";
                    break;
                case 3:
                    isActionPerformed = wash();
                    actionName = "мылся";
                    break;
                case 4:
                    isActionPerformed = walk();
                    actionName = "гулял";
                    break;
                case 5:
                    isActionPerformed = hunt();
                    actionName = "охотился";
                    break;
            }
            if(isActionPerformed){
                dailyActions[i] = i+" - "+actionName;
            } else {
                eat();
                dailyActions[i] = i+" - ел";
            }
        }
        return dailyActions;
    }

    public boolean play(){
        if(satiety > 0){
            satiety--;
            System.out.println("Котик играет");
            return true;
        }
        foodRequest();
        return false;
    }
    public boolean sleep(){
        if(satiety > 0){
            satiety--;
            System.out.println("Котик спит");
            return true;
        }
        foodRequest();
        return false;
    }
    public boolean wash(){
        if(satiety > 0){
            satiety--;
            System.out.println("Котик моется");
            return true;
        }
        foodRequest();
        return false;
    }

    public boolean walk(){
        if(satiety > 0){
            satiety--;
            System.out.println("Котик гуляет");
            return true;
        }
        foodRequest();
        return false;
    }
    public boolean hunt(){
        if(satiety > 0){
            satiety--;
            System.out.println("Котик охотится");
            return true;
        }
        foodRequest();
        return false;
    }
    public void foodRequest(){
        System.out.println("Котик проголодался");
    }
    public void eat(int satiety){
        this.satiety += satiety;
    }
    public void eat(int satiety, String foodName){
        this.satiety += satiety;
        System.out.println("Котик съел "+foodName);
    }
    public void eat(){
        eat(10, "Вискас");
    }
}
