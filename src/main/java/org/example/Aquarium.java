package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class Aquarium {
    private List<Fish> fishes = new CopyOnWriteArrayList<>();

    public void addFish(Fish fish) {
        fishes.add(fish);
        System.out.println(fish.getName() + " joined the aquarium.");
    }

    public void removeFish(Fish fish) {
        fishes.remove(fish);
        System.out.println(fish.getName() + " left the aquarium.");
    }

    public int getFishCount() {
        return fishes.size()-1;
    }

    public Fish getFish(int index) {
        return fishes.get(index);
    }
}
