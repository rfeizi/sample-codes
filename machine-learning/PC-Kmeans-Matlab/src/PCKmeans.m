function [ accuracy ] = PCKmeans( Neighborhoods ,Length,k,count,Data, 
usedindexes, usedindexes_size , mustlinks, cantlinks )

colomns=size(Data,2);
size_of_data=size(Data,1);


%to do   if count<k
if count<k 
    remainingN=k-count;

    for i=count+1:remainingN
         unusedindex=zeros(1,size_of_data);
         unusedindex_size=0;
          for j=1:size_of_data
             if isempty(find(usedindexes == j, 1))
                 unusedindex_size= unusedindex_size+1;
                 unusedindex(1, unusedindex_size)=j;
             end
          end

          randomID = randsample( unusedindex_size,1) ;
          randomPointID=unusedindex(1,randomID);
          Neighborhoods(i,1)=randomPointID;
          usedindexes_size=usedindexes_size+1;
          usedindexes(1,usedindexes_size)=randomPointID;
    end

end


for i=1:k
    nid(i,1)=i;
end
 
for i=1:k
    len(i,1)=Length(1,i);
end
 
%for sorting neighborhoods according to their length. 
nid_len=[nid,len];
nid_len=sortrows(nid_len,2);
nid_len=flipdim(nid_len,1);

% initialize centroids
centroids=zeros(k,colomns-2);

   for i=1:k
     for j=1:Length(1,i)
       centroids(i,:)=Data(Neighborhoods(i,j),2:colomns-1)+centroids(i,:);
     end
     centroids(i,:)=centroids(i,:)/Length(1,i);
   end
    


ids=zeros(size(Data,1),1);


    for i=1:size(Data,1)
            ids(i,1)=i;

    end

temp=ones(size(Data,1),1);

clusters=[ids,temp];

temp1=zeros(size(Data,1),1);
newClusters=[ids,temp1];



draw_clusters(Data,clusters,centroids,k,1,'pckmeans.gif');


changed=1;

            
iterationCount=0;
       

while changed==1 && iterationCount<30 
   
    iterationCount=iterationCount+1;   
        changed=0;
    for i=1:size(Data,1)
    min=10000000000;
    for h=1:k
        
        distv=Data(i,2:colomns-1)-centroids(nid_len(h,1),:);
		distance=distv*distv';
        w_ml=constraint_ml(mustlinks,i,clusters,nid_len(h,1),Data);
        w_cl=constraint_cl(cantlinks,i,clusters,nid_len(h,1),Data);
       if (0.5*distance+w_ml+w_cl)<min
            newClusters(i,2)=nid_len(h,1);
            min=0.5*distance+w_ml+w_cl;
       end
      
       
    end
        if(clusters(i,2)~=newClusters(i,2))
           changed=1;
       end
  
    
    end
    
      clusters(:,:)=newClusters(:,:);
    
     

clustercount=zeros(k,1);
centroids=zeros(k,colomns-2);
for i=1:size(Data,1)
   centroids(clusters(i,2),:)=centroids(clusters(i,2),:)+Data(i,2:colomns-1);
   clustercount(clusters(i,2),1)=clustercount(clusters(i,2),1)+1;
end

for h=1:k
    centroids(h,:)=centroids(h,:)/clustercount(h,1);
end




draw_clusters(Data,clusters,centroids,k,0,'pckmeans.gif');
		


end

 display(iterationCount);
  
     collisions=zeros(k,k+1);
 for i=1:size(Data,1)
     collisions(clusters(i,2),Data(i,end)+1)=
	 collisions(clusters(i,2),Data(i,end)+1)+1;
 end
 
 sum_col=0;
 for i=1:k
     max=0;
     for j=1:k+1
         sum_col=sum_col+collisions(i,j);
         if(collisions(i,j)>max)
             max=collisions(i,j);
         end
     end
     sum_col=sum_col-max;
 end
 
 accuracy=(size(Data,1)-sum_col)/size(Data,1);
 display(accuracy);
 
 
end




