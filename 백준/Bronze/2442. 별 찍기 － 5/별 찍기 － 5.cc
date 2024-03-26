#include <stdio.h>

int n;
int main()
{
    scanf("%d", &n);
    int stars = 1;
    int spaceCount = n - 1;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < spaceCount; j++)
        {
            printf("%s", " ");
        }
        for (int j = 0; j < stars; j++)
        {
            printf("%s", "*");
        }
        printf("\n");
        stars += 2;
        spaceCount -= 1;
    }
    return 0;
}