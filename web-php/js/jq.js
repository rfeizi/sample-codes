






var clicked;
var x,y,y2,yt,yt2;
var closing;
closing=false;
clicked=false;
count=3000;
addlable=false;

var a,b;
var lables=new Array();
var c;
var search_mode;//check kardane halate addi ba search
search_mode=false;
var courses=new Array();
var searchText;
unitNumbers=0;
courseNumbers=0;




var flag=0;
var names = [];
var deps=[];


function show_db()
{
	//alert("show db called");
	$.ajax({
               type: "POST",
               url: "../actions/show_zamanbandi.php",
              //data: "name="+this.name+"&start="+this.start+"&end="+this.end+"&day="+this.day,
			  //start_time,end_time,day,name
               success: function(msg){   
                 //alert(msg);
				 labelInfo=msg.split('*');
				for(z=0;z<labelInfo.length-1;z++){
					splitedLabel=labelInfo[z].split('-');
					
				
					my_name=splitedLabel[0];
					//alert(my_name);
					my_start_time=splitedLabel[1];
					my_end_time=splitedLabel[2];
					my_day=splitedLabel[3];
					//tagDay2=splitedLabel[4];
					//tagId=splitedLabel[5];
					//alert(tagName+" "+tagStart+" "+tagend+" "+tagDay1+" "+tagDay2);
					//splitedTagStart=tagStart.split(':');
					
					
					//alert("tagID= "+tagId);
					//alert("length: "+tags.length);
					lables[lables.length]=new Lable(my_start_time,my_end_time,my_day,my_name);
					lables[lables.length-1].draw();
					
					//$("#col"+day1).append("<div class='mytag' id='mytag"+this.id+"' style='top:"+tagTop+"px;height:"+height+"px'><img id='close' style='cursor:pointer;margin-top:10px;left=0px;' onclick='tags["+this.id+"].remove()' width=20px; height=20px; src='images/Windows Close Program Icon.jpg'/><br/><img  width='40px' height='40px' src='images/"+this.department+".png'/>"+this.name+"</div>");
					//$("#col"+day2).append("<div class='mytag' id='mytag"+this.id+"' style='top:"+tagTop+"px;height:"+height+"px'><img id='close' style='cursor:pointer;margin-top:10px;left=0px;' onclick='tags["+this.id+"].remove()' width=20px; height=20px; src='images/Windows Close Program Icon.jpg'/><br/><img  width='40px' height='40px' src='images/"+this.department+".png'/>"+this.name+"</div>");
				}
					}
             });
}



function search_name()
{
	
	
		st=$("#searchtext").val();
	searchText=st;
	
	
	for(i=0;i<courses.length;i++)
	{
	
		if(courses[i].name==st)
		{
		
			
				flag=1;
			
			
											
		}
		
		
	}
	
		if(flag==1)
		{
		
			$("body").append("<div id='mask'></div>");
			$("body").append("<div id='searchwindow_name'><p><form name='combobox2'><select id='secondcomboselect' onchange='showCourse3(this.form)'><option>...</option><option> مهندسی کامپیوتر</option><option> مهندسی برق </option><option> صنایع </option></select></form></p><p><form name='listbox2'><select id='secondselect'  size='10'></select ></form></p><p><button onclick='showSearchedNameLable()' class='buttone2' id='OK'>افزودن به برنامه</button><button onclick='cancel_window_search2() 'class='buttone2' id='OK'>لغو</button></p></div>;");
			
					
			
				
				
					
	}
			
			
	if(flag==0)
		alert("درسی با این نام یافت نشد");

}


function showSearchedNameLable()
{

	temp=document.forms[3].elements[0].value;

	for(i=0;i<courses.length;i++)
	{
		if(courses[i].name==searchText && courses[i].dep==temp)
		{
			lables[lables.length] = new Lable(courses[i].start,courses[i].end,courses[i].day,courses[i].name);
						
						lables[lables.length-1].draw ();
		
		
		
		}
		
		
	
	
	
	}
	
	$("#searchwindow_name").remove();
	$("#mask").remove();


}







	



