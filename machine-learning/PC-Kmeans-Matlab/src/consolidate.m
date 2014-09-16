function [Neighborhoods  Length count usedindexes mustlinks cantlinks]=
		consolidate( Data,usedindexes,usedindexes_size,remainingQ,Neighborhoods,
												Length,count, mustlinks, cantlinks )

size_of_data=size(Data,1);
colomns=size(Data,2);

%initialize centroids
centers=zeros(count,colomns-2);
for i=1:count
centers(i,1:colomns-2)=calculate_center(Neighborhoods,i,Length,Data);
end

%for sorting according to distance from centroid 
nid_dist=zeros(count,2);
check_unusedindex_size=1;

while remainingQ>0 && check_unusedindex_size==1
    
     %%update unusedindex matrix
     unusedindex=zeros(1,size_of_data);
     unusedindex_size=0;
     for i=1:size_of_data
        if isempty(find(usedindexes == i, 1))
        unusedindex_size= unusedindex_size+1;
         unusedindex(1, unusedindex_size)=i;
        end
     end

    %if there is no unused point break;
    if unusedindex_size==0
       check_unusedindex_size=0;
       break;

   
    else
    randomID = randsample( unusedindex_size,1) ;
    randomPointID=unusedindex(1,randomID);
 

 
 
 
    for i=1:count
      distv=Data( randomPointID,2:colomns-1)-centers(i,:);
      distij=distv*distv';
      nid_dist(i,2)=distij;
      nid_dist(i,1)=i;
    end
 
  nid_dist=sortrows(nid_dist,2);



  %%querying in consolidate    
   for i=1:count
        
       if Data(randomPointID,end)==Data(Neighborhoods(nid_dist(i,1),1),end)
           
                for k=1:Length(1,(nid_dist(i,1)))
                 
            
                 mustlinks(Neighborhoods(nid_dist(i,1),k),randomPointID)=1;
                 mustlinks(randomPointID,Neighborhoods(nid_dist(i,1),k))=1;
                
               end
              
                for h=1:size(Data,1)
                     if(cantlinks(Neighborhoods(nid_dist(i,1),1),h))
                         cantlinks(randomPointID,h)=1;
                         cantlinks(h,randomPointID)=1;
                     end
                end
                
                
           Length(1,nid_dist(i,1))= Length(1,nid_dist(i,1))+1;
           Neighborhoods(nid_dist(i,1),Length(1,nid_dist(i,1)))=randomPointID;
           remainingQ=remainingQ-1;
           usedindexes_size=usedindexes_size+1;
           usedindexes(1,usedindexes_size)=randomPointID;
             
              
              
             break;
       end

   end
 
 
 
 
    end
  end

end

