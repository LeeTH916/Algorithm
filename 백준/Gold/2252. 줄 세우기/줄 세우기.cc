#include <iostream>
#include <vector>
#include <stack>

using namespace std;

vector<int> map[32001];
stack<int> s;
char visited[32001];

void doDFS(int now)
{
	visited[now] = 1;
	for (auto a : map[now])
	{
		if (visited[a] == 0) 
		{
			doDFS(a);
		}
	}
	s.push(now);
}

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int N, M;
	cin >> N >> M;

	int a, b;

	for (int i = 0; i < M; i++)
	{
		cin >> a >> b;
		map[a].push_back(b);
	}

	for (int i = 1; i <= N; i++)
	{
		if(visited[i]==0) doDFS(i);
	}

	while (!s.empty())
	{
		cout << s.top() << ' ';
		s.pop();
	}

}