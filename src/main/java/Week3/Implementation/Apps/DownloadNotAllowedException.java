package Week3.Implementation.Apps;

public class DownloadNotAllowedException extends Exception {
    public DownloadNotAllowedException(String message) {
        super(message);
    }
}