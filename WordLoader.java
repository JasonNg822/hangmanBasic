import java.util.Random;

public class WordLoader {

    // first array is choose category
    // second array is choose level 
    // third array is choose word
    public static String [][][] words = {
        {// fruit
            {"apple", "banana", "orange", "kiwi", "grape", "pear", "peach"},
            {"mango", "lychee", "watermelon", "longan", "coconut", "cherry", "papaya"},
            {"strawberry", "jackfruit", "durian", "pineapple", "lemon", "pomelo", "avacado"},
        },
        {// animal
            {"cat", "dog", "bird", "fish", "cow", "lion", "horse"},
            {"tiger", "elephant", "giraffe", "shark", "zebra", "sheep", "monkey"},
            {"mouse", "rabbit", "snake", "chicken", "rhino", "bear", "hippo"},
        },
        {// country
            {"singapore", "malaysia", "thailand", "china", "america", "india", "japan"},
            {"rusia", "australia", "korea", "vietnam", "barzil", "Canada", "france"},
            {"germany", "bangladesh", "philippnes", "portugal", "finland", "italy", "spain"},
        },
        {// sport
            {"jogging", "swimming", "tennis", "badminton", "cycling", "golf", "football"},
            {"hockey", "diving", "baseball", "bowling", "basketball", "pickleball", "diving"},
            {"fencing", "volleyball", "surfing", "archery", "billiards", "gymnastics", "rugby"},
        }
    };

    public static String get_word (int category, int level) {
        
        Random random = new Random();

        String [] category_level = words[category - 1][level - 1];
        int index = random.nextInt(category_level.length);
        
        return category_level[index];
    }
}