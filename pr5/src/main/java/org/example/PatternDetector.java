package org.example;

public class PatternDetector {
    public enum Phase {
        S, P1, P2, P3, F
    }

    private Phase currentState;
    private boolean patternDetected;

    public PatternDetector() {
        this.currentState = Phase.S;
        this.patternDetected = false;
    }

    public void restart() {
        this.currentState = Phase.S;
        this.patternDetected = false;
    }

    public Phase evaluateCharacter(char inputSymbol) {
        if (patternDetected) {
            return currentState;
        }

        switch (currentState) {
            case S: {
                if (inputSymbol == 'T') {
                    currentState = Phase.P1;
                } else {
                    currentState = Phase.S;
                }
                break;
            }
            case P1: {
                if (inputSymbol == 'E') {
                    currentState = Phase.P2;
                } else {
                    currentState = Phase.S;
                }
                break;
            }
            case P2: {
                if (inputSymbol == 'S') {
                    currentState = Phase.P3;
                } else {
                    currentState = Phase.S;
                }
                break;
            }
            case P3: {
                if (inputSymbol == 'T') {
                    currentState = Phase.F;
                    patternDetected = true;
                } else {
                    currentState = Phase.S;
                }
                break;
            }
            case F: {
                break;
            }
        }
        return currentState;
    }

    public boolean isPatternDetected() {
        return patternDetected;
    }

    public Phase getCurrentState() {
        return currentState;
    }
}
