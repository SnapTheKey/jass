package ch.juventus.caesar.models.card;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CardValue {
    ASS(110),
    KING(100),
    WAITER(100),
    FARMER(100),
    BANNER(100),
    NINE(90),
    EIGHT(80),
    SEVEN(70),
    SIX(60);

    int value;
}
