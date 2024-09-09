package com.labs1904;


import java.util.HashMap;
import java.util.Map;

public class SecretRecipeDecoder {
    private static Map<String, String> ENCODING = new HashMap<String, String>() {
        {
            put("y", "a");
            put("h", "b");
            put("v", "c");
            put("x", "d");
            put("k", "e");
            put("p", "f");
            put("z", "g");
            put("s", "h");
            put("a", "i");
            put("b", "j");
            put("e", "k");
            put("w", "l");
            put("u", "m");
            put("q", "n");
            put("n", "o");
            put("l", "p");
            put("m", "q");
            put("f", "r");
            put("o", "s");
            put("i", "t");
            put("g", "u");
            put("j", "v");
            put("t", "w");
            put("d", "x");
            put("r", "y");
            put("c", "z");
            put("3", "0");
            put("8", "1");
            put("4", "2");
            put("0", "3");
            put("2", "4");
            put("7", "5");
            put("5", "6");
            put("9", "7");
            put("1", "8");
            put("6", "9");
        }
    };

    /**
     * Given a string named str, use the Caesar encoding above to return the decoded string.
     * @param str
     * @return
     */
    public static String decodeString(String str) {
        // TODO: implement me
        String return_string = "";
        for(my_char in str){
            return_string += ENCODING.get(my_char);
        }
        return return_string;
    }

    /**
     * Given an ingredient, decode the amount and description, and return a new Ingredient
     * @param line
     * @return
     */
    public static Ingredient decodeIngredient(String line) {
        // TODO: implement me
        int split = line.indexOf("#");
        return new Ingredient(decodeString(line.substring(0,split)), decodeString(line.substring(split+1,line.length())));
    }

    public static void main(String[] args) {
        // TODO: implement me
        Scanner scanner = new Scanner(new File("secret_recipe.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("decoded_recipe.txt"));

		while (scanner.hasNextLine()) {
            new Ingredient nextIng = decodeIngredient(scanner.nextLine());
			writer.write(nextIng.getAmount + " " + nextIng.getDescription);
            writer.newLine();
		}

		scanner.close();
        writer.close();
    }
}
