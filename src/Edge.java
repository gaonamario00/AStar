// Edge es una clase para crear relaciones entre los nodos

public class Edge {
	 Edge(int weight, Node node){
         this.weight = weight;
         this.node = node;
   }

   public int weight;
   public Node node;
}