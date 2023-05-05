#include <stdio.h>
int main()
{
    int N;
    scanf("%d", &N);

    int MAX;
    MAX = N / 5;
    int i = MAX;
    while (i >= 0)
    {
        int t;
        if ((N - 5 * i)%3 == 0)
        {
            t = (N - 5 * i) / 3;
            printf("%d", i + t);
            return 0;
        }
        i--;
    }
    printf("-1");
}