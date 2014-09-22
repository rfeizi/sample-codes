#include "stdafx.h"
#include <string>
#include <vector>
using namespace std;
#include "error.h"
#include "functions.h"
#include "compiler.h"

void Error::Clear()
{
	errors.clear();
}
void Error::AddError(string err,unsigned int line)
{
	Err tmp;
	tmp.Str=err;
	tmp.Line=line;
	errors.push_back(tmp);
}
void Error::PrintErrors()
{
	System::IO::StreamWriter^ file=gcnew System::IO::StreamWriter("output.txt");
	for(unsigned int i=0;i<errors.size();i++)
	{
		file->Write("-> Error: ");
		System::String ^ out=gcnew System::String(errors[i].Str.c_str());
		file->Write(out);
		file->Write(" (at line: ");
		if(errors[i].Line==0)
			file->Write("unknown");
		else
			file->Write(System::Int32(errors[i].Line).ToString());
		file->Write(")\r\n");
	}
	file->Close();
}

Error error;