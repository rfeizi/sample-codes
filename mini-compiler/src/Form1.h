#pragma once
#include<vcclr.h>
#include<fstream>
#include <string>
#include <iostream>
#include <vector>
using namespace std;
#include "error.h"
#include "functions.h"
#include "compiler.h"


using namespace std;






namespace p {

	using namespace System;
	using namespace System::ComponentModel;
	using namespace System::Collections;
	using namespace System::Windows::Forms;
	using namespace System::Data;
	using namespace System::Drawing;
	using namespace System:: IO;


	/// <summary>
	/// Summary for Form1
	///
	/// WARNING: If you change the name of this class, you will need to change the
	///          'Resource File Name' property for the managed resource compiler tool
	///          associated with all .resx files this class depends on.  Otherwise,
	///          the designers will not be able to interact properly with localized
	///          resources associated with this form.
	/// </summary>
	public ref class Form1 : public System::Windows::Forms::Form
	{
	public:
		Form1(void)
		{
			InitializeComponent();
			//
			//TODO: Add the constructor code here
			//
		}

	protected:
		/// <summary>
		/// Clean up any resources being used.
		/// </summary>
		~Form1()
		{
			if (components)
			{
				delete components;
			}
		}
	private: System::Windows::Forms::MenuStrip^  menuStrip1;
	protected: 
	private: System::Windows::Forms::ToolStripMenuItem^  fileToolStripMenuItem2;
	private: System::Windows::Forms::ToolStripMenuItem^  editToolStripMenuItem;
	private: System::Windows::Forms::ToolStripMenuItem^  compileToolStripMenuItem2;
	private: System::Windows::Forms::ToolStripMenuItem^  compileToolStripMenuItem3;
	private: System::Windows::Forms::ToolStripMenuItem^  newToolStripMenuItem;
	private: System::Windows::Forms::ToolStripMenuItem^  openToolStripMenuItem;
	private: System::Windows::Forms::ToolStripMenuItem^  saveToolStripMenuItem;
	private: System::Windows::Forms::ToolStripMenuItem^  saveAsToolStripMenuItem;
	private: System::Windows::Forms::ToolStripMenuItem^  exitToolStripMenuItem;
	private: System::Windows::Forms::ToolStripMenuItem^  commentToolStripMenuItem;
	private: System::Windows::Forms::ToolStripMenuItem^  uncommentToolStripMenuItem;
	private: System::Windows::Forms::ToolStripMenuItem^  tabularToolStripMenuItem;
	private: System::Windows::Forms::ToolStripMenuItem^  generateMethodToolStripMenuItem;
	private: System::Windows::Forms::ToolStripMenuItem^  debugToolStripMenuItem;
	private: System::Windows::Forms::ToolStripMenuItem^  stepIntoToolStripMenuItem;

	private: System::Windows::Forms::ToolStripMenuItem^  helpToolStripMenuItem;
	private: System::Windows::Forms::ToolStripMenuItem^  stepOverF11ToolStripMenuItem;
	private: System::Windows::Forms::ToolStripMenuItem^  watchToolStripMenuItem;
	private: System::Windows::Forms::ToolStripMenuItem^  autosToolStripMenuItem;
	private: System::Windows::Forms::ToolStripMenuItem^  aboutToolStripMenuItem;
	private: System::Windows::Forms::StatusStrip^  statusStrip1;
	private: System::Windows::Forms::ToolStripStatusLabel^  toolStripStatusLabel1;
	private: System::Windows::Forms::TabControl^  tabControl1;
	private: System::Windows::Forms::TabPage^  tabPage1;
	private: System::Windows::Forms::TabPage^  tabPage2;
	private: System::Windows::Forms::TabPage^  tabPage3;
	private: System::Windows::Forms::TextBox^  textBox1;
	private: System::Windows::Forms::TextBox^  textBox2;
	private: System::Windows::Forms::SaveFileDialog^  saveFileDialog1;



	protected: 







	protected: 


	protected: 

	protected: 

	protected: 


	protected: 


	protected: 


	protected: 

	protected: 

	protected: 

	protected: 

	protected: 

	protected: 









	protected: 

	protected: 

	protected: 

	protected: 

	protected: 

	protected: 

	protected: 



	protected: 
	private: System::ComponentModel::IContainer^  components;

	protected: 

	protected: 



	private:
		/// <summary>
		/// Required designer variable.
		/// </summary>


#pragma region Windows Form Designer generated code
		/// <summary>
		/// Required method for Designer support - do not modify
		/// the contents of this method with the code editor.
		/// </summary>
		void InitializeComponent(void)
		{
			this->menuStrip1 = (gcnew System::Windows::Forms::MenuStrip());
			this->fileToolStripMenuItem2 = (gcnew System::Windows::Forms::ToolStripMenuItem());
			this->newToolStripMenuItem = (gcnew System::Windows::Forms::ToolStripMenuItem());
			this->openToolStripMenuItem = (gcnew System::Windows::Forms::ToolStripMenuItem());
			this->saveToolStripMenuItem = (gcnew System::Windows::Forms::ToolStripMenuItem());
			this->saveAsToolStripMenuItem = (gcnew System::Windows::Forms::ToolStripMenuItem());
			this->exitToolStripMenuItem = (gcnew System::Windows::Forms::ToolStripMenuItem());
			this->editToolStripMenuItem = (gcnew System::Windows::Forms::ToolStripMenuItem());
			this->commentToolStripMenuItem = (gcnew System::Windows::Forms::ToolStripMenuItem());
			this->uncommentToolStripMenuItem = (gcnew System::Windows::Forms::ToolStripMenuItem());
			this->tabularToolStripMenuItem = (gcnew System::Windows::Forms::ToolStripMenuItem());
			this->generateMethodToolStripMenuItem = (gcnew System::Windows::Forms::ToolStripMenuItem());
			this->compileToolStripMenuItem2 = (gcnew System::Windows::Forms::ToolStripMenuItem());
			this->compileToolStripMenuItem3 = (gcnew System::Windows::Forms::ToolStripMenuItem());
			this->debugToolStripMenuItem = (gcnew System::Windows::Forms::ToolStripMenuItem());
			this->stepIntoToolStripMenuItem = (gcnew System::Windows::Forms::ToolStripMenuItem());
			this->stepOverF11ToolStripMenuItem = (gcnew System::Windows::Forms::ToolStripMenuItem());
			this->watchToolStripMenuItem = (gcnew System::Windows::Forms::ToolStripMenuItem());
			this->autosToolStripMenuItem = (gcnew System::Windows::Forms::ToolStripMenuItem());
			this->helpToolStripMenuItem = (gcnew System::Windows::Forms::ToolStripMenuItem());
			this->aboutToolStripMenuItem = (gcnew System::Windows::Forms::ToolStripMenuItem());
			this->statusStrip1 = (gcnew System::Windows::Forms::StatusStrip());
			this->toolStripStatusLabel1 = (gcnew System::Windows::Forms::ToolStripStatusLabel());
			this->tabControl1 = (gcnew System::Windows::Forms::TabControl());
			this->tabPage1 = (gcnew System::Windows::Forms::TabPage());
			this->tabPage2 = (gcnew System::Windows::Forms::TabPage());
			this->tabPage3 = (gcnew System::Windows::Forms::TabPage());
			this->textBox1 = (gcnew System::Windows::Forms::TextBox());
			this->textBox2 = (gcnew System::Windows::Forms::TextBox());
			this->saveFileDialog1 = (gcnew System::Windows::Forms::SaveFileDialog());
			this->menuStrip1->SuspendLayout();
			this->statusStrip1->SuspendLayout();
			this->tabControl1->SuspendLayout();
			this->SuspendLayout();
			// 
			// menuStrip1
			// 
			this->menuStrip1->Items->AddRange(gcnew cli::array< System::Windows::Forms::ToolStripItem^  >(5) {this->fileToolStripMenuItem2, 
				this->editToolStripMenuItem, this->compileToolStripMenuItem2, this->debugToolStripMenuItem, this->helpToolStripMenuItem});
			this->menuStrip1->Location = System::Drawing::Point(0, 0);
			this->menuStrip1->Name = L"menuStrip1";
			this->menuStrip1->Size = System::Drawing::Size(490, 24);
			this->menuStrip1->TabIndex = 2;
			this->menuStrip1->Text = L"menuStrip1";
			this->menuStrip1->ItemClicked += gcnew System::Windows::Forms::ToolStripItemClickedEventHandler(this, &Form1::menuStrip1_ItemClicked);
			// 
			// fileToolStripMenuItem2
			// 
			this->fileToolStripMenuItem2->DropDownItems->AddRange(gcnew cli::array< System::Windows::Forms::ToolStripItem^  >(5) {this->newToolStripMenuItem, 
				this->openToolStripMenuItem, this->saveToolStripMenuItem, this->saveAsToolStripMenuItem, this->exitToolStripMenuItem});
			this->fileToolStripMenuItem2->Name = L"fileToolStripMenuItem2";
			this->fileToolStripMenuItem2->Size = System::Drawing::Size(37, 20);
			this->fileToolStripMenuItem2->Text = L"File";
			this->fileToolStripMenuItem2->Click += gcnew System::EventHandler(this, &Form1::fileToolStripMenuItem2_Click);
			// 
			// newToolStripMenuItem
			// 
			this->newToolStripMenuItem->Name = L"newToolStripMenuItem";
			this->newToolStripMenuItem->Size = System::Drawing::Size(112, 22);
			this->newToolStripMenuItem->Text = L"New";
			this->newToolStripMenuItem->Click += gcnew System::EventHandler(this, &Form1::newToolStripMenuItem_Click);
			// 
			// openToolStripMenuItem
			// 
			this->openToolStripMenuItem->Name = L"openToolStripMenuItem";
			this->openToolStripMenuItem->Size = System::Drawing::Size(112, 22);
			this->openToolStripMenuItem->Text = L"Open";
			this->openToolStripMenuItem->Click += gcnew System::EventHandler(this, &Form1::openToolStripMenuItem_Click);
			// 
			// saveToolStripMenuItem
			// 
			this->saveToolStripMenuItem->Name = L"saveToolStripMenuItem";
			this->saveToolStripMenuItem->Size = System::Drawing::Size(112, 22);
			this->saveToolStripMenuItem->Text = L"Save";
			this->saveToolStripMenuItem->Click += gcnew System::EventHandler(this, &Form1::saveToolStripMenuItem_Click);
			// 
			// saveAsToolStripMenuItem
			// 
			this->saveAsToolStripMenuItem->Name = L"saveAsToolStripMenuItem";
			this->saveAsToolStripMenuItem->Size = System::Drawing::Size(112, 22);
			this->saveAsToolStripMenuItem->Text = L"Save as";
			this->saveAsToolStripMenuItem->Click += gcnew System::EventHandler(this, &Form1::saveAsToolStripMenuItem_Click);
			// 
			// exitToolStripMenuItem
			// 
			this->exitToolStripMenuItem->Name = L"exitToolStripMenuItem";
			this->exitToolStripMenuItem->Size = System::Drawing::Size(112, 22);
			this->exitToolStripMenuItem->Text = L"Exit";
			// 
			// editToolStripMenuItem
			// 
			this->editToolStripMenuItem->DropDownItems->AddRange(gcnew cli::array< System::Windows::Forms::ToolStripItem^  >(4) {this->commentToolStripMenuItem, 
				this->uncommentToolStripMenuItem, this->tabularToolStripMenuItem, this->generateMethodToolStripMenuItem});
			this->editToolStripMenuItem->Name = L"editToolStripMenuItem";
			this->editToolStripMenuItem->Size = System::Drawing::Size(39, 20);
			this->editToolStripMenuItem->Text = L"Edit";
			// 
			// commentToolStripMenuItem
			// 
			this->commentToolStripMenuItem->Name = L"commentToolStripMenuItem";
			this->commentToolStripMenuItem->Size = System::Drawing::Size(166, 22);
			this->commentToolStripMenuItem->Text = L"Comment";
			// 
			// uncommentToolStripMenuItem
			// 
			this->uncommentToolStripMenuItem->Name = L"uncommentToolStripMenuItem";
			this->uncommentToolStripMenuItem->Size = System::Drawing::Size(166, 22);
			this->uncommentToolStripMenuItem->Text = L"Uncomment";
			// 
			// tabularToolStripMenuItem
			// 
			this->tabularToolStripMenuItem->Name = L"tabularToolStripMenuItem";
			this->tabularToolStripMenuItem->Size = System::Drawing::Size(166, 22);
			this->tabularToolStripMenuItem->Text = L"Tabular";
			// 
			// generateMethodToolStripMenuItem
			// 
			this->generateMethodToolStripMenuItem->Name = L"generateMethodToolStripMenuItem";
			this->generateMethodToolStripMenuItem->Size = System::Drawing::Size(166, 22);
			this->generateMethodToolStripMenuItem->Text = L"Generate Method";
			// 
			// compileToolStripMenuItem2
			// 
			this->compileToolStripMenuItem2->DropDownItems->AddRange(gcnew cli::array< System::Windows::Forms::ToolStripItem^  >(1) {this->compileToolStripMenuItem3});
			this->compileToolStripMenuItem2->Name = L"compileToolStripMenuItem2";
			this->compileToolStripMenuItem2->Size = System::Drawing::Size(64, 20);
			this->compileToolStripMenuItem2->Text = L"Compile";
			// 
			// compileToolStripMenuItem3
			// 
			this->compileToolStripMenuItem3->Name = L"compileToolStripMenuItem3";
			this->compileToolStripMenuItem3->Size = System::Drawing::Size(119, 22);
			this->compileToolStripMenuItem3->Text = L"Compile";
			this->compileToolStripMenuItem3->Click += gcnew System::EventHandler(this, &Form1::compileToolStripMenuItem3_Click);
			// 
			// debugToolStripMenuItem
			// 
			this->debugToolStripMenuItem->DropDownItems->AddRange(gcnew cli::array< System::Windows::Forms::ToolStripItem^  >(4) {this->stepIntoToolStripMenuItem, 
				this->stepOverF11ToolStripMenuItem, this->watchToolStripMenuItem, this->autosToolStripMenuItem});
			this->debugToolStripMenuItem->Name = L"debugToolStripMenuItem";
			this->debugToolStripMenuItem->Size = System::Drawing::Size(54, 20);
			this->debugToolStripMenuItem->Text = L"Debug";
			// 
			// stepIntoToolStripMenuItem
			// 
			this->stepIntoToolStripMenuItem->Name = L"stepIntoToolStripMenuItem";
			this->stepIntoToolStripMenuItem->Size = System::Drawing::Size(151, 22);
			this->stepIntoToolStripMenuItem->Text = L"Step Into(F11)";
			// 
			// stepOverF11ToolStripMenuItem
			// 
			this->stepOverF11ToolStripMenuItem->Name = L"stepOverF11ToolStripMenuItem";
			this->stepOverF11ToolStripMenuItem->Size = System::Drawing::Size(151, 22);
			this->stepOverF11ToolStripMenuItem->Text = L"Step Over(F11)";
			// 
			// watchToolStripMenuItem
			// 
			this->watchToolStripMenuItem->Name = L"watchToolStripMenuItem";
			this->watchToolStripMenuItem->Size = System::Drawing::Size(151, 22);
			this->watchToolStripMenuItem->Text = L"Watch";
			// 
			// autosToolStripMenuItem
			// 
			this->autosToolStripMenuItem->Name = L"autosToolStripMenuItem";
			this->autosToolStripMenuItem->Size = System::Drawing::Size(151, 22);
			this->autosToolStripMenuItem->Text = L"Autos";
			// 
			// helpToolStripMenuItem
			// 
			this->helpToolStripMenuItem->DropDownItems->AddRange(gcnew cli::array< System::Windows::Forms::ToolStripItem^  >(1) {this->aboutToolStripMenuItem});
			this->helpToolStripMenuItem->Name = L"helpToolStripMenuItem";
			this->helpToolStripMenuItem->Size = System::Drawing::Size(44, 20);
			this->helpToolStripMenuItem->Text = L"Help";
			// 
			// aboutToolStripMenuItem
			// 
			this->aboutToolStripMenuItem->Name = L"aboutToolStripMenuItem";
			this->aboutToolStripMenuItem->Size = System::Drawing::Size(107, 22);
			this->aboutToolStripMenuItem->Text = L"About";
			// 
			// statusStrip1
			// 
			this->statusStrip1->Items->AddRange(gcnew cli::array< System::Windows::Forms::ToolStripItem^  >(1) {this->toolStripStatusLabel1});
			this->statusStrip1->Location = System::Drawing::Point(0, 394);
			this->statusStrip1->Name = L"statusStrip1";
			this->statusStrip1->Size = System::Drawing::Size(490, 22);
			this->statusStrip1->TabIndex = 3;
			this->statusStrip1->Text = L"statusStrip1";
			// 
			// toolStripStatusLabel1
			// 
			this->toolStripStatusLabel1->Name = L"toolStripStatusLabel1";
			this->toolStripStatusLabel1->Size = System::Drawing::Size(59, 17);
			this->toolStripStatusLabel1->Text = L"Status bar";
			// 
			// tabControl1
			// 
			this->tabControl1->Controls->Add(this->tabPage1);
			this->tabControl1->Controls->Add(this->tabPage2);
			this->tabControl1->Controls->Add(this->tabPage3);
			this->tabControl1->Location = System::Drawing::Point(0, 282);
			this->tabControl1->Name = L"tabControl1";
			this->tabControl1->SelectedIndex = 0;
			this->tabControl1->Size = System::Drawing::Size(490, 109);
			this->tabControl1->TabIndex = 4;
			// 
			// tabPage1
			// 
			this->tabPage1->Location = System::Drawing::Point(4, 22);
			this->tabPage1->Name = L"tabPage1";
			this->tabPage1->Padding = System::Windows::Forms::Padding(3);
			this->tabPage1->Size = System::Drawing::Size(482, 83);
			this->tabPage1->TabIndex = 0;
			this->tabPage1->Text = L"Consol";
			this->tabPage1->UseVisualStyleBackColor = true;
			this->tabPage1->Click += gcnew System::EventHandler(this, &Form1::tabPage1_Click);
			// 
			// tabPage2
			// 
			this->tabPage2->Location = System::Drawing::Point(4, 22);
			this->tabPage2->Name = L"tabPage2";
			this->tabPage2->Padding = System::Windows::Forms::Padding(3);
			this->tabPage2->Size = System::Drawing::Size(482, 83);
			this->tabPage2->TabIndex = 1;
			this->tabPage2->Text = L"Watch";
			this->tabPage2->UseVisualStyleBackColor = true;
			// 
			// tabPage3
			// 
			this->tabPage3->Location = System::Drawing::Point(4, 22);
			this->tabPage3->Name = L"tabPage3";
			this->tabPage3->Padding = System::Windows::Forms::Padding(3);
			this->tabPage3->Size = System::Drawing::Size(482, 83);
			this->tabPage3->TabIndex = 2;
			this->tabPage3->Text = L"Autos";
			this->tabPage3->UseVisualStyleBackColor = true;
			this->tabPage3->Click += gcnew System::EventHandler(this, &Form1::tabPage3_Click);
			// 
			// textBox1
			// 
			this->textBox1->Location = System::Drawing::Point(12, 27);
			this->textBox1->Multiline = true;
			this->textBox1->Name = L"textBox1";
			this->textBox1->ScrollBars = System::Windows::Forms::ScrollBars::Both;
			this->textBox1->Size = System::Drawing::Size(276, 235);
			this->textBox1->TabIndex = 5;
			this->textBox1->TextChanged += gcnew System::EventHandler(this, &Form1::textBox1_TextChanged);
			this->textBox1->KeyPress += gcnew System::Windows::Forms::KeyPressEventHandler(this, &Form1::textBox1_KeyPress);
			// 
			// textBox2
			// 
			this->textBox2->Location = System::Drawing::Point(294, 49);
			this->textBox2->Multiline = true;
			this->textBox2->Name = L"textBox2";
			this->textBox2->ReadOnly = true;
			this->textBox2->ScrollBars = System::Windows::Forms::ScrollBars::Both;
			this->textBox2->Size = System::Drawing::Size(137, 227);
			this->textBox2->TabIndex = 6;
			this->textBox2->TextChanged += gcnew System::EventHandler(this, &Form1::textBox2_TextChanged);
			// 
			// saveFileDialog1
			// 
			this->saveFileDialog1->FileOk += gcnew System::ComponentModel::CancelEventHandler(this, &Form1::saveFileDialog1_FileOk);
			// 
			// Form1
			// 
			this->AutoScaleDimensions = System::Drawing::SizeF(6, 13);
			this->AutoScaleMode = System::Windows::Forms::AutoScaleMode::Font;
			this->ClientSize = System::Drawing::Size(490, 416);
			this->Controls->Add(this->textBox2);
			this->Controls->Add(this->textBox1);
			this->Controls->Add(this->tabControl1);
			this->Controls->Add(this->statusStrip1);
			this->Controls->Add(this->menuStrip1);
			this->MainMenuStrip = this->menuStrip1;
			this->Name = L"Form1";
			this->Text = L"Form1";
			this->Load += gcnew System::EventHandler(this, &Form1::Form1_Load);
			this->KeyPress += gcnew System::Windows::Forms::KeyPressEventHandler(this, &Form1::Form1_KeyPress);
			this->menuStrip1->ResumeLayout(false);
			this->menuStrip1->PerformLayout();
			this->statusStrip1->ResumeLayout(false);
			this->statusStrip1->PerformLayout();
			this->tabControl1->ResumeLayout(false);
			this->ResumeLayout(false);
			this->PerformLayout();

		}
#pragma endregion
		
		


	private: System::Void Form1_Load(System::Object^  sender, System::EventArgs^  e) {			 }
	private: System::Void vScrollBar1_Scroll(System::Object^  sender, System::Windows::Forms::ScrollEventArgs^  e) {
			 }
			 bool To_string( String^ source, string &target )
{
	pin_ptr<const wchar_t> wch = PtrToStringChars( source );
	int len = (( source->Length+1) * 2);
	char *ch = new char[ len ];
	bool result = wcstombs( ch, wch, len ) != -1;
	target = ch;
	delete ch;
	return result;
}
private: System::Void newToolStripMenuItem_Click(System::Object^  sender, System::EventArgs^  e) {
			 string s;
			 //textBox1->Clear();
			 //textBox1->AppendText("salam");
			 			 //string s;
			 /*To_string(textBox1->Text,s);
			 s.erase(3);
			 String^ f=gcnew String(s.c_str());
			 textBox1->Clear();
			 textBox1->AppendText(f);*/
			 /*To_string(textBox1->Text,s);
			 String^ f=gcnew String(s.c_str());
			// textBox1->Clear();
			 textBox2->AppendText(textBox1->Text);*/
			 char *temp = new char[textBox1->Text->Length];
			 int m;
			 for(m=0; m<textBox1->Text->Length; m++)
			 {
				 temp[m] = textBox1->Text->ToCharArray()[m];
			 }
			 temp[m] = 0;
			 string string1(temp);
			String^ f=gcnew String(string1.c_str());
			 textBox2->AppendText(f);

		 }

		 
		 
private: System::Void textBox1_TextChanged(System::Object^  sender, System::EventArgs^  e) {
			 /* char *s=new char[textBox1->Text->Length+1];
			 int i;
			 for(i=0; i<textBox1->Text->Length; i++)
			 {
				 s[i] = textBox1->Text->ToCharArray()[i];
			 }
			 s[i] = 0;
			 string a;
			ToString();*/
			  //string s;
			 
			 //s.erase(3);


			/* char *temp = new char[textBox1->Text->Length];
			 int m;
			 for(m=0; m<textBox1->Text->Length; m++)
			 {
				 temp[m] = textBox1->Text->ToCharArray()[m];
			 }
			 temp[m] = 0;
			 string string1(temp);
			String^ f=gcnew String(string1.c_str());
			 textBox2->AppendText(f);*/
			 

			 

			
			 

				
			
			 
			
		 }
private: System::Void tabPage1_Click(System::Object^  sender, System::EventArgs^  e) {
			 
			
		 }



		 string replaceit(string input,string from,string to)
{
   size_t pos=input.find(from);
   while(pos!=string::npos)
   {
       input.replace(pos,from.length(),to);
       pos=input.find(from,pos+to.length()-from.length()+1);
   }
   return input;
}

private: System::Void compileToolStripMenuItem3_Click(System::Object^  sender, System::EventArgs^  e) {
	string str;
	str=toString(textBox1->Text);
	str=CorrectWhiteSpace(str,"\n");
	Block global(initGlobal());
	global.Compile(str);
	error.PrintErrors();
}
private: System::Void saveAsToolStripMenuItem_Click(System::Object^  sender, System::EventArgs^  e) {
		

			 Stream^ myStream;
 SaveFileDialog^ saveFileDialog1 = gcnew SaveFileDialog; 
saveFileDialog1->Filter = "C files (*.C)|*.C"; 
saveFileDialog1->FilterIndex = 2; 
saveFileDialog1->RestoreDirectory = true; 
if ( saveFileDialog1->ShowDialog() ==::System::Windows::Forms:: DialogResult:: OK ) {
	if ( (myStream = saveFileDialog1->OpenFile()) != nullptr )
 { 
	 StreamWriter^ swFromFileStream = gcnew StreamWriter(myStream ); 
	swFromFileStream->Write(textBox1->Text);                                                   
     swFromFileStream->Flush(); 
     swFromFileStream->Close();

}
}
		 
		 







		 }
private: System::Void fileToolStripMenuItem2_Click(System::Object^  sender, System::EventArgs^  e) {
		 }
private: System::Void contextMenuStrip1_Opening(System::Object^  sender, System::ComponentModel::CancelEventArgs^  e) {
		 }
private: System::Void menuStrip1_ItemClicked(System::Object^  sender, System::Windows::Forms::ToolStripItemClickedEventArgs^  e) {
		 }
private: System::Void Form1_KeyPress(System::Object^  sender, System::Windows::Forms::KeyPressEventArgs^  e) {
			 
		 }
private: System::Void textBox1_KeyPress(System::Object^  sender, System::Windows::Forms::KeyPressEventArgs^  e) {
			// textBox1->Clear();
		 }
private: System::Void textBox2_TextChanged(System::Object^  sender, System::EventArgs^  e) {
		 }
private: System::Void saveToolStripMenuItem_Click(System::Object^  sender, System::EventArgs^  e) {



		 }
private: System::Void openToolStripMenuItem_Click(System::Object^  sender, System::EventArgs^  e) {
			 Stream^ myStream;
      OpenFileDialog^ openFileDialog1 = gcnew OpenFileDialog;

      openFileDialog1->InitialDirectory = "c:\\";
      openFileDialog1->Filter = "C files (*.C)|*.C";
      openFileDialog1->FilterIndex = 2;
      openFileDialog1->RestoreDirectory = true;

	  if ( openFileDialog1->ShowDialog() == ::System::Windows::Forms::DialogResult::OK )
	  {
         if ( (myStream = openFileDialog1->OpenFile()) != nullptr )
         {
			 textBox1->Text = File::ReadAllText(openFileDialog1->FileName);
            // Insert code to read the stream here.
			  
            myStream->Close();
         }
      }

		 }
private: System::Void openFileDialog1_FileOk(System::Object^  sender, System::ComponentModel::CancelEventArgs^  e) {
		 }
private: System::Void saveFileDialog1_FileOk(System::Object^  sender, System::ComponentModel::CancelEventArgs^  e) {

		 }
private: System::Void tabPage3_Click(System::Object^  sender, System::EventArgs^  e) {
		 }
		 
};


