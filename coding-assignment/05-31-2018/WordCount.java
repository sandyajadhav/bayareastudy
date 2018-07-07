public class WordCount{
	public static void main(String args[]){
		String s = "I want to walk my dog, cat, and tarantula; maybe even my tortoise.";
		System.out.println(s);
        //The regex means that the delimiters will be anything that is not a word [\W], in groups of at least one [+]. 
        //Because [+] is greedy, it will take for instance ';' and ' ' together as one delimiter.
		String [] words = s.split("\\W+");//
		
		for(String word : words){
			System.out.println(word);
		}
	}
}