/*
* THIS FILE IS A PART OF SORT ALGORITHMS OF <Introduce to algorithm>
* Created by Chen Yuan<cschenyuan@gmail.com> at 08/2016
*/
#include<stdint.h>

#define ELEM_MIN INT32_MIN

typedef int t_elem;

typedef struct {
    t_elem sum;
    int low;
    int high;
} subarray;

subarray find_max_crossing_subarray(const t_elem[],int,int,int);

subarray find_max_subarray(const t_elem[],int,int);

subarray find_max_subarray_prim(const t_elem[],int,int);
