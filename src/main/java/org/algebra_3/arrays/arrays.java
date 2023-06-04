public class arrays<E> {
    private int N;
    private int[] array;

    arrays(int N){ array = new int[N];}

    private static class duplet<E,A>{
        private E month;
        private A code;
        duplet(E month,A code){
            this.month = month;
            this.code = code;
        }
        private E month(){return this.month;}
        private A code(){return this.code;}

    }
    void set(int index,int elem){
        array[index] = elem;
    }
    int sum(int i , int result){
        result += array[i];
        return sum(i+1 , result);
    }

    int max(){
        int result = 0 ;
        for(int i = 0 ; i < N ; i++){
            if (array[i] > result) result = array[i];
        }
        return result;
    }

    int equal(int number){
        int qty = 0;
        for(int i = 0; i < N ; i++){
            if(array[i] == number) qty += 1;
        }
        return qty;
    }

    int[] homologus(){
        int[] b = new int[N];
        for(int i = 0 ; i < N; i ++){
            b[i] = array[i] * i;
        }
        return b;
    }

    /**
     * iterates through even numbers and returns the sum of uneven data
     *
     * @return int uneven sum with even indexes
     */
    int sumEvenUneven(){
        int result = 0;
        for (int i = 0 ; i < N ; i += 2){
            if (array[i] % 2 != 0) result += array[i];
        }
        return result;
    }

    int[] merge (int [] b){
        int [] c = new int[2*N];
        for(int i = 0 ; i < 2*N ; i++){
            if (i<N)c [i] = array[i];
            else c[i] = b[i];
        }
        return c;
    }

   void permute(){
        int temp;
        for( int i = 0 ; i < N ; i++){
            temp = array[i];
            array[i] = array[N - i];
            array[N-i] = temp;
        }
   }

   int[] oneN (int[] b){
        int[] c = new int[N];
       for(int i = 0 ; i < N ; i++){
           c[i] = array [i] + b[N-i];
       }
       return c;
   }

   int product(int[] b){
        int result = 0;
        for (int i = 0; i< N ; i++){
            result += array[i] * b[i];
        }
        return result;
   }
   int[] greaterArray (){
        int count = 0;
        int[] c = new int[N];
        for( int i = 0; i < N ; i++){
            count = 0;
            for (int j = 0; i < N ; i++){
                if( array [j] > array [i]) count += 1;
            }
            c[i] = count;
        }
        return c;
   }

   boolean melchoriforme(){
        for( int i = 0 ; i < N; i ++){
            int sum = 0;
            for (int j = i + 1 ; j < N ; j ++){
                sum += array[j];
            }
            if ( array[i] != sum) return false;
        }
        return true;
   }

   boolean gaspariforme(){
        int tot = 0 ;
        for( int i = 0; i< N; i ++){
            int sum = 0;
            tot += array[i];
            for( int j = 0 ; j <= i ; j++){
                sum += array[j];
            }
            if (sum < 0 ) return false;
        }
       return tot == 0;
   }

    int worstMonth(duplet<Integer,Integer>[] data){
        int worstCase = 0 ;
        int worstMonth = 0;
        int[] worstMonthes = new int[12];
        for (duplet<Integer, Integer> datum : data) {
            worstMonthes[datum.month()] += 1;
        }
        for(int i=0; i < worstMonthes.length; i++ ){
            if(worstMonthes[i]>worstCase) worstCase = worstMonthes[i];
            worstMonth = i;
        }
        return worstMonth;
        }

    int noInfractions(duplet<Integer,Integer>[] data){
        int bestMonth = 0;
        int[] bestMonthes = new int[12];
        for (duplet<Integer, Integer> datum : data) {
            bestMonthes[datum.month()] += 1;
        }
        for(int i=0; i < bestMonthes.length; i++ ){
            if(bestMonthes[i] == 0 ) bestMonth = i;

        }
        return bestMonth;
    }
    int totalInfractions(duplet<Integer,Integer>[] data){
        return data.length;
    }

    int[] series(int[] a){
        int[] result = new int[a.length];
        for(int i = 0 ; i< a.length ; i++){
            result[i] = 0;
            for(int j = i; j >= 0 ; j--){
                result[i] += a[j];
            }
        }
        return result;
    }
}




