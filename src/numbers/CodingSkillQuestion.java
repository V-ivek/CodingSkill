package numbers;

import java.util.ArrayList;
import java.util.List;

public class CodingSkillQuestion {
    private static List<Integer> primes = new ArrayList<>();

    public static boolean checkPrime(int i){
        for(int k=2; k<=i/2;k++) {
            if (i%k == 0){
                return false;
            }
        }
        return true;
    }

    public static boolean checkPrimePerm(Integer p, Integer n) {
        int check[] = {0,0,0,0,0,0,0,0,0,0};
        for(; p!=0; p/=10) {
            check[p%10] += 1;
        }
        for(; n!=0; n/=10){
            if(check[n%10] == 0)
                return false;
            check[n%10] -= 1;
        }
        return true;
    }

    public static List<Integer> findPrimePerms(int n,int i) {
        List<Integer> primeperms = new ArrayList<>();
        for(; i<primes.size(); i++) {
            if(checkPrimePerm(primes.get(i), n)) {
                primeperms.add(primes.get(i));
            }
        }
        return primeperms;
    }

    public static void printPossibleAns(List<Integer> list) {
        Integer X,Y,Z,j,i,k;
        for(int m = 0 ; m<list.size();m++){
//            System.out.println("ll"+list.get(m)+"ll");
        }
//        for(k = 0; k < list.size()-2; k++) {
            X = list.get(0);
            for(i =  1; i<list.size(); i++) {
                Y = list.get(i);
                for(j = i + 1; j<list.size(); j++) {
                    Z = list.get(j);
//                    System.out.println(X+"ll"+Y+"ll"+Z);
                    if (Z - Y == Y - X) {
                        System.out.println(X + " " + Y + " " + Z);
                    }
                }
            }
//        }
    }

    public static void main(String[] args) {
        System.out.println("X     Y     Z\n");
        for(Integer i = 1000; i<9999; i++) {
            if(checkPrime(i)) {
                primes.add(i);
            }
        }
        List<Integer> temp = new ArrayList<>();
        for(int i = 0; i<primes.size(); i++) {
            temp = findPrimePerms(primes.get(i), i);

//        System.out.println("\nPrime number = "+ primes.get(i)+"\nPrime permutations are : ");
            for(Integer t : temp){
//                System.out.println(t+" ");
            }
            printPossibleAns(temp);
            temp = new ArrayList<>();
        }
    }
}