//marboot be jostojoo zamani
//vaghti az darsi ke search shode zamanesh, mikhaym barchasb ezafe konim
function tagAfterSearch()
{



document.body.style.cursor="default";

var depname=document.forms[1].elements[0].value;
var coursename=document.forms[4].elements[0].value;	
var st,et,day;
for(i=0;i<courses.length;i++)
{
 if(courses[i].name==coursename)
 {
	
	st=courses[i].start;
	et=courses[i].end;
	day=courses[i].day;
	lables[lables.length] = new Lable(st,et,day,coursename);
					 
					 
 lables[lables.length-1].draw ();
	
 }
 
 
 
}




 search_mode=false;
 
 $(".searchwindow").remove();
 $(".searchwindow_time").remove();
$("#mask").remove();
$("#start").remove();
$("#start").remove();




}


//tooye panjereye jostojoo , dars ha motabeghe daneshkade biad
function showCourse(form)
{

	//for clearing select area
	
	//clearing the area
		var str=document.getElementById('huhu');
		
			
		var options=str.getElementsByTagName("option");
		
	
		for (i=options.length-1; i>=0; i--)
		{
		str.removeChild(options[i]);
		
		
		}

	/*temp=document.forms[1].elements[0].value;
	alert(temp);
	if(temp=="ریاضی")
	{
		uni_id= "http://81.31.167.195:8081/edu/newLessonList/newLessonsList.jsp?depID=22";
		alert(uni_id);
	}
	if(temp=="مهندسی کامپیوتر")
	{
		uni_id="http://81.31.167.195:8081/edu/newLessonList/newLessonsList.jsp?depID=40";;
		alert(uni_id);
	}
	if(temp=="فیزیک")
	{
		uni_id="http://81.31.167.195:8081/edu/newLessonList/newLessonsList.jsp?depID=24";
		alert(uni_id);
	}
	if(temp=="معارف")
	{
		uni_id="http://81.31.167.195:8081/edu/newLessonList/newLessonsList.jsp?depID=37";
		alert(uni_id);
	}
	if(temp=="تربیت بدنی")
	{
		uni_id="http://81.31.167.195:8081/edu/newLessonList/newLessonsList.jsp?depID=30";
		alert(uni_id);
	}
	
	
	$.ajax({
			
           type: "POST",
           url: "actions/department.php",
		   data: "code="+uni_id,
           success: function(msg)
           {
				
			   alert(msg);
           }
         });
	
	
	
	
	
	
	//clearing the area
		var str=document.getElementById('huhu');
		
			
		var options=str.getElementsByTagName("option");
		
	
		for (i=options.length-1; i>=0; i--)
		{
		str.removeChild(options[i]);
		
		
		}*/
		
		
	
	
		/*for(i=0;i<courses.length;i++)
	{
	
		
	
			
	
		if(courses[i].dep==temp)
		{
		
		$("#huhu").append("<option>"+courses[i].name+"</option>");
		
		
			
	
		}
				
	}*/
}





//tooye panjereye jostoojo darsa motabegh ba daneshkade biad
function showCourse2(form)
{

	temp=form.elements[0].value;
	
	//clearing the area
	
			
		var str2=document.getElementById('secondselect');
		
		var options=str2.getElementsByTagName("option");
		
		for (i=options.length-1; i>=0; i--)
		{
		
		
		str2.removeChild(options[i]);
		}
	
	
		for(i=0;i<courses.length;i++)
	{
	
					
		if(courses[i].dep==temp)
		{
		
			
		
			if(courses[i].day==b)
			
			{
				
				if(courses[i].start>=y && courses[i].end<y2)
					
					$("#secondselect").append("<option>"+courses[i].name+"</option>");
		}
											
		}
				
		
		
		
	}



}
function showCourse3()
{
	temp=document.forms[3].elements[0].value;
	
	//appending to secondselect
		var str=document.getElementById('secondselect');
			
		var options=str.getElementsByTagName("option");
		
	
		for (i=options.length-1; i>=0; i--)
		{
		str.removeChild(options[i]);
		
		
		}
		
	for(j=0;j<courses.length;j++)
	{
		if(courses[j].name==searchText && courses[j].dep==temp)
		$("#secondselect").append("<option>"+searchText+"</option>");
	}


}










