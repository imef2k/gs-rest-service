package hello.service;

import org.springframework.stereotype.Service;

import hello.model.WordStatus;

@Service
public class WordStatusService {
	
	private static final int NUMBER_OF_ALPHABET_CHARACTERS = 26;

	public WordStatus evaluateWordStatus(String word){
		WordStatus wordStatus = new WordStatus();
		wordStatus.setWord(word);
		
		wordStatus.setPalindrome(isPalindrome(word.toLowerCase()));
		
		wordStatus.setAnagramOfPalindrome(isAnagramOfPalindrome(word.toLowerCase()));
		return wordStatus;
		
	}

	private boolean isAnagramOfPalindrome(String word) {
		int [] count = new int[NUMBER_OF_ALPHABET_CHARACTERS];
        for( int i = 0; i < word.length(); i++ )
        {
            char ch = word.charAt(i);
            count[ch-'a']++;
        }
        int oddOccur = 0;
        for( int cnt:count )
        {
            if( oddOccur > 1)
                return false;
            if( cnt%2 == 1 )
                oddOccur++;
        }
        return true;
	}

	private boolean isPalindrome(String word) {
		String wordInReverse = new StringBuilder(word).reverse().toString();
		return word.equals(wordInReverse);
	}
}