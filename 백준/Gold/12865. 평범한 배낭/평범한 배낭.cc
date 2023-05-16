#include <iostream>
#include <vector>

using namespace std;

int dp[100001];
vector<pair<int, int>> bag;

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int N, K;
	cin >> N >> K;

	for (int i = 0; i < N; i++)
	{
		int v, w;
		cin >> w >> v;
		bag.push_back(make_pair(w, v));
	}

	for (auto a : bag)
	{
		for (int i = K; i >= a.first; i--)
		{
			dp[i] = max(dp[i], dp[i - a.first] + a.second);
		}
	}

	cout << dp[K];
}