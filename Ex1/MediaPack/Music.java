package MediaPack;

class Music extends Media {
    /**
     * constructive function to Music
     */
    public Music(String name, double length) {
        super(name, length);
    }

    /**
     * function to play Music, in media play function is Abstract
     */
    public void play() {
        System.out.println(getName() + " is now playing for " + getLength() + " minutes.");
    }
}
