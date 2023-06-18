package org.example;

import java.util.Random;

class FishThread extends Thread {
    private Fish fish;
    private Aquarium aquarium;
    private Random random;

    public FishThread(Fish fish, Aquarium aquarium) {
        this.fish = fish;
        this.aquarium = aquarium;
        random = new Random();
    }

    @Override
    public void run() {
        try {
            aquarium.addFish(fish);
            System.out.println(fish.getName() + " started swimming.");
            Thread.sleep(random.nextInt(5000) + 1000);
            System.out.println(fish.getName() + " finished swimming.");
            aquarium.removeFish(fish);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
