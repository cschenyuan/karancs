/*
* THIS FILE IS A PART OF SORT ALGORITHMS OF <Introduce to algorithm>
* Created by Chen Yuan<cschenyuan@gmail.com> at 02/2017
*/

typedef int t_elem;

typedef struct tree {
    t_elem key;
    struct tree *parent;
    struct tree *lchild;
    struct tree *rchild;
} *ptree,*tnode;
