package com.poojasingh.tutorialkotlin.data;

class Example {
    int[] arr = {2,1,6,2,9,2,1,10,5};
    // -1, -1, 6, -1, 9, -1, -1, 10, 5
    // min = 1, 2
    Example(){
        int[] newArr = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            int min = 0;

             for(int j = 0; j < arr.length; j++){
                 if(arr[j] != -1)
                     min = arr[j];

                 if(arr[j] < min){
                     min = arr[j];
                 }
             }
            for(int k = 0; k < arr.length; k++){
                if(arr[k] == min){
                    arr[k] = -1;
                }
            }
             newArr[i] = min; // 1, 2,
        }
    }
}
