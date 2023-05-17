#include <iostream>

using namespace std;

char map[100][100];
int visit[100][100];

int x[4] = { -1,0,1,0 };
int y[4] = { 0,-1,0,1 };

int N;

void doDFS(int _y, int _x, char c)
{

	for (int k = 0; k < 4; k++)
	{
		int next_y = _y + y[k];
		int next_x = _x + x[k];

		if (next_x < 0 || next_y < 0 || next_x >= N || next_y >= N) continue;

		if (c == map[next_y][next_x] && visit[next_y][next_x] == 0)
		{
			visit[next_y][next_x] = 1;
			doDFS(next_y, next_x, c);
		}
	}

}

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> N;

	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < N; j++)
		{
			cin >> map[i][j];
		}
	}

	int cnt = 0;
	int cnt2 = 0;

	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < N; j++)
		{
			if (visit[i][j] == 0)
			{
				visit[i][j] = 1;
				doDFS(i, j, map[i][j]);
				cnt++;
			}
		}
	}

	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < N; j++)
		{
			visit[i][j] = 0;
			if (map[i][j] == 'G') map[i][j] = 'R';
		}
	}

	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < N; j++)
		{
			if (visit[i][j] == 0)
			{
				visit[i][j] = 1;
				doDFS(i, j, map[i][j]);
				cnt2++;
			}
		}
	}

	cout << cnt << ' ' << cnt2;

}