/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication10;

//DOĞUKAN GÜL 02195076015
public class Heap {
     int[] dizi;
    int count;
    
    public Heap(){
        dizi = new int[100];
        count = -1;
    }
    
    public int parent(int i){
        if(i-1<0){
            return -1;
        }
        return (i-1)>>1;
    }
    
    public int sol_cocuk(int i){
        int l = i*2 + 1;
        if(i>count || l>count){
            return -1;
        }
        return l;
    }
    
    public int sag_cocuk(int i){
        int r = i*2 + 2;
        if(i>count || r>count){
            return -1;
        }
        return r;
    }
    
    public void takas(int i, int j){
        int temp = dizi[i];
        dizi[i] = dizi[j];
        dizi[j] = temp;
    }
    
    public void percolateUp(int i){
        int size = count;
        while(size>0 && dizi[size] < dizi[parent(size)]){
            takas(size, parent(size));
            size = parent(size);
        }
    }
    
    public void heapify(int i){
        int degis = 1;
        
        while(i<=count && degis==1){
            degis = 0;
            int sol = sol_cocuk(i);
            int sag = sag_cocuk(i);
            
            if(sol == -1 && sag == -1){
                return ;
            }else{
                if(dizi[i] > dizi[sol]){
                    degis = 1;
                    takas(i, sol);
                    i = sol;
                }else if(sag!=-1 && dizi[i] > dizi[sag]){
                    degis = 1;
                    takas(i, sag);
                    i = sag;
                }
            }
        }
        return ;
    }
    
    public void ekle(int i){
        dizi[++count] = i;
        percolateUp(count);
    }
    
    public void sil(){
        int removedEle = dizi[0];
        
        takas(0, count);
        dizi[count--] = 0;
        heapify(0);
        
        System.out.println("Silindi: "+ removedEle);
    }
    
    public void print(){
        for(int i=0;i<=count;i++){
            System.out.print(dizi[i]+" ");
        }
        System.out.println();
    }
}

