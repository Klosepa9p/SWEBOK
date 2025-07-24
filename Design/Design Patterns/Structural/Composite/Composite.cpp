#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

// Abstract Component
class Movie {
public:
    virtual void showMovieInfo() = 0;
    virtual ~Movie() = default;
};

// Leaf: Thriller
class Thriller : public Movie {
private:
    int id;
    string name;
    string releaseDate;
    double imdb;

public:
    Thriller(int id, const string& name, const string& releaseDate, double imdb)
        : id(id), name(name), releaseDate(releaseDate), imdb(imdb) {}

    void showMovieInfo() override {
        cout << "Film adı: " << name << endl;
        cout << "Yayın tarihi: " << releaseDate << endl;
        cout << "IMDB: " << imdb << endl;
        cout << "--" << endl;
    }
};

// Leaf: Horror
class Horror : public Movie {
private:
    int id;
    string name;
    string releaseDate;
    double imdb;

public:
    Horror(int id, const string& name, const string& releaseDate, double imdb)
        : id(id), name(name), releaseDate(releaseDate), imdb(imdb) {}

    void showMovieInfo() override {
        cout << "Film adı: " << name << endl;
        cout << "Yayın tarihi: " << releaseDate << endl;
        cout << "IMDB: " << imdb << endl;
        cout << "--" << endl;
    }
};

// Composite: MovieContainer
class MovieContainer : public Movie {
private:
    vector<Movie*> movies;

public:
    void showMovieInfo() override {
        for (auto movie : movies) {
            movie->showMovieInfo();
        }
    }

    void addMovie(Movie* movie) {
        movies.push_back(movie);
    }

    void removeMovie(Movie* movie) {
        movies.erase(remove(movies.begin(), movies.end(), movie), movies.end());
    }

    ~MovieContainer() {
        for (auto movie : movies) {
            delete movie;
        }
    }
};

// Main
int main() {
    // Thriller Container
    MovieContainer* thrillerContainer = new MovieContainer();
    thrillerContainer->addMovie(new Thriller(1, "The Silence of the Lambs", "11 Ekim 1991", 8.6));
    thrillerContainer->addMovie(new Thriller(2, "Basic Instinct", "27 Kasım 1992", 7.0));

    // Horror Container
    MovieContainer* horrorContainer = new MovieContainer();
    horrorContainer->addMovie(new Horror(2, "Scream", "15 Ağustos 1997", 7.4));

    // Master Container
    MovieContainer* container = new MovieContainer();
    container->addMovie(thrillerContainer);
    container->addMovie(horrorContainer);

    // Show all info
    container->showMovieInfo();

    delete container;

    return 0;
}
