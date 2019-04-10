import java.util.*;
/**
 * @author Qurrat-al-Ain Siddiqui
 * @instructor Laura Marik
 * @date November 4, 2018
 * 
 * COMP 2503-001 Assignment 4: Expression Tree
 * 
 * Expression Tree is the processor class.
 *
 */
public class ExpressionTree {
private TreeNode root;
    
    public ExpressionTree(String postfixExp)
    {
        root = null;
        createExpressionTree(postfixExp);
    }

    public ExpressionTree(TreeNode root) {
        this.root = root;
    }

    /**
     * Constructs expression tree, from the postfix expression
     */
    public void createExpressionTree(String postfixExp) {
    	ArrayDeque<TreeNode> nodes = new ArrayDeque<TreeNode>(); //Creation of the stack
    	TreeNode n;
    	for (int i = 0; i < postfixExp.length(); i++) {
    		switch(postfixExp.charAt(i)){
    		case '0': //create node, push to stack
	    		n = new TreeNode('0');
	    		nodes.push(n);
	    		break;
    		case '1': //create node, push to stack
    			n = new TreeNode('1');
    			nodes.push(n);
    			break;
    		case '|': //creates a node, with left & right subtrees attahed from stack, push to stack
    			n = new TreeNode('|', nodes.pop(), nodes.pop());
    			nodes.push(n);
    			break;
    		case '&': // create node with left and right subtrees attached from stack, push to stack
    			n = new TreeNode('&', nodes.pop(), nodes.pop());
    			nodes.push(n);
    			break;
    		case '^': //create node with left and right subtrees attached from stack, psh to stack
    			n = new TreeNode('^', nodes.pop(), nodes.pop());
    			nodes.push(n);
    			break;
    		case '!': //create node with subtree attached, push to stack
    			n = new TreeNode('!', nodes.pop());
    			nodes.push(n);
    			break;
    		default:
    			break;
    		}
    	}
    	root = nodes.pop();
    }

    public boolean evaluate() {
        return evaluate(root);
    }
    public boolean evaluate(TreeNode n)  {
    	boolean retval = false;
        // recursive function to evaluate tree starting with n as root
    	//Make switch statement t handle different characters/oprators 
    	
    	if (n.getData() == '&' retval = (evaluate(n.getLeftNode() && evaluate(n.getRightNode()));
    	return retval;
    }


    public String getPostfixExp(){
        StringBuilder postfixExp = new StringBuilder();
        return buildPostfixExp(root, postfixExp);
    }


    private String buildPostfixExp(TreeNode node, StringBuilder postfixExp) {
        // traverse the tree in postfix order to build postfix                
        //expression
        if (node != null)
        // Make accessors in TreeNode class to fix this
        {
             buildPostfixExp(node.getLeftNode(), postfixExp);
             buildPostfixExp(node.getRightNode(), postfixExp);
             postfixExp.append(node.getData() + " ");
        }
        return postfixExp.toString();
    }


    public String getInfixExp(){
        StringBuilder infixExp = new StringBuilder();
        return buildInfixExp(root, infixExp);
    }


    private String buildInfixExp(TreeNode node, StringBuilder infixExp)
    {
        // traverse tree in in-fix order to create infix expression
        if (node != null)
        {
		// add code here
        	if (node.getData() != '0' && node.getData( != '1' && !Character.isLetter(node.getData()))) {
        		infixExp.append("("); 
        	}
        	buildInfixExp(node.getLeftNode(), infixExp);
        	infixExp.append(node.getData());
        	buildInfixExp(node.getRightNode(), infixExp);
        	
        	if (node.getData() != '0' && node.getData() != '1' && !Character.isLetter(node.getData())) {
        		infixExp.append(")");
        	}
        }
        return infixExp.toString();
    }


    public String getPrefixExp()
    {
        StringBuilder prefixExp = new StringBuilder();
        return buildPrefixExp(root, prefixExp);
    }


    private String buildPrefixExp(TreeNode node, StringBuilder prefixExp)
    {
        // traverse tree in prefix order to create prefix expression
	  if ( node != null )
	  {
            // add code here
		  prefixExp.append(node.getData());
		  buildPrefixExp(node.getLeftNode(), prefixExp);
		  buildPrefixExp(node.getRightNode(), prefixExp);
        }	
        return prefixExp.toString();
    }


    /** Translates an infix expression to a postfix expression using the shunting yard algorithm
     *
     * The following steps are performed :
     * <ul>While there are tokens to be read:
     * <li>Read a token.
     * <li>If the token is a boolean, then push it to the output queue.
     * <li>If the token is an operator, o1, then:
     * <li>  while there is an operator token o2, at the top of the operator stack and its precedence is less than or equal to that of o2
     * <li>    pop o2 off the operator stack, onto the output queue;
     * <li>  at the end of iteration push o1 onto the operator stack.
     * <li>If the token is a left parenthesis (i.e. "("), then push it onto the stack.
     * <li>If the token is a right parenthesis (i.e. ")"):
     * <li>  Until the token at the top of the stack is a left parenthesis, pop operators off the stack onto the output queue.
     * <li>  Pop the left parenthesis from the stack, but not onto the output queue.
     * <li>  If the token at the top of the stack is a function token, pop it onto the output queue.
     * <li>  If the stack runs out without finding a left parenthesis, then there are mismatched parentheses.
     * <li>When there are no more tokens to read:
     * <li>  While there are still operator tokens in the stack:
     * <li>    If the operator token on the top of the stack is a parenthesis, then there are mismatched parentheses.
     * <li>    Pop the operator onto the output queue.
     * </ul>
     *
     */
    public static String translateToPostfix(String infix)
    {
       StringBuilder postfix = new StringBuilder();
       
       Stack<Character> opperators = new Stack<Character>();
       Stack<Character> opperends = new Stack<Character>();
       String postfix;
       
       for (int i = 0; i < infix.length(); i++) {
    	   char letter = infix.charAt(i);
    	   if(Character.isLetter(letter) || Character.isDigit(letter)) {
    		   System.out.println("] " + letter);
    		   opperends.push(letter);
    	   }
    	   else if(letter != '(' && letter != ')') {
    		   opperators.push(letter); 
    	   }
       }

 
        // perform shunting yard algorithm
        // add code here

       postfix = createPostFixExp(opperends, opperators);
        // return the postfix expression as a String
        return postfix.toString();
    }
    
    private String createPostFixExp(Stack<Character> opperendsStack, Stack<Character> opperatorsStack) {
    	StringBuilder postfix = new StringBuilder();
    	
    	while(!opperendsStack.isEmpty()) {
    		//System.out.println(opperendsStack.peek());
    		postfix.insert(0, opperendsStack.pop());
    	}
    	while (!opperatorsStack.isEmpty()) {
    		postfix.append(opperatorsStack.pop());
    	}
    	
    	return (postfix.toString());
    }

}



}
