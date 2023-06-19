package org.example;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();
        int count = 1;
        boolean bool;
        int maleFishCount = random.nextInt(200) + 1;
        int femaleFishCount = random.nextInt(200) + 1;

        Aquarium aquarium = new Aquarium();
        for (int i = 1; i <= maleFishCount; i++) {
            Fish fish = new Fish("Male Fish " + count++, true, random.nextInt(5), random.nextInt(5));
            FishThread fishThread = new FishThread(fish, aquarium);
            fishThread.start();
        }

        for (int i = 1; i <= femaleFishCount; i++) {
            Fish fish = new Fish("Female Fish " + count++, false, random.nextInt(5), random.nextInt(5));
            FishThread fishThread = new FishThread(fish, aquarium);
            fishThread.start();
        }


        int x; int y;


        Fish fish;
        while (aquarium.getFishCount()>0){
            for (int i = 0; i <= aquarium.getFishCount(); i++) {
                for (int j = i+1; j < aquarium.getFishCount(); j++) {
                    if((aquarium.getFish(i).getA() == aquarium.getFish(j).getA()) && (aquarium.getFish(i).getB() == aquarium.getFish(j).getB()) && aquarium.getFish(j).isMale() != aquarium.getFish(j).isMale()){
                        bool = random.nextBoolean();
                        if(bool){
                            fish = new Fish("Male Fish to be born " + count++, true, random.nextInt(5), random.nextInt(5));
                        }else{
                            fish = new Fish("Female Fish to be born " + count++, false, random.nextInt(5), random.nextInt(5));
                        }
                        FishThread fishThread = new FishThread(fish, aquarium);
                        fishThread.start();
                    }

                }
            }
            for (int i = 0; i < aquarium.getFishCount(); i++) {
                aquarium.getFish(i).setA(random.nextInt(5));
                aquarium.getFish(i).setB(random.nextInt(5));
                System.out.println(aquarium.getFish(i).getName()+  " swimming. cortinate X " + aquarium.getFish(i).getA() + " cortinate Y " + aquarium.getFish(i).getB());

            }
        }
    }
}