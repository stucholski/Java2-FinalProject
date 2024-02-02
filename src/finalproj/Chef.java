package finalproj;

public class Chef implements WalkDirections {
    @Override
    public boolean isWalkingEast() {
        return false;


    }

    @Override
    public boolean isWalkingNorth() {
        return  true;
    }

    @Override
    public boolean isWalkingSouth() {
        return false;
    }

    @Override
    public boolean isWalkingWest() {
        return false;
    }
}
