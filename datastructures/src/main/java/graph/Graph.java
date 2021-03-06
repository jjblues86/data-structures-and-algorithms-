package graph;

import java.util.*;

public class Graph<T> {
    private Map<Node, Set< Node<T>>> vertices;

    //Constructor

    public Graph() {
        this.vertices = new HashMap<>();
    }

    //AddNode()
    public Node addNode(T data){
        Node newNode;
        if(data != null){
            newNode = new Node<>(data);
            vertices.put(newNode, new HashSet<>());
            return newNode;
        }
        return null;
    }

    //AddEdge()
    public void addEdge(int weight,Node one, Node two){
        if(vertices.containsKey(one) && vertices.containsKey(two)){
            Edge edge = new Edge<>(weight, one, two);
            vertices.get(one).add((two));
            one.edges.add(one);
            vertices.put((one), vertices.get(one));

            vertices.get(two).add((one));
            two.edges.add(two);
            vertices.put((two) , vertices.get(two));
        }
    }

    //GetNodes()
    public Set<Node> getNodes(){
        return vertices.keySet();
    }

    //GetNeighbors()
    public Set<Node<T>> getNeighbors(Node vertex){
        if(vertices.containsKey(vertex)){
            return vertices.get(vertex);
        }
        return null;
    }

    //Size()
    public int size(){
       return this.vertices.size();
    }

    //BreadthFirstSearch
    List<Node> bfs(Node node){
        Set<Node> visited = new HashSet<>();
        List<Node> breadthFS = new ArrayList<>();
        //BFS queue
        Queue<Node> queue = new LinkedList<>();
        if(node == null){
            throw new IllegalArgumentException("Graph is Empty");
        }
        if(!vertices.containsKey(node)){
            throw new IllegalArgumentException("Node not found");
        }
        visited.add(node);
        queue.add(node);
        breadthFS.add(node);

        while(queue.size() != 0){
            //remove from queue if it was not visited, add to the queue set
            node = queue.remove();
            if(!visited.contains(node)){
                breadthFS.add(node);
            }
            visited.add(node);
            vertices.get(node).forEach(neighbor -> {
                if(!visited.contains(neighbor)) queue.add(neighbor);
            });
        }
        return breadthFS;
    }

    //Find Edges
    public HashMap<Boolean, Integer> getEdge(Graph graph, Node[] cities){
        HashMap<Boolean, Integer> output = new HashMap<>();
        int tripCost = 0;
        boolean outcome = false;
        Node current;
        for(int i = 0; i < cities.length; i++){
            if(vertices.get(cities[i]).contains(cities[i+1])){

            }
      /*  for(String city : cities){
            if(cities[0].equals(city)){
                current = city;
            }*/
        }
        output.put(outcome, tripCost);
        return output;
    }

    //Depth First Traversal
    List<Node> depthFirstSearch(Node node){
        Set<Node> seen = new HashSet<>();
        List<Node> breadthFirstSearch = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        if(node == null){
            throw new IllegalArgumentException("Input is null");
        }
        if(!vertices.containsKey(node)){
            throw new IllegalArgumentException("Input is wrong");
        }
        seen.add(node);
        stack.add(node);
        breadthFirstSearch.add(node);

        while(stack.size() != 0){
            node = stack.pop();

            if(!seen.contains(node)){
                breadthFirstSearch.add(node);
            }
            seen.add(node);
            vertices.get(node).forEach(neighbor -> {
                if(!seen.contains(neighbor)) stack.add(neighbor);
            });
        }
        return breadthFirstSearch;
    }
}
