import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Node implements Comparable<Node> {
	
	// id que se asigna a cada nodo en orden como se van visitando
    private static int idCounter = 0;
    
    
    // el id que identifica a cada nodo
    public int id;

    // Parent in the path
    public Node parent = null;

    // lista de las relaciones, vecinos
    public List<Edge> neighbors;

    // hace que f y g sea en maximo valor double posible
    // esto se hace para que se asegure que siempre el valor 
    // f y g del camino recorrido sean menor a los por defecto
    public double f = Double.MAX_VALUE;
    public double g = Double.MAX_VALUE;
    
    // variables que almacena la heustica
    public double h; 

    // constructor de la clase Node
    // recibe como parametro la heusristica de cada nodo
    Node(double h){
    	  // setea el valor de la heustica recibida por parametro
          this.h = h;
          
          // setea el valor del id siendo este el orden en el que se recorrio
          this.id = idCounter++;
          
          // inicializa la lista de vecino
          this.neighbors = new ArrayList<>();
    }

    // sobreescribe el metodo compareTo de Comparable<Node>
    @Override
    public int compareTo(Node n) {
    	
    	  // verifica si el f es igual a el f de el nodo recibido por parametro
          return Double.compare(this.f, n.f);
    }
    
    // Agrega las ramas / relaciones / vecinos
    public void addBranch(int weight, Node node){
          Edge newEdge = new Edge(weight, node);
          neighbors.add(newEdge);
    }

    // obtiene la heuristica
    public double getHeuristic(Node target){
          return this.h;
    }
    
    public static Node aStar(Node start, Node target){
    	
    	// ProrityQueue es una clase que nos permite crear 
    	// las estructura cola
    	
    	// Lista para los elementos ya visitados/Cerrados
        PriorityQueue<Node> closedList = new PriorityQueue<>();
        
        // Lista para los elementos por visitar/abiertos
        PriorityQueue<Node> openList = new PriorityQueue<>();

        //Se calcula el valor de f con los valor de g y h
        start.f = start.g + start.getHeuristic(target);
        
        // se agrega el nodo inicial a la lista de abiertos
        openList.add(start);

        // Mientras la lista no este vacia
        while(!openList.isEmpty()){
        	
        	// hace que n sea igual a el ultimo nodo agregadp
            Node n = openList.peek();
            
            //verifica que si el nodo actual es la solucion
            if(n == target){
            	
            	// si el nodo actual es la solucion lo retorna
                return n;
            }

            // Reccorre los vecinos de el nodo actual
            for(Edge edge : n.neighbors){
            	
            	// hace que m sea igual a un vecino
                Node m = edge.node;
                
                // Variable que almacena el costo total del todo el camino
                double totalWeight = n.g + edge.weight;

                
                if(!openList.contains(m) // Si la lista de abiertos no contiene a el vecino actual
                	&& !closedList.contains(m) // si la lista de cerrados no contiene a el vecino actual
                		){
                    m.parent = n; // hace que el padre de el vecino actual sea el nodo actual 
                    m.g = totalWeight; // hace el coste del vecino actual sea el coste total
                    m.f = m.g + m.getHeuristic(target); // setea el valor de f
                    openList.add(m); // agrega a la lista de abiertos el vecino actual
                } else {
                	
                	// si ya se ha visitado el vecino actual verifica que el coste total sea menor a su costo
                    if(totalWeight < m.g){
                    	
                    	// hace que el nodo padre de el vecino actual sea n
                        m.parent = n;
                        
                        // hace el costo del vecino actual sea el costo total
                        m.g = totalWeight;
                        
                        // setea el valor de f del vecino actual
                        m.f = m.g + m.getHeuristic(target);

                        // si la lista de cerrados contiene a el vecino actual
                        if(closedList.contains(m)){
                        	
                        	// elimina el vecino actual de la lista de nodos cerrados
                            closedList.remove(m);
                            
                            // agrega a el vecino actual a la lista de nodos abiertos
                            openList.add(m);
                        }
                    }
                }
            }

            // elimina a el nodo actual de la lista de abiertos
            openList.remove(n);
            
            // agrega el nodo actual a la lista de nodos cerrados
            closedList.add(n);
        }
        return null;
    }

    // Esta funcion nos indica el camino optimo una vez que hemos encontrado la solucion
    public static void printPath(Node target){
    	
    	// hace que n sea el nodo solucion
        Node n = target;

        // si la solucion es nula significa que no se encontro
        if(n==null)
            return;

        //  inicializa una lista para almacenar el camino seguido
        List<Integer> ids = new ArrayList<>();
        
        // recorre todo el camino seguido, usando el atributo padre
        while(n.parent != null){
        	
        	// agrega a ids el nodo actual
            ids.add(n.id);
                        
            // hace que n sea el nodo padre, de esta forma regresando sobre el camino
            n = n.parent;
        }
        
        // agrega a ids el nodo solucion
        ids.add(n.id);
        
        // hace que la lista ids se invierta
        Collections.reverse(ids);
        
        // imprime el camino recorrido  
        for(int i=0;i<ids.size();i++) {
        	
        	if(ids.get(i) == 0) System.out.print("Head("+ids.get(i)+")");
        	else if(ids.get(i) == 13)System.out.print("Target("+ids.get(i)+")");
        	else System.out.print(ids.get(i));
        	
        	if(i != ids.size()-1) {
        		System.out.print("->");
        	}
        }
                
    }
    
    
    
    
}