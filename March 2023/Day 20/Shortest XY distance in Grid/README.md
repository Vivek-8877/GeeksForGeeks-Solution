<h2><a href="https://youtu.be/LQI7OHczMrE">Click Me For Video Solution</a></h2>

<a href="https://youtu.be/LQI7OHczMrE">![16 JAN 2023 (1)](https://user-images.githubusercontent.com/91456523/226261225-519fe845-c56b-44df-90f6-33f0ae5ab2c3.png)</a>

<h2><a href="https://practice.geeksforgeeks.org/problems/7366ce450d84b55391fc787a681c4d60de359e72/1">Shortest XY distance in Grid</a></h2><h3>Difficulty Level : Medium</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size:18px">Give a <strong>N*M </strong>grid of characters 'O', 'X', and 'Y'. Find the minimum&nbsp;Manhattan&nbsp;distance between a&nbsp;<strong>X</strong> and a&nbsp;<strong>Y</strong>.</span><br>
<br>
<span style="font-size:18px"><u>Manhattan&nbsp;Distance</u> :<br>
<strong>| row_index_x - row_index_y | + | column_index_x - column_index_y |</strong></span></p>

<p><br>
<span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:
</strong>N = 4, M = 4
grid  = {{X, O, O, O}
         {O, Y, O, Y}
         {X, X, O, O}
         {O, Y, O, O}}</span>
<span style="font-size:18px"><strong>Output:
</strong>1
<strong>Explanation:</strong>
{{X, O, O, O}
{O, Y, O, Y}
{X, <strong>X</strong>, O, O}
{O, <strong>Y</strong>, O, O}}
The shortest X-Y distance in the grid is 1.
One possible such X and Y are marked in bold
in the above grid.</span></pre>

<p><span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:
</strong>N = 3, M = 3
grid = {{X, X, O}
        {O, O, Y}
        {Y, O, O}}
<strong>Output :</strong>
2</span>
<span style="font-size:18px"><strong>Explanation:</strong>
{{X, <strong>X</strong>, O}
 {O, O, <strong>Y</strong>}
 {Y, O, O}}</span>
<span style="font-size:18px">The shortest X-Y distance in the grid is 2.
One possible such X and Y are marked in bold
in the above grid.</span>
</pre>

<p><span style="font-size:18px"><strong>Your Task:&nbsp;&nbsp;</strong><br>
You don't need to read input or print anything. Your task is to complete the function <strong>shortestXYDist()</strong>&nbsp;which takes two integers N, and M and an 2D list of size N*M as input and returns the shortest Manhattan&nbsp;Distance between a X and a Y.</span></p>

<p><span style="font-size:18px"><strong>Expected Time Complexity:</strong>&nbsp;O(N*M)<br>
<strong>Expected Auxiliary Space:</strong>&nbsp;O(N*M)</span></p>

<p><br>
<span style="font-size:18px"><strong>Constraints:</strong><br>
1 ≤ N, M ≤ 10<sup>3&nbsp;&nbsp;</sup></span></p>

<p><span style="font-size:18px">There exists at least one 'X' and at least one 'Y' in the grid.</span></p>

<p>&nbsp;</p>
</div><p><span style=font-size:18px><strong>Company Tags : </strong><br><code>Google</code>&nbsp;<br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Dynamic Programming</code>&nbsp;<code>BFS</code>&nbsp;<code>Algorithms</code>&nbsp;
