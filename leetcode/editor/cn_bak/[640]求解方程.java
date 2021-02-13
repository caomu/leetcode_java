//求解一个给定的方程，将x以字符串"x=#value"的形式返回。该方程仅包含'+'，' - '操作，变量 x 和其对应系数。 
//
// 如果方程没有解，请返回“No solution”。 
//
// 如果方程有无限解，则返回“Infinite solutions”。 
//
// 如果方程中只有一个解，要保证返回值 x 是一个整数。 
//
// 示例 1： 
//
// 输入: "x+5-3+x=6+x-2"
//输出: "x=2"
// 
//
// 示例 2: 
//
// 输入: "x=x"
//输出: "Infinite solutions"
// 
//
// 示例 3: 
//
// 输入: "2x=x"
//输出: "x=0"
// 
//
// 示例 4: 
//
// 输入: "2x+3x-6x=x+2"
//输出: "x=-1"
// 
//
// 示例 5: 
//
// 输入: "x=x+2"
//输出: "No solution"
// 
// Related Topics 数学 
// 👍 63 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String solveEquation(String equation) {
        boolean left = true;
        int a1 = 0, a2 = 0, b1 = 0, b2 = 0;//a1 X + b1 = a2 X + b2
        int l = equation.length();
        for (int i = 0; i < l; i++) {
            char c = equation.charAt(i);
            if (i == 0 || c == '+' || c == '=' || c == '-') {
                if (c == '=') {
                    left = false;
                }
                for (int j = (i == 0 && equation.charAt(0) == 'x') ? 0 : i + 1; j < l; j++) {
                    char cc = equation.charAt(j);
                    if (cc == 'x' || cc == '+' || cc == '-' || cc == '=' || j == l - 1) {
                        if (j == i + 1 && c == '=') {
                            if (cc == 'x') {
                                a2 += 1;
                            } else if (j == l - 1) {
                                b2 += Integer.parseInt(Character.toString(cc));
                            }
                            break;
                        }
                        int endIdx = cc != 'x' && j == l - 1 ? j + 1 : j;
                        int t = 0;
                        String a;
                        if (i == 0) {
                            a = equation.substring(0, j);
                            t = j == 0 ? 1 : (a.equals("-") ? -1 : Integer.parseInt(a));
                        } else if (c == '=') {
                            a = equation.substring(i + 1, endIdx);
                            t = i + 1 == endIdx ? 1 : (a.equals("-") ? -1 : Integer.parseInt(a));
                        } else {
                            a = equation.substring(i, endIdx);
                            t = a.equals("-") ? -1 : i + 1 == endIdx ? 1 : Integer.parseInt(a);
                        }
                        if (cc == 'x' && left) {
                            a1 += t;
                        } else if (cc == 'x') {
                            //!left
                            a2 += t;
                        } else if (left) {
                            // cc != 'x'
                            b1 += t;
                        } else {
                            b2 += t;
                        }
//                        System.out.println("c:" + c + "\tcc:" + cc + "\ti:" + i + "\tj:" + j + "\tendIdx:" + endIdx + "\tt:" + t + "\ta1:" + a1 + "\tb1:" + b1 + "\ta2:" + a2 + "\tb2:" + b2);
                        break;
                    }
                }
            }
        }
//        System.out.println("a1:" + a1 + "\tb1:" + b1 + "\ta2:" + a2 + "\tb2:" + b2);
        return (a1 == a2 && b1 == b2) ? "Infinite solutions" : a1 == a2 ? "No solution" : "x=" + ((b2 - b1) / (a1 - a2));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
