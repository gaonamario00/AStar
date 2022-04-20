public class app {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		// Nodo del comienzo
		// El 3 es la distancia minima que esperamos 
		// se encuentre nuestra solucion
		 Node head = new Node(3);
		 
		 // Como es el inicio, g=0 ya que ya estamos ahi
		    head.g = 0;

		    //Se crean nodos, el parametro que se envia es la heuristica
		    Node n1 = new Node(2);
		    Node n2 = new Node(2);
		    Node n3 = new Node(2);

		    // se agregan un vecinos a la lista con su costo
		    head.addBranch(1, n1);
		    head.addBranch(5, n2);
		    head.addBranch(2, n3);
		    n3.addBranch(1, n2);

		    Node n4 = new Node(1);
		    Node n5 = new Node(1);
		    Node target = new Node(0);

		    n1.addBranch(7, n4);
		    n2.addBranch(4, n5);
		    n3.addBranch(6, n4);

		    n4.addBranch(3, target);
		    n5.addBranch(1, n4);
		    n5.addBranch(3, target);

		    // se ejecuta el metodo principal
		    Node res = Node.aStar(head, target);
		    
		    // si hay, muestra el camino recorrido optimo
		    Node.printPath(res);
		    */
		
			Node head = new Node(6);
			head.g = 0;
			
			 Node n1 = new Node(5);
			 Node n2 = new Node(7);
			 Node n3 = new Node(7);
			 
			 head.addBranch(3, n1);
			 head.addBranch(4, n2);
			 head.addBranch(5, n3);
			 
			 Node n4 = new Node(6);
			 
			 n1.addBranch(1, n4);
			 n2.addBranch(1, n4);

			 Node n5 = new Node(4);
			 
			 n1.addBranch(3, n5);
			 
			 Node n6 = new Node(8);
			 
			 n2.addBranch(8, n6);
			 
			 Node n7 = new Node(8);
			 
			 n3.addBranch(1, n7);
			 
			 Node n8 = new Node(3);
			 
			 n5.addBranch(5, n8);
			
			 Node n9 = new Node(9);
			 
			 n6.addBranch(12, n9);
			 n7.addBranch(0, n9);
			 
			 Node n10 = new Node(2);
			 
			 n8.addBranch(10, n10);
			 
			 Node n11 = new Node(1);
			 
			 n10.addBranch(2, n11);
			 
			 Node n12 = new Node(1);
			 
			 n7.addBranch(15, n12);
			 
			 Node Target = new Node(0);
			 
			 n11.addBranch(3, Target);
			 n12.addBranch(19, Target);
			 
			 Node res = Node.aStar(head, Target);
			 Node.printPath(res);
			 
	}

}