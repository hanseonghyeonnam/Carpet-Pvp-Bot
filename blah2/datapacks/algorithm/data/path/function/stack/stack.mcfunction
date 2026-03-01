execute as Alex store result score @s alex_y run data get entity @s Pos[1]

$execute as $(player) store result score @s player_y run data get entity @s Pos[1]

execute if score Alex alex_y < Blockfog player_y if score Blockfog player_y matches -55.. run function path:stack/run {"player": "$(player)"}