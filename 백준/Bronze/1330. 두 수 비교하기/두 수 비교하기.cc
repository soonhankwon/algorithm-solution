#include <stdio.h>

int a, b;
int main()
{
    scanf("%d %d", &a, &b);

    if (a > b)
    {
        printf("%s", ">");
    }
    else if (a < b)
    {
        printf("%s", "<");
    }
    else
    {
        printf("%s", "==");
    }
    return 0;
}