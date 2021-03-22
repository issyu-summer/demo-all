package adapter.design.all.format.player;

/**
 * @author issyu 30320182200070
 * @date 2021/1/25 13:04
 */
public class Mp4Player implements AdvanceMediaPlayer{
    @Override
    public void playVlc(String fileName) {

    }

    @Override
    public void playMP4(String fileName) {
        System.out.println("play mp4 fileName:"+fileName);
    }
}
