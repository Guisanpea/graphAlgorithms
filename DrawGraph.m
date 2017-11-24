function fig = DrawGraph(coord, mb)

[n c] = size(coord);
fig = figure;
plot(coord(:,1), coord(:,2), '.')
hold on
for i=1:n,
    for j=1:n,
        if mb(i,j),
            plot([coord(i,1) coord(j,1)], [coord(i,2) coord(j,2)], 'r:');
        end
    end
end
set(gca,'XTick',[])
set(gca,'YTick',[])
axis('square')