#include <iostream>
#include <vector>

using namespace std;

int dp[10001];
vector <int> coin;

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int n, k;

	cin >> n >> k;

	for (int i = 0; i < n; i++)
	{
		int c;
		cin >> c;

		if (c <= k) coin.push_back(c);
	}

	if (coin.empty() == 1)
	{
		cout << -1;
		return 0;
	}

	for (int i = 1; i <= k; i++)
	{
		dp[i] = 10001;
		for (auto a : coin)
		{
			if (i - a >= 0)
			{
				dp[i] = min(dp[i], dp[i - a] + 1);
			}
		}
	}

	cout << (dp[k] != 10001 ? dp[k] : -1);

}