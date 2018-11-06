#include <cstdlib>
#include <iostream>
#include <cmath>

/*
 *       3
 *    1    32
 *   0 2 17  56
 *
 *   3 1 32 0 2 17 56
 */

enum order
{
	PRE = 0,
	IN = 1,
	POST = 2,
	LEVEL = 3,
};

struct node
{
	int value;
	node* left;
	node* right;

	node(int i)
		: value(i)
		, left(nullptr)
		, right(nullptr)
	{}

	void insert(int i)
	{
		if(i <= value)
		{
			if(left == nullptr) 
				left = new node(i);
			else
				left->insert(i);
		}
		else
		{
			if(right == nullptr)
				right = new node(i);
			else
				right->insert(i);
		}
	}

	void print(const order o, int level = 0) const
	{
		switch(o)
		{
			case order::PRE: 
				if(left != nullptr) left->print(o);
				if(right != nullptr) right->print(o);
				std::cout << value << " ";
				break;

			case order::IN:
				if(left != nullptr) left->print(o);
				std::cout << value << " ";
				if(right != nullptr) right->print(o);
				break;

			case order::POST:
				std::cout << value << " ";
				if(left != nullptr) left->print(o);
				if(right != nullptr) right->print(o);
				break;

			case order::LEVEL:
				if(level == 0) std::cout << value << " ";
				if(level > 0) 
				{
					if(left != nullptr) left->print(o, level - 1);
					if(right != nullptr) right->print(o, level - 1);
				}
				break;
		}
	}

	int height() const
	{
		return 1 + std::max(
				  left == nullptr ? 0 : left->height(), 
				  right == nullptr ? 0 : right->height());
	}

	void flip()
	{
		auto tmp = left;
		left = right;
		right = tmp;

		if(left != nullptr) left->flip();
		if(right != nullptr) right->flip();
	}
};

struct bintree
{
	bintree()
		: root(nullptr)
	{}

	~bintree()
	{}

	node* root;
	
	void insert(int i)
	{
		if(root == nullptr)
			root = new node(i);
		else
			root->insert(i);
	}

	void print(const order o) const
	{
		if(root != nullptr)
			if(o != order::LEVEL)
				root->print(o);
			else 
				for(int i = 0; i < root->height(); i++)
					root->print(o, i);
		std::cout << std::endl;
	}

	void flip()
	{
		if(root != nullptr)
			root->flip();
	}
};

int main(int argc, char** argv)
{
	bintree b;
	for(int i = 1; i < argc; i++)
	{
		b.insert(std::atoi(argv[i]));
	}

	b.print(order::PRE);
	b.print(order::IN);
	b.print(order::POST);
	b.print(order::LEVEL);
	b.flip();

	b.print(order::PRE);
	b.print(order::IN);
	b.print(order::POST);
	b.print(order::LEVEL);

	return 0;
}

