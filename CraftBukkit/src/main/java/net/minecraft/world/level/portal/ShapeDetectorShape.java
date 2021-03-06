package net.minecraft.world.level.portal;

import net.minecraft.world.phys.Vec3D;

// CraftBukkit start
import net.minecraft.server.level.WorldServer;
import org.bukkit.craftbukkit.event.CraftPortalEvent;
// CraftBukkit end

public class ShapeDetectorShape {

    public final Vec3D pos;
    public final Vec3D speed;
    public final float yRot;
    public final float xRot;
    // CraftBukkit start
    public final WorldServer world;
    public final CraftPortalEvent portalEventInfo;

    public ShapeDetectorShape(Vec3D vec3d, Vec3D vec3d1, float f, float f1, WorldServer world, CraftPortalEvent portalEventInfo) {
        this.world = world;
        this.portalEventInfo = portalEventInfo;
        // CraftBukkit end
        this.pos = vec3d;
        this.speed = vec3d1;
        this.yRot = f;
        this.xRot = f1;
    }
}
