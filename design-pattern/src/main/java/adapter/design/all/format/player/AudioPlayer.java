package adapter.design.all.format.player;

/**
 * @author issyu 30320182200070
 * @date 2021/1/25 13:11
 */
public class AudioPlayer implements MediaPlayer{


    private MediaAdapter mediaAdapter;

    /**
     * 事实上相当于解除了耦合
     * 目标类与适配者解耦
     * @param audioType
     * @param fileName
     */
//    private Mp4Player mp4Player;
//
//    private VlcPlayer vlcPlayer;


    @Override
    public void play(String audioType, String fileName) {
        if("mp3".equalsIgnoreCase(audioType)){
            System.out.println("Playing mp3 file. Name: "+ fileName);
        }else if("mp4".equalsIgnoreCase(audioType)
        ||"vlc".equalsIgnoreCase(audioType)){

//            mp4Player =new Mp4Player();

//            mp4Player.playMP4(fileName);

            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType,fileName);
        }else {
            System.out.println("Invalid media ..."+audioType+
                    " format not supported");
        }
    }
}
