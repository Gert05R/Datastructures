package textgen;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

/** 
 * An implementation of the MTG interface that uses a list of lists.
 * @author UC San Diego Intermediate Programming MOOC team 
 */
public class MarkovTextGeneratorLoL implements MarkovTextGenerator {

	// The list of words with their next words
	private List<ListNode> wordList; 
	
	// The starting "word"
	private String starter;
	
	// The random number generator
	private Random rnGenerator;
	
	public MarkovTextGeneratorLoL(Random generator)
	{
		wordList = new LinkedList<ListNode>();
		starter = "";
		rnGenerator = generator;
	}
	
	
	/** Train the generator by adding the sourceText */
	@Override
	public void train(String sourceText)
	{
		// TODO: Implement this method
		if (wordList.size() >0) 
		{
			return;
		}
		String [] words = sourceText.split(" ");
		if (words.length == 0) 
		{
			return;
		} 
		//String [] words = sourceText.split(" ");
		starter = words[0];
		String prevWord = starter;
		
		
		for (int i =1; i<words.length; i++) 
		{
			String currentWord = words[i];
			
			ListNode ln = findWord(wordList, prevWord);
			
			if (ln != null) 
			{
				ln.addNextWord(currentWord);
			}
			else 
			{
				ListNode newNode = new ListNode(prevWord);
				newNode.addNextWord(currentWord);
				wordList.add(newNode);
			}
			prevWord = currentWord;
		}
		ListNode lastWord = findWord(wordList, prevWord);
		if (lastWord != null) 
		{
			lastWord.addNextWord(starter);
		}
		else 
		{
			ListNode lastNode = new ListNode(prevWord);
			lastNode.addNextWord(starter);
			wordList.add(lastNode);
		}
	}
		
	
	
	/** 
	 * Generate the number of words requested.
	 */
	@Override
	public String generateText(int numWords) {
	    // TODO: Implement this method
		
		if (numWords == 0) 
		{
			return "";
		}
		
		String currWord = starter;
		String output = "";
		output += currWord + " ";

		for (int i=0; i<numWords-1; i++) 
		{
			if (wordList.size() == 0) 
			{
				return "";
			}
			ListNode currentNode = findWord(wordList, currWord);
			String w = currentNode.getRandomNextWord(rnGenerator);
			output += w + " ";
			currWord = w;
		}
		return output;
	}
	
	
	// Can be helpful for debugging
	@Override
	public String toString()
	{
		String toReturn = "";
		for (ListNode n : wordList)
		{
			toReturn += n.toString();
		}
		return toReturn;
	}
	
	/** Retrain the generator from scratch on the source text */
	@Override
	public void retrain(String sourceText)
	{
		wordList = new LinkedList<ListNode>();
		starter = "";
		train(sourceText);

	}
	
	
	private ListNode findWord(List<ListNode> x, String source) 
	{
		for (ListNode node: x) 
		{
			if (node.getWord().equals(source)) 
			{
				return node;
			}
			
		}
		
		return null;
	}
	
	
	/**
	 * This is a minimal set of tests.  Note that it can be difficult
	 * to test methods/classes with randomized behavior.   
	 * @param args
	 */
	public static void main(String[] args)
	{
		
		/*String testString = "hi there hi Leo";
		MarkovTextGeneratorLoL gen = new MarkovTextGeneratorLoL(new Random(40));
		gen.train(testString);
		System.out.println(gen.toString());
		System.out.println(gen.generateText(4));*/
		
		
		/*for (int j = 0; j<gen.wordList.size(); j++) 
		{
			ListNode test1 = gen.wordList.get(j);
			test1.toString();
			System.out.println("Test2" + test1.toString());
		}*/
		
		
		
		// feed the generator a fixed random value for repeatable behavior
		MarkovTextGeneratorLoL gen = new MarkovTextGeneratorLoL(new Random(42));
		String textString = "Hello.  Hello there.  This is a test.  Hello there.  Hello Bob.  Test again.";
		System.out.println(textString);
		gen.train(textString);
		System.out.println(gen);
		System.out.println(gen.generateText(20));
		String textString2 = "You say yes, I say no, "+
				"You say stop, and I say go, go, go, "+
				"Oh no. You say goodbye and I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"I say high, you say low, "+
				"You say why, and I say I don't know. "+
				"Oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"Why, why, why, why, why, why, "+
				"Do you say goodbye. "+
				"Oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"You say yes, I say no, "+
				"You say stop and I say go, go, go. "+
				"Oh, oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello,";
		System.out.println(textString2);
		gen.retrain(textString2);
		System.out.println(gen);
		System.out.println(gen.generateText(20));
	}

}

/** Links a word to the next words in the list 
 * You should use this class in your implementation. */
class ListNode
{
    // The word that is linking to the next words
	private String word;
	
	// The next words that could follow it
	private List<String> nextWords;
	
	ListNode(String word)
	{
		this.word = word;
		nextWords = new LinkedList<String>();
	}
	
	public String getWord()
	{
		return word;
	}

	public void addNextWord(String nextWord)
	{
		nextWords.add(nextWord);
	}
	
	public String getRandomNextWord(Random generator)
	{
		// TODO: Implement this method
	    // The random number generator should be passed from 
	    // the MarkovTextGeneratorLoL class
		List<String> words= this.nextWords;
		int index = generator.nextInt(words.size());
		String word = words.get(index);
	    return word;
	}

	public String toString()
	{
		String toReturn = word + ": ";
		for (String s : nextWords) {
			toReturn += s + "->";
		}
		toReturn += "\n";
		return toReturn;
	}
	
}


