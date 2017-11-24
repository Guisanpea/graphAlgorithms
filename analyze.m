coord= load('coord.txt');
f_graf = fopen('graph.txt','r');
n = fscanf(f_graf, '%d', 1);
mb = zeros(n,n);
u = fscanf(f_graf, '%d', 1);
while (u>=0)
    v = fscanf(f_graf, '%d', 2);
    mb(u(1)+1,v(1)+1) = 1;
    u = fscanf(f_graf, '%d', 1);    
end
fclose(f_graf);


mico = min(coord(:,2:3));
maco = max(coord(:,2:3));
scale = [5 80];

DrawGraph(coord(:,2:3), mb);
axis([mico(1)-scale(2) maco(1)+scale(2) mico(2)-scale(2) maco(2)+scale(2)])
title ('original graph')

centrality=load('centrality.txt');
mic = min(centrality);
mac = max(centrality);
nombre = {'degree centrality', 'closeness centrality', 'betweenness centrality'};
for j=2:4,
    DrawGraph(coord(:,2:3), mb);
    title (cell2mat(nombre(j-1)))
    centrality(:,j) = (centrality(:,j)-mic(j))*(scale(2)-scale(1))/mac(j) + scale(1);
    [y, ind] = sort(-centrality(:,j));
    for i=1:n,
        x = coord(ind(i),2) + sin(0:.1:(2*pi)) * centrality(ind(i),j);
        y = coord(ind(i),3) + cos(0:.1:(2*pi)) * centrality(ind(i),j);    
        fill (x,y,'r')
    end
    axis([mico(1)-scale(2) maco(1)+scale(2) mico(2)-scale(2) maco(2)+scale(2)])
end
    