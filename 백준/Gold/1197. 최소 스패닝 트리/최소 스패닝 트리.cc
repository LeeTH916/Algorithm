#include <iostream>
#include <vector>
#include <tuple>
#include <algorithm>

using namespace std;

vector <tuple<int, int, int>> tree;
vector<int> _link;
vector<int> _size;
int weight = 0;

bool cmp(tuple<int, int, int> &a, tuple<int, int, int> &b) {
	return get<2>(a) < get<2>(b);
}

int find(int x) {
	if (x == _link[x]) return x;
	return _link[x] = find(_link[x]);
}

bool same(int a, int b) {
	return find(a) == find(b);
}

void unite(int a, int b) {
	a = find(a);
	b = find(b);

	if (a < b) swap(a, b);

	_size[a] += _size[b];
	_link[b] = a;
}

int main() 
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int V, E;
	int A, B, C;

	cin >> V >> E;

	for (int i = 0; i < V; i++) {
		_link.push_back(i);
		_size.push_back(1);
	}

	for (int i = 0; i < E; i++) {
		cin >> A >> B >> C;
		tree.push_back(make_tuple(A - 1, B - 1, C));
	}

	sort(tree.begin(), tree.end(), cmp);

	for (auto a : tree) {
		if (!same(get<0>(a), get<1>(a))) {
			unite(get<0>(a), get<1>(a));
			weight += get<2>(a);
		}
	}

	cout<<weight;
}