//tabe marboot be onclick dokmeye jostojoo zamani
function addwindowsearch()
{

search_mode=true;
document.body.style.cursor="help";


}






//class cours
function Course(name,unit,start,end,dep,day)
{
	this.name=name;
	this.start=start;
	
	this.end=end;
	this.unit=unit;
	this.dep=dep;
	this.day=day;
	
	this.addC=function()
	{
		
		//$("#huhu").append("<option>"+this.name+"</option>");
	
	}

}









//marboot be dokmeye afzoodane be barname

function addtagC()
{

	
	cdepartment=document.forms[1].elements[0].value;
	
	
     cname=document.forms[2].elements[0].value;
	 
	//alert(document.forms[3].elements[0].value);
	 var data=cname.split('-');
	// alert(data[0]);
	// alert(data[1]);
	 //alert(data[2]);
	 var Name=data[0];
	 var Group=data[1];
	 //alert(Group);
	 
	$.ajax({
			
           type: "POST",
           url: "actions/insertCourse.php",
		   data: "name="+data[0]+"&group="+data[1],
           success: function(msg)
           {
				alert("Data Saved name and group: " + msg); 
				courseInfo=msg.split('-');
			   
			  var myday=parseInt(courseInfo[3]);
			 
			courseInfo[1]=(courseInfo[1]*80)-483;
			courseInfo[2]=(courseInfo[2]*80)-483;
			
			  
			 
			lables[lables.length] = new Lable(courseInfo[1],courseInfo[2],myday,courseInfo[0]);
			
			lables[lables.length-1].draw ();
			if(courseInfo[4]!=0)
			{
				lables[lables.length] = new Lable(courseInfo[1],courseInfo[2],courseInfo[4],courseInfo[0]);
			
				lables[lables.length-1].draw ();
			}
              
               
			   
           }
         });
		 
		 
		 
		 
		//echo $row['name']."-".$st."-".$et."-".$nday1."-".$nday2; 
		 $.ajax({
			
           type: "POST",
           url: "actions/insertCourse.php",
		   
           success: function(msg)
           {
				
				//alert(msg);
               //courseInfo=msg.split('-');
			   //alert(courseInfo[0]);
			   //alert(courseInfo[1]);
			  //alert(courseInfo[2]);
			  
			 
			//lables[lables.length] = new Lable(courseInfo[1],courseInfo[2],courseInfo[3],courseInfo[0]);
			
			//lables[lables.length-1].draw ();
			
			/*if(courseInfo[4]!=null)
			{.
				lables[lables.length] = new Lable(courseInfo[1],courseInfo[2],courseInfo[4],courseInfo[0]);
			lables[lables.length-1].draw ();
			}*/
			   
			   
           }
         });
		 
     
                
						
						
							
		//lables[lables.length] = new Lable((courses[i].start),(courses[i].end),courses[i].day,cname);
		//lables[lables.length-1].draw ();
								
							
							
					 
					
                        


	
}

