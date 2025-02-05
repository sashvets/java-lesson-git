import java.time.LocalDateTime;

public class Commit {

    private String diff;

    private String message;

    private String author;

    private LocalDateTime time;

    int hash;

    public Commit(String diff, String message, String author) {
        this.diff = diff;
        this.message = message;
        this.author = author;
        this.time = LocalDateTime.now();
        this.hash = (diff + message + author).hashCode();
    }

    public int getHash() {
        return this.hash;
    }

    public String getAuthor() {
        return this.author;
    }

    @Override
    public String toString() {
        return String.format("commit [diff: %s, message: %s, author: %s, time: %s, hash: %d]",
                this.diff, this.message, this.author, this.time, this.hash);
    }

}