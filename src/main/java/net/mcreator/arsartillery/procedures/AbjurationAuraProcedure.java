package net.mcreator.arsartillery.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.arsartillery.entity.AbjurationTurret3Entity;
import net.mcreator.arsartillery.entity.AbjurationTurret2Entity;
import net.mcreator.arsartillery.entity.AbjurationTurret1Entity;

import com.hollingsworth.arsnouveau.api.util.SourceUtil;

import java.util.List;
import java.util.Comparator;

public class AbjurationAuraProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		int cost = 1;
		if (entity instanceof AbjurationTurret2Entity) cost++;
		if (entity instanceof AbjurationTurret3Entity) cost++;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		final int DURATION = 21*20;
		entity.getPersistentData().putLong("counter1", (entity.getPersistentData().getLong("counter1") + 1));
		if (entity.getPersistentData().getLong("counter1") % (DURATION - 20) == 0) {
			if (SourceUtil.takeSourceWithParticles(entity.blockPosition(), entity.level(), 10, 10 * cost) == null) return;
			if (entity instanceof AbjurationTurret1Entity) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("ars_artillery:turrets")))) {
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, DURATION, 0, false, false));
						}
					}
				}
			} else if (entity instanceof AbjurationTurret2Entity) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("ars_artillery:turrets")))) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, DURATION, 0, false, false));
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, DURATION, 1, false, false));
						}
					}
				}
			} else if (entity instanceof AbjurationTurret3Entity) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("ars_artillery:turrets")))) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, DURATION, 0, false, false));
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, DURATION, 1, false, false));
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, DURATION, 0, false, false));
						}
					}
				}
			}
		}
	}
}
