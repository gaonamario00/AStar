public class app {

	public static void main(String[] args) {
		
			//Nodo de donde se comienza
			Node head = new Node(6);
			head.g = 0;
			
			// se crean los nodos hijos de head
			 Node n1 = new Node(5);
			 Node n2 = new Node(7);
			 Node n3 = new Node(7);
			 
			 // se establecen su relacion con head
			 head.addBranch(3, n1);
			 head.addBranch(4, n2);
			 head.addBranch(5, n3);
			 
			 // Declaracion del nodo 4
			 Node n4 = new Node(6);
			 
			 // Se establece la relacion de n4 con n1 y n2
			 n1.addBranch(1, n4);
			 n2.addBranch(1, n4);

			 // Se declara el nodo 5
			 Node n5 = new Node(4);
			 
			 // Se establece la relacion de n5 y n1
			 n1.addBranch(3, n5);
			 
			// Se declara el nodo 6
			 Node n6 = new Node(8);
			 
			// Se establece la relacion de n6 y n2
			 n2.addBranch(8, n6);
			 
			 // Se declara el nodo 7
			 Node n7 = new Node(8);
			 
			 // Se establece la relacion de n7 y n3
			 n3.addBranch(1, n7);
			 
			 // Se declara el nodo 8
			 Node n8 = new Node(3);
			 
			 // Se establece la relacion de n8 y n5
			 n5.addBranch(5, n8);
			
			 // Se declara el nodo 9
			 Node n9 = new Node(9);
			 
			 // Se establece la relacion de n9 con n6 y n7
			 n6.addBranch(12, n9);
			 n7.addBranch(0, n9);
			 
			 // Se declara el nodo 10
			 Node n10 = new Node(2);
			 
			 // se establece la relacion de n10 y n8
			 n8.addBranch(10, n10);
			 
			 // Se declara el nodo 11
			 Node n11 = new Node(1);
			 
			 // se establece la relacion de n11 y n10
			 n10.addBranch(2, n11);
			 
			 // se declara el nodo 12
			 Node n12 = new Node(1);
			 
			 // Se establece la relacion de n12 y n7
			 n7.addBranch(15, n12);
			 
			 // se declara el nodo objetivo/destino
			 Node Target = new Node(0);
			 
			 // Se establece la relacion de target con n11 y n12
			 n11.addBranch(3, Target);
			 n12.addBranch(19, Target);
			 
			 // Se ejecuta el algoritmo para obtener el camino mas barato y corto
			 Node res = Node.aStar(head, Target);
			 
			 // Imprime el camino optimo
			 Node.printPath(res);
			 
	}

}