//class addcourse          marboot be ezafe kardane darse jadid az samte chap
function update()
{



temp=document.forms[1].elements[0].value;
	alert(temp);
	if(temp=="ریاضی")
	{
		uni_id= "http://81.31.167.195:8081/edu/newLessonList/newLessonsList.jsp?depID=22";
		alert(uni_id);
	}
	if(temp=="مهندسی کامپیوتر")
	{
		uni_id="http://81.31.167.195:8081/edu/newLessonList/newLessonsList.jsp?depID=40";;
		alert(uni_id);
	}
	if(temp=="فیزیک")
	{
		uni_id="http://81.31.167.195:8081/edu/newLessonList/newLessonsList.jsp?depID=24";
		alert(uni_id);
	}
	if(temp=="معارف")
	{
		uni_id="http://81.31.167.195:8081/edu/newLessonList/newLessonsList.jsp?depID=37";
		alert(uni_id);
	}
	if(temp=="تربیت بدنی")
	{
		uni_id="http://81.31.167.195:8081/edu/newLessonList/newLessonsList.jsp?depID=30";
		alert(uni_id);
	}
	
	
	/*$.ajax({
			
           type: "POST",
           url: "actions/department.php",
		   data: "code="+uni_id,
           success: function(msg)
           {
				
			   alert(msg);
           }
         });*/
	
	
	
	
	
	
	$.ajax({
			
           type: "POST",
           url: "actions/department.php",
		   data: "code="+uni_id,
           success: function(msg)
           {
				alert(msg);
				//images/ajax-loader.gif
               //$("#huhu").html("<img src='images/loading.gif'/>");
               $("#huhu").html(msg);
           }
         });
	/*$("body").append("<div id='mask'></div>");
	$("body").append("<div id='window_getcourse'><table> <tr><td>name</td><td><input type='text' id='name'></td></tr><tr><td>unit</td><td><input type='text' id='unit'></td></tr><tr><td>start time</td><td><input type='text' id='st'></td></tr><tr><td>end time</td><td><input type='text' id='et'></td></tr><tr><td>day</td><td><input type='text' id='day'></td></tr><tr><td> <button class='buttone2' id='OK2' '>OK</button></td><td><button  class='buttone2' onClick='cancel_window()'>Cancel</button></td></tr></table></div>");
	$("#OK2").click(function()
		{
		
			courses[courses.length]=new Course();
			 name=$("#name").val();
			 unit=$("#unit").val();
			 st=$("#st").val();
			 et=$("#et").val();
			 day=$("#day").val();
			 et=((80*et)-483);
			 st=((80*st)-483);
			 
			 if(day=="شنبه")
			 {
				day1=0;
			 }
			 
			 if(day=="یکشنبه")
			 {
				day1=1;
			 }
			 if(day=="دوشنبه")
			 {
				day1=2;
			 }
			 if(day=="سه شنبه")
			 {
				day1=3;
			 }
			 if(day=="چهارشنبه")
			 {
				day1=4;
			 }
			 if(day=="پنج شنبه")
			 {
				day1=5;
			 }
			 if(day=="جمعه")
			 {
				day1=6;
			 }
			 
			 
			 
			 
			 
			 
			
			 
			 			 
			 temp=document.forms[1].elements[0].value;
			
			courses[courses.length]=new Course(name,unit,st,et,temp,day1);
			
			alert("new course added");
			courses[courses.length-1].addC();					 
					
			
			$("#window_getcourse").remove();
			$("#mask").remove();
			
			
			
			
		});*/
	
}



var dars;

