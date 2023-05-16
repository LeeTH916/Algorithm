#include <iostream>

using namespace std;

int dp[31];

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int N;

	cin >> N;

	dp[0] = 1;

	for (int i = 1; i <= N; i++)
	{
		if (i % 2 == 0)
		{
			dp[i] = dp[i - 2] * 3;

			int k = 2;

			while (i - 2 * k >= 0)
			{
				dp[i] += dp[i - 2 * k] * 2;
				k++;
			}
		}
	}

	cout << dp[N];
}