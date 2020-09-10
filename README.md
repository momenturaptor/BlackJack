# BlackJack

This program simulates Blackjack games and implements basic strategy and two different card counting techniques:
Knockout and High-Low.  Unlike other simulators which use the expected values per hand, this program generates
cards and plays the game like a real casino game.  This can be used to tell you the odds of winning Blackjack
(winning is defined by doubling your bankroll before going bankrupt) or can be used to find the optimal betting
spread.

Blackjack Rules: Blackjack pays 3:2, Dealer stands on soft 17, no doubling after splitting.  Deck Penetration is 75%.

Betting: The bet will always be the minimum bet entered until the count exceeds +1.  The bet is then calculated as
minimum * (count^multiplier).  Multiplier is inputted by the user (recommended between .5 and 2.5).

Annotated Mode: Use to verify program is playing and counting correctly.  Will simulate 1000 hands and print out the
bet, count, player and dealer hands.  Cannot use annotated mode when finding optimal betting spread.

Additional notes: splitting is resolved by discarding the top card and doubling the initial bet, only one hand is played.
The program will run out of memory after 100 billion hands played recommended that bankroll<1500*minimum bet.  The
simulation does not buy insurance or use any other indicies.
