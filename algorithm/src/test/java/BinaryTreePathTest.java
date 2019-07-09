import org.junit.Test;

import static  org.junit.Assert.*;

public class BinaryTreePathTest {

    @Test
    public void test_case_0() {
        BinaryTreePath.TreeNode root = new BinaryTreePath.TreeNode(100);

        BinaryTreePath.TreeNode n1_1 = root.left = new BinaryTreePath.TreeNode(50);
        BinaryTreePath.TreeNode n1_2 = root.right = new BinaryTreePath.TreeNode(150);

        BinaryTreePath.TreeNode n2_1 = n1_1.left = new BinaryTreePath.TreeNode(25);
        BinaryTreePath.TreeNode n2_2 = n1_1.right = new BinaryTreePath.TreeNode(75);

        BinaryTreePath.TreeNode n2_3 = n1_2.left = new BinaryTreePath.TreeNode(125);
        BinaryTreePath.TreeNode n2_4 = n1_2.right = new BinaryTreePath.TreeNode(175);


        BinaryTreePath.TreeNode n3_1 = n2_1.left = new BinaryTreePath.TreeNode(20);
        BinaryTreePath.TreeNode n3_2 = n2_1.right = new BinaryTreePath.TreeNode(30);

        BinaryTreePath.TreeNode n3_3 = n2_2.left = new BinaryTreePath.TreeNode(70);
        BinaryTreePath.TreeNode n3_4 = n2_2.right = new BinaryTreePath.TreeNode(80);

        BinaryTreePath.TreeNode n3_5 = n2_3.left = new BinaryTreePath.TreeNode(120);
        BinaryTreePath.TreeNode n3_6 = n2_3.right = new BinaryTreePath.TreeNode(130);

        BinaryTreePath.TreeNode n3_7 = n2_4.left = new BinaryTreePath.TreeNode(170);
        BinaryTreePath.TreeNode n3_8 = n2_4.right = new BinaryTreePath.TreeNode(180);


        BinaryTreePath.ListNode first =  BinaryTreePath.findPath(root, n3_7);

        BinaryTreePath.ListNode p = first;
        do{
            System.out.println(p.val + " ->");
        }while( (p=p.next) != first.prev);
//
//        for (BinaryTreePath.ListNode p = head; p!= head; p=p.next) {
//            System.out.println(p.val + " ->");
//        }

        assertEquals(100, first.val);
        assertEquals(150, first.next.val);
        assertEquals(175, first.next.next.val);
        assertEquals(170, first.next.next.next.val);
    }
}
