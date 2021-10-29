package pl.wiatrowski;


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public static void main(String[] args) {


        double Pk, Pm, a, b, c, d, sum = 0, percent;

        int Literacji = 0;
        int tempMaxResult = 0;
        double maxFunctrionValue = 0;
        double sum_Function = 0;
        int maxValue111111 =0;
        String sub1;
        String sub2;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj Pk: ");
        Pk = scanner.nextDouble();
        System.out.println("Podaj Pm: ");
        Pm = scanner.nextDouble();
        System.out.println("Podaj współczyniki funcji - a: ");
        a = scanner.nextDouble();
        System.out.println("Podaj współczyniki funcji - b: ");
        b = scanner.nextDouble();
        System.out.println("Podaj współczyniki funcji - c: ");
        c = scanner.nextDouble();
        System.out.println("Podaj współczyniki funcji - d: ");
        d = scanner.nextDouble();


        int IntArr[] = new int[6];
        StringBuilder[] binArr = new StringBuilder[6];

        int[] IntArrStart = new int [IntArr.length];

        for (int i = 0; i < 6; i++) {
            IntArr[i] = getRandomNumberInRange(1, 31);
            IntArrStart[i] = IntArr[i];
        }
        for (int value : IntArr) System.out.println(value);

        double[] percent_Value = new double[IntArr.length];

        StringBuilder[] binNewArr = new StringBuilder[binArr.length];

        String[] finalStringArr = new String[binNewArr.length];

        int[] resultArray = new int[finalStringArr.length];

        StringBuilder[] Ruletka = new StringBuilder[100];

        StringBuilder[] binArrShuffle = new StringBuilder[IntArr.length];

        double[] percent1 = new double[6];

        int[] bestArray = new int[IntArr.length];


        for (int i = 0; i < 100; i++) { // main Loop


            for (int r = 0; r < IntArr.length; r++) {
                //if   (IntArr[r] < 0) IntArr[r] = IntArr[r] * (-1);
                sum_Function = a * Math.pow(IntArr[r], 3) + b * Math.pow(IntArr[r], 2) + c * IntArr[r] + d;

                if (maxFunctrionValue < sum_Function) {
                    maxFunctrionValue = sum_Function;
                    maxValue111111 = r;



                    for (int j = 0; j < IntArr.length; j++) {
                        bestArray[j] = IntArr[j];
                        maxValue111111 =  bestArray[r];
                    }

                }

                System.out.println(sum_Function);
                percent_Value[r] = sum_Function;
                sum += sum_Function;
            }
            System.out.println(sum);


            for (int t = 0; t < IntArr.length; t++) {
                percent = percent_Value[t] / sum * 100;
                System.out.println(percent + "%");
                percent1[t] = percent;
                if (percent1[t] < 0){
                    percent1[t] = percent1[t]*(-1);
                }
            }


            for (int k = 0; k < 6; k++) {
                StringBuilder nr = new StringBuilder(Integer.toBinaryString(IntArr[k]));

                int bytes = 5 - nr.length();

                for (int p = 0; p < bytes; p++) {
                    nr.insert(0, "0");
                }
                binArr[k] = nr;
            }

            for (StringBuilder stringBuilder : binArr)
                System.out.println(stringBuilder);
            /////////////////////////



            int zakres1=0;
            int zakres2=0;
            for (int l = 0; l <6 ; l++)
            {

                if(l==0){
                    zakres2 = (int)percent1[l]+1;
                    for (int j = zakres1; j <zakres2 ; j++) {
                        Ruletka[j]=binArr[l];
                    }
                    zakres1=zakres2;
                    zakres2=(int)percent1[l+1]+zakres1;/////
                }
                if(l==1){
                    for (int j = zakres1; j <zakres2 ; j++) {
                        Ruletka[j]=binArr[l];
                    }
                    zakres1=zakres2;
                    zakres2=(int)percent1[l+1]+zakres1;
                }
                if(l==2){

                    for (int j = zakres1; j <zakres2 ; j++) {
                        Ruletka[j]=binArr[l];
                    }
                    zakres1=zakres2;
                    zakres2=(int)percent1[l+1]+zakres1;
                }
                if(l==3){

                    for (int j = zakres1; j <zakres2 ; j++) {
                        Ruletka[j]=binArr[l];
                    }
                    zakres1=zakres2;
                    zakres2=(int)percent1[l+1]+zakres1;
                }
                if(l==4){

                    for (int j = zakres1; j <zakres2 ; j++) {
                        Ruletka[j]=binArr[l];
                    }
                    zakres1=zakres2;
                    zakres2=(int)percent1[l+1]+zakres1;
                }
                if(l==5){
                    for (int j = zakres1; j <100 ; j++) {
                        Ruletka[j]=binArr[l];
                    }
                }
            }

            for (int p = 0; p < IntArr.length; p++) {
                binArrShuffle[p] = Ruletka[getRandomNumberInRange(1, 100) -1 ];
            }
            for (int j = 0; j < binArr.length; j++) {
                System.out.println("///////////////" + binArrShuffle[j]);
            }


            double PkRandom = getRandomNumberInRange(1, 10);
            double PmRandom = getRandomNumberInRange(1, 10);
            int LPk = getRandomNumberInRange(1, 4);
            int LPm = getRandomNumberInRange(0, 4);

            System.out.println("//////////////////////////////////////" + PkRandom);
            System.out.println("//////////////////////////////////////" + PmRandom);

            for (int j = 0; j < 6; j++) {
                if (PkRandom <= Pk * 10) {

                    sub1 = binArrShuffle[j].substring(LPk - 1, 5);
                    sub2 = binArrShuffle[j + 1].substring(LPk - 1, 5);
                    System.out.println(sub1);
                    System.out.println(sub2);



                    binArrShuffle[j + 1] = binArrShuffle[j + 1].delete(LPk - 1, 5);
                    System.out.println(binArr[j + 1]);

                    binArrShuffle[j] = binArrShuffle[j].delete(LPk - 1, 5);
                    System.out.println(binArr[j]);


                    binNewArr[j] = binArrShuffle[j].append(sub2);
                    binNewArr[j + 1] = binArrShuffle[j + 1].append(sub1);

                    if (binNewArr[j].capacity() != 5) binNewArr[j].delete(5, binNewArr[j].capacity());
                    if (binNewArr[j+1].capacity() != 5) binNewArr[j+1].delete(5, binNewArr[j+1].capacity());

                } else {
                    binNewArr[j] = binArr[j];
                    binNewArr[j + 1] = binArr[j + 1];
                }
                j++;
            }

            System.out.println(LPk);


            for (StringBuilder stringBuilder : binNewArr)
                System.out.println(stringBuilder);

            System.out.println("///////////////////////");


            if (PmRandom <= Pm * 10) {

                for (int j = 0; j < binNewArr.length; j++) {

                    if (binNewArr[j].charAt(LPm) == '0')
                        binNewArr[j].setCharAt(LPm, '1');
                    else binNewArr[j].setCharAt(LPm, '0');
                }
            }
            System.out.println(LPm);

            for (int q = 0; q < binNewArr.length; q++)
                System.out.println(binNewArr[q]);


            for (int y = 0; y < 6 ; y++) {
                finalStringArr[y] = binNewArr[y].toString();
            }
            Arrays.sort(finalStringArr);

            System.out.println();
            for (int u = 0; u < finalStringArr.length; u++) {
                int foo = Integer.parseInt(String.valueOf(finalStringArr[u]), 2);
                resultArray[u] = foo;
            }
            for (int value : resultArray)
                System.out.println(value);

            int maxResult = resultArray[resultArray.length - 1];
            Literacji++;

            for (int j = 0; j < IntArr.length; j++)   // swap main chromosomes
                IntArr[j] = resultArray[j];

//////////////////////////////////////////////////
            System.out.println();
            if ((maxFunctrionValue < sum_Function)){
                maxFunctrionValue = sum_Function;
                i = 0;
            }
            System.out.println("Najlepsze chromosomy: ");
            for (int j = 0; j < bestArray.length; j++) {
                System.out.println(bestArray[j]);
            }

            //if (tempMaxResult < maxResult){
            //    tempMaxResult = maxResult;
            //    i = 0;
            //}
            //System.out.println("Najwyzsza wartosc: " + tempMaxResult);
            //System.out.println("Najwyzsza wartosc: " + maxValue111111);

            sum = 0;
        } //// Main Loop

        System.out.print("Pula początkowa chromosomów: ");
        for (int i = 0; i < IntArr.length; i++) {
            System.out.print(IntArrStart[i] + ",");
        }
        System.out.println();
        System.out.println("Maksymalna wartość funkcji w przeciale: " + maxFunctrionValue + ", x = "  + maxValue111111);
        System.out.println("Liczba iteracji: " + Literacji);
////////////////////////////////////////////////////

    }//args
}//main
