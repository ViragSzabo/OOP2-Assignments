package ExamPreparation.Implementation.ComicStoreSystem.Shop;

import ExamPreparation.Implementation.ComicStoreSystem.Comics.ComicSeries;
import ExamPreparation.Implementation.ComicStoreSystem.Enums.Status;
import ExamPreparation.Implementation.ComicStoreSystem.People.Author;

public class PublishingControlRoom {
    private Publisher publisher;

    public PublishingControlRoom(Publisher publisher) {
        this.publisher = publisher;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public boolean isPublishingStable(Author author) {
        for(ComicSeries series : author.getComics()) {
            if(series.checkStatus() == Status.STABLE) {
                return true;
            }
        }
        return false;
    }
}