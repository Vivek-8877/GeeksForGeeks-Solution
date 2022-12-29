<h2><a href="https://practice.geeksforgeeks.org/problems/shreyansh-and-his-bits1420/1">Shreyansh and his bits</a></h2><h3>Difficulty Level : Medium</h3><hr><div class="problems_problem_content__Xm_eO"><p>Shreyansh has an integer N. He is really curious about the binary representation of integers. He sees that any given integer has a number of set bits. Now he wants to find out that how many positive integers, strictly less than N, have the <strong>same number of set bits as N</strong>.<br>
He is a little weak in maths. Help him find the number of integers.<br>
<strong>Note</strong> : Since N takes large values, brute force won't work.</p>

<p>&nbsp;</p>

<p><strong>Example 1:</strong></p>

<pre><strong>Input</strong>:
N = 8
<strong>Output:</strong>&nbsp;3
<strong>Explanation</strong>:
Binary representation of 8 : 1000
So the integers less than 8 with 
same number of set bits are : 4, 2, 1
Hence, the result is 3.  
</pre>

<p>&nbsp;</p>

<p><strong>Example 2:</strong></p>

<pre><strong>Input:</strong>
N = 4
<strong>Output:&nbsp;</strong>2
Explanation:
Binary representation of 4 : 100
So the integers less than 4 with 
same number of set bits are : 2, 1
So, The result is 2.
</pre>

<p><br>
<strong>Your Task:&nbsp;&nbsp;</strong><br>
You don't need to read input or print anything. Your task is to complete the function&nbsp;<strong>count()</strong>&nbsp;which takes the integer&nbsp;N<strong>&nbsp;</strong>as input parameters and returns the required answer.<br>
<br>
<strong>Expected Time Complexity:</strong> O(log(n))<br>
<strong>Expected Auxiliary Space:</strong> O(log(n)*log(n))<br>
&nbsp;</p>

<p>&nbsp;</p>

<p><strong>Constraints :</strong>&nbsp;<br>
1 &lt;= N &lt;= 10^12</p>

<p>&nbsp;</p>
</div><br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Bit Magic</code>&nbsp;<code>Data Structures</code>&nbsp;