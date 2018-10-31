
#include <iostream>
#include <string>
#include <algorithm>

bool are_permutations(std::string a, std::string b);

int main(int argc, char** argv)
{
	if(argc != 3)
	{
		std::cout << "Input exactly two strings." << std::endl;
		return 1;
	}

	std::string left(argv[1]);
	std::string right(argv[2]);

	std::cout << left << " and " << right 
		<< " are" << (are_permutations(left, right) ? " " : " not ") << "permutations." << std::endl;
	return 0;
}

bool are_permutations(std::string a, std::string b)
{
	if(a.length() != b.length()) 
		return false;

	std::sort(a.begin(), a.end());
	std::sort(b.begin(), b.end());

	for(auto i = 0; i < a.length(); i++)
	{
		if(a[i] != b[i]) return false;
	}
	return true;
}

