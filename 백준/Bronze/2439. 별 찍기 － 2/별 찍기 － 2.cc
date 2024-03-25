#include <stdio.h>

int n;
int main() {
    scanf("%d", &n);
    for (int i = 1; i <= n; i++) {
        int spaceCount = n - i;
        for (int j = 0; j < spaceCount; j++) {
            printf("%s", " ");
        }
        for (int j = 0; j < i; j++) {
            printf("%s", "*");
        }
        printf("\n");
    }
    return 0;
}