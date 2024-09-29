package Week3.Implementation;

public class DownloadNotAllowedException extends Exception {
    public DownloadNotAllowedException(String message) {
        super(message);
    }
}