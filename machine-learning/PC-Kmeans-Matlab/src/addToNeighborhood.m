function [count Neighborhoods  remainingQ  Lenghth mustlinks cantlinks]=
addToNeighborhood(index,Neighborhoods, Lenghth,remainingQ,
Data,count,mustlinks,cantlinks)

checkingCL=zeros(1,count);
checkingML=zeros(1,count);
flag=1;
MLflag=0;
label=size(Data,2);


for i=1:count
       if(cantlinks(Neighborhoods(i,1),index)==1)
          checkingCL(1,i)=1;% if can not link to neighborhood i
       elseif Data(index,label)~=Data(Neighborhoods(i,1),label)
            display(Data(index,label));
            display(Data(Neighborhoods(i,1),label));
            checkingCL(1,i)=1;% if can not link to neighborhood i
            remainingQ=remainingQ-1;
            
              for k=1:Lenghth(1,i)
                 cantlinks(Neighborhoods(i,k),index)=1 ;
                 cantlinks(index,Neighborhoods(i,k))=1;
              end
       end
         
end


for i=1:count
    if checkingCL(1,i)==0
        flag=0;
    end
      
end


if flag==1 %start a new neighborhood :) because we found a CL
    
     count=count+1;
     Neighborhoods(count,1)=index;
     Lenghth(1,count)= Lenghth(1,count)+1;
   

elseif flag==0 % add to one of the previous neighborhoods
    
    
    for i=1:count
         if(mustlinks(Neighborhoods(i,1),index)==1)
          checkingML(1,i)=1;% if must link to neighborhood i
          break;
         elseif Data(index,label)==Data(Neighborhoods(i,1),label)
             checkingML(1,i)=1;% if must link to neighborhood i
             remainingQ=remainingQ-1;
             
               for k=1:Lenghth(1,i)
                 mustlinks(Neighborhoods(i,k),index)=1 ;
                 mustlinks(index,Neighborhoods(i,k))=1;
                
               end
              
                for h=1:size(Data,1)
                     if(cantlinks(Neighborhoods(i,1),h))
                         cantlinks(index,h)=1;
                         cantlinks(h,index)=1;
                     end
                end
              
             break;
         end
    end
    
    
    for i=1:count
        if checkingML(1,i)==1
            MLflag=1;
            temp_index=i;
            break;
        end
    end
    
  if MLflag==1 %
     Lenghth(1,temp_index)= Lenghth(1,temp_index)+1;
     Neighborhoods(temp_index,Lenghth(1,temp_index))=index;  
  end  
    
end
    
    
end
   
    
    
    
    
     
    
  





    






