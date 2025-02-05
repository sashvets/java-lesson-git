public class Main {
    public static void main(String[] args) {

        Repository repository = new Repository();

        Branch branch = new Branch("ЖАБА-1.init");
        Commit commit = new Commit("diff", "init", "me");
        Commit commit2 = new Commit("diff2", "init2", "me");
        branch.addCommit(commit);
        branch.addCommit(commit2);
        repository.addBranch(branch);

        Branch branch2 = new Branch("ЖАБА-2.init");
        Commit commit3 = new Commit("diff3", "init3", "me2");
        Commit commit4 = new Commit("diff4", "init4", "me2");
        branch2.addCommit(commit3);
        branch2.addCommit(commit4);
        repository.addBranch(branch2);

        System.out.println(repository.toString());

        int hash = commit.getHash();
        branch.removeCommit(hash);
        System.out.println(branch.toString());
        System.out.println(repository.findCommitsByAuthor("me").toString());

        System.out.println(repository.findCommitsByAuthor("me2").toString());

        Branch branch3 = new Branch("ЖАБА-1.init");
        repository.addBranch(branch3);

        System.out.println(repository.toString());
    }
}