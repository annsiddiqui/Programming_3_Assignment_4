
/**
 * @author Qurrat-al-Ain Siddiqui
 * @instructor Laura Marik
 * @date November 4, 2018
 * 
 * COMP 2503-001 Assignment 4: Expression Tree
 *
 */
public class TreeNode {
	
	public char data;
	public TreeNode leftNode, rightNode;

	    public TreeNode(char data)
	    {
	        this(data, null, null);
	    }

	    public TreeNode(char data, TreeNode leftNode, TreeNode rightNode)
	    {
	        this.data = data;
	        this.leftNode = leftNode;
	        this.rightNode = rightNode;
	    }

		/**
		 * @return the data
		 */
		public char getData() {
			return data;
		}

		/**
		 * @param data the data to set
		 */
		public void setData(char data) {
			this.data = data;
		}

		/**
		 * @return the leftNode
		 */
		public TreeNode getLeftNode() {
			return leftNode;
		}

		/**
		 * @param leftNode the leftNode to set
		 */
		public void setLeftNode(TreeNode leftNode) {
			this.leftNode = leftNode;
		}

		/**
		 * @return the rightNode
		 */
		public TreeNode getRightNode() {
			return rightNode;
		}

		/**
		 * @param rightNode the rightNode to set
		 */
		public void setRightNode(TreeNode rightNode) {
			this.rightNode = rightNode;
		}
	}



