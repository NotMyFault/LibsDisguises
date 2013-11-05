package me.libraryaddict.disguise.disguisetypes;

import org.bukkit.entity.EntityType;

public class MiscDisguise extends Disguise {
    private int data = -1;
    private int id = -1;

    public MiscDisguise(DisguiseType disguiseType) {
        this(disguiseType, true, -1, -1);
    }

    public MiscDisguise(DisguiseType disguiseType, boolean replaceSounds) {
        this(disguiseType, replaceSounds, -1, -1);
    }

    public MiscDisguise(DisguiseType disguiseType, boolean replaceSounds, int id, int data) {
        if (id == -1)
            id = disguiseType.getDefaultId();
        if (data == -1)
            data = disguiseType.getDefaultData();
        this.id = id;
        this.data = data;
        createDisguise(disguiseType, replaceSounds);
    }

    public MiscDisguise(DisguiseType disguiseType, int id, int data) {
        this(disguiseType, true, id, data);
    }

    @Deprecated
    public MiscDisguise(EntityType entityType) {
        this(entityType, true, -1, -1);
    }

    @Deprecated
    public MiscDisguise(EntityType entityType, boolean replaceSounds) {
        this(entityType, replaceSounds, -1, -1);
    }

    @Deprecated
    public MiscDisguise(EntityType entityType, boolean replaceSounds, int id, int data) {
        if (id == -1)
            id = DisguiseType.getType(entityType).getDefaultId();
        if (data == -1)
            data = DisguiseType.getType(entityType).getDefaultData();
        this.id = id;
        this.data = data;
        createDisguise(DisguiseType.getType(entityType), replaceSounds);
    }

    @Deprecated
    public MiscDisguise(EntityType disguiseType, int id, int data) {
        this(disguiseType, true, id, data);
    }

    public MiscDisguise clone() {
        MiscDisguise disguise = new MiscDisguise(getType(), replaceSounds(), getId(), getData());
        disguise.setViewSelfDisguise(viewSelfDisguise());
        disguise.setHearSelfDisguise(canHearSelfDisguise());
        disguise.setHideArmorFromSelf(isHidingArmorFromSelf());
        disguise.setHideHeldItemFromSelf(isHidingHeldItemFromSelf());
        disguise.setVelocitySent(isVelocitySent());
        disguise.setWatcher(getWatcher().clone());
        return disguise;
    }

    public int getData() {
        return data;
    }

    public int getId() {
        return id;
    }

}