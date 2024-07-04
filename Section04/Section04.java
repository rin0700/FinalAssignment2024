import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Section04 {
    public static void main(String[] args) {
        // ログフォルダのパス
        String logDirPath = "log";
        // ログファイルのパス
        String logFilePath = logDirPath + File.separator + "execution.log";

        // ログフォルダが存在しない場合は作成
        File logDir = new File(logDirPath);
        if (!logDir.exists()) {
            logDir.mkdirs();
        }

        // 現在時刻を取得
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedNow = now.format(formatter);

        // ログファイルに書き込む
        try (FileWriter writer = new FileWriter(logFilePath, true)) {
            writer.write("Program executed at " + formattedNow + "\n");
            System.out.println("ログファイルが生成されました。");
        } catch (IOException e) {
            System.err.println("ログファイルの書き込み中にエラーが発生しました: " + e.getMessage());
        }
    }
}
