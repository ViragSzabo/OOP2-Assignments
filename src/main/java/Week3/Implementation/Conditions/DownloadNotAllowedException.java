package Week3.Implementation.Conditions;

public class DownloadNotAllowedException extends Exception {
    public DownloadNotAllowedException(String message) {
        super(message);
    }
}