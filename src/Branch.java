import java.util.HashSet;
import java.util.Set;

public class Branch {

    private String name;

    private Set<Commit> commits;

    public Branch(String name) {
        this.name = name;
        this.commits = new HashSet<>();
    }

    public void addCommit(Commit commit) {
        this.commits.add(commit);
    }

    public Set<Commit> getCommits() {
        return this.commits;
    }

    public String getName() {
        return this.name;
    }

    public void removeCommit(int hash) {
        for (Commit commit : this.commits) {
            if (commit.hash == hash) {
                this.commits.remove(commit);
                break;
            }
        }
    }

    @Override
    public String toString() {
          String stringCommits = new String();
        for (Commit commit : getCommits()) {
            stringCommits = stringCommits + commit.toString() + "\n";
        }
       return String.format("branch [name: %s, commits:\n%s]", this.name, stringCommits);
    }
}