
#include<stdio.h>
#include<stdlib.h>

void
lcs_length(char X[],char Y[],int m,int n) {

    int **c = (int **) malloc((m+1) * sizeof(int *));
    int i;
    for (i=0;i<=m;i++) {
        c[i] = (int *)malloc((n+1) * sizeof(int));
        c[i][0] = 0;
    }
    for (i=1;i<=n;i++)
        c[0][i] = 0;
    int j; for (i=1;i<=m;i++)
        for (j=1;j<=n;j++) {
            if (X[i-1] == Y[j-1])
                c[i][j] = c[i-1][j-1] + 1;
            else if (c[i-1][j] >= c[i][j-1])
                c[i][j] = c[i-1][j];
            else
                c[i][j] = c[i][j-1];
            printf("(%c,%c): c[%d,%d] => %d\n", X[i-1],Y[j-1],i,j,c[i][j]);
        }
    printf("LCS length: %d\n", c[m][n]);
}

int main() {
    char X[] = {'A','B','C','B','D','A','B'};
    char Y[] = {'B','D','C','A','B','A'};

    int m = 7;
    int n = 6;

    lcs_length(X, Y, m, n);
}
