#include <iostream>
#include <algorithm>
using namespace std;

int N, M;
int dp[10001];

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N >> M;
	for (int i = 0; i < N; i++)
	{
		int V, C, K;
		cin >> V >> C >> K;

		int weight, val;
		for (int j = 1; K > 0; j *= 2 )
		{
			int temp = min(j, K);
			weight = V * temp, val = C * temp;
			K -= temp;
			for (int t = M; t >= weight; t--)
			{
				dp[t] = max(dp[t], dp[t - weight] + val);
			}
		}
	}

	cout << dp[M];
}