package P06MilitaryElite;

import java.util.Collection;

public interface LieutenantGeneral extends Soldier{
    void addPrivate(Soldier soldier);

    Collection<Soldier> getPrivates();
}
