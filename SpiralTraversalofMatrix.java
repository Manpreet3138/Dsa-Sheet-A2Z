import java.util.*;

public class SpiralTraversalofMatrix {
    
    // Spiral traversal method
    public static List<Integer> spiralPathMatrix(int[][] matrix, int n, int m) {
        Integer[] resultArray = new Integer[n * m];
        int idx = 0;

        int top = 0, bottom = n - 1;
        int left = 0, right = m - 1;

        while (top <= bottom && left <= right) {
            // Traverse from Left to Right
            for (int i = left; i <= right; i++) {
                resultArray[idx++] = matrix[top][i];
            }
            top++;

            // Traverse from Top to Bottom
            for (int i = top; i <= bottom; i++) {
                resultArray[idx++] = matrix[i][right];
            }
            right--;

            // Traverse from Right to Left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    resultArray[idx++] = matrix[bottom][i];
                }
                bottom--;
            }

            // Traverse from Bottom to Top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    resultArray[idx++] = matrix[i][left];
                }
                left++;
            }
        }

        return Arrays.asList(resultArray);
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int n = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int m = sc.nextInt();

        int[][] matrix = new int[n][m];

        System.out.println("Enter matrix elements:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        List<Integer> spiral = spiralPathMatrix(matrix, n, m);

        System.out.println("Spiral traversal:");
        for (int num : spiral) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}