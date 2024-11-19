/mob/living/simple_animal/hostile/deth
	name = "Deth"
	desc = "A normal humanoid-looking person, he has a nametag that reads 'Deth' around their neck and a sickening look on his eyes."
	icon = 'modular_splurt/icons/mobs/vharmob.dmi'
	icon_state = "deth"
	icon_living = "deth"
	icon_dead = "idle"
	gender = NEUTER
	speak_chance = 10
	speak = list("mm hmmm", "Shhhhh", "Come on now, don't make me break up the place~" )
	turns_per_move = 1
	turns_per_move = 2
	maxHealth = 150
	health = 150
	see_in_dark = 7
	response_help_continuous  = "pets"
	response_disarm_continuous = "pushes aside"
	response_harm_continuous   = "attacks"
	melee_damage_lower = 30
	melee_damage_upper = 40
	armour_penetration = 10
	attack_verb_continuous = "attacks"
	attack_sound = 'sound/weapons/blade1.ogg'
	faction = list("cult")
	ranged = 0
	harm_intent_damage = 10
	obj_damage = 60
	a_intent = INTENT_HARM
	death_sound = 'sound/voice/ed209_20sec.ogg'
	deathmessage = "kneels down, looks you in the eyes and explodes in a pile of gibs..."
	move_to_delay = 2
	loot = list(/obj/effect/gibspawner/human)
	zone_selected = "head"