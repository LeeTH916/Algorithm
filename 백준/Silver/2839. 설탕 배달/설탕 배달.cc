#include <iostream>
#include <vector>

using namespace std;

int dp[5001];

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int N;
	cin >> N;

	dp[3] = dp[5] = 1;

	for (int i = 6; i <= N; i++)
	{
		if (dp[i - 3]) dp[i] = dp[i - 3] + 1;
		if (dp[i - 5]) dp[i] = dp[i] == 0 ? dp[i - 5] + 1 : min(dp[i], dp[i - 5] + 1);
	}
	cout << (dp[N] != 0 ? dp[N] : -1);
	return 0;

}