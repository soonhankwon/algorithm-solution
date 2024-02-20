#include <stdio.h>

int main()
{
    int index;
    char s[1001];

    scanf("%s", s);
    scanf("%d", &index);

    printf("%c", s[index - 1]);
    return 0;
}