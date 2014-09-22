#pragma once
struct Err{
	string Str;
	unsigned int Line;
};
class Error
{
private:
	vector<Err> errors;
public:
	void Clear();
	void AddError(string err,unsigned int line);
	void PrintErrors();
};
extern Error error;