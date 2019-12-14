/*
 * GameController.java             1.0.0   2019-12-12
 *
 * Copyright (c) 2019 Hyungju An.
 * All rights reserved.
 * Contact me for more information. a301dks@naver.com
 */

package com.precourse.blackjack.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.precourse.blackjack.domain.game.Game;
import com.precourse.blackjack.domain.user.Player;
import com.precourse.blackjack.domain.util.InputUtil;
import com.precourse.blackjack.view.InputView;
import com.precourse.blackjack.view.OutputView;

/**
 * 게임 컨트롤러 클래스입니다.
 *
 * @author HyungjuAn
 */
public class GameController {
	public static void startGame() {
		Game game = new Game(initializePlayers());
		//game.start();
	}

	public static List<Player> initializePlayers() {
		List<Player> players = new ArrayList<>();
		List<String> playersName = getPlayersName();
		List<Double> playersBettingMoney = new ArrayList<>(); // getPlayersBettingMoney();

		for (int i = 0; i < playersName.size(); i++) {
			players.add(new Player(playersName.get(i), playersBettingMoney.get(i)));
		}

		return players;
	}

	public static List<String> getPlayersName() {
		List<String> playersName;

		try {
			InputView.printPlayerNameQuestion();
			playersName = InputUtil.readPlayersName();
		} catch (IOException e) {
			OutputView.printWrongPlayerNameInput();
			return getPlayersName();
		}
		return playersName;
	}
}