package ep2.teamaufgabe.Quadtree;

import ep2.teamaufgabe.Datastructure;
import ep2.teamaufgabe.Models.Airport;
import ep2.teamaufgabe.Models.Location;

public class QuadtreeNode{
    public Location value;
    private QuadtreeNode topLeft, topRight, bottomLeft, bottomRight; // Subtrees
    private double minX, maxX, minY, maxY;
    private boolean leaf;

    public QuadtreeNode(double minX, double maxX, double minY, double maxY){
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
        this.leaf = true;
    }

    public void add(Location location) {
        if(this.leaf){ // Dieser Knoten ist ein Blatt
            if(this.value == null){ // Blattknoten ist leer
                this.value = location;
            }else{ // Blattknoten ist nicht leer
                double hx = (this.minX + this.maxX) / 2; // Wert zwischen minX und maxX
                double hy = (this.minY + this.maxY) / 2; // Wert zwischen minY und maxY

                this.topLeft = new QuadtreeNode(this.minX, hx, hy, this.maxY);
                this.topRight = new QuadtreeNode(hx, this.maxX, hy, this.maxY);
                this.bottomLeft = new QuadtreeNode(this.minX, hx, this.minY, hy);
                this.bottomRight = new QuadtreeNode(hx, this.maxX, this.minY, hy);
                this.leaf = false;

                this.branchAdd(location);
                this.branchAdd(this.value);
                this.value = null;
            }

        }else{ // Dieser Knoten ist kein Blatt und der value ist folglich null
            this.branchAdd(location);
        }
    }

    private void branchAdd(Location location){ // Macht die rekursiven Aufrufe
        switch (this.getQuadrant(location)){
            case topLeft:       this.topLeft.add(location);
                break;
            case topRight:      this.topRight.add(location);
                break;
            case bottomLeft:    this.bottomLeft.add(location);
                break;
            case bottomRight:   this.bottomRight.add(location);
                break;
        }
    }

    private Quadrant getQuadrant(Location location){
        double x = location.getXCoordiante();
        double y = location.getYCoordinate();
        double hx = (this.minX + this.maxX) / 2; // Wert zwischen minX und maxX
        double hy = (this.minY + this.maxY) / 2; // Wert zwischen minY und maxY

        if(x >= minX && x <= hx){ // linke Seite

            if(y >= minY && y <= hy) { // unten
                return Quadrant.bottomLeft;
            }else if(y >= hy && y <= maxY){ // oben
                return Quadrant.topLeft;
            }

        }else if(x >= hx && x <= maxX){ // rechte Seite

            if(y >= minY && y <= hy) { // unten
                return Quadrant.bottomRight;
            }else if(y >= hy && y <= maxY){ // oben
                return Quadrant.topRight;
            }

        }

        System.err.println("The point is not inside!");
        return Quadrant.error;
    }

    public int[] countLocationsInArea(double x, double y, double r) {
        if(this.maxX < x-r || this.minX > x+r || this.maxY < y-r || this.minY > y+r){ // der Punkt x, y kann sich nicht in diesem Quadranten befinden (Stichwort: Bounding-Box)
            return new int[] {0, 0};
        }else{ // der Punkt x, y kann, muss sich aber nicht im Quadranten befinden (evtl. nur in der Bounding-Box)
            if(this.value == null){ // weiterverzweigen

                return branchLocationsInArea(x, y, r, this.topLeft, this.topRight, this.bottomLeft, this.bottomRight);

            }else{ // Blattknoten mit Wert
               double distance = Math.sqrt(Math.pow(this.value.getXCoordiante() - x, 2) + Math.pow(this.value.getYCoordinate() - y, 2));
               if(distance <= r){ // Im Radius
                   if(this.value.getClass() == Airport.class){
                       return new int[] {1, 0};
                   }else{
                       return new int[] {0, 1};
                   }
               }else{
                   return new int[] {0, 0};
               }
            }
        }

    }

    private int[] branchLocationsInArea(double x, double y, double r, QuadtreeNode... subtrees){ // rekursive Verzweitung der LocationInArea-Methode
        int airports = 0;
        int trainstations = 0;

        for(QuadtreeNode l : subtrees){
            if(l != null){
                int[] locations = l.countLocationsInArea(x, y, r);
                airports += locations[0];
                trainstations += locations[1];
            }
        }

        return new int[] {airports, trainstations};
    }


    public int countAriportsNearTrainstation(double r, int n, QuadtreeNode root) {
        // Rekursiv weiterverzweigen
        if(this.value == null){
            return branchToCount(r, n, root, this.topLeft, this.topRight, this.bottomLeft, this.bottomRight);
        }

        // Berechnen
        if(this.value.getClass() == Airport.class){ // Fundierung
            int[] locations = root.countLocationsInArea(this.value.getXCoordiante(), this.value.getYCoordinate(), r);
            if(locations[1] >= n) {
                return 1;
            }
        }

        return 0; // kein Airport


    }



    public int branchToCount(double r, int n, QuadtreeNode root, QuadtreeNode... subtree){ // macht die rekursiven Aufrufe
        int counter = 0;

        for(int i = 0; i < subtree.length; i++){
            if(subtree[i] != null){
                counter += subtree[i].countAriportsNearTrainstation(r, n, root);
            }
        }

        return counter;
    }



}