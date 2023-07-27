
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

// we represent the tree for Twenty Question game
public class Tree {

    public TreeNode root; // root of our tree

    public Tree() {
        root = new TreeNode();
    }

    // we load data from our file in a Tree instance
    public void loadTree(String filename) {
        File file = new File(filename);
        FileReader fileReader = null;
        BufferedReader buf = null;

        try {
            fileReader = new FileReader(file);
            buf = new BufferedReader(fileReader);
            buildTree(root, buf);
        } catch (Exception e) {
            System.out.println("Error during tree building : " + e.getMessage());
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }

                if (buf != null) {
                    buf.close();
                }
            } catch (Exception e) {
            }
        }
    }

    // we build the three from a buffered reader with a breadth first search strategy
    private void buildTree(TreeNode currentNode, BufferedReader buf) throws Exception {
        String line = buf.readLine();

        if (line != null) {
            currentNode.setData(line);

            if (currentNode.isQuestion()) {
                TreeNode yesNode = new TreeNode();
                TreeNode noNode = new TreeNode();
                currentNode.yes = yesNode;
                currentNode.no = noNode;
                buildTree(yesNode, buf);
                buildTree(noNode, buf);
            }
        }
    }

}