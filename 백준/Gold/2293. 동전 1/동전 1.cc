#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int dp[10000];
vector <int> coin;

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int n, k;
	int c;

	cin >> n >> k;
	for (int i = 0; i < n; i++)
	{
		cin >> c;
		if(c<=k) coin.push_back(c);
	}

	int tmp = 0;

	for (auto a:coin)
	{
		dp[a] += 1;
		for (int i = 1; i <= k; i++)
		{
			tmp = i - a;
			if (tmp > 0)
			{
				dp[i] += dp[tmp];
			}
		}
	}

	cout << dp[k];

}