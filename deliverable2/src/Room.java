

public class Room {



    private static int pseudoRand = 0;
    private String description = null;

    private boolean northExit = false;
    private boolean southExit = false;

    private boolean hasSugar = false;
    private boolean hasCream = false;
    private boolean hasCoffee = false;

    public Room(boolean hasCoffee,
                boolean hasCream,
                boolean hasSugar,
                boolean northExit,
                boolean southExit) {
        this.hasCoffee = hasCoffee;
        this.hasCream = hasCream;
        this.hasSugar = hasSugar;
        this.northExit = northExit;
        this.southExit = southExit;
        description = generateDescription();
    }

    public boolean hasItem() {
        return hasSugar || hasCream || hasCoffee;
    }

    public boolean hasSugar() {
        return hasSugar;
    }

    public boolean hasCream() {
        return hasCream;
    }

    public boolean hasCoffee() {
        return hasCoffee;
    }

    public boolean northExit() {
        return northExit;
    }

    public boolean southExit() {
        return southExit;
    }


    private String getAdjective() {
        String[] adjs = { "Small",  "Quaint",
                "Shiny", "Magenta", "Funny", "Sad", "Fuchsia", "Beige", "Massive", "Refinanced", "Tight", "Loose",
                "Dead", "Smart", "Dumb", "Flat", "Bumpy", "Vivacious",
                "Slim", "Bloodthirsty", "Beautiful",
                "Flowery", "Purple", "Sandy", "Rough",
                "Perfect", "Heroic", "Minimalist", "Shoe-Losing", "Major",
                "Wonderful", "Loving", "Fun-Loving",
                "High-Level", "Functional","Static", "Dynamic",
                "Fast", "Bulletproof", "Late", "Silly",
                "Salty", "Sour",
                "Chair-Adjusting", "Brave", "Forgetful", "Chair-Sitting", "Mind-Blowing", "Crazy",
                "Funny", "Birdlike", "Bird-Brained", "Miniature",
                "High-Strung", "Famous", "Light", "Dark", "Feral", "Hairy",
                "Leaky", "Criminal", "Sassy", "Frumpy", "Tiny",
                "Prehistoric", "Metallic", "Sharp", "Historical", "Fierce", "Loud",
                "Lunar", "Bohemian", "Bored", "Suspicious",
                "Flirtatious", "Street-Smart", "Forgetful",
                "Tooth-Filled", "Ravenous",
                "Well-Directed", "Well-Fed", "Well-Maintained", "Deep", "Shallow",
                "Victorian", "Formal", "Creamy", "Tangy", "Fresh", "Magical", "Mystical",
                "Secret", "Prophetic", "Immortal", "Far-Sighted",
                "Short-Sighted",  "Latin", "Nepalese",  "Medical",
                "Straightforward", "Literary", "Critical", "Backward", "Rabid", "Bombastic",
                "Smelly", "Wanton", "Confusing", "Cheesy",
                "Devious", "Pumpkin Spice", "Submerged", "Muscular",
                "Well-Organized", "Smooth", "Delicious", "Creamy", "Dry",
                "Independent", "Free", "Cheap", "Diaphonous", "Tired",
                "Sultry", "Beguiling", "Long-Lived", "Repetitive",
                "Disgusting", "Swampy", "Dirty", "Muddy", "Clean", "Dry", "Wet",
                "Clear", "Transparent", "Glorious", "Sacrificial", "Electric", "Mechanical",
                "Automatic", "Rapid", "Nervous", "Calm", "Contemplative",
                "Cerebral", "Voracious", "Starving", "Full", "Killer", "Wicked", "Rational", "Real",
                "Homemade", "Cigar-Chomping", "Sinister", "Doubting",
                "Robotic", "Monosyllabic", "Maniacal", "Postmodern", "Prehistoric" };
        return adjs[(pseudoRand++ % adjs.length)];
    }

    private String getNoun() {
        String[] nouns = { "kettle", "sink", "sofa", "plant", "elephant", "bird cage", "record player", "picture of a ghost",
                "picture of a dog", "dresser", "book", "pizza", "cake", "pinball game",
                "slug", "board game", "energy drink", "jack o' lantern", "fireplace",
                "pumpkin spice latte", "copy machine", "bag of money", "stapler",
                "bottle", "xylophone", "tablecloth", "air hockey table", "textbook", "dog", "duck", "programmer",
                "radish", "clock", "carpet", "rug", "stamp collection"};
        return nouns[(pseudoRand++ % nouns.length)];
    }

    private String generateDescription() {
        String toReturn = "\nYou see a " + getAdjective() + " room.\n"
                + "It has a " + getAdjective() + " " + getNoun() + ".\n";

        if (northExit) {
            toReturn += "A " + getAdjective() + " door leads North.\n";
        }

        if (southExit) {
            toReturn += "A " + getAdjective() + " door leads South.\n";
        }

        return toReturn;

    }

    public String getDescription() {
        return description;
    }



}