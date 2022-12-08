/*
 * Copyright (c) 2022 Axel Parkkila, Micah Grimaud, Isaac Johnson
 * 
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 * 
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 * 
 */

/**
 * A player representing a participant in a game of Nim
 *
 * @author      Axel Parkkila
 * @author      Micah Grimaud
 * @author      Isaac Johnson
 */
public final class Player {
    /**
     * The name of this {@code Player}.
     */
    private String name;
    
    /**
     * The score of this {@code Player}.
     *
     * @see #subtractScore()
     */
    private int score;

    /**
     * Constructs and initializes a {@code Player} instance with the specified name {@code name}
     * @param  name the name of this newly constructed {@code Player}
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     * Returns the {@code name} of this {@code Player} instance
     * @return  the {@code name} of this {@code Player}
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Returns the {@code score} of this {@code Player} instance as a 32-bit integer
     * @return  the {@code score} of this {@code Player}
     */
    public int getScore() {
        return this.score;
    }

    /**
     * Subtracts one from the {@code score} of this {@code Player} instance
     */
    public void subtractScore() {
        this.score--;
    }
}
