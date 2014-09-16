function [ pointID ] = ...
 find_farthest_point( Data,usedindexes,usedindexes_size )

size_of_data=size(Data,1);
colomns=size(Data,2);
unusedindex=zeros(1,size_of_data);
unusedindex_size=0;

%display(usedindexes(1,usedindexes_size));

for i=1:size_of_data
    if isempty(find((usedindexes == i), 1))
        unusedindex_size= unusedindex_size+1;
         unusedindex(1, unusedindex_size)=i;
    end
end




maxdist=-1;
farthest_ind=-1;
for i=1:unusedindex_size
    disti=-1;
	for j=1:usedindexes_size
      
	  distv= ...
	  Data(usedindexes(1,j),2:colomns-1)-Data(unusedindex(1,i),2:colomns-1);
		distij=distv*distv';
		if(disti==-1)
			disti=distij;
		else
			if(disti>distij)
				disti=distij;
			end
		end
	end
	if(disti>maxdist)
		maxdist=disti;
		farthest_ind=unusedindex(1,i);
	end
end

pointID=farthest_ind;


end