function Lable(start_time,end_time,day,name)
{
this.start_time=start_time;
this.end_time=end_time;
this.name=name;
this.day=day;
this.id=lables.length;






   
 this.draw=function ()
    {
	
	//alert("in draw");
	//alert(this.day);
	//alert("name: "+this.name);
		
		if(this.day==7)
		{
			a="#weekdaysColomn7";
			//alert("shanbe");
		}
		
		if(this.day==1)
		{
			a="#weekdaysColomn1";
			//alert("1shanbe");
		}
		
		if(this.day==2)
		{
			a="#weekdaysColomn2";
		}
		if(this.day==3)
		{
			a="#weekdaysColomn3";
		}
		if(this.day==4)
		{
			a="#weekdaysColomn4";
		}
		if(this.day==5)
		{
			a="#weekdaysColomn5";
		}
		if(this.day==6)
		{
			a="#weekdaysColomn6";
		}
		
		
		
		
			
	
		if(lables.length>1)	
		{
		c=this.hasConflict(this.start_time,this.end_time);
		
		
		
		}
		
		if(lables.length==1)
		{
		//add tag div
		
		$(a).append("<div class='tag' id='tag"+this.id+"' style='position:absolute; top:"+this.start_time+"px; height:"+(this.end_time-this.start_time)+"px; '> <img id='remove'  ALIGN='LEFT' width=20px  onclick='lables["+this.id+"].remove()' src='images/index.jpg'/><p ALIGN='CENTER'>"+this.name+" </p> </div>");
		$.ajax({
			
           type: "POST",
           url: "actions/insertTagtoDB.php",
		   data: "name="+this.name+"&day="+this.day+"&start="+this.start_time+"&end="+this.end_time,
           success: function(msg)
           {
				alert(msg);
              
               
			   
           }
         });
			
		return;
		
		}
		
		
		
		
		if(c==0 && lables.length>1)
		{
		
		$(a).append("<div class='tag' id='tag"+this.id+"' style='position:absolute; top:"+this.start_time+"px; height:"+(this.end_time-this.start_time)+"px; '> <img id='remove'  ALIGN='LEFT' width=20px  onclick='lables["+this.id+"].remove()' src='images/index.jpg'/> <p  ALIGN='CENTER'>"+this.name+"</p></div>");
		$.ajax({
			
           type: "POST",
           url: "actions/insertTagtoDB.php",
		   data: "name="+this.name+"&day="+this.day+"&start="+this.start_time+"&end="+this.end_time,
           success: function(msg)
       
	   {
				alert(msg);
              
               
			   
           }
         });
		 }
			
		else
		{
			alert("conflict");
			lables[this.id].remove();
			
			
			
			
			$("#start").remove();
		}
		
		
			$("#start").remove();
			//data: "id=" + course + "&name=" + course_group,
			//after url
			//before success ...
			//in ajax
			//and then in php
			//write:
			//$_POST[name]
			//or
			//$_POST[id]
			
			
	
		
          // Show this label in the row of this.day
      //....
     }
 this.remove= function ()
    {
	
		
	
	
		closing=true;
		
		
		
		
		$.ajax({
			
           type: "POST",
           url: "actions/deleteTaginDB.php",
		   data: "start="+this.start_time+"&end="+this.end_time+"&myday="+this.day,
           success: function(msg)
           {
				//alert(msg);
              
               
			   
           }
         });
		
		
		
		
		lables[this.id].start_time=count;
		lables[this.id].end_time=count;
		
		
			

	$("#tag"+this.id).remove();
	
	$("#start").remove();
	
	
	
	
	
	
	
		
          // Remove this label from timetable
        //...
    }
 this.hasConflict= function(other_start,other_end)
        {
		
		
			for(i=0;i<lables.length;i++)
			{
				if(this.day==lables[i].day)
				{
					//alert(this.day);
					if( (this.start_time > lables[i].start_time  && this.start_time<lables[i].end_time) || (this.end_time>lables[i].start_time && this.end_time<lables[i].end_time) || (this.end_time<lables[i].end_time && this.start_time>lables[i].start_time) ||(this.end_time>lables[i].end_time && this.start_time<lables[i].start_time) )
					{
					
					
					
					return true;
					}
				}
			}
          //....
          
          //....
          return false;
        }   
}
























function cancel_window()
{
$("#mask").remove();
$("#window_get").remove();
$("#window_getcourse").remove();
$("#start").remove();
$("#start").remove();

}

