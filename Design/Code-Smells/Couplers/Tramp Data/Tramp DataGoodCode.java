public class Game {
    private final Match match;

    public Game(Match match) {
        this.match = match;
    }

    public void startTurn() {
        match.processTurn();
    }
}

public class Match {
    private final Field field;

    public Match(Field field) {
        this.field = field;
    }

    public void processTurn() {
        field.updatePlayers();
    }
}

public class Field {
    private final Players players;
    private final Timer timer;

    public Field(Players players, Timer timer) {
        this.players = players;
        this.timer = timer;
    }

    public void updatePlayers() {
        players.adjustTroops(timer.getValue());
    }
}

public class Players {
    public void adjustTroops(int timerValue) {
        System.out.println("Askerler güncellendi: Zamanlayıcı=" + timerValue);
    }
}

public class Timer {
    private final int value;

    public Timer(int value) {
        this.value = value;
    }

    public int getValue() { return value; }
}

// Kullanım örneği
public class Main {
    public static void main(String[] args) {
        Timer timer = new Timer(100);
        Players players = new Players();
        Field field = new Field(players, timer);
        Match match = new Match(field);
        Game game = new Game(match);
        
        game.startTurn();
    }
}

/*
Açıklama: Düzeltilmiş kodda, Tramp Data sorunu şu şekilde giderildi:

- Veriyi Kapsülle: timer verisi, Timer sınıfı olarak kapsüllendi ve yalnızca Field sınıfında kullanılıyor, böylece gereksiz parametre geçişi ortadan kalktı.
- Metodu Taşı: timer verisinin kullanımı, gerçekten ihtiyaç duyulan Field sınıfına taşındı, böylece Game ve Match sınıfları bu veriyi taşımak zorunda kalmadı.
- Bağımlılık Enjeksiyonu: Timer, Field sınıfına constructor aracılığıyla enjekte edildi, bu da bağımlılıkları açık hale getirdi.
- Sorumluluk Ayrımı: Her sınıf, kendi sorumluluğuna odaklandı: Game oyunu başlatıyor, Match turu işliyor, Field oyuncuları güncelliyor ve Timer zamanlayıcıyı tutuyor.
- Sadeleştirme: Gereksiz parametreler kaldırılarak metod imzaları sadeleştirildi ve kodun okunabilirliği artırıldı.

Bu değişiklikler, kodun modülerliğini, okunabilirliğini ve bakım kolaylığını artırdı. Gereksiz veri geçişi kaldırılarak Tramp Data code smell'i ortadan kaldırıldı.
*/

