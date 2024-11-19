/mob/living/simple_animal/hostile/cultistmelee
	name = "Blood Cultist"
	desc = "Blood for the blood goddess."
	icon = 'modular_splurt/icons/mobs/vharmob.dmi'
	icon_state = "cultistmelee"
	icon_living = "cultistmelee"
	icon_dead = "idle"
	gender = NEUTER
	speak_chance = 0
	turns_per_move = 2
	turns_per_move = 3
	maxHealth = 150
	health = 150
	see_in_dark = 7
	response_help_continuous  = "pets"
	response_disarm_continuous = "pushes aside"
	response_harm_continuous   = "attacks"
	melee_damage_lower = 20
	melee_damage_upper = 30
	armour_penetration = 10
	attack_verb_continuous = "attacks"
	attack_sound = 'sound/weapons/blade1.ogg'
	faction = list("cult")
	ranged = 0
	harm_intent_damage = 5
	obj_damage = 60
	a_intent = INTENT_HARM
	death_sound = 'sound/voice/ed209_20sec.ogg'
	deathmessage = "lets out scream and explodes in a pile of gibs..."
	move_to_delay = 4
	loot = list(/obj/effect/gibspawner/human)