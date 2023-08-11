package com.github.curriculeon.jfoot;

import com.github.git_leon.RandomUtils;

import static com.github.curriculeon.jfoot.Direction.*;

/**
 * Wombat. A Wombat moves forward until it hits the edge of the world, at
 * which point it turns left. If a wombat finds a leaf, it eats it.
 *
 * @author Michael Kölling
 * @version 2.0
 */
public class Wombat extends Herbivore {
    public Wombat() {
        setImage("wombat.png");
    }

    public void act() {
        if (this.foundLeaf()) {
            this.eatLeaf();
        } else if (this.canMove()) {
            this.move();
        } else { // has not found a leaf AND wombat can't move
            if (this.getDirection() == EAST) { // facing east
                this.turnLeft();
                this.move();
                this.turnLeft();
            } else if (this.getDirection() == WEST) { // facing west
                this.turnRight();
                this.move();
                this.turnRight();
            } else {
                int xPosition = this.getX();
                int yPosition = this.getY();
                if(xPosition == 0 && yPosition == 0) {
                    // TODO - do things here
                }
            }
        }
    }

    public void turnLeft() {
        if (this.getDirection() == EAST) {
            this.setDirection(NORTH);
        } else if (this.getDirection() == WEST) {
            this.setDirection(SOUTH);
        } else if (this.getDirection() == NORTH) {
            this.setDirection(WEST);
        } else {
            this.setDirection(EAST);
        }
    }

    public void turnRight() {
        turnLeft();
        turnLeft();
        turnLeft();
    }
}
