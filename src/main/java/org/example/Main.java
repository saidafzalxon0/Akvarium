package org.example;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();
        AtomicInteger atomicInteger = new AtomicInteger(1);
        boolean bool;
        int maleFishCount = random.nextInt(5) + 1;
        int femaleFishCount = random.nextInt(5) + 1;

        Aquarium aquarium = new Aquarium();
        for (int i = 1; i <= maleFishCount; i++) {
            Fish fish = new Fish("Male Fish " + atomicInteger.getAndIncrement(), true);
            FishThread fishThread = new FishThread(fish, aquarium);
            fishThread.start();
        }

        for (int i = 1; i <= femaleFishCount; i++) {
            Fish fish = new Fish("Female Fish " + atomicInteger.getAndIncrement(), false);
            FishThread fishThread = new FishThread(fish, aquarium);
            fishThread.start();
        }


        Fish fish;
        while (aquarium.getFishCount()>0){
            if(aquarium.getFish(random.nextInt(aquarium.getFishCount())).isMale() != aquarium.getFish(random.nextInt(aquarium.getFishCount())).isMale()){
                bool = random.nextBoolean();
                if(bool){
                    fish = new Fish("Male Fish to be born " + atomicInteger.getAndIncrement(), true);
                }else{
                    fish = new Fish("Female Fish to be born " + atomicInteger.getAndIncrement(), false);
                }
                FishThread fishThread = new FishThread(fish, aquarium);
                fishThread.start();
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}