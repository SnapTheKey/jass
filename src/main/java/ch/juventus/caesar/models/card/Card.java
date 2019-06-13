package ch.juventus.caesar.models.card;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Card {
    ACORN_ASS(CardColor.ACORN, CardValue.ASS),
    ACORN_KING(CardColor.ACORN, CardValue.KING),
    ACORN_WAITER(CardColor.ACORN, CardValue.WAITER),
    ACORN_FRAMER(CardColor.ACORN, CardValue.FARMER),
    ACORN_BANNER(CardColor.ACORN, CardValue.BANNER),
    ACORN_NINE(CardColor.ACORN, CardValue.NINE),
    ACORN_EIGHT(CardColor.ACORN, CardValue.EIGHT),
    ACORN_SEVEN(CardColor.ACORN, CardValue.SEVEN),
    ACORN_SIX(CardColor.ACORN, CardValue.SIX),

    ROSE_ASS(CardColor.ROSE, CardValue.ASS),
    ROSE_KING(CardColor.ROSE, CardValue.KING),
    ROSE_WAITER(CardColor.ROSE, CardValue.WAITER),
    ROSE_FRAMER(CardColor.ROSE, CardValue.FARMER),
    ROSE_BANNER(CardColor.ROSE, CardValue.BANNER),
    ROSE_NINE(CardColor.ROSE, CardValue.NINE),
    ROSE_EIGHT(CardColor.ROSE, CardValue.EIGHT),
    ROSE_SEVEN(CardColor.ROSE, CardValue.SEVEN),
    ROSE_SIX(CardColor.ROSE, CardValue.SIX),

    SHIELD_ASS(CardColor.SHIELD, CardValue.ASS),
    SHIELD_KING(CardColor.SHIELD, CardValue.KING),
    SHIELD_WAITER(CardColor.SHIELD, CardValue.WAITER),
    SHIELD_FRAMER(CardColor.SHIELD, CardValue.FARMER),
    SHIELD_BANNER(CardColor.SHIELD, CardValue.BANNER),
    SHIELD_NINE(CardColor.SHIELD, CardValue.NINE),
    SHIELD_EIGHT(CardColor.SHIELD, CardValue.EIGHT),
    SHIELD_SEVEN(CardColor.SHIELD, CardValue.SEVEN),
    SHIELD_SIX(CardColor.SHIELD, CardValue.SIX),

    BELL_ASS(CardColor.BELL, CardValue.ASS),
    BELL_KING(CardColor.BELL, CardValue.KING),
    BELL_WAITER(CardColor.BELL, CardValue.WAITER),
    BELL_FRAMER(CardColor.BELL, CardValue.FARMER),
    BELL_BANNER(CardColor.BELL, CardValue.BANNER),
    BELL_NINE(CardColor.BELL, CardValue.NINE),
    BELL_EIGHT(CardColor.BELL, CardValue.EIGHT),
    BELL_SEVEN(CardColor.BELL, CardValue.SEVEN),
    BELL_SIX(CardColor.BELL, CardValue.SIX);

    private CardColor color;
    private CardValue value;
}
