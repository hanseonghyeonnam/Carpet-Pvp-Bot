__config() -> {
	'commands' -> {
		'' -> 'main',
		'set' -> 'set_player_help',
		'set <target>' -> 'set_player'
	}
};

_set_player_task(t) -> {
	run('/player ' + t + ' attack once');
	run('/player ' + t + ' look at ' + x + ' ' + y + ' ' + z);
};

main() -> {
	texts = [
		'r =================\n',
		'g Auto-Player 1.0\n',
		'g Features:\n',
		'g Auto-Farm\n',
		'g Pvp-pratice\n',
		'g ...And more!\n',
		'r =================\n'
	];
	print(format(texts));
};

set_player_help() -> {
	texts = [
		'g Fake player setting command!'
	];
	print(format(texts));
};

set_player(target) -> {
	if (player(target) != null,
		print('Now setting player: ' + target);
		task('_set_player_task', target);
	,
		print('Player not found: ' + target);
	);
};