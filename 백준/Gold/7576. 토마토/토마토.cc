#include <iostream>
#include <queue>

using namespace std;

int box[1000][1000];
queue <pair<int,int>> tomato;

int x[4] = { -1,0,1,0 };
int y[4] = { 0,-1,0,1 };

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int M, N;

	cin >> M >> N;

	for (int y = 0; y < N; y++)
	{
		for (int x = 0; x < M; x++)
		{
			cin >> box[y][x];
			if (box[y][x] == 1)
			{
				tomato.push(make_pair(y, x));
			}
		}
	}

	int _x, _y;
	int date = 1;

	while (!tomato.empty())
	{
		_y = tomato.front().first;
		_x = tomato.front().second;

		tomato.pop();

		for (int k = 0; k < 4; k++)
		{
			int next_y = _y + y[k];
			int next_x = _x + x[k];
			if (next_x<0 || next_y<0 || next_x>=M || next_y>=N) continue;

			if (box[next_y][next_x] == 0)
			{
				box[next_y][next_x] = box[_y][_x] + 1;
				date = box[next_y][next_x];
				tomato.push(make_pair(next_y, next_x));
			}
		}
	}

	for (int m = 0; m < M; m++)
	{
		for (int n = 0; n < N; n++)
		{
			if (box[n][m] == 0)
			{
				cout << -1;
				return 0;
			}
		}
	}

	cout << date - 1;

}