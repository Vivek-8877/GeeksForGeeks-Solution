<h2><a href="https://youtu.be/9muPCGLD2WQ">Click Me For Video Solution</a></h2>

<a href="https://youtu.be/9muPCGLD2WQ">![16 JAN 2023](https://user-images.githubusercontent.com/91456523/212829368-c36070fa-5c17-4301-999a-c5f858a0ceaa.png)</a>

<h2><a href="https://practice.geeksforgeeks.org/problems/6eb51dc638ee1b936f38d1ab4b2f7062d4425463/1">Find the maximum GCD of the siblings of a Binary Tree</a></h2><h3>Difficulty Level : Easy</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size:18px">Given a binary tree. The task is to find the maximum GCD&nbsp;of the siblings of this tree. You have to return the value of the node whose two immediate children has the maximum gcd.<br>
If there are multiple such nodes, return&nbsp;the node which has the maximum value.</span></p>

<p><span style="font-size:18px"><strong>Siblings:</strong>&nbsp;Nodes with the same parent are called siblings.</span></p>

<p><span style="font-size:18px"><strong>GCD (Greatest Common Divisor)</strong>&nbsp;of two positive integers is the largest positive integer that divides both numbers without a remainder.</span></p>

<h4><span style="font-size:18px"><strong>Note:</strong></span></h4>

<ul>
	<li><span style="font-size:18px">Return 0&nbsp;if input tree is empty i.e level of tree is -1.</span></li>
	<li><span style="font-size:18px">Consider those nodes which have a&nbsp;sibling.</span></li>
	<li><span style="font-size:18px">Return 0&nbsp;if no such pair of siblings found.</span></li>
</ul>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:</strong>
              4
            /   \
           5     2
                /  \
               3    1
              /  \
             6   12

<strong>Output:</strong> 3
<strong>Explanation:</strong> For the above tree, the maximum
GCD for the siblings is formed for nodes 6 and 12
for the children of node 3.</span></pre>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input: </strong>
            1
          /   \
        3      5
      /  \    /  \
     6    9  4    8

<strong>Output:</strong> 5
<strong>Explanation:</strong> For the above tree, the maximum
GCD for the siblings is formed for nodes 4 and 8
for the children of node 5.</span></pre>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Your Task:</strong><br>
You don't need to take input. Just complete the function<strong> maxGCD() </strong>that takes the root <strong>node </strong>as a parameter and returns the value of the node whose two immediate children has the maximum gcd.</span></p>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Expected Time Complexity:&nbsp;</strong>O(|Number of nodes|) .<br>
<strong>Expected Auxiliary Space:&nbsp;</strong>O(1) .</span></p>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Constraints:</strong><br>
1 &lt;= Number of nodes &lt;= 10<sup>5</sup><br>
1 &lt;= Data of a node &lt;= 10<sup>5</sup></span></p>
</div><p><span style=font-size:18px><strong>Company Tags : </strong><br><code>Samsung</code>&nbsp;<br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Tree</code>&nbsp;<code>Data Structures</code>&nbsp;
