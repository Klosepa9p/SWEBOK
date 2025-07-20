#include <iostream>
#include <vector>
#include <string>
using namespace std;

class Player {
public:
    Player(string name) : name(name) {}

    void show() {
        cout << "Player: " << name << endl;
    }

    string name;
};

class Team {
public:
    void addPlayer(Player* p) {
        players.push_back(p);
    }

    void showPlayers() {
        cout << "Team players:" << endl;
        for (auto p : players) {
            p->show();
        }
    }

private:
    vector<Player*> players; // Aggregation: Player nesnelerini tutar ama sahip olmaz
};

int main() {
    Player p1("Alice");
    Player p2("Bob");

    Team team1;
    team1.addPlayer(&p1);
    team1.addPlayer(&p2);

    team1.showPlayers();

    return 0;
}