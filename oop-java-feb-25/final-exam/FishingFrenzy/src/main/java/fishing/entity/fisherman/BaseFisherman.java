package fishing.entity.fisherman;

import fishing.common.ExceptionMessages;

public abstract class BaseFisherman implements Fisherman{
    private String name;
    private int harvest;
    private int bait;

    public BaseFisherman(String name, int bait) {
        this.setName(name);
        this.harvest = 0;
        this.setBait(bait);
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessages.FISHERMAN_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int getHarvest() {
        return harvest;
    }

    public void setHarvest(int harvest) {
        this.harvest = harvest;
    }

    @Override
    public int getBait() {
        return bait;
    }

    public void setBait(int bait) {
        this.bait = bait;
    }

    public void fishing() {
        this.harvest++;
        this.bait -= 10;
        if(this.bait < 0) {
            this.bait = 0;
        }
    }

}
