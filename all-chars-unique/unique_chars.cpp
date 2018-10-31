
#include <iostream>
#include <string>
#include <algorithm>

bool find_if_all_unique(std::string);

int main(int argc, char** argv)
{
	if(argc <= 1)
	{
		std::cout << "Input exactly one string." << std::endl;
		return 1;
	}

	std::string word(argv[1]);

	std::cout << find_if_all_unique(word) << std::endl;
	return 0;
}

bool find_if_all_unique(std::string word)
{
	std::sort(word.begin(), word.end());

	char compare = word[0];
	for(auto c : word.substr(1))
	{
		if(compare == c) 
			return false;
		
		compare = c;
	}

	return true;
}

