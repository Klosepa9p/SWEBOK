public class Game {
    public void startTurn(int timer, Match match) {
        match.processTurn(timer);
    }
}

public class Match {
    public void processTurn(int timer) {
        field.updatePlayers(timer);
    }
}

public class Field {
    public void updatePlayers(int timer) {
        players.adjustTroops(timer);
    }
}

public class Players {
    public void adjustTroops(int timer) {
        System.out.println("Askerler güncellendi: Zamanlayıcı=" + timer);
    }
}

/*
Sorun: Yukarıdaki kodda, timer parametresi bir Tramp Data örneğidir:

- Game ve Match sınıfları, timer parametresini yalnızca bir sonraki metoda iletmek için alıyor ve kendi içinde kullanmıyor.
- Bu, timer verisinin Game, Match ve Field sınıfları üzerinden gereksiz yere taşındığını gösteriyor, bu da Message Chains'e benzer bir code smell oluşturuyor.
- Kodun okunabilirliği azalıyor ve çağrı zincirinde değişiklik yapmak (örneğin, yeni bir parametre eklemek) tüm metodları etkileyebilir.
*/
