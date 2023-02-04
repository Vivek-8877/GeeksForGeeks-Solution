<h2><a href="https://practice.geeksforgeeks.org/problems/7a33c749a79327b2889d420dd80342fff33aac6d/1">Max Sum without Adjacents</a></h2><h3>Difficulty Level : Easy</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size:18px">Given an array <strong>Arr&nbsp;</strong>of size <strong>N</strong>&nbsp;containing&nbsp;positive integers. Find the maximum sum of a subsequence such that no two numbers in the sequence should be adjacent in the array. </span></p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:
</strong>N = 6
Arr[] = {5, 5, 10, 100, 10, 5}
<strong>Output:</strong> 110
<strong>Explanation:</strong> If you take indices 0, 3
and 5, then Arr[0]+Arr[3]+Arr[5] =
5+100+5 = 110.</span></pre>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:
</strong>N = 4
Arr[] = {3, 2, 7, 10}
<strong>Output:</strong> 13
<strong>Explanation: </strong>3 and 10 forms a non
continuous  subsequence with maximum
sum.</span></pre>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Your Task:</strong><br>
You don't need to read input or print anything. Your task is to complete the function&nbsp;<strong>findMaxSum()</strong>&nbsp;which takes the&nbsp;array of&nbsp;integers&nbsp;<strong>arr&nbsp;</strong>and&nbsp;<strong>n</strong><strong>&nbsp;</strong>as parameters and returns an integer denoting the answer. It is guaranteed that your answer will always fit in the 32-bit integer.</span></p>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Expected Time Complexity:</strong>&nbsp;O(N)<br>
<strong>Expected Auxiliary Space:</strong>&nbsp;O(1)</span></p>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Constraints:</strong><br>
1 ≤ N ≤ 10<sup>6</sup><br>
1 ≤ Arr<sub>i</sub> ≤ 10<sup>7</sup></span></p>
</div><p><span style=font-size:18px><strong>Company Tags : </strong><br><code>Paytm</code>&nbsp;<code>Amazon</code>&nbsp;<code>OYO Rooms</code>&nbsp;<code>FactSet</code>&nbsp;<code>Walmart</code>&nbsp;<code>Adobe</code>&nbsp;<code>Oxigen Wallet</code>&nbsp;<code>Yahoo</code>&nbsp;<br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Arrays</code>&nbsp;<code>Dynamic Programming</code>&nbsp;<code>Data Structures</code>&nbsp;<code>Algorithms</code>&nbsp;