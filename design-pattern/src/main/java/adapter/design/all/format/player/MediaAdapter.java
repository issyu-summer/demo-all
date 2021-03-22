package adapter.design.all.format.player;

/**
 * @author issyu 30320182200070
 * @date 2021/1/25 13:05
 */
public class MediaAdapter implements MediaPlayer{

    private AdvanceMediaPlayer advanceMediaPlayer;

    private static final String MP4="mp4";
    private static final String VLC="vlc";

    public MediaAdapter(String audioType){
        if(VLC.equalsIgnoreCase(audioType)){
            advanceMediaPlayer=new VlcPlayer();
        }else if(MP4.equalsIgnoreCase(audioType)){
            advanceMediaPlayer=new Mp4Player();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if(VLC.equalsIgnoreCase(audioType)){
            advanceMediaPlayer.playVlc(fileName);
        }else if(MP4.equalsIgnoreCase(audioType)){
            advanceMediaPlayer.playMP4(fileName);
        }
    }
}
