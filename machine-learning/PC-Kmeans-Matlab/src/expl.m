function [accuracy ] = expl( k,Q )

%reading data
%Data=read_data_iris();
%Data=read_data_glass();
Data=read_data_yeast();


%definitions
 size_of_data=size(Data,1);
 colomn_n= size_of_data;
 Neighborhoods=zeros(k,colomn_n);
 Length=zeros(1,colomn_n);
 count=1;
 flag=0;
 remainingQ=Q;
 mustlinks=zeros(size(Data,1),size(Data,1));
 cantlinks=zeros(size(Data,1),size(Data,1));


 
 %preprocessing
 
 randomPointID = randsample(size_of_data,1) ;
 usedindexes=zeros(1,size_of_data);
 usedindexes_size=1;
 usedindexes(1,1)=randomPointID;
 Neighborhoods(1,1)=randomPointID;
 Length(1,1)=1;
 
 if Q==0 
     accuracy=Kmeans(k);
 
 else
     while remainingQ>0 && flag==0

        pointID= find_farthest_point(Data,usedindexes,usedindexes_size);
         [count Neighborhoods  remainingQ  Length mustlinks cantlinks]=...
            addToNeighborhood(pointID,Neighborhoods,Length,remainingQ,...
                                        Data,count,mustlinks, cantlinks);
         usedindexes_size=usedindexes_size+1;
         usedindexes(1,usedindexes_size)=pointID;


         if count>=k
          flag=1;
         end
     end


    [Neighborhoods Length count usedindexes mustlinks cantlinks]=...
    consolidate(Data,usedindexes,usedindexes_size,remainingQ,Neighborhoods
	,Length,count,mustlinks,cantlinks);


    [accuracy]=PCKmeans( Neighborhoods ,Length,k,count,Data,
	usedindexes, usedindexes_size , mustlinks, cantlinks);
 end

end
