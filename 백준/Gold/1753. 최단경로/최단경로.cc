#include <iostream>
#include <queue>

#define inf 210000000

using namespace std;

vector<pair<int, char>> map[20001];
priority_queue <pair<int, int>> route;
int dist[20001];

int main()
{
	int V, E, K;

	cin >> V >> E;

	cin >> K;

	int u, v;
	int w;

	for (int i = 0; i < E; i++)
	{
		cin >> u >> v >> w;

		map[u].push_back(make_pair(v,(char)w));
	}

	for (int i = 1; i <= V; i++)
	{
		dist[i] = inf;
	}

	dist[K] = 0;

	route.push(make_pair(0, K));

	while (!route.empty())
	{
		int cur = route.top().second;
		int tmp_dist = -route.top().first;
		route.pop();

		if (tmp_dist > dist[cur]) continue;

		for (auto a : map[cur])
		{
			if (dist[a.first]>a.second+dist[cur])
			{
				dist[a.first] = a.second + dist[cur];
				route.push(make_pair(-(a.second + dist[cur]), a.first));
			}
		}
	}

	for (int i = 1; i <= V; i++)
	{
		if (dist[i] == inf) cout << "INF" << '\n';
		else cout << dist[i] << '\n';
	}
}