#include "stdafx.h"
#include <string>
#include <vector>
using namespace std;
#include "error.h"
#include "functions.h"
#include "compiler.h"


string Replace(string input,string from,string to)
{
	if(input.length()<1||input=="")
		return"";
   size_t pos=input.find(from);
   while(pos!=string::npos)
   {
       input.replace(pos,from.length(),to);
       pos=input.find(from,pos+to.length()-from.length()+1);
   }
   return input;
}
string CorrectWhiteSpace(string str,string what)
{
	if(str.length()<1||str=="")
		return "";
	str=Replace(str,"<<"," ___SHLEFT ");
	str=Replace(str,">>"," ___SHRIGHT ");
	if(what==""||what=="\n")
	{
		str=Replace(str,"\r"," ");
		if(what!="\n")
			str=Replace(str,"\n"," ");
		str=Replace(str,"\t"," ");
		str=Replace(str,"}","};");
		str=CorrectWhiteSpace(str,"(");
		str=CorrectWhiteSpace(str,")");
		str=CorrectWhiteSpace(str,"{");
		str=CorrectWhiteSpace(str,"}");
		str=CorrectWhiteSpace(str,"[");
		str=CorrectWhiteSpace(str,"]");
		str=CorrectWhiteSpace(str,";");
		str=CorrectWhiteSpace(str,",");
		str=Replace(str,";;",";");
		str=Replace(str,"\\\""," ");
		str=Replace(str,"\\'"," ");
	}else{
		str=Replace(str,what+" ",what);
		str=Replace(str," "+what,what);
	}
	str=Replace(str,"___SHLEFT ","<<");
	str=Replace(str,"___SHRIGHT ",">>");
	str=Replace(str,"  "," ");
	return trim(str);
}
string trim(string input)
{
	if(input.length()<1||input=="")
		return "";
	while(input.length()>1&&input[0]==' '||input[0]=='\t'||input[0]=='\n'||input[0]=='\r')
		input=input.erase(0,1);
	while(input.length()>1&&input[input.length()-1]==' '||input[input.length()-1]=='\t'||input[input.length()-1]=='\n'||input[input.length()-1]=='\r')
		input=input.erase(input.length()-1,1);
	return input;
}
unsigned int start(string str,unsigned int pos)
{
	if (pos<1)
		return 0;
	char c=str[pos-1];
	while( isChar(c) || isNum(c) )
	{
		if(pos==1)
			return 0;
		pos--;
		c=str[pos-1];
	}
	return pos;
}
unsigned int end(string str,unsigned int pos,bool skip)
{
	unsigned int POpen=0,PClose=0;
	for(unsigned int i=pos+1; i<=str.length(); i++)
	{
		char tmp=str[i];
		if(tmp=='(')
			POpen++;
		if(tmp==')')
			PClose++;
		if (PClose>POpen || (PClose==POpen && tmp==',' && !skip))
			return i-1;
	}
	return str.length();
}
unsigned int GetPos(string str,unsigned int pos,bool goleft)
{
	unsigned int dOpen=0,dClose=0;
	int j=pos+(goleft?-1:1);
	char c;
	while( true )
	{
		if(j>=(int)str.length())
			return j;
		if(j<0)
			return 0;
		c=str[j];
		if(c=='(')
			dOpen++;
		if(c==')')
			dClose++;
		if( !isChar(c) && !isNum(c) && dOpen==0 && dClose==0 )
			return goleft?j+1:j;
		if(dOpen==dClose && dOpen!=0)
			return j;
		if((!goleft && dOpen<dClose) || (goleft && dOpen>dClose))
			return j+1;
		if(goleft)j--;
		else j++;
	}
	return pos;
}
string Correct(string input)
{
	vector<string> from;
	from.push_back("*");
	from.push_back("/");
	from.push_back("%");
	input=ChangeOperators(input,from,"___SET1");
	from.clear();
	from.push_back("+");
	from.push_back("-");
	input=ChangeOperators(input,from,"___SET2");
	from.clear();
	from.push_back(">");
	from.push_back("<");
	from.push_back("<=");
	from.push_back(">=");
	input=ChangeOperators(input,from,"___SET3");
	from.clear();
	from.push_back("==");
	from.push_back("!=");
	input=ChangeOperators(input,from,"___SET3");
	from.clear();
	from.push_back("=");
	input=ChangeOperators(input,from,"___EQQ");
	return Replace(input,"___SET2(,","___SET2(0,");
}
string ChangeOperators(string str,vector<string> from,string to)
{
	str="("+str+")";
	str=CorrectWhiteSpace(str);
	for(unsigned int i=0;i<from.size();i++)
		str=CorrectWhiteSpace(str,from[i]);
	str=trim(str);
	unsigned int ppos,pos;
	int which;
	while( true )
	{
		which=-1;
		pos=str.length();
		for(unsigned int i=0;i<from.size();i++)
		{
			ppos=str.find(from[i]);
			if(ppos!=string::npos && ppos<pos)
			{
				pos=ppos;
				which=i;
			}
		}
		if(which<0)
			break;
		str=str.replace(pos,from[which].length(),",");
		str=str.insert(GetPos(str,pos,false),")");
		int h=GetPos(str,pos,true)-1;
		if(h>=0){
			for(char temp=str[h];(isChar(temp) || isNum(temp) || temp==')' || temp=='.') && h>=0;h--)
			{
				if(h<=0)
				{
					h=-1;
					break;
				}
				temp=str[h-1];
			}
		}
		str=str.insert(h+1,to+"(");
		//str=str.insert(end(str,pos),")");
		//str=str.insert(start(str,pos),to);
	}
	return str.substr(1,str.length()-2);
}
bool isChar(char input)
{
	if( (input>='a' && input<='z') || (input>='A' && input<='Z') || input=='_' )
		return true;
	return false;
}
bool isNum(char input)
{
	if(input>='0' && input<='9')
		return true;
	return false;
}
bool isName(string input)
{
	if(isReserved(input))
		return false;
	if(!isChar(input[0]))
		return false;
	for(unsigned int i=1;i<input.size();i++)
	{
		if( !isChar(input[i]) && !isNum(input[i]) )
			return false;
	}
	return true;
}
bool isInt(string input)
{
	for(unsigned int i=0;i<input.size();i++)
	{
		if(!isNum(input[i]) )
			return false;
	}
	return true;
}
bool isFloat(string input)
{
	bool gotDot=false;
	for(unsigned int i=0;i<input.size();i++)
	{
		if(!isNum(input[i]) )
		{
			if(input[i]=='.' && !gotDot)
				gotDot=true;
			else
				return false;
		}
	}
	return true;
}
bool isBool(string input)
{
	if(input=="true"||input=="false"||input=="0"||input=="1")
		return true;
	return false;
}
bool isChar(string input)
{
	if(isInt(input))
		return true;
	if(input.length()==3&&input[0]=='\''&&input[2]=='\'')
		return true;
	if(input.length()==4&&input[0]=='\''&&input[1]=='\\'&&input[3]=='\'')
		return true;
	return false;
}
bool isString(string input)
{
	if(input.length()>2&&input[0]=='"'&&input[input.length()-1]=='"'&&input.substr(1,input.length()-2).find("\"")!=string::npos)
		return true;
	return false;
}
bool isConst(string input)
{
	if(isInt(input) || isFloat(input) || isBool(input) || isChar(input))
		return true;
	return false;
}
bool isReserved(string input)
{
	return (input=="true"||input=="false"||input=="int"||input=="float"||input=="double"||input=="char"||input=="bool"||input=="void"||input=="if"||input=="else"||input=="for"||input=="while"||input=="cin"||input=="cout");
}
int checkParanteses(string input)
{
	unsigned int pOpen=0,pClose=0;
	for(unsigned int i=0;i<input.length();i++)
	{
		if(input[i]=='(')
			pOpen++;
		if(input[i]==')')
			pClose++;
		if(pClose>pOpen)
			return 1;
	}
	if(pOpen>pClose)
		return -1;
	return 0;
}
vector<string> Split(string input,char what,bool DontPass)
{
	vector<string> output;
	output.clear();
	if(input==""||input==")"||input=="]"||input=="}")
		return output;
	if(input[input.length()-1]!=what)
		input.push_back(what);
	unsigned int Open[3]={0,0,0},Close[3]={0,0,0},pos=0;
	for(unsigned int i=0;i<input.length();i++)
	{
		if(!DontPass)
		{
			if(input[i]=='(')
				Open[0]++;
			if(input[i]==')')
				Close[0]++;
			if(input[i]=='{')
				Open[1]++;
			if(input[i]=='}')
				Close[1]++;
			if(input[i]=='[')
				Open[2]++;
			if(input[i]==']')
				Close[2]++;
			if(Open[0]>Close[0] || Open[1]>Close[1] || Open[2]>Close[2])
				continue;
			if(Close[0]>Open[0] || Close[1]>Open[1] || Close[2]>Open[2])
			{
				output.push_back(input.substr(pos,i-pos));
				return output;
			}
		}
		if(input[i]==what)
		{
			output.push_back(input.substr(pos,i-pos));
			pos=i+1;
		}
	}
	return output;
}
unsigned int endOfCode(string code)
{
	if(code==""||code==")"||code=="]"||code=="}")
		return string::npos;
	unsigned int Open[2]={0,0},Close[2]={0,0},pos=0;
	bool Quote[2]={false,false};
	for(unsigned int i=0;i<code.length();i++)
	{
		if(code[i]=='(')
			Open[0]++;
		if(code[i]==')')
			Close[0]++;
		if(code[i]=='{')
			Open[1]++;
		if(code[i]=='}')
			Close[1]++;
		if(code[i]=='"'&&!Quote[1])
			Quote[0]=!Quote[0];
		if(code[i]=='\''&&!Quote[0])
			Quote[1]=!Quote[1];
		if(Quote[0]||Quote[1])
			continue;
		if(Open[0]>Close[0] || Open[1]>Close[1])
			continue;
		if(Close[0]>Open[0] || Close[1]>Open[1])
			return i;
		if(code[i]==';' || (Open[1]==Close[1] && Open[1]>0) )
			return i;
	}
	return string::npos;
}

string Remove(string input,string start,string end)
{
	unsigned int pos=input.find(start),pos2;
	if(pos==string::npos)
		return input;
	pos2=input.find(end,pos+start.length());
	if(pos2==string::npos)
		pos2=input.length()-1;
	else
		pos2+=end.length();
	string from=input.substr(pos,pos2-pos),to="";
	unsigned int lines=0,i;
	for(i=0;i<from.length();i++)
	{
		if(from[i]=='\n')
			to+="\n";
	}
	input=Replace(input,from,to);
	return Remove(input,start,end);
}
string toString(System::String^ input)
{
	string output;
	using namespace System::Runtime::InteropServices;
	const char* chars=(const char*)(Marshal::StringToHGlobalAnsi(input)).ToPointer();
	output=chars;
	Marshal::FreeHGlobal(System::IntPtr((void*)chars));
	return output;
}
