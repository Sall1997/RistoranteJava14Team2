public enum Tipo {
    VEGANO("VEGANO", ColorEnum.BLUE),
    VEGETARIANO("VEGETARIANO", ColorEnum.GREEN),
    SENZA_GLUTINE("SENZA GLUTINE", ColorEnum.YELLOW),
    EMPTY(" " ,ColorEnum.RESET);
    private String info;
    private ColorEnum color;
    Tipo (String info, ColorEnum color) {
        this.info = info;
        this.color = color;
    }
    public String getNome(){
        return info;
    }
    public String printWithColor() {
        return color.getEscapeSequence() + info + ColorEnum.RESET.getEscapeSequence();
    }
}
