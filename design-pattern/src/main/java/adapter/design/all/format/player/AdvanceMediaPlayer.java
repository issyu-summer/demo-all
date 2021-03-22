package adapter.design.all.format.player;

/**
 * @author issyu 30320182200070
 * @date 2021/1/25 13:00
 */
public interface AdvanceMediaPlayer {
    /**
     * 播放vlc
     * @param fileName
     */
    void playVlc(String fileName);

    /**
     * 播放MP4
     * @param fileName
     */
    void playMP4(String fileName);
}
