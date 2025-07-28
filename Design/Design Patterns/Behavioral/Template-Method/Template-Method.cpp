#include <iostream>

class Game {
public:
    // Template Method
    void play() {
        initialize();
        startPlay();
        endPlay();
    }

protected:
    virtual void initialize() = 0;
    virtual void startPlay() = 0;
    virtual void endPlay() = 0;
};

class Football : public Game {
protected:
    void initialize() override {
        std::cout << "Football Game Initialized.\n";
    }
    void startPlay() override {
        std::cout << "Football Game Started.\n";
    }
    void endPlay() override {
        std::cout << "Football Game Finished.\n";
    }
};

class Basketball : public Game {
protected:
    void initialize() override {
        std::cout << "Basketball Game Initialized.\n";
    }
    void startPlay() override {
        std::cout << "Basketball Game Started.\n";
    }
    void endPlay() override {
        std::cout << "Basketball Game Finished.\n";
    }
};

int main() {
    Game* game = new Football();
    game->play();
    delete game;

    game = new Basketball();
    game->play();
    delete game;

    return 0;
}