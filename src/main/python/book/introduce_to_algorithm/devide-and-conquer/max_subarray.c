/*
* THIS FILE IS A PART OF SORT ALGORITHMS OF <Introduce to algorithm>
* Created by Chen Yuan<cschenyuan@gmail.com> at 08/2016
*/
#include<stdio.h>
#include<stdlib.h>
#include"max_subarray.h"

subarray
find_max_crossing_subarray(const t_elem array[],int low,int mid,int high) {
    t_elem left_sum = ELEM_MIN, right_sum = ELEM_MIN;
    t_elem sum = (t_elem) 0;
    int max_left = mid, max_right = mid + 1;
    int i;
    for (i = mid;i >= low;i--) {
        sum += array[i];
        if (sum > left_sum) {
            left_sum = sum;
            max_left = i;
        }
    }
    sum = (t_elem) 0;
    for (i = mid+1;i <= high;i++) {
        sum += array[i];
        if (sum > right_sum) {
            right_sum = sum;
            max_right = i;
        }
    }
    subarray max_subarray = {left_sum + right_sum, max_left, max_right};
    return max_subarray;
}

subarray
find_max_subarray(const t_elem array[],int low,int high) {
    if (low == high) {
        subarray max_subarray = {array[low], low, high};
        return max_subarray;
    } else {
        int mid = (low + high) / 2;
        subarray left_max_subarray,
                 crossing_max_subarray,
                 right_max_subarray;
        left_max_subarray = find_max_subarray(array, low, mid);
        right_max_subarray = find_max_subarray(array, mid+1, high);
        crossing_max_subarray = find_max_crossing_subarray(array, low, mid, high);
        if (left_max_subarray.sum >= right_max_subarray.sum &&
                left_max_subarray.sum >= crossing_max_subarray.sum)
            return left_max_subarray;
        else if (right_max_subarray.sum >= left_max_subarray.sum &&
                    right_max_subarray.sum >= crossing_max_subarray.sum)
            return right_max_subarray;
        else
            return crossing_max_subarray;
    }
}

subarray
find_max_subarray_prim(const t_elem array[],int low,int high) {
    t_elem max_sum = INT32_MIN;
    int max_low, max_high;
    int i;
    for (i = low;i <= high;i++) {
        t_elem left_sum = ELEM_MIN;
        t_elem sum = (t_elem)0;
        int max_left = -1;
        int j;
        for(j = i;j >= low;j--) {
            sum += *(array + j);
            if (sum > left_sum) {
                left_sum = sum;
                max_left = j;
            }
        }
        t_elem right_sum = ELEM_MIN;
        sum = (t_elem)0;
        int max_right = -1;
        for (j = i + 1;j <= high;j++) {
            sum += *(array + j);
            if (sum > right_sum) {
                right_sum = sum;
                max_right = j;
            }
        }
        if (left_sum + right_sum > max_sum) {
            max_sum = left_sum + right_sum;
            max_low = max_left;
            max_high = max_right;
        }
    }
    subarray max_subarray = {max_sum, max_low, max_high};
    return max_subarray;
}

subarray
find_max_subarray_liner(const t_elem array[],int low,int high) {
    subarray max_subarray =  {(t_elem) 0, 0, 0};
    subarray ctnl_subarray = max_subarray;
    int i;
    for(i = 0;i < high; i++) {
        if (ctnl_subarray.sum <= 0) {
            ctnl_subarray.sum = array[i];
            ctnl_subarray.low = ctnl_subarray.high = i;
        } else {
            ctnl_subarray.sum += array[i];
            ++ ctnl_subarray.high;
        }
        if ( ctnl_subarray.sum > max_subarray.sum)
            max_subarray = ctnl_subarray;
    }
    return max_subarray;
}

t_elem tarray[] = {13, -3, -25, 20, -3, -16, -23, 18,
    20, -7, 12, -5, -22, 15, -4, 7, 123, 1231};
int main() {
    int BULK = 100000;
    t_elem array[BULK];
    char elem[10];
    int n = 0;
    while(fgets(elem, 10, stdin) != NULL) {
        array[n++] = atoi(elem);
    //    printf("%d ", array[n-1]);
    }
    //subarray max_subarray = find_max_subarray_liner(tarray, 0, 15);
    //subarray max_subarray1 = find_max_subarray(array, 0, n-1);
    //subarray max_subarray2 = find_max_subarray_prim(array, 0, n-1);
    subarray max_subarray3 = find_max_subarray_liner(array, 0, n-1);
    printf("%d\n", n);
    //printf("max_sum: %d left: %d right: %d\n",
    //       max_subarray.sum, max_subarray.low, max_subarray.high);
    printf("max_sum: %d left: %d right: %d\n",
           max_subarray3.sum, max_subarray3.low, max_subarray3.high);
    return 0;
}
