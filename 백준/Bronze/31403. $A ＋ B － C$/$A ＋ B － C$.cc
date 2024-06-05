#include <stdio.h>
#include <stdlib.h>
#define _CRT_SECURE_NO_WARNINGS

int main()
{
    int a, b, c;
    scanf("%d", &a);
    scanf("%d", &b);
    scanf("%d", &c);

    printf("%d\n", a + b - c);

    char str[1001];
    sprintf(str, "%d%d", a, b);
    int ab_as_int = atoi(str);
    int result = ab_as_int - c;

    printf("%d\n", result);
    return 0;
}