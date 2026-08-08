package com.mycompany.app;

public class App {

    public static void main(String[] args) {
        App app = new App();

        // should print 9
        System.out.println(app.method(new int[] {4, 9, 1, 15, 8}, 10));

        // should print 1
        System.out.println(app.method(new int[] {4, 9, 1, 15, 8}, 2));

        // should print 5 (tie, smaller value returned)
        System.out.println(app.method(new int[] {5, 15}, 10));

        // should print -1 (empty array)
        System.out.println(app.method(new int[] {}, 10));
    }

    public int method(int[] arr, int target){
        int distance = Integer.MAX_VALUE;
        int current_closest = -1;
        for(int i = 0; i < arr.length; i++){
            int d = Math.abs(arr[i] - target);
            if(d < distance){
                current_closest = arr[i];
                distance = d;
            }
        }
        return current_closest;
    }

}
