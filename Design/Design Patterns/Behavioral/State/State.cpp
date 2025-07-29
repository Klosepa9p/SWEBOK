#include <iostream>
#include <memory>

// State arayüzü
class State {
public:
    virtual void pressPlay() = 0;
    virtual ~State() = default;
};

// Forward declaration
class MusicPlayer;

// ConcreteState: Oynatılıyor
class PlayingState : public State {
private:
    MusicPlayer* player;
public:
    PlayingState(MusicPlayer* p) : player(p) {}
    void pressPlay() override;
};

// ConcreteState: Duraklatıldı
class PausedState : public State {
private:
    MusicPlayer* player;
public:
    PausedState(MusicPlayer* p) : player(p) {}
    void pressPlay() override;
};

// Context
class MusicPlayer {
private:
    std::unique_ptr<State> state;
public:
    MusicPlayer();
    void setState(std::unique_ptr<State> newState) {
        state = std::move(newState);
    }
    void pressPlay() {
        if (state) {
            state->pressPlay();
        }
    }
    // Bu metodlar, durum değiştirmek için ConcreteState'lerden çağrılır
    void changeToPlaying() {
        setState(std::make_unique<PlayingState>(this));
    }
    void changeToPaused() {
        setState(std::make_unique<PausedState>(this));
    }
};

// PlayingState davranışı
void PlayingState::pressPlay() {
    std::cout << "Music is playing. Now pausing...\n";
    player->changeToPaused();
}

// PausedState davranışı
void PausedState::pressPlay() {
    std::cout << "Music is paused. Now playing...\n";
    player->changeToPlaying();
}

// MusicPlayer constructor: başlangıç durumu
MusicPlayer::MusicPlayer() {
    // Başlangıçta duraklatılmış olsun
    setState(std::make_unique<PausedState>(this));
}

int main() {
    MusicPlayer player;

    player.pressPlay(); // pause -> play
    player.pressPlay(); // play -> pause
    player.pressPlay(); // pause -> play

    return 0;
}