import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RepositoryTest {

    @Test
    public void test_addBranch() {
        Repository repo = new Repository();
        Branch branch = new Branch("master");
        repo.addBranch(branch);

        Assertions.assertTrue(repo.getBranches().contains(branch));
    }

    @Test
    public void test_addCommit() {
        Branch branch = new Branch("master");
        Commit commit = new Commit("diff", "Init", "Lera");
        branch.addCommit(commit);

        Assertions.assertTrue(branch.getCommits().contains(commit));
    }

    @Test
    public void test_delCommit() {
        Branch branch = new Branch("master");
        Commit commit = new Commit("diff", "Init", "Lera");
        Commit commit2 = new Commit("diff2", "Init2", "Lera2");
        branch.addCommit(commit);
        branch.addCommit(commit2);
        int hash = commit.getHash();
        branch.removeCommit(hash);

        Assertions.assertTrue(branch.getCommits().contains(commit2));
        Assertions.assertFalse(branch.getCommits().contains(commit));
    }
}