package javacollections.maintask.stones;

public enum StoneTransparency {
    COLORLESS(0),
    EXTREMELY_LIGHT(1),
    VERY_LIGHT(2),
    LIGHT_COLOURED(3),
    MEDIUM_LIGHT(4),
    MEDIUM(5),
    MEDIUM_CLOUDY(6),
    CLOUDY(7),
    VERY_CLOUDY(8),
    EXTREMELY_CLOUDY(9),
    IMPENETRABLE(10);

    public int typeNumberScale;

    StoneTransparency(int typeNumberScale) {
        this.typeNumberScale = typeNumberScale;
    }
}