function cancel_window_search()
{
	$("#mask").remove();
	$(".searchwindow").remove();
	$("#start").remove();
	$("#start").remove();
	search_mode=false;
	document.body.style.cursor="default";
}

function cancel_window_search2()
{
	$("#mask").remove();
	$("#searchwindow_name").remove();
	
}

/////////////////jquery ready function

jQuery(document).ready(function(){
	

	show_db();
	//ajax for show_zamanbandi.php
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


   $("#timeTable").click(function(e){
   
   
   
   
   if(clicked==false )
   {
	if(closing==false)
	{
	x=e.pageX;
	y=e.pageY;
	
	
	
	
	clicked=true;
	
	
	
	
	
	if(x>=442 && x<=540)
	{
								
		$("#weekdaysColomn6").append("<div id='start' style='top: "+y+"px' >  </div>");
		a="#weekdaysColomn6";
		b=6;
		
	}
	
	
	if( x>540 && x<=641)
	{
		$("#weekdaysColomn5").append("<div id='start'  style='top: "+y+"px'> </div>");
		a="#weekdaysColomn5";
		b=5;
		
	}
	
	
	if(x>641 && x<=742)
	{
		$("#weekdaysColomn4").append("<div id='start'     style='top: "+y+"px'></div>");
		a="#weekdaysColomn4";
		b=4;
		
	}
	
	
	if(x>742 && x<=846)
	{
		$("#weekdaysColomn3").append("<div id='start'     style='top: "+y+"px'></div>");
		a="#weekdaysColomn3";
		b=3;
		
	}
	
	
	if(x>846 && x<=948)
	{
		$("#weekdaysColomn2").append("<div id='start'     style='top: "+y+"px'></div>");
		a="#weekdaysColomn2";
		b=2;
		
	}
	
	
	if(x>948 && x<=1049)
	{
		$("#weekdaysColomn1").append("<div id='start'     style='top: "+y+"px'></div>");
		a="#weekdaysColomn1";
		b=1;
		
	}
	
	
	
	if(x>1049 && x<=1151)
	{
		$("#weekdaysColomn7").append("<div id='start'     style='top: "+y+"px'></div>");
		a="#weekdaysColomn7";
		b=7;
		
	}
	
		
		 
	 }
		else
		{
			closing=false;
		}
	 }
	 else
	 {
		if(clicked==true && closing==false)
		{
		y2=e.pageY;
		
		
		$(a).append("<div id='start' style='top: "+y2+"px' >  </div>");
		clicked=false;
		$("body").append("<div id='mask'></div>");
		
		if(search_mode==true)
		{
			
			
		
			$("body").append("<div class='searchwindow' id='searchwindow_time'><p><form name='comboboxS'><select onChange='showCourse2(this.form)'><option> مهندسی کامپیوتر</option><option> مهندسی برق </option><option> صنایع </option></select></form></p><p><form name='listboxS'><select id='secondselect' size='7'></select ><option></option></form></p><p><button onclick='tagAfterSearch()' class='buttone2' id='OK'>افزودن به برنامه</button><button onclick='cancel_window_search()' class='buttone2' id='OK'>لغو</button></p></div>;");
						
						
		}
		
		else
		{
		$("body").append("<div style='background-color:#FFCCCC' id='window_get'><table><tr><td>name</td><td><input type='text' id='name'></td></tr><tr><td> <button class='buttone2' id='OK'>OK</button></td><td><button  class='buttone2' onClick='cancel_window()'>Cancel</button></td></tr></table></div>");
		
		$("#OK").click(function()
		{
	 
			dars=$("#name").val();
			
			lables[lables.length]=new Lable(y,y2,b,dars);
			 
			
			
			lables[lables.length-1].draw();
			$("#start").remove();
			$("#window_get").remove();
			$("#mask").remove();
			
			
			
		
		});
		
		
		
		
		
		

		 
	 }
	 }
	 }
	 
	 
	 
	

	  
});
   
});


