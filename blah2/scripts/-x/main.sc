// 1. Shift + F 감지 (이벤트 리스너)
__on_player_swaps_hands(player) -> (
    if (player ~ 'sneaking',
        _open_menu(player);
        return('cancel');
    )
);

_open_menu(player) -> (
    screen = create_screen(player, 'generic_9x3', format('b 나만의 메뉴'), _(screen, player, action, data) -> (
        if (action == 'pickup' || action == 'quick_move',
            if (data:'slot' == 13,
                run('give ' + player + ' diamond 1');
                sound('entity.experience_orb.pickup', pos(player), 1.0, 1.0);
                close_screen(screen);
                print(player, format('g 다이아몬드를 획득했습니다!'));
            );
            return('cancel');
        );
    ));

    // 1. 다이아몬드 배치
    inventory_set(screen, 13, 1,
        'minecraft:diamond[minecraft:custom_name={"text":"💎 다이아몬드 받기","italic":false,"color":"aqua"},minecraft:lore=[{"text":"클릭하면 다이아 1개를 받습니다.","italic":false,"color":"gray"}]]'
    );

    // 2. 배경 유리판 배치
    loop(27,
        if (inventory_get(screen, _) == null,
            inventory_set(screen, _, 1,
                'minecraft:gray_stained_glass_pane[minecraft:custom_name={"text":""}]'
            );
        )
    );
);