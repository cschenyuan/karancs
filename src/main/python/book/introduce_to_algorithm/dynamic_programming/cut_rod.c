/**
 *
**/

#include<stdio.h>
#include<stdint.h>


int max(int a,int b) {
    return a >= b ? a : b;
}

int cut_rod(int *p,int n) {
    if (n == 0)
        return 0;
    int q = INT32_MIN;
    int i;
    for (i = 1;i<=n;i++)
        q = max(q, p[i-1] + cut_rod(p, n-i));
    return q;
}

int main() {
    int p[] = {1,5,9,8,10,17,17,20,24,30};

    printf("%d\n", cut_rod(p, 40));
}
