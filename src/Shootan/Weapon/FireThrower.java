package Shootan.Weapon;

import Shootan.Bullets.AbstractBullet;
import Shootan.Bullets.Flame;
import Shootan.Bullets.SmallBullet;
import Shootan.Units.Unit;

public class FireThrower extends Weapon {

    public FireThrower(Unit owner) {
        super(owner);
    }

    @Override
    protected long getShotDelayMilliseconds() {
        return 50;
    }

    @Override
    protected boolean getIsInSingleShotMode() {
        return false;
    }

    @Override
    protected AbstractBullet shot() {
        return new Flame(owner.getId(), owner.getX(), owner.getY(), owner.getViewAngle());
    }
}