#include<stdio.h>
#include "binary_search_tree.h"

int main() {
    tnode r = create_node(12);
    ptree *bst = &r;
    //error expr: ptree *bst = (ptree *) create_node(12);
    insert_bst(bst, 5);
    insert_bst(bst, 18);
    insert_bst(bst, 2);
    insert_bst(bst, 9);
    insert_bst(bst, 15);
    insert_bst(bst, 19);
    insert_bst(bst, 13);
    insert_bst(bst, 17);

    traverse(*bst);
    printf("\n");
    //printf("minimum: %d\n", bst_minimum(bst)->key);
    //printf("maximum: %d\n", bst_maximum(bst)->key);
    //printf("succussor of 9: %d\n", successor(search_bst(bst, 9))->key);
    //printf("predecessor of 13: %d\n", predecessor(search_bst(bst, 13))->key);
    delete_bst(bst, 12);
    //transplant(bst, search_bst(bst,5), search_bst(bst, 9));
    traverse(*bst);
    printf("\n");
}
