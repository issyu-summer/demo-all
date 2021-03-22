package adapter.design.all.format.player;

/**
 * @author issyu 30320182200070
 * @date 2021/1/25 13:01
 */
public class VlcPlayer implements AdvanceMediaPlayer{
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing Vlc fileName:"+fileName);
    }

    @Override
    public void playMP4(String fileName) {

    }
}
