function draw_clusters(Data,clusters,centroids,n_clusters,init,fn)
filename=fn;

xi=1;
yi=3;

colors=zeros(size(Data,1),3);

cols=zeros(5,3);

cols(1,:)=[1,0,0];
cols(2,:)=[0,1,0];
cols(3,:)=[0,0,1];
cols(4,:)=[1,1,0];
cols(5,:)=[1,0,1];
cols(6,:)=[0,1,1];

cols(7,:)=[0.5,0.2,0.5];
cols(8,:)=[0.2,0.5,0.5];
cols(9,:)=[0.5,0.5,0.2];
cols(10,:)=[0.3,0.3,0.3];



for i=1:size(Data,1)
    colors(i,:)=cols(clusters(i,2),:);
    %colors(i,:)=cols(Data(i,end)+1,:);
end

            
            figure(1)
            hold off

			scatter(Data(:,xi+1),Data(:,yi+1),5,colors);
            
                        hold on
            
if(init==1)
      
			drawnow

			frame = getframe(1);
			im = frame2im(frame);
			[imind,cm] = rgb2ind(im,256);
			imwrite(imind,cm,filename,'gif', 'Loopcount',inf);
else 
            
            scatter(centroids(:,xi),centroids(:,yi),50,cols(1:n_clusters,:));
			drawnow

			frame = getframe(1);
			im = frame2im(frame);
			[imind,cm] = rgb2ind(im,256);
			imwrite(imind,cm,filename,'gif','WriteMode','append');
end

end