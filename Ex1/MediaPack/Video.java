package MediaPack;

class Video extends Media {
    /**
     * constructive function to Video
     */
    public Video(String name, double length) {
        super(name, length);
    }

    /**
     * function to show Video, in media play function is abstract
     */
    public void play() {
        System.out.println(getName() + " is now shown for " + getLength() + " seconds.");
    }
}
