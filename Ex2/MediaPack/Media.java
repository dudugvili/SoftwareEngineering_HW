package MediaPack;

abstract public class Media {
    private String name;
    private double length;

    /**
     * constructive function to media
     */
    public Media(String name, double length){
        this.name = name;
        this.length = length;
    }

    public String getName(){
        return name;
    }

    public double getLength(){
        return length;
    }

    /**
     * abstract function to media, to play video / music
     */
    public abstract void play();
}
