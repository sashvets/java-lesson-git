import java.util.HashSet;
import java.util.Set;

public class Repository {

    private Set<Branch> branches;

    public Repository() {
        this.branches = new HashSet<>();
    }

    public void addBranch(Branch branch) {
        for (Branch existingBranch : this.branches) {
            if (existingBranch.getName().equals(branch.getName())) {
                System.out.println("Ветка с именем " + branch.getName() + " уже существует.");
                break;
            }
        }
        this.branches.add(branch);
    }

    public Set<Branch> getBranches() {
        return this.branches;
    }

    public Set<Commit> findCommitsByAuthor(String author) {
        Set<Commit> result = new HashSet<>();
        for (Branch branch : this.branches) {
            for (Commit commit : branch.getCommits()) {
                if (commit.getAuthor().equals(author)) {
                    result.add(commit);
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {
        String stringBranches = new String();
        for (Branch branch : branches) {
            stringBranches = stringBranches + branch.toString() + "\n";
        }
        return String.format("repository [branches:\n%s]", stringBranches);
    }
}