
#include <string>
#include <iostream>

char* urlify(char* word_, int length)
{
	std::string word(word_);
	char* result = (char *) malloc(word.length());

	if(result != nullptr)
	{
		int j = 0;
		for(int i = 0; i < length; i++)
		{
			if(word[i] != ' ')
			{
				result[j] = word[i];
				j++;
			}
			else
			{
				result[j++] = '%';
				result[j++] = '2';
				result[j++] = '0';
			}
		}
	}

	return result;
}

int main(int argc, char** argv)
{
	if(argc < 3)
	{
		std::cout << "Expected: word, length." << std::endl;
		return 1;
	}

	char* word = argv[1];
	int length = std::atoi(argv[2]);

	std::cout << "\"" << word << "\"" << std::endl;
	std::cout << length << std::endl;
	std::cout << "\"" << urlify(word, length) << "\"" << std::endl;
	return 0;
}

