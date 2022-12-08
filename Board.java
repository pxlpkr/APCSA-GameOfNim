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
 * A board representing a game of Nim
 *
 * @author      Axel Parkkila
 * @author      Micah Grimaud
 * @author      Isaac Johnson
 */
public final class Board {
    /**
     * Constructs and initializes a {@code Board} instance
     */
    public Board(int numberOfPlayers) {
        initializeHeap(numberOfPlayers);
    }

    /**
     * The size of the piece heap of this {@code Board}.
     *
     * @see #initializeHeap()
     * @see #changeHeapSize(int)
     */
    private int heapSize;
    
    /**
     * Returns the {@code heapSize} of this {@code Board} instance as a 32-bit integer
     * @return  the {@code heapSize} of this {@code Board}
     */
    public int getHeapSize() {
        return this.heapSize;
    }

    /**
     * Adds the input value {@code i} to the {@code heapSize} of this {@code Board} instance
     * @param   i the value with which to modify {@code heapSize}
     */
    public void changeHeapSize(int i) {
        this.heapSize += i;
    }
    
    /**
     * Generates a random 32-bit integer value for {@code heapSize} between 10 and 50
     */
    public void initializeHeap(int numberOfPlayers) {
        this.heapSize = (int) (Math.random()*20*numberOfPlayers) + 5*numberOfPlayers;
    }
}
